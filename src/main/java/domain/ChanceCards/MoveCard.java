package domain.ChanceCards;

import domain.Player;

public class MoveCard extends ChanceCard {
    
    public MoveCard(String name, int move, int price) {
        super(name, move, price);
    }

    public boolean applyEffect(Player p){
        return true;
    }
    
}
