package domain;

import controllers.GUILogic;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerListTest {
    StubSquare testSquare;
    GUILogic guiLogic;
    PlayerList testlist = new PlayerList(testSquare,guiLogic);

    @Test
    public void addPlayer() {

        testlist.addPlayer("test",99);
        String expectedName = "test";
        int expectedAge = 99;
        assertEquals(Player.class,testlist.getPlayer(0).getClass());
        assertEquals(expectedName,testlist.getPlayer(0).getName());
        assertEquals(expectedAge,testlist.getPlayer(0).getAge());
    }


    @Test
    public void numberOfPlayers() {
        testlist.addPlayer("test",99);
        int actual = testlist.NumberOfPlayers();
        int expected = 1;
        assertEquals(expected,actual);
    }


    @Test
    public void sortPlayersByAge() {
        testlist.addPlayer("test",7);
        testlist.addPlayer("test1",8);
        testlist.addPlayer("test2",5);
        testlist.addPlayer("test3",4);
        testlist.addPlayer("test4",9);
        testlist.sortPlayersByAge();
        int[] ages = new int[5];
        for (int i = 0; i < testlist.NumberOfPlayers() ; i++){
            ages[i] = testlist.getPlayer(i).getAge();
        }

        for (int i = 0; i < (ages.length - 1); i++){
            assertEquals(true, ages[i] < ages[i + 1]);
        }
        assertEquals(true,ages[ages.length-2]<ages[ages.length-1]);

    }
    @Test
    public void setStartBalance() {
        testlist.addPlayer("test",7);
        testlist.addPlayer("test1",8);
        testlist.setStartBalance();
        int expected = 20;
        assertEquals(expected,testlist.getPlayer(0).getBalance());
        assertEquals(expected,testlist.getPlayer(1).getBalance());
    }

    @Test
    public void sortPlayersByPoint() {
        testlist.addPlayer("test",7);
        testlist.addPlayer("test1",8);
        testlist.addPlayer("test2",5);
        testlist.addPlayer("test3",4);
        testlist.addPlayer("test4",9);
        for (int i = 0; i < testlist.NumberOfPlayers() ; i++) {
            testlist.getPlayer(i).setBalance(i);
        }
        testlist.sortPlayersByPoint();

        int[] points = new int[5];
        for (int i = 0; i < testlist.NumberOfPlayers() ; i++){
            points[i] = testlist.getPlayer(i).getBalance();
        }

        for (int i = 0; i < (points.length - 1); i++){
            assertEquals(true, points[i] < points[i + 1]);
        }
        assertEquals(true,points[points.length-2] < points[points.length-1]);
    }

    @Test
    public void getWinner() {
        testlist.addPlayer("test",7);
        testlist.addPlayer("test1",8);

        testlist.getPlayer(0).setBalance(20);
        testlist.getPlayer(1).setBalance(18);

        Player expected = testlist.getPlayer(0);
        Player actual = testlist.getWinner();

        assertEquals(expected,actual);

    }


}