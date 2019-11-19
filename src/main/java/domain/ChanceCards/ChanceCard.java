package domain.ChanceCards;

//Chance card that has point and move modifier.

import domain.Player;

public abstract class ChanceCard {
    private String name;
    private int move;
    private int price;

    public ChanceCard(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public abstract void applyEffect(Player p);
    
}
