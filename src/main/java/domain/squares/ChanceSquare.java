package domain.squares;

import domain.Board;
import domain.ChanceCards.ChanceCard;
import domain.Player;

import java.util.Random;

// Chance holds chance cards that affect player randomly
public class ChanceSquare extends Square {
    
    private final int N_CHANCECARDS = 4;
    ChanceCard[] chanceCards = new ChanceCard[N_CHANCECARDS];

// Chance cards are defined her
    public ChanceSquare(String name, int index, Board board) {
        super(name, index, board);
        
        //todo skal nok flyttes til en txt
//        chanceCards[0] = new ChanceCard("Fødselsdag",0,2);
//        chanceCards[1] = new ChanceCard("Ryk 3 frem",3,0);
//        chanceCards[2] = new ChanceCard("Lotto",0,2);
//        chanceCards[3] = new ChanceCard("Ryk 5 frem",5,0);
    }

    // Pulls a random card from chancecards array and affects the player with it.
    public void landedOn(Player p) {
    
        int rng = new Random().nextInt(N_CHANCECARDS);
//        chanceCards[rng].applyEffect(p);
        
//        p.setLocation(board.nextLocation(this,chanceCards[rng].getMove()));
//        p.withdraw((chanceCards[rng].getPrice()));
//        if(chanceCards[rng].getMove()>0){
//            p.getLocation().landedOn(p);
//        }
        
    }

    public ChanceCard[] getChanceCards() {
        return chanceCards;
    }

}
