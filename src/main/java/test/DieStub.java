package test;

import java.util.Random;

public class DieStub {
    
    private final int N_SIDES = 6;
    private int dieValue = 0;
    private int[] rolls = {1,1,2,4,1,4,4,3,9,11,   18,1,1,1};
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
