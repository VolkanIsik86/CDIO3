package domain;

import java.util.Random;

public class Die {

    private int dieValue = 0;
    private final Random rnd = new Random();

    public int  getFaceValue(){
        return this.dieValue;
    }
    
    // finder et tilfældigt tal mellem 1 og antal sider som vælges i main
    public void roll(){
        int n_SIDES = 6;
        this.dieValue = (rnd.nextInt(n_SIDES)+1);
    }
    
    // skriver ud
    public String toString (){
        return "dieValue: " + dieValue;
        
    }
}
