package test;

public class DieStub {
    
    private int dieValue = 0;
    
    /*
   // Talrækker til de forskellige testcases:
   
   T01 backendvsgui: {1, 1, 2, 4, 1, 4, 4, 3, 9, 11, 18, 1, 1, 1}
   T02 1. PropertySquare.landedOn(): {1, 1, 23, 16, 1, 7, 13, 13, 8}
   T02 2. PropertySquare.landedOn(): {1, 1, 23, 16, 1, 7, 13, 13, 2, 1}
   T03 Flest point vinder:
       2. spillere: {19}
       3. spillere: {1, 19}
       4. spillere: {1, 2, 19}
       
    */
    
    private int[] rolls = {1, 1, 23, 16, 1, 7, 13, 13, 2, 1};

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
