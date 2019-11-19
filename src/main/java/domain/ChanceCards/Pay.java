package domain.ChanceCards;

import domain.Player;

public class Pay extends ChanceCard {
    
    public Pay(String name, int move, int price) {
        super(name, move, price);
    }
    
    public boolean applyEffect(Player p){
        return true;
    }
    
}
