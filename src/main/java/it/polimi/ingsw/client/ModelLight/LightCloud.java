package it.polimi.ingsw.client.ModelLight;

public class LightCloud{

    private int numPawn;
    private int greenPawn;
    private int redPawn;
    private int yellowPawn;
    private int pinkPawn;
    private int bluePawn;
    public LightCloud(){
        numPawn=0;
        greenPawn=0;
        redPawn=0;
        yellowPawn=0;
        pinkPawn=0;
        bluePawn=0;
    }

    public void setYellowPawn(int yellowPawn) {
        this.yellowPawn = yellowPawn;
    }

    public void setRedPawn(int redPawn) {
        this.redPawn = redPawn;
    }

    public void setPinkPawn(int pinkPawn) {
        this.pinkPawn = pinkPawn;
    }

    public void setGreenPawn(int greenPawn) {
        this.greenPawn = greenPawn;
    }

    public void setBluePawn(int bluePawn) {
        this.bluePawn = bluePawn;
    }

    public void setNumPawn(int numPawn) {
        this.numPawn = numPawn;
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
