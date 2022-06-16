package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.model.ColorTower;

import java.io.Serial;
import java.io.Serializable;

/**
 * LightTowerSpace is the serialized class that contains the TowerSpace information to be sent to the client
 * @see it.polimi.ingsw.model.TowerSpace
 */
public class LightTowerSpace implements Serializable {
    @Serial
    private static final long serialVersionUID= 3577937004411664490L;
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