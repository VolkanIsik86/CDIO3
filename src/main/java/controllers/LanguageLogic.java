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
            System.out.println("Enlgish");
        } else {
            language = "da";
            System.out.println("Dansk");
        }
        return language;
    }
}
