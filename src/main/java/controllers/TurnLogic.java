package controllers;

import domain.*;
import domain.squares.*;
import gui_fields.GUI_Player;


public class TurnLogic {
    
    private Die die = new Die();
    private Board board;
    private GUILogic guiLogic;
    
    public TurnLogic(Board board, GUILogic guiLogic) {
        this.board = board;
        this.guiLogic = guiLogic;
    }
    
    public void takeTurn(Player player) {
        
        //Roll the die
        die.roll();
        int roll = die.getFaceValue();
        player.setLastRoll(roll);
        guiLogic.displayDie(roll);

        //Calculate and move to next location
        Square nextLocation = board.nextLocation(player, die.getFaceValue());
        player.setLocation(nextLocation);
        guiLogic.movePiece(player);
        
        //Apply the squares effect to the player
        nextLocation.landedOn(player);
        
    }
}
