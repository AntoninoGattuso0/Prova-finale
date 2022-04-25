package it.polimi.ingsw.model;

public class Island {
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
    //public boolean isMotherNature(){
    //    return isMotherNature;
    //}
    Island(){
            isMotherNature = false;
            greenPawn = 0;
            redPawn = 0;
            yellowPawn = 0;
            pinkPawn = 0;
            bluePawn = 0;
            isTower=false;
            colorTower = null;
            isProhibited = false;
            totIsland = 1;
        }
    public boolean IsTower(Island island){
        return island.isTower;
    }
}