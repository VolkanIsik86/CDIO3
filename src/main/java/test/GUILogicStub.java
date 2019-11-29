package test;

import controllers.GUILogic;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;

public class GUILogicStub extends GUILogic {
    
    private int NumberOfPlayers;
    private String[] nameArr;
    private int[] ageArr;
    
    public GUILogicStub(){
        STARTBALANCE = 5;
        NumberOfPlayers = 2;
        String[] nameArr = {"Mikkel", "Volkan"};
        ageArr = new int[]{6, 7};
    }
    
    @Override
    public String[] makeUsers() {
        //todo skal ændres til at fungere på alle sprog1
        
        String names[] = new String[NumberOfPlayers];
        addPlayers(NumberOfPlayers);
        
        return names;
    }
    
    @Override
    protected void addPlayers(int numberofPlayers) {
        
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
            String name = nameArr[i];
        
            while (name.length() >= 8 || name.length()<= 1) {
                name = gui.getUserString(guiTxt.getLine("length"));
            }
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
                    age = ageArr[i];
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
            
            // Constructs a player.
            GUI_Player player = new GUI_Player(name, STARTBALANCE, car);
        
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
    
}
