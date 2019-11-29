package domain;

import controllers.GUILogic;
import domain.chanceCards.ChanceCard;
import domain.chanceCards.EarnCard;

import domain.chanceCards.MoveCard;
import domain.chanceCards.PayCard;
import services.TxtReader;

import java.util.Random;

public class ChanceDeck {
    
    private final int N_CARDS = 14;
    protected final ChanceCard[] chanceCards;
    private final Random rnd = new Random();
    
    //Creates all the Chance cards and adds them to an array
    public ChanceDeck(GUILogic guiLogic, TxtReader cardsTxt, Board board) {
        
        chanceCards = new ChanceCard[N_CARDS];
    
        //For all cards
        for (int i = 0; i < N_CARDS; i++) {
    
            //Extract corresponding card description
            String[] oneLine = cardsTxt.getLine(String.valueOf(i)).split("-");
    
            //Creates the proper card subclass and places it in array
            if ("Earn".equalsIgnoreCase(oneLine[0])) {
                chanceCards[i] = new EarnCard(oneLine[0], oneLine[2], guiLogic, this, Integer.parseInt(oneLine[1]));
                
            } else if ("Move".equals(oneLine[0])) {
                chanceCards[i] = new MoveCard(oneLine[0], oneLine[2], guiLogic, this, Integer.parseInt(oneLine[1]), board);
                
            } else if ("Pay".equals(oneLine[0])) {
                chanceCards[i] = new PayCard(oneLine[0], oneLine[2], guiLogic, this, Integer.parseInt(oneLine[1]), cardsTxt);
    
            }
    
        }
    }
    
    public ChanceCard pullRandomChanceCard(){
    
        int i = rnd.nextInt(N_CARDS);
        return chanceCards[i];
        
    }
    
}

