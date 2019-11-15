import controllers.GUILogic;
import controllers.LanguageLogic;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class main {
    public static void main(String[] args) {
        LanguageLogic language = new LanguageLogic();
        GUILogic guilog = new GUILogic(language.selectLangauge());


    }
}
