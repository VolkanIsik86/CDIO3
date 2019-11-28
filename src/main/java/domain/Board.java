package domain;

import controllers.GUILogic;
import domain.squares.*;
import services.TxtReader;
import test.ChanceDeckStub;

public class Board {

    private int SIZE;
    private Square[] squares;
    private ChanceDeckStub chanceDeck;
    
    public void makeBoard(TxtReader squareTxt, TxtReader landedOnTxt, TxtReader cardsTxt, GUILogic guiLogic){
        
        //Chancefelterne skal bruge chancedækket i deres landOn, samtidig skal chancedækket bruge boardet, til at rykke spillerne
        chanceDeck = new ChanceDeckStub(guiLogic, cardsTxt, this);
    
        SIZE = squareTxt.getN_LINES();
        squares = new Square[SIZE];
    
        //For all squares
        for (int i = 0; i < SIZE; i++) {
        
            //Extract corresponding square description
            String[] oneLine = squareTxt.getLine(String.valueOf(i)).split("-");
        
            //Create the proper square subclass and place in array
            if ("Regular".equalsIgnoreCase(oneLine[0])) {
                squares[i] = new RegularSquare(oneLine[1], Integer.parseInt(oneLine[2]),guiLogic, landedOnTxt);
            
            } else if ("Property".equals(oneLine[0])) {
                squares[i] = new PropertySquare(oneLine[1], Integer.parseInt(oneLine[2]), guiLogic, landedOnTxt, Integer.parseInt(oneLine[3]), oneLine[4]);
            
            } else if ("Jail".equals(oneLine[0])) {
                squares[i] = new GoToJailSquare(oneLine[1], Integer.parseInt(oneLine[2]), guiLogic, landedOnTxt, this);
            
            } else if ("Chance".equals(oneLine[0])) {
                squares[i] = new ChanceSquare(oneLine[1], Integer.parseInt(oneLine[2]), guiLogic, landedOnTxt, chanceDeck);
            }
        }
    }
    
    public Square getSquare(int index){
        return squares[index];
    }
    
    public Square nextLocation(Player player, int roll){
        
        int nextIndex;
        nextIndex = (player.getLocation().getIndex() + roll) % SIZE;
        return squares[nextIndex];
    }
    
    public Square getJail(){
        return squares[6];
    }
    
    public Square getStart() {
        return squares[0];
    }
    
    
}
