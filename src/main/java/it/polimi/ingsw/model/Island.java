package it.polimi.ingsw.model;

public  class Island {
    protected boolean isMotherNature;
    protected int greenPawn;
    protected int redPawn;
    protected int yellowPawn;
    protected int pinkPawn;
    protected int bluePawn;
    protected boolean isTower;
    protected ColorTower colorTower;
    protected boolean isProhibited;
    protected int totIsland;

    public boolean isMotherNature(){
        return isMotherNature;
    }

    public boolean isTower(){
        return isTower;
    }
}