package domain.squares;

import controllers.SquareLogic;
import domain.Board;
import domain.Player;

public abstract class Square {

    private String name;
    private int index;
    protected Board board;
    private Square nextSquare;



    public Square(String name, int index, Board board) {
        this.name = name;
        this.index = index;
        this.board = board;
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
