package it.polimi.ingsw.client.ModelLight;

public class LightEntrance {
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
        this.bluePawn =pinkPawn;
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