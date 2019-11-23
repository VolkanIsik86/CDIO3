package domain.squares;


import controllers.GUILogic;
import domain.Board;
import domain.Player;
import services.TxtReader;

// Property square is the square that can be owned and other players, who land on it, pays to the owner.
public class PropertySquare extends Square {
    
    private String color;
    private int price;
    private Player owner = null;
    
    public PropertySquare(String name, int index, Board board, GUILogic guiLogic, TxtReader landedOnTxt, int price, String color) {
        super(name, index, board, guiLogic, landedOnTxt);
        this.color = color;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public Player getOwner() {
        return owner;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
    
    //Pay rent logic: withdraws balance from player
    private void payRent(Player p){
        p.withdraw(this.getPrice());
    }

    // get rent logic: Adds points to the owner of this square.
    private  void earnRent(){
        owner.deposit(this.getPrice());
    }
    
    private void purchase(Player p){
        this.setOwner(p);
        payRent(p);
    }
    
    public void landedOn(Player player) {
        
        if (this.equals(player)){
            guiLogic.showMessage(landedOnTxt.getLine("Owned by yourself property square"));
            return;
        }
        
        //If property is not owned
        if (owner == null) {
    
            guiLogic.showMessage(landedOnTxt.getLine("Not owned property square"));
            
            //If player has the requested fonds
            if (player.attemptToPurchase(this)){
                purchase(player);
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
