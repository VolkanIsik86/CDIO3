import controllers.GUILogic;
import controllers.Game;
import controllers.LanguageLogic;
import gui_fields.*;
import gui_main.GUI;
import services.TxtReader;

import java.awt.*;

public class main {

    
    public static void main(String[] args) {
        
        new Game().playGame();
    }
    
    
//    String languagePath = "src/main/java/services/languagefiles/";
//    String language;
//    TxtReader landedOnTxt;
//    TxtReader squaresTxt;
//
//    LanguageLogic languageLogic = new LanguageLogic();
//
//    //Promts user to select language
//    language = languageLogic.selectLangauge();
//
//    //Load txt files
//    landedOnTxt = new TxtReader(languagePath, "landedOn_" + language);
//    squaresTxt = new TxtReader(languagePath, "squares_" + language);
//
//    GUILogic guilog = new GUILogic(squaresTxt);
    
}

