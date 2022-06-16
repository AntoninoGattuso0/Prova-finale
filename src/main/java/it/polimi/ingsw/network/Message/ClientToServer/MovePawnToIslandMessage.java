package it.polimi.ingsw.network.Message.ClientToServer;

import it.polimi.ingsw.model.ColorPawn;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Message sent by the client to server for move pawns to Island
 */
public class MovePawnToIslandMessage extends ClientToServer implements Serializable{
    @Serial
    private static final long serialVersionUID = 8736574405034849035L;
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
