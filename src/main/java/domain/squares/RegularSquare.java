package domain.squares;

import domain.Board;
import domain.Player;
//Start, fængsel, parkering squares
public class RegularSquare extends Square {

    public RegularSquare(String name, int index, Board board) {
        super(name, index,board);
    }

    @Override
    public boolean landedOn(Player p) {
        return true;
    }


}
