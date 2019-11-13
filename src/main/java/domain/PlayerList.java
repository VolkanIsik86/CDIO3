package domain;

//Creates and maintains a list of players

public class PlayerList {
    
    Player[] players = new Player[0];
    Board board;
    
    public PlayerList(Board board){
        this.board = board;
    }
    
    public void addPlayer(String name, int age, int points){
        
        // Increase size of player-array by 1
        Player[] temp = new Player[players.length+1];
        for (int i = 0; i < players.length; i++) {
            temp[i] = players[i];
        }
        players = temp;
        
        //Create player piece
        Piece piece = new Piece(board.getSquare(0));
        
        //Create and add new player to array
        players[players.length-1] = new Player(name,age,points,piece);
        
    }
    
    
}
