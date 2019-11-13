package game_classes;

import game_classes.square.*;
import service.TxtReader;

public class Board {

    private int SIZE = 24;
    private Square[] squares;

    public Board(String path, String file){

        TxtReader sDec = new TxtReader(path,file);

        for (int i = 0; i < 24; i++) {

            String[] oneLine = sDec.getLine("1").split("-");
    
            if ("Regular".equalsIgnoreCase(oneLine[0])) {
                squares[i] = new RegularSquare(oneLine[1], Integer.parseInt(oneLine[2]));
            } else if ("Property".equals(oneLine[0])) {
                squares[i] = new PropertySquare(oneLine[1], Integer.parseInt(oneLine[2]), Integer.parseInt(oneLine[3]), oneLine[4]);
            } else if ("Jail".equals(oneLine[0])) {
                squares[i] = new GoToJailSquare(oneLine[1], Integer.parseInt(oneLine[2]));
            } else if ("Chance".equals(oneLine[0])) {
                squares[i] = new ChanceSquare(oneLine[1], Integer.parseInt(oneLine[2]));
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

    public Square[] getSquares() {
        return squares;
    }
    //Skal have en .nextLocation(Square location, eyes)
    
    public static void main(String[] args) {
        
    }
    
}
