package controllers;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import services.TxtReader;

import java.awt.*;
import java.util.Arrays;


public class GUILogic {
    private String PATH = "src/main/java/services/";
    private String FILE = "squareDescriptions";
    public GUILogic() {


    }


    public void makeBoard() {

        GUI_Field[] fields = new GUI_Field[24];
        //læser fra fil
        TxtReader juniorFields = new TxtReader(PATH,FILE);

        //Løber igennem for hvert felt
        for (int i = 0; i < 24; i++) {
            fields[i] = new GUI_Street();

            //opretter objekt
            GUI_Street street = new GUI_Street();
            //generer et array for hver linje i .txt med strenge spredt ud over de forskellige indexer.
            String[] juniorField = juniorFields.getLine(""+ i).split("-");
            //bestemmer titel på felt (index 1)
            street.setTitle(juniorField[1]);
            //bestemmer farven. MANGEL: at kunne læse farven fra .txt
            street.setBackGroundColor(Color.cyan);
            //bestemmer bundtext
            street.setSubText("$10.000");
            fields[i] = street;
        }
        GUI gui = new GUI(fields);


    }
}
