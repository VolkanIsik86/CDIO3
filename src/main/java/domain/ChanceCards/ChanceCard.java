package domain.ChanceCards;

//Chance card that has point and move modifier.

import controllers.GUILogic;
import domain.ChanceDeck;
import domain.Player;

public abstract class ChanceCard {
    
    private String type;
    private String description;
    protected GUILogic guiLogic;
    protected ChanceDeck chanceDeck;

    public ChanceCard(String type, String description, GUILogic guiLogic, ChanceDeck chanceDeck) {
        this.type = type;
        this.description = description;
        this.guiLogic = guiLogic;
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
