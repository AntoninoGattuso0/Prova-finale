package it.polimi.ingsw.client.ModelLight;

import java.io.Serial;
import java.io.Serializable;

/**
 * LightEntrance is the serialized class that contains the Entrance information to be sent to the client
 * @see it.polimi.ingsw.model.Entrance
 */
public class LightEntrance implements Serializable {
    @Serial
    private static final long serialVersionUID= -4779606610459309810L;
    private final int numPawn;
    private final int greenPawn;
    private final int bluePawn;
    private final int pinkPawn;
    private final int yellowPawn;
    private final int redPawn;

    public LightEntrance(int numPawn,int greenPawn,int redPawn,int yellowPawn,int pinkPawn,int bluePawn){
        this.numPawn=numPawn;
        this.greenPawn=greenPawn;
        this.redPawn=redPawn;
        this.yellowPawn =yellowPawn;
        this.pinkPawn =pinkPawn;
        this.bluePawn =bluePawn;
    }
    public int getNumPawn() {
        return numPawn;
    }

    public int getBluePawn() {
        return bluePawn;
    }

    public int getGreenPawn() {
        return greenPawn;
    }

    public int getPinkPawn() {
        return pinkPawn;
    }

    public int getRedPawn() {
        return redPawn;
    }

    public int getYellowPawn() {
        return yellowPawn;
    }
}