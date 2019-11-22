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
        
    }

    // Pulls a random card from chancecards array and affects the player with it.
    
    //todo skal skrives færdig
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
