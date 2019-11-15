package domain;

import domain.squares.PropertySquare;
import domain.squares.Square;

public class Player {
    
    private String name;
    private int age;
    private Account account;
    private Piece piece;
    private boolean lost = false;
    
    
    public Player(String name, int age, int points, Piece piece){
        this.name = name;
        this.age = age;
        account = new Account(points);
        this.piece = piece;

    }
    
    public boolean attempPurchase(PropertySquare property){
        if (property.getPrice() > this.getPoints())
            return false;
        else
            return true;
    }
    
    public void setLocation(Square newLocation){
        piece.setLocation(newLocation);
    }
    
    public Square getLocation(){
        return piece.getLocation();
    }
    
    public int getType(){
        return piece.getType();
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
    
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", account=" + account +
                ", piece=" + piece +
                '}';
    }
}

