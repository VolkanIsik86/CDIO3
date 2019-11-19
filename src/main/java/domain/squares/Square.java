package domain.squares;

// todo lav landedOn metoden til en boolean

import domain.Board;
import domain.Player;

//All squares that belongs to monopoly junior board inherits from this abstract superclass
public abstract class Square {

    private String name;
    private int index;
    protected Board board;
    
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
    
    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    // landedOn is the key method of squares. This polymorph method affects player with various effects.
    public abstract void landedOn(Player p);
    
    @Override
    public String toString() {
        return "Square{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", board=" + board +
                '}';
    }
}
