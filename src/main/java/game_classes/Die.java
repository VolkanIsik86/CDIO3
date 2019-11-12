package game_classes;

import java.util.Random;

public class Die {
    
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
        this.dieValue = (rnd.nextInt(6)+1);
    }
    
    // skriver ud
    public String toString (){
        return "dieValue: " + dieValue;
        
    }
}
