package domain.ChanceCards;

import domain.Player;

public class Move extends ChanceCard {
    
    public Move(String name, int move, int price) {
        super(name, move, price);
    }

    public boolean applyEffect(Player p){
        return true;
    }
    
}
