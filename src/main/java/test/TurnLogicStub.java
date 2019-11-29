package test;

import controllers.GUILogic;
import controllers.TurnLogic;
import domain.Board;
import domain.Player;
import domain.squares.Square;
import services.TxtReader;

public class TurnLogicStub extends TurnLogic {
    
    public void init(Board board, GUILogic guiLogic, TxtReader landedOnTxt){
        super.init(board, guiLogic, landedOnTxt);
    }
    
    @Override
    public void takeTurn(Player player){
    
        String name = player.getName();
    
        System.out.println("\n" + name + "'s tur");
        System.out.print("Stod på " + player.getLocation().getIndex());
        System.out.println(", " + player.getLocation().getClass());
        System.out.println("Balancen var: " + player.getBalance());
    
        //Roll the die
        die.roll();
        int roll = die.getFaceValue();
        player.setLastRoll(roll);
        guiLogic.displayDie(roll, player.getName());
    
        System.out.println("Slog: " + roll);
    
        //Calculate and move to next location
        Square nextLocation = board.nextLocation(player, die.getFaceValue());
        player.setLocation(nextLocation);
        guiLogic.movePiece(player, player.getLastRoll());
    
        System.out.print("Står nu på: " + player.getLocation().getIndex());
        System.out.println(", " + player.getLocation().getClass());
    
        //Apply the square's effect to the player
        nextLocation.landedOn(player);
    
        guiLogic.showMessage(landedOnTxt.getLine("End turn"));
        
        
    }
    
}
