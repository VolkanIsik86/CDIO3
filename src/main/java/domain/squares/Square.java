package domain.squares;

// todo lav landedOn metoden til en boolean

import domain.Board;
import domain.Player;
// This abstract super class inherits all squares that belongs to monopoly junior board.
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

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public Square getNextSquare() {
        return nextSquare;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setNextSquare(Square nextSquare) {
        this.nextSquare = nextSquare;
    }

    // landedOn is the key method og squares. This polymorph method affects player with various effects.

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
