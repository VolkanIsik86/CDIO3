package game_classes;

import service.TxtReader;

public class Board {

    private int SIZE = 24;
    private Square[] square;
    
    public Board(String path, String file){
    
        TxtReader squareDescriptions = new TxtReader(path,file);
        String[] line;
    
        line = squareDescriptions.getLine("1").split(" ");
    
        System.out.println(line[2]);
        
//        for (int i = 0; i < 24; i++) {
//            squares[i] = new Square()
//        }
    
    
    
    }
    
    public static void main(String[] args) {
        Board board = new Board("src/main/java/service/","squareDescriptions");
        
        
    }
    
    //Skal have en .nextLocation(Square location, eyes)
    
}
