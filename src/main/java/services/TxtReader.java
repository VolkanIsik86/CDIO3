package services;

import java.io.*;

public class TxtReader {
    
    private String[][] lines;
    private int N_LINES = 0;
    File file;
    BufferedReader br;
    
    public void openFile(String path, String fileName){
        
        try{
            file = new File(path + fileName + ".txt");
            br = new BufferedReader(new FileReader(file));
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void readLines(){
        
        try{
    
            //Count number of lines
            String currentLine = br.readLine();
            while (currentLine != null) {
                N_LINES++;
                currentLine = br.readLine();
            }
    
            //Reset reader
            br = new BufferedReader(new FileReader(file));
            
            //Add lines to 2D array
            lines = new String[N_LINES][2];
            for (int i = 0; i < N_LINES; i++) {
                String[] oneLine = br.readLine().split(",,");
                for (int j = 0; j < 2; j++) {
                    lines[i][j] = oneLine[j];
                }
            }
            
            br.close();
            
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public int getN_LINES(){
        return N_LINES;
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
