package domain.squares;


import domain.Board;
import domain.Player;
// Property square is the square that can be owned and other players, who lands on it, pays to the owner.
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

    // pay rent logic: removes points from player
    public  void payRent(Player p){
        if(p.getPoints() < this.getPrice()){
            p.setLost(true);
        }
        else {
            p.addPoints(-this.getPrice());
        }
    }

    // get rent logic: Adds points to the owner of this square.
    public  void getRent(){
        this.getOwner().addPoints(this.getPrice());
    }

    public void landedOn(Player p) {
        if (owner==null) {
            if(p.attempPurchase(this)){
                this.setOwner(p);
                payRent(p);
                //TODO her skal logikken implementeres for hvis spilleren ikke kan betale for feltet.
            }
            else {
                p.setLost(true);
            }
        }
        else{
            payRent(p);
            getRent();
        }
    }
}
