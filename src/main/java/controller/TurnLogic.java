package controller;

import game_classes.*;

public class TurnLogic {
  
    public void takeTurn(){
        die.roll();
        Square nextLocation = board.nextLocation(piece.getLocation(), die.getFaceValue());
        piece.setLocation(nextLocation);
        nextLocation.landedOn(this);
    }
    
    
}
