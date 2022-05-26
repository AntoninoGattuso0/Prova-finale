package it.polimi.ingsw.network.Message.UpdateMessage;

import it.polimi.ingsw.client.ModelLight.LightTowerSpace;
import it.polimi.ingsw.network.Message.ServerToClient.ServerToClient;

public class TowerSpaceUpdateMessage extends ServerToClient {
    private static final long serialVersionUID= 3135856563326845662L;
    private final LightTowerSpace towerSpace;
    public TowerSpaceUpdateMessage(LightTowerSpace towerSpace){
        this.towerSpace=towerSpace;
    }
    public LightTowerSpace getTowerSpace() {
        return towerSpace;
    }
}
