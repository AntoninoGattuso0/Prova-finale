package it.polimi.ingsw.client.ModelLight;

import java.io.Serial;
import java.io.Serializable;

public class LightCloud implements Serializable {
    @Serial
    private static final long serialVersionUID= 7032643951141513848L;
    private final int numPawn;
    private final int greenPawn;
    private final int redPawn;
    private final int yellowPawn;
    private final int pinkPawn;
    private final int bluePawn;
    public LightCloud(int redPawn,int bluePawn,int numPawn,int pinkPawn,int yellowPawn,int greenPawn){
        this.bluePawn=bluePawn;
        this.numPawn=numPawn;
        this.greenPawn=greenPawn;
        this.yellowPawn=yellowPawn;
        this.pinkPawn=pinkPawn;
        this.redPawn=redPawn;
    }

    public int getRedPawn() {
        return redPawn;
    }

    public int getYellowPawn() {
        return yellowPawn;
    }

    public int getPinkPawn() {
        return pinkPawn;
    }

    public int getGreenPawn() {
        return greenPawn;
    }

    public int getBluePawn() {
        return bluePawn;
    }

    public int getNumPawn() {
        return numPawn;
    }

}
