package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.model.ColorTower;

public class LightTowerSpace {
    private ColorTower colorTower;
    private int numTower;


    public LightTowerSpace(ColorTower colorTower,int numTower) {
        this.colorTower=colorTower;
        this.numTower=numTower;
    }

    public ColorTower getColorTower() {
        return colorTower;
    }

    public int getNumTower() {
        return numTower;
    }
    }