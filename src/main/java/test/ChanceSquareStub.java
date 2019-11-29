package test;

import controllers.GUILogic;
import domain.ChanceDeck;
import domain.Player;
import domain.chanceCards.ChanceCard;
import domain.chanceCards.MoveCard;
import domain.squares.ChanceSquare;
import services.TxtReader;

public class ChanceSquareStub extends ChanceSquare {
    
    public ChanceSquareStub(String name, int index, GUILogic guiLogic, TxtReader landedOnTxt, ChanceDeck chanceDeck){
        super(name, index, guiLogic, landedOnTxt, chanceDeck);
    }
    
    @Override
    public void landedOn(Player player) {
    
        guiLogic.showMessage(landedOnTxt.getLine("Chance square"));
        
        ChanceCard pulledCard = chanceDeck.pullRandomChanceCard();
        System.out.println("Har trukket et: " + pulledCard.getClass());
        System.out.println(pulledCard.getDescription());
        
        guiLogic.showChanceCard(pulledCard.getDescription());
        guiLogic.showMessage(landedOnTxt.getLine("Press OK"));
        
        pulledCard.applyEffect(player);
        
        if (!(pulledCard instanceof MoveCard)){
            System.out.println(player.getName() + "'s balance " + player.getBalance());
        }
        
    }
}
