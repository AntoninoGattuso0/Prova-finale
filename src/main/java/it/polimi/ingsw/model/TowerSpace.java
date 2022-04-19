package it.polimi.ingsw.model;

public class TowerSpace {
    private ColorTower colorTower;
    protected int numTower;

    //modifiche all'UML:ho aggiunto setter per definire quante sono le torri iniziali, final o no?
    public void setNumTowerIniziale(){
        if(Game.totPlayer == 2 || Game.totPlayer == 4) numTower = 8;
        else if(Game.totPlayer == 3) numTower = 6;
    }

    public int getNumTower() {
        return numTower;
    }
}
