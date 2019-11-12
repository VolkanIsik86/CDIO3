package game_classes.square;

import game_classes.Player;

public class ChanceSquare extends Square {
    ChanceCard [] chanceCards = new ChanceCard[4];

    public ChanceSquare(String name, int index) {
        super(name, index);
        chanceCards[0] = new ChanceCard("Fødselsdag",0,2);
        chanceCards[1] = new ChanceCard("Ryk 3 frem",3,0);
        chanceCards[2] = new ChanceCard("Lotto",0,2);
        chanceCards[3] = new ChanceCard("Ryk 5 frem",5,0);
    }

    public ChanceCard[] getChanceCards() {
        return chanceCards;
    }
    public void landedOn(Player p) {
        controller.pullCard(p,chanceCards);
    }
}
