package domain;

import controllers.GUILogic;
import domain.squares.RegularSquare;
import org.junit.Test;
import services.TxtReader;

import static org.junit.Assert.*;

//Testing the static numbering of new pieces

public class PieceTest {
    
    private RegularSquare square = new RegularSquare("TestSquare", 1, new GUILogic(), new TxtReader());
    private Piece testPiece1 = new Piece(square);
    private Piece testPiece2 = new Piece(square);
    private Piece testPiece3 = new Piece(square);

    @Test
    public void getType() {
        assertEquals(0,testPiece1.getType());
        assertEquals(1,testPiece2.getType());
        assertEquals(2,testPiece3.getType());


    }
}