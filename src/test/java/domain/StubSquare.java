package domain;

import controllers.GUILogic;
import domain.squares.Square;
import services.TxtReader;

public class StubSquare extends Square {
    public StubSquare(String name, int index, GUILogic guiLogic, TxtReader landedOnTxt) {
        super(name, index, guiLogic, landedOnTxt);
    }

    @Override
    public void landedOn(Player p) {

    }
}
