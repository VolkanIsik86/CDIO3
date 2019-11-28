package services;

import org.junit.Test;

import static org.junit.Assert.*;

//Testes kun positivt, da brugeren ikke skal interegere direkte med objektet

public class TxtReaderTest {
    
    private TxtReader txt = new TxtReader();
    
    public TxtReaderTest(){
        txt.openFile("src/test/java/services/","testText");
        txt.readLines();
    }
    
    @Test
    public void getLine() {
        
        assertEquals(6,txt.getN_LINES());
        assertEquals("Tekst1",txt.getLine("key"));
        assertEquals("Tekst med mellemrum",txt.getLine("key2"));
        assertEquals("Tekst2",txt.getLine("key med mellemrum"));
        assertEquals("Tekst3",txt.getLine("1 tal først"));
        assertEquals("samme1",txt.getLine("Samme key"));
    }
}