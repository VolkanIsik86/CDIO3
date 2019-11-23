package domain.squares;

import controllers.GUILogic;
import domain.Board;
import domain.Player;
import services.TxtReader;
//This square moves player to jail

public class GoToJailSquare extends Square {
    
    public GoToJailSquare(String name, int index, Board board, GUILogic guiLogic, TxtReader landedOnTxt) {
        super(name, index, board, guiLogic, landedOnTxt);
    }

    // Moves player to jail.
    public void landedOn(Player player) {
        guiLogic.showMessage(landedOnTxt.getLine("GoToJail square"));
        player.setLocation(board.getJail());
        guiLogic.moveToJail(player);
        player.setJail(true);
    }
}
