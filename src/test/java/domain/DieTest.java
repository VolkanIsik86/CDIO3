package domain;

import org.junit.Test;

import static org.junit.Assert.*;

//Testing the correctness and fairness of the die

public class DieTest {
    
    private final Die die = new Die();
    
    @Test
    public void roll() {
        
        double[] rolls = new double[6];
        
        for (int i = 0; i < 6000000; i++) {
            die.roll();
            
            //Check to see if facevalue is integer from 1-6
            assertTrue(die.getFaceValue()%1==0);
            assertEquals(3.5, die.getFaceValue(),2.5);
            
            //And record in array
            rolls[die.getFaceValue()-1]++;

        }
    
        //Check to see if distribution is fair
        double[] expected = {1000000, 1000000, 1000000, 1000000, 1000000, 1000000};
        assertArrayEquals(expected, rolls, 10000);
        
    }
    
    
}