package services;

import java.io.*;

public class TxtReader {
    
    private String[][] lines;
    private int N_LINES = 0;
    
    public TxtReader(String path, String fileName) {
        
        BufferedReader txtReader;
        
        try {
            //Create reader object
            File file = new File(path + fileName + ".txt");
            txtReader = new BufferedReader(new FileReader(file));
            
            //Count number of lines
            String currentLine = txtReader.readLine();
            while (currentLine != null) {
                N_LINES++;
                currentLine = txtReader.readLine();
            }
            
            //Reset reader
            txtReader = new BufferedReader(new FileReader(file));
            
            //Add lines to 2D array
            lines = new String[N_LINES][2];
            for (int i = 0; i < N_LINES; i++) {
                String[] oneLine = txtReader.readLine().split(",,");
                for (int j = 0; j < 2; j++) {
                    lines[i][j] = oneLine[j];
                }
            }
            txtReader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public String getLine(String key){
        
        int index = -1;
        
        //Find corresponding index to key
        for (int i = 0; i < N_LINES; i++) {
            if (lines[i][0].equalsIgnoreCase(key)){
                index = i;
                break;
            }
        }
        
        if (index == -1){
            return "ERROR: Key didn't match any index";
        } else{
            return lines[index][1];
        }
    }
    
}
