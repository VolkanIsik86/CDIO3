package domain.ChanceCards;

//Chance card that has point and move modifier.

import controllers.GUILogic;
import domain.ChanceDeck;
import domain.Player;
import services.TxtReader;

public abstract class ChanceCard {
    
    private String type;
    private String description;
    protected GUILogic guiLogic;
    protected TxtReader cardsTxt;
    protected ChanceDeck chanceDeck;

    public ChanceCard(String type, String description, GUILogic guiLogic, TxtReader cardsTxt, ChanceDeck chanceDeck) {
        this.type = type;
        this.description = description;
        this.guiLogic = guiLogic;
        this.cardsTxt = cardsTxt;
        this.chanceDeck = chanceDeck;
        
    }

    public String getDescription(){
        return description;
    }
    
    public String getType() {
        return type;
    }
    
    
    public abstract void applyEffect(Player p);
    
}
