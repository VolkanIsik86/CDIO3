package domain;

import domain.squares.PropertySquare;
import domain.squares.Square;

public class Player {
    
    private String name;
    private int age;
    private Account account;
    private Piece piece;
    private boolean lost = false;
    private boolean jail = false;
    
    public Player(String name, int age, int balance, Piece piece){
        this.name = name;
        this.age = age;
        account = new Account(balance);
        this.piece = piece;

    }

    public void setLost(boolean status){
        lost = status;
    }
    
    public void setJail(boolean status){
        jail = status;
    }
    
    public boolean attemptToPurchase(PropertySquare property){
        if (property.getPrice() > this.getBalance())
            return false;
        else
            return true;
    }
    
    public boolean attemptToPay(int amount){
        if (amount > this.getBalance())
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
    
    public int getBalance(){
        return account.getBalance();
    }
    
    public void setBalance(int points){
        account.setBalance(points);
    }
    
    public void withdraw(int amount){
        account.withdraw(amount);
    }
    
    public void deposit(int amount){
        account.deposit(amount);
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
                ", lost=" + lost +
                ", jail=" + jail +
                '}';
    }
}

