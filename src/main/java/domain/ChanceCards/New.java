package domain.ChanceCards;

import domain.Player;

public class New extends ChanceCard{
    
    public New(String name, int move, int price) {
        super(name, move, price);
    }
    
    public boolean applyEffect(Player p){
        return true;
    }
    
}
