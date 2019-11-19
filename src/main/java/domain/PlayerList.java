package domain;

//Creates and maintains a list of players

import domain.squares.Square;

public class PlayerList {
    
    Player[] players = new Player[0];
    Square startSquare;
    
    public PlayerList(Square startSquare){
        this.startSquare = startSquare;
    }
    
    public void addPlayer(String name, int age, int points){
        
        // Increase size of player-array by 1
        Player[] temp = new Player[players.length+1];
        for (int i = 0; i < players.length; i++) {
            temp[i] = players[i];
        }
        players = temp;
        
        //Create player's piece
        Piece piece = new Piece(startSquare);
        
        //Create and add new player to array
        players[players.length-1] = new Player(name, age, points, piece);
        
    }
    
    public Player getPlayer(int index){
        return players[index];
    }
    
    public int NumberOfPlayers(){
        return players.length;
    }
// Hentet inspiration fra geeksforgeeks.org/insertion-sort/
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
    
    
    // todo slet nedenstående (bare til testing)
//    public static void main(String[] args) {
//
//        Board board = new Board("src/main/java/services/","squareDescriptions");
//        PlayerList players = new PlayerList(board.getSquare(0));
//
//        players.addPlayer("navn",25,2000);
//        System.out.println(players.getPlayer(0).getName());
//
//        players.addPlayer("Hans",56,1000);
//
//        System.out.println(players.getPlayer(0).getType());
//        System.out.println(players.getPlayer(1).getType());
//
//    }

    
}
