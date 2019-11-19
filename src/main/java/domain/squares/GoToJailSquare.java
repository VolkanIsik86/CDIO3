package domain.squares;

import domain.Board;
import domain.Player;
//This square moves player to jail

public class GoToJailSquare extends Square {

    public GoToJailSquare(String name, int index, Board board) {
        super(name, index, board);
    }

    // Moves player to jail.
    public void landedOn(Player p) {
        p.setLocation(board.getJail());
        p.setJail(true);
    }
}
