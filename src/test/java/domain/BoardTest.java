package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    
    Board board = new Board("src/main/java/services/","squareDescriptions");
    
    // todo hurtig test, skal muligvis udbygges
    
    @Test
    public void getSquare() {
        
        assertEquals("Chancen", board.getSquare(3).getName());
        
    }
}