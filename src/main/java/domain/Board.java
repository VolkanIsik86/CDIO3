package domain;

import domain.squares.*;
import services.TxtReader;

public class Board {

    private int SIZE;
    private Square[] squares;

    public Board(String path, String file){
        
        //Load square descriptions
        TxtReader sDec = new TxtReader(path,file);
        
        SIZE = sDec.getN_LINES();
        squares = new Square[SIZE];
        
        //For all squares
        for (int i = 0; i < SIZE; i++) {

            //Extract corresponding square description
            String[] oneLine = sDec.getLine(String.valueOf(i)).split("-");
            
            //Create the proper square subclass and place in array
            if ("Regular".equalsIgnoreCase(oneLine[0])) {
                squares[i] = new RegularSquare(oneLine[1], Integer.parseInt(oneLine[2]),this);
            } else if ("Property".equals(oneLine[0])) {
                squares[i] = new PropertySquare(oneLine[1], Integer.parseInt(oneLine[2]),this, Integer.parseInt(oneLine[3]), oneLine[4]);
            } else if ("Jail".equals(oneLine[0])) {
                squares[i] = new GoToJailSquare(oneLine[1], Integer.parseInt(oneLine[2]), this);
            } else if ("Chance".equals(oneLine[0])) {
                squares[i] = new ChanceSquare(oneLine[1], Integer.parseInt(oneLine[2]), this);
            }
        }
    }

    public Square getSquare(int index){
        return squares[index];
    }
    
    public Square nextLocation(Square currentLocation, int roll){
        int nextIndex;
        nextIndex = (currentLocation.getIndex() + roll)%SIZE;
        return squares[nextIndex];
    }

    public Square getJail(){
        return squares[5];
    }
    
    public Square getStart() {
        return squares[0];
    }
    
    
}
