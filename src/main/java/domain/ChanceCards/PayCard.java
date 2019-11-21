package domain.ChanceCards;

import domain.Player;

public class PayCard extends ChanceCard {
    
    int amount;
    
    public PayCard(String type, int amount) {
        super(type);
        this.amount = amount;
    }
    
    public void applyEffect(Player p){
        if (p.attemptToPay(amount)){
            p.withdraw(amount);
        } else {
            p.setLost(true);
            p.setBalance(0);
        }
    }
    
}
