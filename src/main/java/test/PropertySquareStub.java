package test;

import controllers.GUILogic;
import domain.Player;
import domain.squares.PropertySquare;
import services.TxtReader;

public class PropertySquareStub extends PropertySquare {
    
    public PropertySquareStub(String name, int index, GUILogic guiLogic, TxtReader landedOnTxt, int price, String color){
        super(name, index, guiLogic, landedOnTxt, price, color);
    }
    
    @Override
    public void landedOn(Player player){
        
        if (this.getOwner() != null && this.getOwner().equals(player)){
            guiLogic.showMessage(landedOnTxt.getLine("Owned by yourself property square"));
            return;
        }
    
        //If property is not owned
        if (owner == null){
    
            System.out.println("Feltet er ikke ejet");
            guiLogic.showMessage(landedOnTxt.getLine("Not owned property square"));
        
            //If player has the requested fonds
            if (player.attemptToPurchase(this)){
                
                purchase(player);
                guiLogic.setSquareOwner(player,this.getPrice());
                guiLogic.setPlayerBalance(player);
                
                System.out.println("Balancen er nu: " + player.getBalance());
                System.out.println("Ejeren er nu: " + this.getOwner().getName());
                
            }
        
            //If player doesn't have the requested fonds
            else {
                player.setLost(true);
                player.setBalance(0);
                guiLogic.showMessage(landedOnTxt.getLine("Does not have fonds to buy"));
                guiLogic.setPlayerBalance(player);
    
                System.out.println("Havde ikke råd");
                System.out.println(player.getName() + "'s balance er nu: " + player.getBalance());
                System.out.println("player.getLost(): " + player.getLost());
                
            }
        }
    
        //If property is owned
        else{
    
            System.out.println("Feltet er ejet");
            guiLogic.showMessage(landedOnTxt.getLine("Owned by another property square"));
            System.out.println("Ejeren er: " + this.getOwner().getName());
            System.out.println(this.getOwner().getName() + "'s balance var: " + this.getOwner().getBalance());
            
            //If player has the requested fonds
            if (player.attemptToPay(this.getPrice())){
                payRent(player);
                earnRent();
                guiLogic.setPlayerBalance(player);
                guiLogic.setPlayerBalance(this.getOwner());
    
                System.out.println(this.getOwner().getName() + "'s balance er nu: " + this.getOwner().getBalance());
                System.out.println(player.getName() + "'s balancen er nu: " + player.getBalance());
                System.out.println("Ejeren er (stadig): " + this.getOwner().getName());
          
            }
        
            //If player doesn't have the requested fonds
            else {
                player.setLost(true);
                player.setBalance(0);
                guiLogic.showMessage(landedOnTxt.getLine("Does not have fonds for rent"));
                guiLogic.setPlayerBalance(player);
    
                System.out.println("Havde ikke råd");
                System.out.println(player.getName() + "'s balance er nu: " + player.getBalance());
                System.out.println("player.getLost(): " + player.getLost());
                
            }
        
        }
    }
    
}
