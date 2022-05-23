package it.polimi.ingsw.network.Message.UpdateMessage;

import it.polimi.ingsw.model.Entrance;
import it.polimi.ingsw.network.Message.ServerToClient;

public class EntranceUpdateMessage extends ServerToClient {
    private final static long serialVersionUID= 8303322386683056404L;
    private final Entrance entrance;
    public EntranceUpdateMessage(Entrance entrance){
        this.entrance=entrance;
    }
    public Entrance getEntrance() {
        return entrance;
    }
}
