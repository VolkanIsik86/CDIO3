package domain.squares;

import controllers.GUILogic;
import domain.Board;
import domain.Player;
import services.TxtReader;

//This square moves player to jail
public class GoToJailSquare extends Square {
    
    private final Board board;
    
    public GoToJailSquare(String name, int index, GUILogic guiLogic, TxtReader landedOnTxt,  Board board) {
        super(name, index, guiLogic, landedOnTxt);
        this.board = board;
        
    }

    // Moves player to jail.
    public void landedOn(Player player) {
        guiLogic.showMessage(landedOnTxt.getLine("GoToJail square"));
        player.setLocation(board.getJail());
        guiLogic.moveToJail(player);
        player.setJail(true);
    }
}
