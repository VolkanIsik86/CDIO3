package domain.squares;

import controllers.GUILogic;
import domain.Board;
import domain.ChanceCards.ChanceCard;
import domain.ChanceDeck;
import domain.Player;
import services.TxtReader;

import java.util.Random;

// Chance holds chance cards that affect player randomly
public class ChanceSquare extends Square {
    
    private final int N_CHANCECARDS = 4;
    private ChanceCard[] chanceCards = new ChanceCard[N_CHANCECARDS];
    private Board board;
    private ChanceDeck chanceDeck;
    
    //Constructor
    public ChanceSquare(String name, int index, GUILogic guiLogic, TxtReader landedOnTxt, Board board, ChanceDeck chanceDeck) {
        super(name, index, guiLogic, landedOnTxt);
        this.board = board;
        this.chanceDeck = chanceDeck;
    }

    // Pulls a random card from chancecards array and affects the player with it.
    public void landedOn(Player player) {
    
        guiLogic.showMessage(landedOnTxt.getLine("Chance square"));
        ChanceCard pulledCard = chanceDeck.pullRandomChanceCard();
        guiLogic.showChanceCard(pulledCard.getDescription());
        guiLogic.showMessage(landedOnTxt.getLine("Tryk OK"));
        pulledCard.applyEffect(player);
        
    }
}
