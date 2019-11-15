import controllers.GUILogic;
import controllers.LanguageLogic;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class main {
    public static void main(String[] args) {
        GUILogic guilog = new GUILogic();
        GUI_Car car = new GUI_Car();
        GUI_Player player = new GUI_Player("Test", 1000, car);

        guilog.getGui().addPlayer(player);
        guilog.movePiece(player, 22, 3);


    }
}
