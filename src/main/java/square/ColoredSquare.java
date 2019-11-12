package square;

import game_classes.Player;

public class ColoredSquare extends PropertySquare {
    public ColoredSquare(String name, int index, String color, int price, Player owner) {
        super(name, index, color, price, owner);
    }

    public void payRent(Player p) {
        p.addPoints(-getPrice());

    }

    public void getRent() {
        getOwner().addPoints(getPrice());

    }
}
