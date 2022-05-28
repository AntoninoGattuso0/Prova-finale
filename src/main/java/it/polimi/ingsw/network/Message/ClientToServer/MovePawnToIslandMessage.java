package it.polimi.ingsw.network.Message.ClientToServer;

import it.polimi.ingsw.model.ColorPawn;

import java.util.ArrayList;

public class MovePawnToIslandMessage extends ClientToServer {
    private static final long serialVersionUID = 159102344896104559L;
    public final int island;
    public final ArrayList<ColorPawn> arrayPawn;
    public int numPawn;


    public MovePawnToIslandMessage(int island,int numPawn, ArrayList<ColorPawn> arrayPawn) {
        this.island = island;
        this.numPawn=numPawn;
        this.arrayPawn=arrayPawn;
    }

    public int getIsland() {
        return island;
    }
    public int getNumPawn() {
        return numPawn;
    }
    public ArrayList<ColorPawn> getArrayPawn() {
        return arrayPawn;
    }
}