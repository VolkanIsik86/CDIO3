package controllers;

import domain.Board;
import domain.ChanceDeck;
import domain.Player;
import domain.PlayerList;
import services.TxtReader;

public class Game {
   
   private GUILogic guiLogic;
   private Board board;
   private ChanceDeck chanceDeck;
   private TurnLogic turnLogic;
   private PlayerList playerList;
   private String looser = "null";
   
   private String languagePath = "src/main/java/services/languagefiles/";
   private String language;
   private TxtReader landedOnTxt;
   private TxtReader squaresTxt;
   private TxtReader cardsTxt;
   
   
    //todo ret antal startpoints
    private final int START_POINTS = 10;
    
    public void playGame(){
    
        initializeGame();
        
        do {
            playRound();
        } while(looser.equals("null"));
    
        getWinner();
   }
   
   private void playRound(){
       for (int i = 0; i < playerList.NumberOfPlayers(); i++) {
        
           Player currentPlayer = playerList.getPlayer(i);
        
           System.out.println("\nTager en tur for: " + currentPlayer.getName());
           System.out.println("Spilleren stod på: " + currentPlayer.getLocation().getIndex());
           System.out.println("Spilleren havde: " + currentPlayer.getBalance() + " point");
        
           turnLogic.takeTurn(currentPlayer);
        
           System.out.println("Spiller slog: " + currentPlayer.getLastRoll());
           System.out.println("Spilleren har nu: " + currentPlayer.getBalance() + " point");

           if (currentPlayer.getLost() == true){
               looser = currentPlayer.getName();
               break;
           }
       }
   }
   
   private void initializeGame(){
       initLanguage();
       initGUILogic();
       initBoard();
       initTurnLogic();
       initPlayerList();
   }
   
   private void initLanguage(){
       
       LanguageLogic languageLogic = new LanguageLogic();
    
       //Promts user to select language
       language = languageLogic.selectLangauge();
       
       //Load txt files
       landedOnTxt = new TxtReader(languagePath, "landedOn_" + language);
       squaresTxt = new TxtReader(languagePath, "squares_" + language);
       cardsTxt = new TxtReader(languagePath,"chanceCards_" + language);
       
   }
   
   private void initGUILogic(){
       
       //Includes the initialization of the GUI itself
       guiLogic = new GUILogic(squaresTxt);
   }
   
   private void initBoard(){
        
        //Includes the initialization of the chance deck
        board = new Board(squaresTxt, landedOnTxt, cardsTxt, guiLogic);
   }
   
   private void initTurnLogic(){
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


