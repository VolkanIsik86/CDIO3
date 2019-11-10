package game_classes;

// Creates a Player object with name and an account belongs to it.

public class Player {
    
    private String name;
    private Account account;
    private int age;
    private Die die;
    
    public Player(String name, int points, int age){
        this.name = name;
        this.age = age;
        account = new Account(points);
        die = new Die();
    }
    
    public int getPoints(){
        return account.getPoints();
    }
    
    public void setPoints(int points){
        account.setPoints(points);
    }
    
    public void addPoints(int points){
        account.addPoints(points);
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void takeTurn(){
        die.roll();
        Square nextLocation = piece.nextLocation(die.getFaceValue());
        piece.setLocation(nextLocation);
        
    }
    
   
   
    
    
    
    
    
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", account=" + account +
                ", age=" + age +
                ", die=" + die +
                '}';
    }
}

