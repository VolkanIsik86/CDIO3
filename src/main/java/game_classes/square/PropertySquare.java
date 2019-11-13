package game_classes.square;


import game_classes.Player;
// Property square som kan købes ejes og lejes
public class PropertySquare extends Square {
    private String color;
    private int price;
    private Player owner = null;


    public PropertySquare(String name, int index, int price, String color) {
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
        controller.attempToBuy(this,p);
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
