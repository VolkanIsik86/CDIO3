package domain.squares;

import domain.Board;
import domain.Player;
// Gå til fængsel square
public class GoToJailSquare extends Square {

    public GoToJailSquare(String name, int index, Board board) {
        super(name, index, board);
    }

    public void landedOn(Player p) {
        p.setLocation(board.nextLocation(this,12));

    }

}
