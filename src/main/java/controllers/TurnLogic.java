package controllers;

import domain.*;
import domain.squares.*;
import gui_fields.GUI_Player;


public class TurnLogic {
    
    private Die die = new Die();
    private Board board;
    private GUILogic guiLogic;
    
    public TurnLogic(Board board, GUILogic guiLogic)
    {
        this.board = board;
        this.guiLogic = guiLogic;
    }
    
    public int takeTurn(Player player) {
    
        GUI_Player guiPlayer = guiLogic.getPlayer(player.getName());
        
        die.roll();
        int roll = die.getFaceValue();
        player.setLastRoll(roll);
        guiLogic.displayDie(roll);

        Square nextLocation = board.nextLocation(player.getLocation(), die.getFaceValue());
        player.setLocation(nextLocation);
        
        nextLocation.landedOn(player);
        
        //sætter spillerens pengebeholdning til at være den samme i GUI'en som i backenden.
        guiLogic.setPlayerBalance(guiPlayer,player.getBalance());
        
        // todo taketurn skal ikke returnere en int, men det skal fixes i Game og Gui logic først
        return die.getFaceValue();
    
    }
}
