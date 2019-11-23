package domain.ChanceCards;

import controllers.GUILogic;
import domain.Board;
import domain.ChanceDeck;
import domain.Player;
import domain.squares.Square;
import services.TxtReader;

public class MoveCard extends ChanceCard {
    
    private int moves;
    private Board board;
    
    public MoveCard(String type, String description, GUILogic guiLogic, TxtReader cardsTxt, ChanceDeck chanceDeck, int moves, Board board) {
        super(type, description, guiLogic, cardsTxt, chanceDeck);
        this.moves = moves;
        this.board = board;
    }

    public void applyEffect(Player player){
        Square nextLocation = board.nextLocation(player, moves);
        player.setLocation(nextLocation);
    
        guiLogic.movePiece(player);
        nextLocation.landedOn(player);
    }
    
}
