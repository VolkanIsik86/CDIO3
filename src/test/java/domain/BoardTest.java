package domain;

import controllers.GUILogic;
import domain.squares.*;
import org.junit.Test;
import services.TxtReader;
import static org.junit.Assert.*;

//Testes kun positivt, da brugeren ikke skal interegere direkte med objektet

public class BoardTest {
    
    private String languagePath = "src/main/java/services/languagefiles/";
    
    private TxtReader squareTxt = new TxtReader();
    private TxtReader landedOnTxt = new TxtReader();
    private TxtReader cardsTxt = new TxtReader();
    private TxtReader guiTxt = new TxtReader();

    private GUILogic guiLogic;
    private Board board = new Board();
    
    private Player player;
    
    public BoardTest(){
        squareTxt.openFile(languagePath,"squares_da");
        squareTxt.readLines();
        
        landedOnTxt.openFile(languagePath,"landedOn_da");
        landedOnTxt.readLines();
        
        cardsTxt.openFile(languagePath,"chanceCards_da");
        cardsTxt.readLines();
        
        guiTxt.openFile(languagePath, "guitext_da");
        guiTxt.readLines();
        

        board.makeBoard(squareTxt, landedOnTxt, cardsTxt, guiLogic);
        
        player = new Player("Mikkel", 23, 20, new Piece(board.getStart()), guiLogic);
    }
    
    @Test
    public void getSquare() {

        assertEquals("Chancen", board.getSquare(3).getName());
        assertEquals(3, board.getSquare(3).getIndex());
        assertEquals(ChanceSquare.class, board.getSquare(3).getClass());
        
        assertEquals("Start", board.getSquare(0).getName());
        assertEquals(0, board.getSquare(0).getIndex());
        assertEquals(RegularSquare.class, board.getSquare(0).getClass());
        
        assertEquals("Skaterparken",board.getSquare(10).getName());
        assertEquals(10, board.getSquare(10).getIndex());
        assertEquals(PropertySquare.class, board.getSquare(10).getClass());
        
        assertEquals("Strandpromenaden",board.getSquare(23).getName());
        assertEquals(23, board.getSquare(23).getIndex());
        assertEquals(PropertySquare.class, board.getSquare(23).getClass());
    }
    
    @Test
    public void nextLocation() {
        assertEquals(4, board.nextLocation(player, 4).getIndex());
        
        player.setLocation(board.getSquare(4));
        assertEquals(9, board.nextLocation(player, 5).getIndex());
        
        player.setLocation(board.getSquare(23));
        assertEquals(1, board.nextLocation(player,2).getIndex());
        
    }
}