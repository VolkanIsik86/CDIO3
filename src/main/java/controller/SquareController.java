package controller;


import game_classes.Board;
import game_classes.Player;
import game_classes.square.*;

import java.util.Random;

public class SquareController {
    Square[] squares;

    public void getBoard(Board board){
        squares = board.getSquares();
    }

    public void goToJail(Player p){
        p.setLocation(squares[6]);
    }
    public void attempToBuy(PropertySquare x, Player p){
        if (x.getOwner()==null){
            if (x.getPrice() > p.getPoints()){
                x.setOwner(p);
            }
        }
        else {
            x.payRent(p);
            x.getRent();
        }
    }
    public void pullCard(Player p , ChanceCard[] c){
        int rng = new Random().nextInt(4);
        int temp = 0;
        temp = p.getLocation().getIndex();
        temp = temp + c[rng].getMove();
        p.setLocation(squares[temp]);
        p.addPoints(c[rng].getPrice());
    }
}

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
//