package it.polimi.ingsw.client.ModelLight;

public class LightEntrance {
    private int numPawn;
    private int greenPawn;
    private int bluePawn;
    private int pinkPawn;
    private int yellowPawn;
    private int redPawn;

    public LightEntrance(){
        this.numPawn=0;
        this.greenPawn =0;
        this.redPawn =0;
        this.yellowPawn =0;
        this.pinkPawn =0;
        this.bluePawn =0;
    }

    public void setNumPawn(int numPawn) {
        this.numPawn = numPawn;
    }

    public void setBluePawn(int bluePawn) {
        this.bluePawn = bluePawn;
    }

    public void setGreenPawn(int greenPawn) {
        this.greenPawn = greenPawn;
    }

    public void setPinkPawn(int pinkPawn) {
        this.pinkPawn = pinkPawn;
    }

    public void setRedPawn(int redPawn) {
        this.redPawn = redPawn;
    }

    public void setYellowPawn(int yellowPawn) {
        this.yellowPawn = yellowPawn;
    }

}