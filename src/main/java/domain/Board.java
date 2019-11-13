package domain;

import domain.squares.*;
import services.TxtReader;

public class Board {

    private int SIZE = 24;
    private Square[] squares;

    public Board(String path, String file){

        TxtReader sDec = new TxtReader(path,file);
        squares = new Square[SIZE];

        for (int i = 0; i < 24; i++) {

            String[] oneLine = sDec.getLine(String.valueOf(i)).split("-");
            
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

    // todo skal slettes men bruges pt. af SquareLogic
    public Square[] getSquares() {
        return squares;
    }
   
    // todo skal slettes (kun til midlertidig test
//    public static void main(String[] args) {
//        Board board = new Board("src/main/java/services/","squareDescriptions");
//        System.out.println(board.getSquare(3).getName());
//
//    }
    
}
