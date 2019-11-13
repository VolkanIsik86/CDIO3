package controllers;

import domain.*;
import domain.squares.*;


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
    
    }
    
    public void Property(){
    
    }
    
    public void Jail(){
    
    }
    
    
}
