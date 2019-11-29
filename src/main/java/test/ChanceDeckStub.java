package test;

import controllers.GUILogic;
import domain.Board;
import domain.ChanceDeck;
import domain.chanceCards.ChanceCard;
import services.TxtReader;

public class ChanceDeckStub extends ChanceDeck {
    
    private int counter = 0;
    private final int[] pullSequence = {0, 4, 11};
    
    public ChanceDeckStub(GUILogic guiLogic, TxtReader cardsTxt, Board board){
        super(guiLogic, cardsTxt, board);
    }
    
    @Override
    public ChanceCard pullRandomChanceCard(){
        return chanceCards[pullSequence[counter++]];
    }
    
}
