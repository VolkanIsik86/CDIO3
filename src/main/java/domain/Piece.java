package domain;

import domain.squares.Square;

public class Piece {
    
    private Square location;
    private String type;
    
    public Piece (Square location, String type){
        this.location = location;
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
    
    public Square getLocation(){
        return location;
    }
    
    public void setLocation(Square newLocation){
        location = newLocation;
    }

}
