package domain.squares;

import controllers.GUILogic;
import domain.Board;
import domain.Player;
import services.TxtReader;

//All squares that belongs to monopoly junior board inherits from this abstract superclass
public abstract class Square {

    private final String name;
    private final int index;
    private Board board;
    protected final GUILogic guiLogic;
    protected final TxtReader landedOnTxt;
    
    Square(String name, int index, GUILogic guiLogic, TxtReader landedOnTxt) {
        this.name = name;
        this.index = index;
        this.guiLogic = guiLogic;
        this.landedOnTxt = landedOnTxt;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
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
