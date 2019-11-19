package domain;

import java.util.Random;

public class Die {
    
    private final int N_SIDES = 6;
    private int dieValue = 0;
    private Random rnd = new Random();
    
    // Sætter antal øjne
    public void setFaceValue(int value) {
        this.dieValue = value;
    }
    
    public int  getFaceValue(){
        return this.dieValue;
    }
    
    // finder et tilfældigt tal mellem 1 og antal sider som vælges i main
    public void roll(){
        this.dieValue = (rnd.nextInt(N_SIDES)+1);
    }
    
    // skriver ud
    public String toString (){
        return "dieValue: " + dieValue;
        
    }
}
