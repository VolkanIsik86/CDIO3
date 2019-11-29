package domain.chanceCards;

//Chance card that has point and move modifier.

import controllers.GUILogic;
import domain.ChanceDeck;
import domain.Player;

public abstract class ChanceCard {
    
    private final String type;
    private final String description;
    protected final GUILogic guiLogic;

    ChanceCard(String type, String description, GUILogic guiLogic, ChanceDeck chanceDeck) {
        this.type = type;
        this.description = description;
        this.guiLogic = guiLogic;
    }

    public String getDescription(){
        return description;
    }
    
    public String getType() {
        return type;
    }
    
    public abstract void applyEffect(Player p);
    
}
