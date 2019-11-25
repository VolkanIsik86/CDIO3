package domain;

import controllers.GUILogic;
import domain.squares.RegularSquare;
import domain.squares.Square;
import org.junit.Test;
import services.TxtReader;

import static org.junit.Assert.*;

public class PieceTest {
    
    @Test
    public void getType() {
        
        TxtReader squaresTxt = new TxtReader("src/main/java/services/languagefiles/", "squares_da");
        TxtReader landedOnTxt = new TxtReader("src/main/java/services/languagefiles/", "landedOn_da");
        GUILogic guiLogic = new GUILogic(squaresTxt);
        RegularSquare square = new RegularSquare("Test",0, guiLogic, landedOnTxt);
        
        Piece test = new Piece(square);
        
        
    }
}