package controllers;

import domain.*;
import domain.squares.*;
import gui_fields.GUI_Player;
import services.TxtReader;


public class TurnLogic {
    
    private Die die = new Die();
    private Board board;
    private GUILogic guiLogic;
    private TxtReader landedOnTxt;
    
    public TurnLogic(Board board, GUILogic guiLogic, TxtReader landedOnTxt) {
        this.board = board;
        this.guiLogic = guiLogic;
        this.landedOnTxt = landedOnTxt;
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
        guiLogic.movePiece(player, player.getLastRoll());
        
        //Apply the square's effect to the player
        nextLocation.landedOn(player);
        
        guiLogic.showMessage(landedOnTxt.getLine("End turn"));
        
    }
}
