package controllers;

import javax.swing.*;

class LanguageLogic {
    private String languageLogic() {
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
        } else if(choice == JOptionPane.NO_OPTION){
            language = "da";
        }
        else{
            System.exit(0);
        }
        return language;
    }

    public String selectLanguage() {
        LanguageLogic language = new LanguageLogic();
        String lang;
        lang = language.languageLogic();
        return lang;
    }

}
