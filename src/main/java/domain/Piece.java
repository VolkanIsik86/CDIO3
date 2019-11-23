package domain;

import domain.squares.ChanceSquare;
import domain.squares.Square;

public class Piece {
    
    private Square location;
    private Square lastLocation;
    private boolean chanceStatus = false;
    private int type;
    private static int pieceType = 0;
    
    public Piece (Square location){
        this.location = location;
        this.type = pieceType;
        
        //Every new piece gets a unique number
        pieceType++;
    }
    
    public boolean getChanceStatus() {
        return chanceStatus;
    }
    
    public int getType() {
        return type;
    }
    
    public Square getLocation(){
        return location;
    }
    
    public void setLocation(Square newLocation){
        
        //Check if new location is a chanceSquare
        if (newLocation instanceof ChanceSquare){
            chanceStatus = true;
        } else {
            chanceStatus = false;
        }
        
        lastLocation = location;
        location = newLocation;
    }
    
    public Square getLastLocation(){
        return lastLocation;
    }

}
