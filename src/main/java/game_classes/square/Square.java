package game_classes.square;

import controller.SquareController;
import game_classes.Player;

public abstract class Square {

    private String name;
    private int index;
    private Square nextSquare;
    protected SquareController controller;


    public Square(String name, int index) {
        this.name = name;
        this.index = index;
    }
    //gettere

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }


    public Square getNextSquare() {
        return nextSquare;
    }


    //settere


    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setNextSquare(Square nextSquare) {
        this.nextSquare = nextSquare;
    }


    // Gamelogik skal kalde denne metode for at udføre et logik hensyn til square
    public abstract void landedOn(Player p);


    @Override
    public String toString() {
        return "Square{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", nextSquare=" + nextSquare +
                '}';
    }


}
