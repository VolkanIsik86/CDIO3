package controllers;

import domain.Board;
import domain.*;
import domain.Player;
import domain.PlayerList;
import services.TxtReader;
import java.util.Scanner;

public class Game {

   GUILogic guiLogic = new GUILogic();
   Board board = new Board(guiLogic.getPATH(),guiLogic.getFILE());
   TurnLogic turnLogic = new TurnLogic(board);
   PlayerList playerList = new PlayerList(board.getSquare(0));

   
}