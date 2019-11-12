package square;

import game_classes.Player;

public class GoToJailSquare extends Square {
    public GoToJailSquare(String name, int index) {
        super(name, index);
    }

    public void landedOn(Player p) {
        p.setLocation();

    }


}
