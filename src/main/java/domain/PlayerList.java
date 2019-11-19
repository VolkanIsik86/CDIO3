package domain;

//Creates and maintains a list of players

import domain.squares.Square;

public class PlayerList {
    
    Player[] players = new Player[0];
    Square startSquare;
    
    public PlayerList(Square startSquare){
        this.startSquare = startSquare;
    }
    
    public void addPlayer(String name, int age, int Balance){
        
        // Increase size of player-array by 1
        Player[] temp = new Player[players.length+1];
        for (int i = 0; i < players.length; i++) {
            temp[i] = players[i];
        }
        players = temp;
        
        //Create player's piece
        Piece piece = new Piece(startSquare);
        
        //Create and add new player to array
        players[players.length-1] = new Player(name, age, Balance, piece);
        
    }
    
    public Player getPlayer(int index){
        return players[index];
    }
    
    public int NumberOfPlayers(){
        return players.length;
    }
    //Returnerer player array
    public Player [] getPlayers(){
        return players;
    }
    
}
