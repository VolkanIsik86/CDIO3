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
    
    public void landedOn(Player p) {
        
        if (this.equals(p)){
            guiLogic.showMessage(landedOnTxt.getLine("Owned by yourself property square"));
            return;
        }
        
        //If property is not owned
        if (owner == null) {
    
            guiLogic.showMessage(landedOnTxt.getLine("Not owned property square"));
            
            //If player has the requested fonds
            if (p.attemptToPurchase(this)){
                purchase(p);
            }
            
            //If player doesn't have the requested fonds
            else {
                guiLogic.showMessage(landedOnTxt.getLine("Does not have fonds to buy"));
                p.setLost(true);
                p.setBalance(0);
            }
        }
        
        //If property is owned
        else{
    
            guiLogic.showMessage(landedOnTxt.getLine("Owned by another property square"));
    
            //If player has the requested fonds
            if (p.attemptToPay(this.getPrice())){
                payRent(p);
                earnRent();
            }
    
            //If player doesn't have the requested fonds
            else {
                guiLogic.showMessage(landedOnTxt.getLine("Does not have fonds for rent"));
                p.setLost(true);
                p.setBalance(0);
            }
            
        }
    }
}
