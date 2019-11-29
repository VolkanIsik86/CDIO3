package domain.chanceCards;

import controllers.GUILogic;
import domain.ChanceDeck;
import domain.Player;
import services.TxtReader;

public class PayCard extends ChanceCard {
    
    private final int amount;
    private final TxtReader cardsTxt;
    
    public PayCard(String type, String description, GUILogic guiLogic, ChanceDeck chanceDeck, int amount, TxtReader cardsTxt) {
        super(type, description, guiLogic, chanceDeck);
        this.amount = amount;
        this.cardsTxt = cardsTxt;
    }
    
    public void applyEffect(Player player){
        if (player.attemptToPay(amount)){
            player.withdraw(amount);
            guiLogic.setPlayerBalance(player);
        } else {
            player.setLost(true);
            player.setBalance(0);
            guiLogic.showMessage(cardsTxt.getLine("Does not have fonds to pay"));
            guiLogic.setPlayerBalance(player);
        }
    }
    
}
