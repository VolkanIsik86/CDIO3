import controllers.GUILogic;
import gui_fields.GUI_Field;
import gui_fields.GUI_Shipping;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;

public class main {
    public static void main(String[] args) {
        GUILogic guilog = new GUILogic();
        GUI gui = new GUI(guilog.makeBoard());


    }
}
