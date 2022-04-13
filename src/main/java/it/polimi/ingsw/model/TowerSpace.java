package it.polimi.ingsw.model;

public class TowerSpace {
    private ColorTower colorTower;
    protected int numTower;

    //ho aggiunto setter per definire quanti sono le torri iniziali, final perché si setta all'inizio il numero di torri
    public final void setNumTowerIniziale(){
        if(Game.totPlayer == 2 || Game.totPlayer == 4) numTower = 8;
        else if(Game.totPlayer == 3) numTower = 6;
    }
    public int getNumTower() {
        return numTower;
    }
}
