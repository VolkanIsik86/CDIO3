package domain.ChanceCards;

import domain.Player;

public class EarnCard extends ChanceCard{
    
    int amount;
    
    public EarnCard(String name, int amount) {
        super(name);
        this.amount = amount;
    }
    
    public void applyEffect(Player p){
        p.deposit(amount);
    }
    
}
