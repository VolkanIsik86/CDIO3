package controllers;

import domain.*;
import domain.squares.*;


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

        die.roll();
        int roll = die.getFaceValue();
        guiLogic.displayDie(roll);

        Square nextLocation = board.nextLocation(player.getLocation(), die.getFaceValue());
        nextLocation.landedOn(player);
        player.setLocation(nextLocation);
        //sætter spillerens pengebeholdning til at være den samme i GUI-Logikken som i spil-logikken.
        guiLogic.setPlayerBalance(guiLogic.getPlayer(player.getName()),player.getBalance());

        
        // todo taketurn skal ikke returnere en int, men det skal fixes i Game og Gui logic
        return die.getFaceValue();
    
    }
}
