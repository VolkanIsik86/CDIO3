package domain.squares;

import controllers.GUILogic;
import domain.Board;
import domain.Player;
import services.TxtReader;

//All squares that belongs to monopoly junior board inherits from this abstract superclass
public abstract class Square {

    private String name;
    private int index;
    protected Board board;
    protected GUILogic guiLogic;
    protected TxtReader landedOnTxt;
    
    public Square(String name, int index, Board board, GUILogic guiLogic, TxtReader landedOnTxt) {
        this.name = name;
        this.index = index;
        this.board = board;
        this.guiLogic = guiLogic;
        this.landedOnTxt = landedOnTxt;
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
    
    // landedOn is the key method of squares.
    // This polymorph method affects player with various effects.
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
