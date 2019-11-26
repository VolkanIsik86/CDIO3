package controllers;

import domain.Player;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import services.TxtReader;

import java.awt.*;
import java.util.Random;


public class GUILogic {
    
    private Color BROWN = new Color(153, 102, 0);
    private Color GOLD = new Color(255, 204, 51);
    private final int N_FIELDS = 24;
    private final int DELAY = 200;
    private GUI_Field[] fields;
    private GUI gui;
    private String[] names = new String[0];
    private GUI_Player[] guiPlayers = new GUI_Player[0];
    private int[] ages = new int [0];
    private Color red = new Color(255,0,0);
    private Color blue = new Color(0,0,255);
    private Color white = new Color(255,255,255);
    private Color green = new Color(28,126,0);
    private Color[] carcolor = {red,blue,white,green};
    private TxtReader guiTxt;



    public GUILogic(TxtReader squaresTxt, TxtReader guiTxt) {
        this.guiTxt = guiTxt;
        makeBoard(squaresTxt);
        makeUsers();
    }

    /**
     * Creates an array of fields for the game and initialize it.
     * @param squaresTxt Defines square names and costs with language depended Txtreader.
     * @return Array with fields that game board consist of.
     */
    private GUI_Field[] makeBoard(TxtReader squaresTxt) {
        fields = new GUI_Field[N_FIELDS];
       // Løbe igennem for hvert felt
        for (int i = 0; i < N_FIELDS; i++) {
            fields[i] = new GUI_Street();

            //Creates object
            GUI_Street street = new GUI_Street();
            
            //Generates an arrat for each line in .txt with strings.
            String[] juniorField = squaresTxt.getLine("" + i).split("-");
            
            //Writes titel of the field.
            street.setTitle(juniorField[1]);
            
            //Sets colors of the fields.
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

            //Writes the price
            street.setSubText(juniorField[3]);
            
            //removes field price If price is 0
            if (juniorField[3].equals("0"))
                street.setSubText("");
            fields[i] = street;
        }
        gui = new GUI(fields);
        return fields;


    }

    /**
     * Adds player to the Graphical User Interface (GUI).
     * @param numberofPlayers Adds quantity of player into the GUI.
     */
    private void addPlayers(int numberofPlayers) {
        
        //Does the same for all player that is added into the game.
        for (int i = 0; i < numberofPlayers; i++) {
            
            //Extend players with 1 quantity.
            String[] temp = new String[names.length + 1];
            int[] tempAge = new int[ages.length+1];
            for (int j = 0; j < names.length; j++) {
                temp[j]=names[j];
                tempAge[j]=ages[j];
            }
            names = temp;
            ages = tempAge;

            //Asks player to write their name.
            String name = gui.getUserString(guiTxt.getLine("Enter name")); //todo skal ændres til at fungere på alle sprog

                for (String samename : names) {
                    boolean sameNameTest = true;
                    while (sameNameTest) {
                    if (name.equals(samename)) {
                        name = gui.getUserString(guiTxt.getLine("Already in use"));

                    }
                    else
                        sameNameTest = false;

                }
            }

            //Crates an array of player names.

            names[i] = name;
            boolean ageIsInt = true;
            int age = 0;
            do {
                try {
                    age = Integer.parseInt(gui.getUserString(guiTxt.getLine("Age") + " " + name ));
                    if (age >= 5 && age <= 150) {
                        ageIsInt = true;
                    }
                    else{
                        ageIsInt = false;
                    }
                } catch (NumberFormatException e) {
                    ageIsInt = false;
                }
            } while (!ageIsInt);


            ages[i] = age;
            
            //Constructs figures for the players that can move on the game board. (Inspired From The teacher Daniel Kolditz Rubin-Grøn in class demonstration.)

                GUI_Car car = new GUI_Car(carcolor[i], carcolor[i], GUI_Car.Type.values()[i], GUI_Car.Pattern.values()[i]);



            //Predefine player balance at the start of the game

            int tempbalance = 0;
            if (numberofPlayers==2){
                tempbalance = 20;
            }
            else if (numberofPlayers==3){
                tempbalance = 18;
            }
            else
                tempbalance = 16;

            // Constructs a player.
            GUI_Player player = new GUI_Player(name, tempbalance, car);

            //Adds player to Player array.
            GUI_Player[] temp2 = new GUI_Player[guiPlayers.length + 1];
            for (int j = 0; j < guiPlayers.length; j++) {
                temp2[j] = guiPlayers[j];
            }
            guiPlayers = temp2;
            guiPlayers[i] = player;
            
            //Adds player on to the board.
            gui.addPlayer(player);
            
            //Places the figures to start point.
            fields[0].setCar(player, true);
        }
    }

    /**
     * Define and creates players for the game and uses addPlayer method number of players.
     *
     * @return Names array og every player that initialized for the game.
     */
    public String[] makeUsers() {
        //todo skal ændres til at fungere på alle sprog1
        String nrPlayers = gui.getUserSelection(guiTxt.getLine("player numbers"), "2","3","4");
        int NumberOfPlayers = Integer.parseInt(nrPlayers);
        
        String names[] = new String[NumberOfPlayers];
        addPlayers(NumberOfPlayers);
        
        return names;
    }


