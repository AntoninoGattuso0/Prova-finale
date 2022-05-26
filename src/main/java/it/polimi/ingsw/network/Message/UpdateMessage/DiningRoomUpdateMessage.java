package it.polimi.ingsw.network.Message.UpdateMessage;

import it.polimi.ingsw.client.ModelLight.LightDiningRoom;
import it.polimi.ingsw.network.Message.ServerToClient.ServerToClient;

public class DiningRoomUpdateMessage extends ServerToClient {
    private static final long serialVersionUID= 8297247884231830692L;
    private final LightDiningRoom diningRoom;
    public DiningRoomUpdateMessage(LightDiningRoom diningRoom){
        this.diningRoom =diningRoom;
    }
    public LightDiningRoom getDiningRoom() {
        return diningRoom;
    }
}
