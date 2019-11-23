package domain.squares;

import controllers.GUILogic;
import domain.Board;
import domain.Player;
import services.TxtReader;

//Start, fængsel, parkering squares
public class RegularSquare extends Square {

    public RegularSquare(String name, int index, Board board, GUILogic guiLogic, TxtReader landedOnTxt) {
        super(name, index,board, guiLogic, landedOnTxt);
    }

    @Override
    public void landedOn(Player p) {
        guiLogic.showMessage(landedOnTxt.getLine("Regular square"));
    }


}
