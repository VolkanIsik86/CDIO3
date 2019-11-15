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
        p.setLocation(board.nextLocation(this,-12));
        // TODO er ikke helt sikker om vi kan sige -12 her. Denne metode skal testes.
    }
}
