package it.polimi.ingsw.model;

public  class Island {
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

    public boolean isMotherNature(){
        return isMotherNature;
    }

    public boolean isTower(){
        return isTower;
    }
}