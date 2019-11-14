package controllers;

import domain.*;
import domain.squares.*;


public class TurnLogic {
    
    private Die die = new Die();
    private Board board;

    
    public TurnLogic(Board board){
        this.board = board;
    
        // todo udkommenter når Squarelogic er opdateret
//        squareLogic = new SquareLogic(board);
    }
    
    public void takeTurn(Player player){
        die.roll();
        Square nextLocation = board.nextLocation(player.getLocation(), die.getFaceValue());
        player.setLocation(nextLocation);
        
        // todo udkommenter når Squarelogic er opdateret
//        squareLogic.landedOn(player);
    }
    
    public void takeRound(){
    
    }
    
    
}
