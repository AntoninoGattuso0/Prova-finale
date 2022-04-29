package it.polimi.ingsw.model;

public class Island {
    private boolean isMotherNature;
    private int greenPawn;
    private int redPawn;
    private int yellowPawn;
    private int pinkPawn;
    private int bluePawn;
    private boolean isTower;
    private ColorTower colorTower;
    private boolean isProhibited;
    private int totIsland;

    Island() {
        isMotherNature = false;
        greenPawn = 0;
        redPawn = 0;
        yellowPawn = 0;
        pinkPawn = 0;
        bluePawn = 0;
        isTower = false;
        colorTower = null;
        isProhibited = false;
        totIsland = 1;
    }
    public void setMotherNature(boolean isMotherNature){
        this.isMotherNature = isMotherNature;
    }
    public boolean getMotherNature(){
        return isMotherNature;
    }
    public void setGreenPawn(int i){
        greenPawn = i;
    }
    public int getGreenPawn(){
        return greenPawn;
    }
    public void setRedPawn(int i){
        redPawn = i;
    }
    public int getRedPawn(){
        return redPawn;
    }
    public void setYellowPawn(int i){
        yellowPawn = i;
    }
    public int getYellowPawn(){
        return yellowPawn;
    }
    public void setPinkPawn(int i){
        pinkPawn = i;
    }
    public int getPinkPawn(){
        return pinkPawn;
    }
    public void setBluePawn(int i){
        bluePawn = i;
    }
    public int getBluePawn() {
        return bluePawn;
    }
    public void setTower(boolean isTower){
        this.isTower = isTower;
    }
    public boolean getTower(){
        return isTower;
    }
    public void setColorTower(ColorTower colorTower){
        this.colorTower = colorTower;
    }
    public ColorTower getColorTower(){
        return colorTower;
    }
    public void setProhibited(boolean isProhibited){
        this.isProhibited = isProhibited;
    }
    public boolean getProhibited(){
        return isProhibited;
    }
    public void setTotIsland(int totIsland){
        this.totIsland = totIsland;
    }
    public int getTotIsland(){
        return totIsland;
    }
}
