package domain.ChanceCards;

//Chance card that has point and move modifier.

import domain.Player;

public abstract class ChanceCard {
    private String type;

    public ChanceCard(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    
    public abstract void applyEffect(Player p);
    
}
