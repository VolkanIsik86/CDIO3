package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    
    Board board = new Board("src/main/java/services/","squareDescriptions");
    
    // todo hurtig test, skal muligvis udbygges
    
    @Test
    public void getSquare() {
        
        assertEquals("Chancen", board.getSquare(3).getName());
        
    }
    
    @Test
    public void nextLocation() {
    
//        squares = new Square[size];
//        squares[0] = new RegularSquare("Go_Square",0);
//        squares[1] = new PropertySquare("Burgerbaren",1,"brown",1);
//        squares[2] = new PropertySquare("Pizzahuset",2,"brown",1);
//        squares[3] = new ChanceSquare("Chance",3);
//        squares[4] = new PropertySquare("Slikbutik",4,"blue",1);
//        squares[5] = new PropertySquare("Iskiosken",5,"blue",1);
//        squares[6] = new RegularSquare("Fængsel",6);
//        squares[7] = new PropertySquare("Museet",7,"purple",2);
//        squares[8] = new PropertySquare("Biblioteket",8,"purple",2);
//        squares[9] = new ChanceSquare("Chance",9);
//        squares[10] = new PropertySquare("Skaterparken",10,"yellow",2);
//        squares[11] = new PropertySquare("Swimmingpoolen",11,"yellow",2);
//        squares[12] = new RegularSquare("Parkering",12);
//        squares[13] = new PropertySquare("Spillehallen",13,"red",3);
//        squares[14] = new PropertySquare("Biografen",14,"red",3);
//        squares[15] = new RegularSquare("Chance",15);
//        squares[16] = new PropertySquare("Lejetøjsbutiken",16,"yellow",3);
//        squares[17] = new PropertySquare("Dyrehandlen",17,"yellow",3);
//        squares[18] = new GoToJailSquare("Gå til Fængsel",18);
//        squares[19] = new PropertySquare("Bowlinghallen",19,"green",4);
//        squares[20] = new PropertySquare("Zoo",20,"green",4);
//        squares[21] = new ChanceSquare("Chance",21);
//        squares[22] = new PropertySquare("Vandlandet",22,"darkblue",5);
//        squares[23] = new PropertySquare("Stranpromoneden",23,"darkblue",5);
    
    }
}