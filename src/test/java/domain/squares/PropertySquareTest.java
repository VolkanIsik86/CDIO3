package domain.squares;

import controllers.GUILogic;
import domain.Piece;
import domain.Player;
import org.junit.Test;
import services.TxtReader;

import static org.junit.Assert.*;

public class PropertySquareTest {

    private final PropertySquare[] testSquare = new PropertySquare[2];
    private GUILogic guiLogic;
    private String languagePath = "src/main/java/services/languagefiles/";
    private TxtReader landedOnTxt;
    private final Piece testPiece = new Piece(testSquare[0]);
    private final Player test = new Player("Test",99,20,testPiece);

   public PropertySquareTest(){
       testSquare[0] = new PropertySquare("Test1",0,guiLogic,landedOnTxt,2,"yellow");
       testSquare[1] = new PropertySquare("Test2",1,guiLogic,landedOnTxt,3,"red");
    }



    @Test
    public void getColor() {
       String expected = "yellow";
       String actual = testSquare[0].getColor();
       assertEquals(expected,actual);

       String expected2 = "red";
       String actual2 = testSquare[1].getColor();
       assertEquals(expected2,actual2);

    }

    @Test
    public void getPrice() {

       int expected = 2;
       int actual = testSquare[0].getPrice();
       assertEquals(expected,actual);

        int expected2 = 3;
        int actual2 = testSquare[1].getPrice();
        assertEquals(expected,actual);


    }

    @Test
    public void getOwner() {

       testSquare[0].setOwner(test);
        assertEquals(test,testSquare[0].getOwner());

       Player expected2 = null;
       assertEquals(expected2,testSquare[1].getOwner());


    }

    @Test
    public void setColor() {
       testSquare[0].setColor("black");
       String expected = "black";
       assertEquals(expected,testSquare[0].getColor());

    }

    @Test
    public void setPrice() {
       testSquare[1].setPrice(5);
       int expected = 5;
       assertEquals(expected,testSquare[1].getPrice());
    }


    @Test
    public void payRent() {
       testSquare[0].payRent(test);
       int expected = 18;
       assertEquals(expected,test.getBalance());

    }
    @Test
    public void earnRent() {
       testSquare[1].setOwner(test);
       testSquare[1].earnRent();
       int expected = 23;
       assertEquals(expected,test.getBalance());
    }

    @Test
    public void purchase(){
       testSquare[0].purchase(test);
        int expectedBalance = 18;

       assertEquals(test,testSquare[0].getOwner());
       assertEquals(expectedBalance,test.getBalance());

    }
}