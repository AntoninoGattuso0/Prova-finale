package it.polimi.ingsw.network.Message.UpdateMessage;

import it.polimi.ingsw.model.TowerSpace;
import it.polimi.ingsw.network.Message.ServerToClient;

public class TowerSpaceUpdateMessage extends ServerToClient {
    private static final long serialVersionUID= 3135856563326845662L;
    private final TowerSpace towerSpace;
    public TowerSpaceUpdateMessage(TowerSpace towerSpace){
        this.towerSpace=towerSpace;
    }
    public TowerSpace getTowerSpace() {
        return towerSpace;
    }
}
