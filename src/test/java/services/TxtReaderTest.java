package services;

import org.junit.Test;

import static org.junit.Assert.*;

public class TxtReaderTest {
    
    TxtReader txt = new TxtReader("src/test/java/service/","testText");
    
    @Test
    public void getLine() {
        assertEquals("Tekst1",txt.getLine("key"));
        assertEquals("Tekst med mellemrum",txt.getLine("key2"));
        assertEquals("Tekst2",txt.getLine("key med mellemrum"));
        assertEquals("Tekst3",txt.getLine("1 tal først"));
        assertEquals("samme1",txt.getLine("Samme key"));
    }
}