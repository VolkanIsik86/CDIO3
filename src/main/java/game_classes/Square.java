package game_classes;

public abstract class Square {

    private String name;
    private int index;
    private String color;
    private Square nextSquare;
    private int price;
    private Player owner;

    public Square(String name, int index, String color,int price, Player owner) {
        this.name = name;
        this.index = index;
        this.color = color;
        this.price = price;
        this.owner = owner;

    }
    //gettere

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public String getColor() {
        return color;
    }

    public Square getNextSquare() {
        return nextSquare;
    }

    public int getPrice() {
        return price;
    }
    //settere


    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNextSquare(Square nextSquare) {
        this.nextSquare = nextSquare;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // logik implementeres afhengig af felt i de andre klasser
    public abstract void landedOn(Piece p);

    public abstract void payRent();
    public abstract void getRent();




    @Override
    public String toString() {
        return "Square{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", color='" + color + '\'' +
                ", nextSquare=" + nextSquare +
                '}';
    }
}
