package square;

import game_classes.Player;

public abstract class PropertySquare extends Square {
    private String color;
    private int price;
    private Player owner;

    public PropertySquare(String name, int index, String color, int price, Player owner) {
        super(name, index);
        this.color = color;
        this.owner = owner;
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
        if (owner!= p){
            p.attempPurchase();
        }
        else {
            payRent(p);
            getRent();
        }
    }
    public abstract void payRent(Player p);
    public abstract void getRent();
}
