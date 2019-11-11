package game_classes;

import java.util.Scanner;

public class GameLogic {

    private int startKapital;
    Private Piece piece = new Piece();
    private Square[] squares = new Square[][24];
    private Player[] players;
    private Scanner input = new Scanner(System.in);
    private TxtReader txt;
    private Account account = new Account();
    private int die1, die2;
    private String winner;

    //Konstruktør
    public GameLogic(int nPlayers){
        this.players =  new Player[nPlayers];
    }

    public void createPlayers() {
        System.out.println("");

        //Point bliver bestemt efter antal spillere
        if (players.equals(2)){
            startKapital = 20;
        }
        if (players.equals(3)){
            startKapital = 18;
        }
        if (players.equals(4)){
            startKapital = 16;
        }

        //Array af spillere laves
        for (int index = 0; index < players.length; index++) {
            final String navn = readPlayerName(index);
            players[index] = new Player(navn, startKapital);
        }
    }

    private String readPlayerName(final int index) {
        final String navn = input.nextLine();

        //Hvis tomt generer standardnavn
        if (navn.equals(""))
            return txt.getLine(23) + " " + (index + 1);
        return navn;
    }
}
