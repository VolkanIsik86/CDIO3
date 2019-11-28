package Stubs;

import controllers.GUILogic;
import domain.Piece;
import domain.Player;

public class PlayerStub extends Player {
    public PlayerStub(String name, int age, int balance, Piece piece, GUILogic guiLogic) {
        super(name, age, balance, piece, guiLogic);
    }
}
