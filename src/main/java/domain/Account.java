package domain;

//Formålet med account-klassen er at holde styr på spillernes point

public class Account {
    private int points;
    
    public Account(int points){
        this.points = points;
    }
    
    public int getPoints(){
        return points;
    }
    
    public void setPoints(int points){
        this.points = points;
    }
    
    public void addPoints(int addition){
        points = points + addition;
        if (points <= 0 ){
            points = 0;
        }
    }
    
    public String toString(){
        return "Points: " + points;
    }
    
}
