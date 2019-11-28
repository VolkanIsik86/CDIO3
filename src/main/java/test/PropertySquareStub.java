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
        
            guiLogic.showMessage(landedOnTxt.getLine("Not owned property square"));
        
            //If player has the requested fonds
            if (player.attemptToPurchase(this)){
                purchase(player);
                guiLogic.setSquareOwner(player,this.getPrice());
                guiLogic.setPlayerBalance(player);
            }
        
            //If player doesn't have the requested fonds
            else {
                player.setLost(true);
                player.setBalance(0);
                guiLogic.showMessage(landedOnTxt.getLine("Does not have fonds to buy"));
                guiLogic.setPlayerBalance(player);
            }
        }
    
        //If property is owned
        else{
        
            guiLogic.showMessage(landedOnTxt.getLine("Owned by another property square"));
        
            //If player has the requested fonds
            if (player.attemptToPay(this.getPrice())){
                payRent(player);
                earnRent();
                guiLogic.setPlayerBalance(player);
                guiLogic.setPlayerBalance(this.getOwner());
            }
        
            //If player doesn't have the requested fonds
            else {
                player.setLost(true);
                player.setBalance(0);
                guiLogic.showMessage(landedOnTxt.getLine("Does not have fonds for rent"));
                guiLogic.setPlayerBalance(player);
            }
        
        }
    }
    
}
