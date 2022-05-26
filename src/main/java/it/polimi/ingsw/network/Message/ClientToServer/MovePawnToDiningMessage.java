package it.polimi.ingsw.network.Message.ClientToServer;


import it.polimi.ingsw.model.ColorPawn;

import java.util.ArrayList;

public class MovePawnToDiningMessage extends ClientToServer {
    private static final long serialVersionUID = -5298217876902603010L;
    public final int num;
    public final ArrayList<ColorPawn> arrayPawn;

    public MovePawnToDiningMessage(int num, ArrayList<ColorPawn> arrayPawn) {
        this.num = num;
        this.arrayPawn=arrayPawn;
    }
    public int getNumPawn() {
        return num;
    }
    public ArrayList<ColorPawn> getArrayPawn(){
        return this.arrayPawn;
    }
}
