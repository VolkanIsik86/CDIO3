package domain.squares;

import domain.Board;
import domain.Player;

import java.util.Random;

// chance square som inde holde chancekorte
public class ChanceSquare extends Square {
    ChanceCard [] chanceCards = new ChanceCard[4];

// kontruktøren definere korterne her
    public ChanceSquare(String name, int index, Board board) {
        super(name, index, board);
        chanceCards[0] = new ChanceCard("Fødselsdag",0,2);
        chanceCards[1] = new ChanceCard("Ryk 3 frem",3,0);
        chanceCards[2] = new ChanceCard("Lotto",0,2);
        chanceCards[3] = new ChanceCard("Ryk 5 frem",5,0);
    }

    public void landedOn(Player p) {
        int rng = new Random().nextInt(4);
        p.setLocation(board.nextLocation(this,chanceCards[rng].getMove()));
        p.addPoints((chanceCards[rng].getPrice()));
    }

    public ChanceCard[] getChanceCards() {
        return chanceCards;
    }

}
