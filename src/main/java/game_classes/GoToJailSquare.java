package game_classes;

public class GoToJailSquare extends Square {
    public GoToJailSquare(String name, int index, String color) {
        super(name, index, color);
    }

    @Override
    public void landedOn(Piece p) {
        p.setLocation(Square jail);
    }
}
