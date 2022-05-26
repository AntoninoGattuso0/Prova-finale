package it.polimi.ingsw.network.Message.UpdateMessage;

import it.polimi.ingsw.client.ModelLight.LightEntrance;
import it.polimi.ingsw.network.Message.ServerToClient.ServerToClient;

public class EntranceUpdateMessage extends ServerToClient {
    private final static long serialVersionUID= 8303322386683056404L;
    private final LightEntrance entrance;
    public EntranceUpdateMessage(LightEntrance entrance){
        this.entrance=entrance;
    }
    public LightEntrance getEntrance() {
        return entrance;
    }
}
