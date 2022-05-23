package it.polimi.ingsw.network.Message.UpdateMessage;

import it.polimi.ingsw.model.DiningRoom;
import it.polimi.ingsw.network.Message.ServerToClient;

public class DiningRoomUpdateMessage extends ServerToClient {
    private static final long serialVersionUID= 8297247884231830692L;
    private final DiningRoom diningRoom;
    public DiningRoomUpdateMessage(DiningRoom diningRoom){
        this.diningRoom =diningRoom;
    }
    public DiningRoom getDiningRoom() {
        return diningRoom;
    }
}
