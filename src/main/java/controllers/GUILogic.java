package controllers;

import domain.Player;
import domain.squares.Square;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import services.TxtReader;

import java.awt.*;


public class GUILogic {
    private String PATH = "src/main/java/services/";
    private String FILE = "squareDescriptions";
    private Color BROWN = new Color(153, 102, 0);
    private Color GOLD = new Color(255, 204, 51);
    private final int N_FIELDS = 24;
    private GUI_Field[] fields;
    private GUI gui;
    private Game game;
    private String[] names = new String[0];
    private GUI_Player[] players = new GUI_Player[0];

    public GUILogic(String language) {
        makeBoard(language);
        makeUsers();
    }

    private GUI_Field[] makeBoard(String language) {
        fields = new GUI_Field[N_FIELDS];
        //læser fra fil
        TxtReader juniorFields = new TxtReader(PATH, FILE + "_" + language);

        //Løber igennem for hvert felt
        for (int i = 0; i < N_FIELDS; i++) {
            fields[i] = new GUI_Street();

            //opretter objekt
            GUI_Street street = new GUI_Street();
            //generer et array for hver linje i .txt med strenge spredt ud over de forskellige indexer.
            String[] juniorField = juniorFields.getLine("" + i).split("-");
            //bestemmer titel på felt (index 1)
            street.setTitle(juniorField[1]);
            //bestemmer farven
            switch (juniorField[4].charAt(0)) {
                case 'r':
                    street.setBackGroundColor(Color.RED);
                    break;
                case 'B':
                    street.setBackGroundColor(BROWN);
                    break;
                case 'w':
                    street.setBackGroundColor(Color.WHITE);
                    break;
                case 'c':
                    street.setBackGroundColor(Color.CYAN);
                    break;
                case 'p':
                    street.setBackGroundColor(Color.PINK);
                    break;
                case 'g':
                    street.setBackGroundColor(GOLD);
                    break;
                case 'y':
                    street.setBackGroundColor(Color.YELLOW);
                    break;
                case 'G':
                    street.setBackGroundColor(Color.GREEN);
                    break;
                case 'b':
                    street.setBackGroundColor(Color.BLUE);
                    break;
                default:
                    street.setBackGroundColor(Color.BLACK);
            }

            //bestemmer prisen
            street.setSubText(juniorField[3]);
            //Hvis prisen er 0, fjernes teksten
            if (juniorField[3].equals("0"))
                street.setSubText("");
            fields[i] = street;
        }
        gui = new GUI(fields);
        return fields;


    }

    private void addPlayers(int numberofPlayers) {
        for (int i = 0; i < numberofPlayers; i++) {
            String[] temp = new String[names.length + 1];
            for (int j = 0; j < names.length; j++) {
                temp[j] = names[j];
            }
            names = temp;

            String name = gui.getUserString("Enter name:");  //todo skal ændres til at fungere på alle sprog

            //todo hvorfor står der names[i] nedenfor og ikke names[names.length-1]?
            names[i] = name;
            GUI_Car car = new GUI_Car();
            GUI_Player player = new GUI_Player(name, 1000, car);
            GUI_Player[] temp2 = new GUI_Player[players.length + 1];
            for (int j = 0; j < players.length; j++) {
                temp2[j] = players[j];
            }
            players = temp2;
            players[i] = player;
            gui.addPlayer(player);
            movePiece(player, 0, 0);
        }
    }

    public void movePiece(GUI_Player player, int currentField, int moves) {

        System.out.println("currentField: " + currentField);
        int movesDone = 0;
        if (moves != 0) {
            if (currentField + moves >= N_FIELDS) {
                for (int i = 1; currentField + i < N_FIELDS; i++) {
                    fields[currentField + i - 1].setCar(player, false);
                    fields[currentField + i].setCar(player, true);
                    movesDone++;
                    sleep(200);
                }
                fields[N_FIELDS - 1].setCar(player, false);
                currentField = 0;
                fields[currentField].setCar(player, true);
                sleep(200);
                movesDone++;
            }
            for (int i = 0; i + movesDone < moves; i++) {
                fields[currentField].setCar(player, false);
                fields[currentField + 1].setCar(player, true);
                currentField = currentField + 1;
                sleep(200);
            }
        } else {
            fields[0].setCar(player, true);
        }
    }

    public GUI_Field[] getFields() {
        return fields;
    }

    public void update(Player player, Square oldLocation, int roll) {

        GUI_Player gui_Player = getPlayer(player.getName());
        movePiece(gui_Player, oldLocation.getIndex(), roll);

    }

    public GUI getGui() {
        return gui;
    }

    public String getPATH() {
        return PATH;
    }

    public String getFILE() {
        return FILE;
    }

    public GUI_Player getPlayer(String playerName) {
        boolean q = true;
        GUI_Player dims = null;
        for (GUI_Player player : players) {
            if (q) {
                if (player.getName().equals(playerName)) {
                    dims = player;
                    q = false;
                } else {
                    System.out.println("Dit fuck-up er i at den spiller du kalder ikke eksisterer i gui'en");
                    dims = null;
                }

            }

        }

        return dims;
    }

    public String[] makeUsers() {

        String nrPlayers = gui.getUserSelection("Hvor mange spillere skal spille spillet?", "2", "3", "4");
        int NumberOfPlayers = Integer.parseInt(nrPlayers);

        String names[] = new String[NumberOfPlayers];
        addPlayers(NumberOfPlayers);

        return names;
    }

    public void displayDie(int faceValue) {
        gui.setDie(faceValue);
    }

    public String[] getPlayerNames() {
        return names;
    }

    private void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

// todo GUI skal vise det felt man lander på i midten
// todo opdatere spillernes point
// todo skal ændre på feltfarverne når man ejer det
// todo implementeres en OK menu før spillet slår med terningerne
// todo chancekort
// todo kraftigt overveje vores .update funktion
// todo spillerne skal også vælge alder


