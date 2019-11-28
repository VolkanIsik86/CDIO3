package domain.squares;


import controllers.GUILogic;
import domain.Player;
import services.TxtReader;

// Property square is the square that can be owned and other players, who land on it, pays to the owner.
public class PropertySquare extends Square {
    
    private String color;
    private int price;
    private Player owner;
    
    public PropertySquare(String name, int index, GUILogic guiLogic, TxtReader landedOnTxt, int price, String color) {
        super(name, index, guiLogic, landedOnTxt);
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
    void payRent(Player p){
        p.withdraw(this.getPrice());
    }

    // get rent logic: Adds points to the owner of this square.
    void earnRent(){
        owner.deposit(this.getPrice());
    }
    
    void purchase(Player p){
        this.setOwner(p);
        payRent(p);
    }
    
    public void landedOn(Player player) {
        
        
        if (this.getOwner() != null && this.getOwner().equals(player)){
            guiLogic.showMessage(landedOnTxt.getLine("Owned by yourself property square"));
            return;
        }
        
        //If property is not owned
        if (owner == null) {
    
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
