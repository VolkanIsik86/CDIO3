package square;

import game_classes.Player;

public class PropertySquare extends Square {
    private String color;
    private int price;
    private Player owner = null;

    public PropertySquare(String name, int index, String color, int price) {
        super(name, index);
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
    public void landedOn(Player p) {
        if (owner == null){
            if (p.attempPurchase(this)){
                this.setOwner(p);
            }

        }
        else {
            payRent(p);
            getRent();
        }
    }
    public  void payRent(Player p){
        p.addPoints(- this.getPrice());
        // pay rent logic
    }
    public  void getRent(){
        this.getOwner().addPoints(this.getPrice());
        // get rent logic
    }
}
