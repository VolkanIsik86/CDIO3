package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerListTest {
    
    @Test
    public void addPlayer() {
        
        //todo

        Board board = new Board("src/main/java/services/","squareDescriptions");
        PlayerList players = new PlayerList(board.getSquare(0));

        players.addPlayer("navn",25,2000);
        System.out.println(players.getPlayer(0).getName());

        players.addPlayer("Hans",56,1000);

        System.out.println(players.getPlayer(0).getType());
        System.out.println(players.getPlayer(1).getType());

    }
    
    
    }
}