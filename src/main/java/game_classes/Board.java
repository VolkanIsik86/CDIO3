package game_classes;

import service.TxtReader;

public class Board {

    private int SIZE = 24;
    private Square[] squares;

    public Board(String path, String file){

        TxtReader sDec = new TxtReader(path,file);
        String[] oneLine;

        for (int i = 0; i < 24; i++) {

            oneLine = sDec.getLine("1").split("-");

            switch (oneLine[0]) {
                case ("Regular"):
                    oneLine[i] = new Regular(sDec.getLine("1"),sDec.getLine("2"));
                    break;
                case("Property"):
                    oneLine[i] = new Property(sDec.getLine("1"),sDec.getLine("2"),sDec.getLine("3"),sDec.getLine("4"));
                    break;
                case("Jail"):
                    oneLine[i] = new Jail(sDec.getLine("1"),sDec.getLine("2"));
                    break;
                case("Chance"):
                    oneLine[i] = new Chance(sDec.getLine("1"),sDec.getLine("2"));
                    break;
            }
        }
    }

    public Square getSquare(int index){
        return squares[index+1];
    }
    
    //Skal have en .nextLocation(Square location, eyes)
    
}
