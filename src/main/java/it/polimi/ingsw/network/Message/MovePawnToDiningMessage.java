package it.polimi.ingsw.network.Message;


import it.polimi.ingsw.model.ColorPawn;

import java.util.ArrayList;

public class MovePawnToDiningMessage extends ClientToServer {
    public final int num;
    public final ArrayList<ColorPawn> arrayPawn;

    public MovePawnToDiningMessage(int num, ArrayList<ColorPawn> arrayPawn) {
        this.num = num;
        this.arrayPawn=arrayPawn;
    }
    public int getNumDiningRoom() {
        return num;
    }
    public ArrayList<ColorPawn> getArrayPawn(){
        return this.arrayPawn;
    }
}
