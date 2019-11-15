package controllers;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import services.TxtReader;

import java.awt.*;


public class GUILogic {
    private String PATH = "src/main/java/services/";
    private String FILE = "squareDescriptions";
    private Color BROWN = new Color(153, 102, 0);
    private Color GOLD = new Color(255, 204, 51);
    private final int N_FIELDS = 24;
    private GUI_Field[] fields;
    private GUI gui;

    public GUILogic() {
        makeBoard();
    }

    public GUI_Field[] makeBoard() {
        selectLangauge();
        fields = new GUI_Field[N_FIELDS];
        //læser fra fil
        TxtReader juniorFields = new TxtReader(PATH, FILE);

        //Løber igennem for hvert felt
        for (int i = 0; i < 24; i++) {
            fields[i] = new GUI_Street();

            //opretter objekt
            GUI_Street street = new GUI_Street();
            //generer et array for hver linje i .txt med strenge spredt ud over de forskellige indexer.
            String[] juniorField = juniorFields.getLine("" + i).split("-");
            //bestemmer titel på felt (index 1)
            street.setTitle(juniorField[1]);
            //bestemmer farven
            switch (juniorField[4].charAt(0)) {
                case 'r':
                    street.setBackGroundColor(Color.RED);
                    break;
                case 'B':
                    street.setBackGroundColor(BROWN);
                    break;
                case 'w':
                    street.setBackGroundColor(Color.WHITE);
                    break;
                case 'c':
                    street.setBackGroundColor(Color.CYAN);
                    break;
                case 'p':
                    street.setBackGroundColor(Color.PINK);
                    break;
                case 'g':
                    street.setBackGroundColor(GOLD);
                    break;
                case 'y':
                    street.setBackGroundColor(Color.YELLOW);
                    break;
                case 'G':
                    street.setBackGroundColor(Color.GREEN);
                    break;
                case 'b':
                    street.setBackGroundColor(Color.BLUE);
                    break;
                default:
                    street.setBackGroundColor(Color.BLACK);
            }

            //bestemmer prisen
            street.setSubText(juniorField[3]);
            //Hvis prisen er 0, fjernes teksten
            if (juniorField[3].equals("0"))
                street.setSubText("");
            fields[i] = street;
        }
        gui = new GUI(fields);
        return fields;


    }

    public void addPlayer(GUI gui, String name) {
        GUI_Player p1 = new GUI_Player(name);
        gui.addPlayer(p1);
    }

    public void movePiece(GUI_Field[] fields, GUI_Player player, int currentField, int moves) {
        fields[currentField].setCar(player, false);
        if ((currentField + moves < N_FIELDS)) {
            fields[currentField + moves].setCar(player, true);
        } else {
            fields[currentField + moves - N_FIELDS].setCar(player, true);
        }

    }

    public GUI_Field[] getFields() {
        return fields;
    }

    public GUI getGui() {
        return gui;
    }

    private void selectLangauge() {
        LanguageLogic language = new LanguageLogic();
        FILE += "_" + language.LanguageLogic();
    }

}
