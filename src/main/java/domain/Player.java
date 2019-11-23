package domain;

import controllers.GUILogic;
import domain.squares.PropertySquare;
import domain.squares.Square;

public class Player {
    
    private GUILogic guiLogic;
    private Account account;
    private Piece piece;
    
    private String name;
    private int age;
   
    private boolean lost = false;
    private boolean jail = false;
    private int lastRoll = 0;
    
    public Player(String name, int age, int balance, Piece piece, GUILogic guiLogic){
        this.name = name;
        this.age = age;
        account = new Account(balance);
        this.piece = piece;
        this.guiLogic = guiLogic;
    }
    
    public void setLastRoll(int lastRoll) {
        this.lastRoll = lastRoll;
    }
    
    public void setJail(boolean status){
        jail = status;
    }
    
    public boolean getJail(){
        return jail;
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
    
    public boolean equals(Player player){
        
        if (this.getName().equals(player.getName())){
            return true;
        } else {
            return false;
        }
        
    }
    
    public void setLocation(Square newLocation){
        piece.setLocation(newLocation);
    }
    
    public boolean getChanceStatus() {
        return piece.getChanceStatus();
    }
    
    public boolean getLost() {
        return lost;
    }

    public void setLost(boolean status) {
        this.lost = status;
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
    
    public int getAge() {
        return age;
    }
    
    public Square getLastLocation(){
        return piece.getLastLocation();
    }
    
    public int getLastRoll(){
        return lastRoll;
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

