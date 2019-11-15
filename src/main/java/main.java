import controllers.GUILogic;
import gui_fields.GUI_Field;
import gui_fields.GUI_Shipping;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;

public class main {
    public static void main(String[] args) {
        GUILogic guilog = new GUILogic();
        gui_fields.GUI_Field[] fields = guilog.makeBoard();
        GUI gui = new GUI(fields);
        guilog.addPlayer(gui,"Johnny");


        //Spørg IngeLise om vision
        //Overvej at hive fully dressed ud af skemaet






    }
}
