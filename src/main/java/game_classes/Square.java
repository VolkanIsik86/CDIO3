package game_classes;

import javax.swing.*;

public class Square {
    
    private String navn;
    private final int index;
    private String color;
    private boolean bonusTurn;

    //kontrollør
    public Square(int effektval, String descriptiontxt, boolean bonusTurnBool) {
        index = effektval;
        navn = descriptiontxt;
        bonusTurn = bonusTurnBool;
    }

    //gettere
    public String getName(){
        return navn;
    }

    public int getIndex(){
        return index;
    }

    //getter bonus-turn. Denne værdi kan bestemme om spilleren skal have en ekstra tur efter at lande på feltet
    public boolean getBonusTurn(){
        return bonusTurn;
    }

    public String toString(){
        return "Effect desciption: " + navn + "\n"
                + "Effect: "+ index + "\n"
                + "Bonus turn: " + bonusTurn;
    }

}
