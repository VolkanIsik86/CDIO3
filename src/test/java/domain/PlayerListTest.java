package domain;

import controllers.GUILogic;
import domain.squares.Square;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerListTest {
    
    private Square testSquare;
    private GUILogic guiLogic;
    private final PlayerList testlist = new PlayerList(testSquare,guiLogic);
    private final int STARTBALANCE = 20;
    
    @Test
    public void addPlayer() {

        testlist.addPlayer("test",99, STARTBALANCE);
        String expectedName = "test";
        int expectedAge = 99;
        assertEquals(Player.class,testlist.getPlayer(0).getClass());
        assertEquals(expectedName,testlist.getPlayer(0).getName());
        assertEquals(expectedAge,testlist.getPlayer(0).getAge());
    }
    
    @Test
    public void numberOfPlayers() {
        testlist.addPlayer("test",99, STARTBALANCE);
        int actual = testlist.NumberOfPlayers();
        int expected = 1;
        assertEquals(expected,actual);
    }


    @Test
    public void sortPlayersByAge() {
        testlist.addPlayer("test",7, STARTBALANCE);
        testlist.addPlayer("test1",8, STARTBALANCE);
        testlist.addPlayer("test2",5, STARTBALANCE);
        testlist.addPlayer("test3",4,STARTBALANCE);
        testlist.addPlayer("test4",9,STARTBALANCE);
        testlist.sortPlayersByAge();
        int[] ages = new int[5];
        for (int i = 0; i < testlist.NumberOfPlayers() ; i++){
            ages[i] = testlist.getPlayer(i).getAge();
        }

        for (int i = 0; i < (ages.length - 1); i++){
            assertTrue(ages[i] < ages[i + 1]);
        }
        assertTrue(ages[ages.length - 2] < ages[ages.length - 1]);

    }

    @Test
    public void sortPlayersByPoint() {
        testlist.addPlayer("test",7,STARTBALANCE);
        testlist.addPlayer("test1",8,STARTBALANCE);
        testlist.addPlayer("test2",5,STARTBALANCE);
        testlist.addPlayer("test3",4,STARTBALANCE);
        testlist.addPlayer("test4",9,STARTBALANCE);
        for (int i = 0; i < testlist.NumberOfPlayers() ; i++) {
            testlist.getPlayer(i).setBalance(i);
        }
        testlist.sortPlayersByPoint();

        int[] points = new int[5];
        for (int i = 0; i < testlist.NumberOfPlayers() ; i++){
            points[i] = testlist.getPlayer(i).getBalance();
        }

        for (int i = 0; i < (points.length - 1); i++){
            assertTrue(points[i] < points[i + 1]);
        }
        assertTrue(points[points.length - 2] < points[points.length - 1]);
    }

    @Test
    public void getWinner() {
        testlist.addPlayer("test",7,STARTBALANCE);
        testlist.addPlayer("test1",8,STARTBALANCE);

        testlist.getPlayer(0).setBalance(20);
        testlist.getPlayer(1).setBalance(18);

        Player expected = testlist.getPlayer(0);
        Player actual = testlist.getWinner();

        assertEquals(expected,actual);

        testlist.getPlayer(0).setBalance(20);
        testlist.getPlayer(1).setBalance(20);

        Player expectedDraw = null;
        Player actualDraw = testlist.getWinner();
        assertEquals(expectedDraw,actualDraw);


    }


}