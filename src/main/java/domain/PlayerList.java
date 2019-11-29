package domain;

//Creates and maintains a list of players

import controllers.GUILogic;
import domain.squares.Square;

public class PlayerList {
    
    private Player[] players = new Player[0];
    private final Square startSquare;
    private final GUILogic guiLogic;
    
    public PlayerList(Square startSquare, GUILogic guiLogic){
        this.startSquare = startSquare;
        this.guiLogic = guiLogic;
    }
    
    public void addPlayer(String name, int age, int startBalance){
        
        // Increase size of player-array by 1
        Player[] temp = new Player[players.length+1];
        for (int i = 0; i < players.length; i++) {
            temp[i] = players[i];
        }
        players = temp;
        
        //Create player's piece
        Piece piece = new Piece(startSquare);
        
        //Create and add new player to array
        players[players.length-1] = new Player(name, age, startBalance, piece);
        
    }
    
    public Player getPlayer(int index){
        return players[index];
    }
    
    public int NumberOfPlayers(){
        return players.length;
    }

    // Hentet inspiration fra geeksforgeeks.org/insertion-sort/ insertion sort algoritme.
    public void sortPlayersByAge(){

        for (int i = 0; i < players.length ; i++) {
            Player key = players[i];
            int j = i-1;

            while (j>=0 && players[j].getAge() > key.getAge()){
                players[j+1] = players[j];
                j=j-1;
            }
            players[j+1] = key;
        }
    }
    public void sortPlayersByPoint(){
        for (int i = 0; i < players.length ; i++) {
            Player key = players[i];
            int j = i-1;

            while (j>=0 && players[j].getBalance() > key.getBalance()){
                players[j+1] = players[j];
                j=j-1;
            }
            players[j+1] = key;
        }
    }

    /**
     * Sorts player list and returns highest scored player
     * @return returns winner
     */
    public Player getWinner(){

        sortPlayersByPoint();

        Player winner = this.getPlayer(this.NumberOfPlayers()-1);

        if (winner.getBalance()==this.getPlayer(this.NumberOfPlayers()-2).getBalance()){
            winner = null;
        }

        return winner;
    }
    
}