    /**
     * Moves players figure around the board.
     *
     * @param player Figure of this player will be moved.
     * @param moves Count of fields that figure moves(face value of dice).
     */
    public void movePiece(Player player, int moves) {
        
        int currentField = player.getLastLocation().getIndex();
        GUI_Player guiPlayer = getGUIPlayer(player);
        
        int movesDone = 0; //Bruges til at holde styr på antal moves udført
        if (moves != 0) {
            
            //Controls figure position + move and board length.
            if (currentField + moves >= N_FIELDS) {
                
                //Runs fields until the start point.
                for (int i = 1; currentField + i < N_FIELDS; i++) {
                    moveRest(guiPlayer, currentField, i);
                    movesDone++;
                    sleep(DELAY);
                }
                currentField = passStart(guiPlayer);
                passedStart(player);
                movesDone++;
                sleep(DELAY);
            }

            //Run figure and controls moves done.
            for (int i = 0; i + movesDone < moves; i++) {
                currentField = moveOnce(guiPlayer, currentField);
                sleep(DELAY);
            }
            
        } else {
            fields[0].setCar(guiPlayer, true);
        }
    }

    private void passedStart(Player player) {
        player.deposit(2);
        setPlayerBalance(player);
    }

    /**
     * Moves player to the end field of the board.
     * @param player Player figure needs to be moved.
     * @param field Field number that figure stands on.
     * @param increment Counts moves that player has done.
     */
    private void moveRest(GUI_Player player, int field, int increment) {
        fields[field + increment - 1].setCar(player, false);
        fields[field + increment].setCar(player, true);
    }

    /**
     * Moves players figure. Remove figure from old location to new location.
     *
     * @param player Player figure needs to be moved.
     * @param field  Field number that figure stands on.
     * @return Field that players last position
     */
    private int moveOnce(GUI_Player player, int field) {
        fields[field].setCar(player, false);
        fields[field + 1].setCar(player, true);
        field = field + 1;
        return field;
    }

    /**
     * Places players figure to start point.
     *
     * @param player Player figure needs to be moved.
     * @return Field that players last position
     */
    private int passStart(GUI_Player player) {
        int currentField;
        fields[N_FIELDS - 1].setCar(player, false);
        currentField = 0;
        fields[currentField].setCar(player, true);
        return currentField;
    }

    /**
     * Places players figure to jail.
     * @param player
     */
    public void moveToJail(Player player){
        
        GUI_Player guiPlayer = getGUIPlayer(player);
        
        //Remove player from current field
        fields[player.getLastLocation().getIndex()].setCar(guiPlayer,false);
        
        //Place player on jail
        fields[6].setCar(guiPlayer,true);
    }

    /**
     * Fields of the game can be interacted from here.
     * @return Array of field that is initialized
     */
    public GUI_Field[] getFields() {
        return fields;
    }

    /**
     * Changes Font color of a field.
     * @param player New owner of the field.
     */
    public void setSquareOwner(Player player, int price){
        fields[player.getLocation().getIndex()].setSubText(player.getName() + "-" + price);
    }

    /**
     * GUI of the game can be interacted from here.
     * @return GUI that is initialized.
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * Synchronize backend player with the GUI player.
     * @param player Backend player that need to be initialized.
     * @return NULL
     */
    public GUI_Player getGUIPlayer(Player player) {
        
        String playerName = player.getName();
        
        //For all GUIPlayers
        for (GUI_Player guiPlayer : guiPlayers) {
            
            //If names match
            if (guiPlayer.getName().equals(playerName)) {
                return guiPlayer;
            }
        }

        return null;
    }

    /**
     * Displays Die on the GUI.
     * @param faceValue at the backend is showed on GUI.
     * @param name of player showed on GUI.
     */
    public void displayDie(int faceValue, String name){
        
        //todo Skal hente den rigtige sætning afhængig af sprog
        showMessage(guiTxt.getLine("it is") + " " + name + guiTxt.getLine("throw dice"));
        gui.setDie(faceValue);
    }

    /**
     * Shows chance cards middle og the board.
     * @param txt is the chance card description that is showed.
     */
    public void showChanceCard(String txt){
        gui.displayChanceCard(txt);
    }

    /**
     * Names of all players who is created.
     * @return names of the players.
     */
    public String[] getPlayerNames(){
        return names;
    }

    /**
     * Ages of all players who is created.
     * @return ages to define youngest player.
     */
    public int [] getPlayerAges() {return ages;}

    /**
     * Sleep time is initialized for more understandable game.(Stops figures to teleport.)
     * @param n Sleep time in miliseconds.
     */
    private void sleep(long n){
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Configures players balances for the game.
     * @param player whos balance will be configured.
     */
    public void setPlayerBalance(Player player){
        
        GUI_Player guiPlayer = getGUIPlayer(player);
        guiPlayer.setBalance(player.getBalance());
    }

    /**
     * Displays message on GUI.
     * @param message is the message that will be showed.
     */
    public void showMessage(String message){
        gui.showMessage(message);
    }
    
   

}

// todo GUI skal vise det felt man lander på i midten
// todo skal ændre på feltfarverne når man ejer det
// todo chancekort
// todo kraftigt overveje vores .update funktion



