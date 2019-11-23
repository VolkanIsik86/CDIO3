package controllers;

import com.sun.media.jfxmedia.events.PlayerEvent;
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
   
   
    //todo ret antal startpoints
    private final int START_POINTS = 10;
    
    public void playGame(){
    
        initializeGame();
    
        //Play a round
        String looser = "null";
        
        do {
            for (int i = 0; i < playerList.NumberOfPlayers(); i++) {
                
                Player currentPlayer = playerList.getPlayer(i);
                
                System.out.println("\nTager en tur for: " + currentPlayer.getName());
                System.out.println("Spilleren stod på: " + currentPlayer.getLocation().getIndex());
                System.out.println("Spilleren havde: " + currentPlayer.getBalance() + " point");
                
                //todo skal det ændres?
                Square oldLocation = currentPlayer.getLocation();
                
                int roll = turnLogic.takeTurn(currentPlayer);
                System.out.println("Spiller slog: " + roll);
                System.out.println("Spilleren har nu: " + currentPlayer.getBalance() + " point");
                
                guiLogic.update(currentPlayer);
                
                if (currentPlayer.getLost() == true){
                    looser = currentPlayer.getName();
                    break;
                }
            }
            
        } while(looser.equals("null"));
    
        getWinner();
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
       playerList = new PlayerList(board.getSquare(0), guiLogic);
       String[] playerNames = guiLogic.getPlayerNames();
       int [] ageOfPlayer = guiLogic.getPlayerAges();
       for (int i = 0; i < playerNames.length; i++) {
           playerList.addPlayer(playerNames[i],ageOfPlayer[i]);
       }

       playerList.sortPlayersByAge();
       playerList.setStartBalance();
       
   }
   
   //todo uafgjort mellem spillere med ens point mangler at blive implementeret
   private Player getWinner(){

       Player winner = playerList.getPlayer(0);

       for (int i = 0; i < playerList.NumberOfPlayers(); i++) {
           Player currentPlayer = playerList.getPlayer(i);
           if (currentPlayer.getLost()){
               int maxScore = playerList.getPlayer(0).getBalance();
               for (int k = 1; k < playerList.NumberOfPlayers(); k++) {
                   if (playerList.getPlayer(k).getBalance()>maxScore){
                       winner = playerList.getPlayer(k);
                   }

               }

           }

       }
       return winner;
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


