package domain;

import controllers.GUILogic;
import domain.squares.*;
import services.TxtReader;

public class Board {

    private int SIZE;
    private Square[] squares;

    public Board(TxtReader squareTxt, TxtReader landedOnTxt, GUILogic guiLogic){
        
        SIZE = squareTxt.getN_LINES();
        squares = new Square[SIZE];
        
        //For all squares
        for (int i = 0; i < SIZE; i++) {

            //Extract corresponding square description
            String[] oneLine = squareTxt.getLine(String.valueOf(i)).split("-");
            
            //Create the proper square subclass and place in array
            if ("Regular".equalsIgnoreCase(oneLine[0])) {
                squares[i] = new RegularSquare(oneLine[1], Integer.parseInt(oneLine[2]),this, guiLogic, landedOnTxt);
                
            } else if ("Property".equals(oneLine[0])) {
                squares[i] = new PropertySquare(oneLine[1], Integer.parseInt(oneLine[2]),this, guiLogic, landedOnTxt, Integer.parseInt(oneLine[3]), oneLine[4]);
                
            } else if ("Jail".equals(oneLine[0])) {
                squares[i] = new GoToJailSquare(oneLine[1], Integer.parseInt(oneLine[2]), this, guiLogic, landedOnTxt);
                
            } else if ("Chance".equals(oneLine[0])) {
                squares[i] = new ChanceSquare(oneLine[1], Integer.parseInt(oneLine[2]), this, guiLogic, landedOnTxt);
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
