package controllers;

import domain.Board;
import domain.*;
import domain.Player;
import domain.PlayerList;
import services.TxtReader;
import java.util.Scanner;

public class Game {


   GUILogic guiLogic;
   Board board;
   TurnLogic turnLogic;
   PlayerList playerList;
   int antalSpiller;
   String[] spillernavne;
   String path = "src/main/java/services";
   String file = "squareDescriptions_en";

   public void initGame(){
       GUILogic guiLogic = new GUILogic();
       guiLogic.makeBoard();
       Board board = new Board(path, file);
       TurnLogic turnLogic = new TurnLogic(board);
       PlayerList playerList = new PlayerList(board.getSquare(0));
       int antalSpiller;
       String[] spillernavne = guiLogic.makeUsers();
       setPlayer();
   }






   public void setPlayer() {
       for (int i = 0; i < spillernavne.length; i++) {

           //TODO player alder skal kunne defineres fra gui.
           playerList.addPlayer(spillernavne[i], 0, 20);

       }

   }
//    public void createPlayers() {
//        System.out.println("");
//
//        //Point bliver bestemt efter antal spillere
//        if (players.equals(2)){
//            startKapital = 20;
//        }
//        if (players.equals(3)){
//            startKapital = 18;
//        }
//        if (players.equals(4)){
//            startKapital = 16;
//        }
//
//        //Array af spillere laves
//        for (int index = 0; index < players.length; index++) {
//            final String navn = readPlayerName(index);
////            players[index] = new Player(navn, startKapital);
        }


