package domain.ChanceCards;

import domain.Board;
import domain.Player;
import domain.squares.Square;

public class MoveCard extends ChanceCard {
    
    private int moves;
    private Board board;
    
    public MoveCard(String type, int moves, Board board) {
        super(type);
        this.moves = moves;
        this.board = board;
    }

    public void applyEffect(Player p){
        Square nextLocation = board.nextLocation(p, moves);
        p.setLocation(nextLocation);
        nextLocation.landedOn(p);
    }
    
}
