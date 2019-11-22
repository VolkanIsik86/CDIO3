package domain;

import domain.ChanceCards.ChanceCard;
import domain.ChanceCards.EarnCard;

import domain.ChanceCards.MoveCard;
import domain.ChanceCards.PayCard;
import services.TxtReader;

public class ChanceDeck {
    
    private final int N_CARDS;
    private ChanceCard[] chanceCards;
    
    //Creates all the Chance cards and adds them to an array
    public ChanceDeck(String path, String file) {
    
        TxtReader cDec = new TxtReader(path, file);
        N_CARDS = cDec.getN_LINES();
        chanceCards = new ChanceCard[N_CARDS];
    
        //For all cards
        for (int i = 0; i < N_CARDS; i++) {
    
            //Extract corresponding card description
            String[] oneLine = cDec.getLine(String.valueOf(i)).split("-");
    
//            //Create the proper card subclass and places it in array
//            if ("Earn".equalsIgnoreCase(oneLine[0])) {
//                chanceCards[i] = new EarnCard(oneLine[1], Integer.parseInt(oneLine[2]),this);
//            } else if ("Move".equals(oneLine[0])) {
//                chanceCards[i] = new MoveCard(oneLine[1], Integer.parseInt(oneLine[2]),this, Integer.parseInt(oneLine[3]), oneLine[4]);
//            } else if ("Pay".equals(oneLine[0])) {
//                chanceCards[i] = new PayCard(oneLine[1], Integer.parseInt(oneLine[2]), this);
//
        }
    
    }
}

