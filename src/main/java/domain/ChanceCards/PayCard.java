package domain.ChanceCards;

import domain.Player;

public class PayCard extends ChanceCard {
    
    public PayCard(String name, int move, int price) {
        super(name, move, price);
    }
    
    public boolean applyEffect(Player p){
        return true;
    }
    
}
