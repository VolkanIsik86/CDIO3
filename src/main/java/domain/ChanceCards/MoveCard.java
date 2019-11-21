package domain.ChanceCards;

import domain.Player;

public class MoveCard extends ChanceCard {
    
    private int moves;
    
    public MoveCard(String type, int moves) {
        super(type);
        this.moves = moves;
    }

    public void applyEffect(Player p){
    
    }
    
}
