package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.model.ColorTower;
import it.polimi.ingsw.network.Message.UpdateMessage.TowerSpaceUpdateMessage;

public class LightTowerSpace {
    private ColorTower colorTower;
    private int numTower;


    public LightTowerSpace() {
        colorTower=null;
        int numTower=-1;
    }

    public void setColorTower(ColorTower colorTower) {
        this.colorTower = colorTower;
    }

    public void setNumTower(int numTower) {
        this.numTower = numTower;
    }

    public ColorTower getColorTower() {
        return colorTower;
    }

    public int getNumTower() {
        return numTower;
    }

    public void update(TowerSpaceUpdateMessage message){
        this.colorTower = message.getTowerSpace().getColorTower();
        this.numTower = message.getTowerSpace().getNumTower();
    }
}
