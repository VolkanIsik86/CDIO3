package domain.squares;

import controllers.SquareLogic;
import domain.Player;

public abstract class Square {

    private String name;
    private int index;
    private Square nextSquare;



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



    @Override
    public String toString() {
        return "Square{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", nextSquare=" + nextSquare +
                '}';
    }


}
