package controller;

import game_classes.*;
import game_classes.square.*;


public class TurnLogic {
    
    private Die die = new Die();
    private Board board;
    
    public TurnLogic(Board board){
        this.board = board;
    }
    
    public void takeTurn(Player player){
        die.roll();
        Square nextLocation = board.nextLocation(player.getLocation(), die.getFaceValue());
        player.setLocation(nextLocation);
        landedOn(player);
    }
    
    private void landedOn(Player player){
        
        Square 
        
        switch(String..){
            case "Property":
                Property(player);
                break;
            case "Jail":
                break;
        }
        
        
        player.getLocation()
    }
    
    public void Property(){
    
    }
    
    public void Jail(){
    
    }
    
    
}
