package it.polimi.ingsw.network.Message;

import it.polimi.ingsw.model.ColorPawn;

import java.util.ArrayList;

public class MovePawnToIslandMessage extends ClientToServer {
    public final int island;
    public final ArrayList<ColorPawn> arrayPawn;


    public MovePawnToIslandMessage(int island,ArrayList<ColorPawn> arrayPawn) {
        this.island = island;
        this.arrayPawn=arrayPawn;
    }

    public int getIsland() {
        return island;
    }

    public ArrayList<ColorPawn> getArrayPawn() {
        return arrayPawn;
    }
}
