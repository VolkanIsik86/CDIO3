package game_classes;

import game_classes.square.PropertySquare;
import game_classes.square.Square;

public class Player {
    
    private String name;
    private int age;
    
    private Account account;
    private Die die;
    private Board board;
    private Piece piece;
    
    public Player(String name, int age, int points, String pieceType, Board board){
        this.name = name;
        this.age = age;
        this.board = board;
        account = new Account(points);
        die = new Die();
        piece = new Piece(board.getSquare(1), pieceType);
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
    
    public Square getSquare(int index){
        return board.getSquare(index);
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
                ", die=" + die +
                ", board=" + board +
                ", piece=" + piece +
                '}';
    }
}

