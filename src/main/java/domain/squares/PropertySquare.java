package domain.squares;


import domain.Board;
import domain.Player;

// Property square is the square that can be owned and other players, who land on it, pays to the owner.
public class PropertySquare extends Square {
    
    private String color;
    private int price;
    private Player owner = null;
    
    public PropertySquare(String name, int index, Board board, int price, String color) {
        super(name, index, board);
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
    
    public boolean landedOn(Player p) {
        
        //If property is not owned
        if (owner == null) {
            
            //If player has the requested fonds
            if (p.attemptToPurchase(this)){
                purchase(p);
                return true;
            }
            
            //If player doesn't have the requested fonds
            else {
                p.setLost(true);
                return false;
            }
        }
        
        //If property is owned
        else{
    
            //If player has the requested fonds
            if (p.attemptToPay(this.getPrice())){
                payRent(p);
                earnRent();
                return true;
            }
    
            //If player doesn't have the requested fonds
            else {
                p.setLost(true);
                return false;
            }
            
        }
    }
}
