package domain.ChanceCards;

import controllers.GUILogic;
import domain.ChanceDeck;
import domain.Player;
import gui_main.GUI;
import services.TxtReader;

public class PayCard extends ChanceCard {
    
    int amount;
    
    public PayCard(String type, String description, GUILogic guiLogic, TxtReader cardsTxt, ChanceDeck chanceDeck, int amount) {
        super(type, description, guiLogic, cardsTxt, chanceDeck);
        this.amount = amount;
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
