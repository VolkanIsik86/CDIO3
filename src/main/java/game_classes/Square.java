package game_classes;

public abstract class Square {

    private String name;
    private int index;
    private String color;
    private Square nextSquare;

    public Square(String name, int index, String color) {
        this.name = name;
        this.index = index;
        this.color = color;
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


    //settere


    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNextSquare(Square nextSquare) {
        this.nextSquare = nextSquare;
    }

    // logik implementeres afhengig af felt i de andre klasser
    public abstract void landedOn();


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
