package test;

import java.util.Random;

public class DieStub {
    
    private final int N_SIDES = 6;
    private int dieValue = 0;
    private int[] rolls = {1, 1, 6, 11, 17, 1, 11, 18, 18, 2, 7, 1, 3, 1, 3, 6 ,3 ,8, 4, 5, 4, 5, 4, 5};
    private int counter = 0;
    
    public int  getFaceValue(){
        return this.dieValue;
    }
 
    public void roll(){
        this.dieValue = rolls[counter];
        counter++;
    }
    
    public String toString (){
        return "dieValue: " + dieValue;
    }
    
}
