package controllers;

import javax.swing.*;

public class LanguageLogic {
    public String LanguageLogic() {
        Object[] options1 = {"English",
                "Dansk"};
        String language = "";
        int choice = JOptionPane.showOptionDialog(null,
                "Select language/Vælg sprog",
                "Language/Sprog",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options1,
                null);
        if (choice == JOptionPane.YES_OPTION) {
            language = "en";
            System.out.println("English");
        } else if(choice == JOptionPane.NO_OPTION){
            language = "da";
            System.out.println("Dansk");
        }
        else{
            System.exit(0);
        }
        return language;
    }

    public String selectLangauge() {
        LanguageLogic language = new LanguageLogic();
        String lang = "";
        lang = language.LanguageLogic();
        return lang;
    }
}
