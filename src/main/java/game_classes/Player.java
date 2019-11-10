package game_classes;

// Creates a Player object with name and an account belongs to it.

public class Player {
    private String name;
    private Account account;
    
    public Player(String name, int points){
        this.name = name;
        account = new Account(points);
    }
    // Setter and getters for player class that uses account class.
    public void addPoints(int points){
        account.addPoints(points);
    }
    
    public int getPoints(){
        return account.getPoints();
    }
    
    public void setPoints(int points){
        account.setPoints(points);
    }
    
    // Setter and getters for player class that uses account class.
    public String getName(){
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String toString() {
        return "name: " + name + " " + "Account: " + account;
    }
}

