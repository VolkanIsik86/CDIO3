package domain.ChanceCards;

import controllers.GUILogic;
import domain.ChanceDeck;
import domain.Player;

public class EarnCard extends ChanceCard{
    
    int amount;
    
    public EarnCard(String type, String description, GUILogic guiLogic, ChanceDeck chanceDeck, int amount) {
        super(type, description, guiLogic, chanceDeck);
        this.amount = amount;
    }
    
    public void applyEffect(Player player){

        player.deposit(amount);
        guiLogic.setPlayerBalance(player);
    }
    
}

