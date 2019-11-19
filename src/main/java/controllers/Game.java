package controllers;

import domain.Board;
import domain.*;
import domain.Player;
import domain.PlayerList;
import domain.squares.Square;
import services.TxtReader;
import java.util.Scanner;

public class Game {


   private GUILogic guiLogic;
   private Board board;
   private TurnLogic turnLogic;
   private PlayerList playerList;
   private String path = "src/main/java/services/";
   private String language;
   private String winner;
   
    //todo ret antal startpoints
    private final int START_POINTS = 10;
    
    public void playGame(){
    
        initializeGame();
    
        //Play a round

        for (int j = 0; j < 25; j++) {
            for (int i = 0; i < playerList.NumberOfPlayers(); i++) {

                Player currentPlayer = playerList.getPlayer(i);

                Square oldLocation;
                oldLocation =currentPlayer.getLocation();

                int roll = turnLogic.takeTurn(currentPlayer);

                // todo slet når vi er færdige med at teste
                // System.out.println("Roll: " + roll);
                // System.out.println(currentPlayer.getName() + ": " + currentPlayer.getPoints());

                guiLogic.update(currentPlayer, oldLocation, roll);

                //todo check for winner --> break; Skal også vises i GUILogic!
                if (currentPlayer.getPoints()<=0){
                    winner = currentPlayer.getName();

                }
            }
        }


        
        
       
        
   }
   
   private void initializeGame(){
       initLanguage();
       initBoard();
       initControllers();
       initPlayerList();
   }
   
   private void initLanguage(){
       LanguageLogic languageLogic = new LanguageLogic();
    
       // Promts user to select language
       language = languageLogic.selectLangauge();
   }
   
   private void initBoard(){
       board = new Board(path,"squareDescriptions_" + language);
   }
   
   private void initControllers(){
       //Creates GuiLogic object which initializes the GUI itself in its constructor
       guiLogic = new GUILogic(language);
       
       turnLogic = new TurnLogic(board,guiLogic);
   }
   
   private void initPlayerList(){
       
       //Creates a playerList and adds the players from guiLogic
       playerList = new PlayerList(board.getSquare(0));
       String[] playerNames = guiLogic.getPlayerNames();
       for (int i = 0; i < playerNames.length; i++) {
           playerList.addPlayer(playerNames[i],10,10);
       }
       
   }
   
    
    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }






//   public void setPlayer() {
//       for (int i = 0; i < spillernavne.length; i++) {
//
//           //TODO player alder skal kunne defineres fra gui.
//           playerList.addPlayer(spillernavne[i], 0, 20);
//
//       }
//
//   }

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


