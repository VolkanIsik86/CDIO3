package domain.ChanceCards;

import domain.Player;

public class EarnCard extends ChanceCard{
    
    int amount;
    
    public EarnCard(String type, int amount) {
        super(type);
        this.amount = amount;
    }
    
    public void applyEffect(Player p){
        p.deposit(amount);
    }
    
}
