package domain;

import controllers.GUILogic;
import gui_fields.GUI_Street;
import services.TxtReader;

public class GUILogicStub extends GUILogic {
    public GUILogicStub(TxtReader squaresTxt, TxtReader guiTxt) {
        super(squaresTxt, guiTxt);
    }

    @Override
    public String[] makeUsers() {
        return null;
    }

}
