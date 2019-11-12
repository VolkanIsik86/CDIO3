package game_classes;

import game_classes.square.Square;

public class Board {

    private int SIZE = 24;
    private Square[] squares = new Square[SIZE];


    public Board(int SIZE, Square[] squares) {
        this.SIZE = SIZE;
        this.squares = squares;

    }

    //Skal have en .nextLocation(Square location, eyes)
    
}
