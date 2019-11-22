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
    private final int DELAY = 200;
    private GUI_Field[] fields;
    private GUI gui;
    private Game game;
    private String[] names = new String[0];
    private GUI_Player[] players = new GUI_Player[0];
    private int[] ages = new int [0];


    public GUILogic(String language) {
        makeBoard(language);
        makeUsers();
    }

    private GUI_Field[] makeBoard(String language) {
        fields = new GUI_Field[N_FIELDS];
        //læser fra fil
        TxtReader juniorFields = new TxtReader(PATH, FILE+"_"+language);

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
        //Gør det samme for antallet af spillere der er valgt
        for (int i = 0; i < numberofPlayers; i++) {
            //Udvider listen over spillere med 1
            String[] temp = new String[names.length + 1];
            int[] tempAge = new int[ages.length+1];
            for (int j = 0; j < names.length; j++) {
                temp[j]=names[j];
                tempAge[j]=ages[j];
            }
            names = temp;

            ages = tempAge;


            //Beder spilleren indtaste et navn

            String name = gui.getUserString("Enter name:");  //todo skal ændres til at fungere på alle sprog

                for (String samename : names) {
                    boolean sameNameTest = true;
                    while (sameNameTest) {
                    if (name.equals(samename)) {
                        name = gui.getUserString("name is already in use, type another name:");

                    }
                    else
                        sameNameTest = false;

                }
            }
    
            //todo hvorfor står der names[i] nedenfor og ikke names[names.length-1]?
            //Fordi vi er inde i et for-loop og det betyder det samme. Desuden er det pænere sådan her.
            //Tilføjer spillerens navn til listen over navne

            names[i] = name;


            int age = gui.getUserInteger("Enter age of "  + name + ":" , 5,150);
            ages[i] = age;

            //Konstruere en tilfældig GUI-bil

            GUI_Car car = new GUI_Car();
            //Konstruere en spiller med den tilfældige bil og et navn
            GUI_Player player = new GUI_Player(name, 0, car);
            //tilføjer spillerne til en spillerliste
            GUI_Player[] temp2 = new GUI_Player[players.length + 1];
            for (int j = 0; j < players.length; j++) {
                temp2[j] = players[j];
            }
            players = temp2;
            players[i] = player;
            //Tilføjer spilleren på brættet
            gui.addPlayer(player);
            //Flytter spilleren til startfeltet
            movePiece(player,0,0);
        }
    }

    //todo når en spiller lander på "Go to jail" bliver spilleren som det er nu ikke fjernet fra feltet
    public void movePiece(GUI_Player player, int currentField, int moves) {
        
        int movesDone = 0; //Bruges til at holde styr på antal moves udført
        if (moves != 0) {
            //Tjekker om piece position bliver større end board
            if (currentField + moves >= N_FIELDS) {
                //Kører resten af felterne igennem inden start
                for (int i = 1; currentField + i < N_FIELDS; i++) {
                    moveRest(player, currentField, i);
                    movesDone++;
                    sleep(DELAY);
                }
                currentField = passStart(player);
                movesDone++;
                sleep(DELAY);
            }
            //Kører flytning af piece, tjekker om der er moves tilbage
            for (int i = 0; i + movesDone < moves; i++) {
                currentField = moveOnce(player, currentField);
                sleep(DELAY);
            }
        } else {
            fields[0].setCar(player, true);
        }
    }

    private void moveRest(GUI_Player player, int field, int increment) {
        fields[field + increment - 1].setCar(player, false);
        fields[field + increment].setCar(player, true);
    }

    private int moveOnce(GUI_Player player, int field) {
        fields[field].setCar(player, false);
        fields[field + 1].setCar(player, true);
        field = field + 1;
        return field;
    }

    private int passStart(GUI_Player player) {
        //Placerer piece på start
        int currentField;
        fields[N_FIELDS - 1].setCar(player, false);
        currentField = 0;
        fields[currentField].setCar(player, true);
        return currentField;
    }

    public GUI_Field[] getFields() {
        return fields;
    }

    public void update(Player player, Square oldLocation, int roll){

        GUI_Player gui_Player = getPlayer(player.getName());
        movePiece(gui_Player,oldLocation.getIndex(),roll);
        if (oldLocation.getIndex() + roll == 3 || oldLocation.getIndex() + roll == 9 || oldLocation.getIndex() + roll == 15 || oldLocation.getIndex() + roll == 21){
            gui.displayChanceCard("Her en chance kort");
        }

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
        //Undersøger hvilken GUI-spiller som spilleren der er kaldt passer sammen med ved at undersøge navnet.
        for (GUI_Player player : players) {
            if (q) {
                if (player.getName().equals(playerName)) {
                    dims = player;
                    q = false;
                } else {
                    dims = null;
                }

            }

        }

        return dims;
    }
    
    public String[] makeUsers() {
        //todo skal ændres til at fungere på alle sprog1
        String nrPlayers = gui.getUserSelection("Hvor mange spillere skal spille spillet?", "2","3","4");
        int NumberOfPlayers = Integer.parseInt(nrPlayers);

        String names[] = new String[NumberOfPlayers];
        addPlayers(NumberOfPlayers);

        return names;
    }
    
    public void displayDie(int faceValue){
        
        //todo Skal hente den rigtige sætning afhængig af sprog
        //todo det skal også fremgå vis tur det er.
        showMessage("lol, kast lige terningen");
        gui.setDie(faceValue);
    }
    public String[] getPlayerNames(){
        return names;
    }
    
    public int [] getPlayerAges() {return ages;}

    private void sleep(long n){
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void setPlayerBalance(GUI_Player player, int value){
        player.setBalance(value);
    }
    
    public void showMessage(String message){
        gui.showMessage(message);
    }

}

// todo GUI skal vise det felt man lander på i midten
// todo opdatere spillernes point
// todo skal ændre på feltfarverne når man ejer det
// todo implementeres en OK menu før spillet slår med terningerne
// todo chancekort
// todo kraftigt overveje vores .update funktion



