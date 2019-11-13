package domain;

import domain.squares.Square;

public class Piece {
    
    private Square location;
    private int type;
    private static int pieceType = 0;
    
    public Piece (Square location){
        this.location = location;
        this.type = pieceType;
        pieceType++;
    }
    
    public int getType() {
        return type;
    }
    
    public Square getLocation(){
        return location;
    }
    
    public void setLocation(Square newLocation){
        location = newLocation;
    }

}
