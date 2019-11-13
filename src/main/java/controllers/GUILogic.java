package controllers;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;
import java.util.Arrays;


public class GUILogic {

    public void makeBoard() {
        GUI_Field[] fields = new GUI_Field[24];

        //Dette er så simpelt som det kan blive.
        for (int i = 0; i < 24; i++) {
            fields[i] = new GUI_Street();

            //Der tilføjes et par værdier.

            GUI_Street testStreet = new GUI_Street();
            testStreet.setTitle("Anker Engelundsvej");
            testStreet.setBorder(Color.cyan); //Useful to show owner
            testStreet.setRent("600,-");
            fields[i] = testStreet;
        }


    }
}
