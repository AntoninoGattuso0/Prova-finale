package it.polimi.ingsw.network.Message.UpdateMessage;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.network.Message.ServerToClient;

public class AllUpdateMessage extends ServerToClient {
    private static final long serialVersionUID= 8105229548955203739L;
    LightGame lightGame;
    public AllUpdateMessage(LightGame lightGame){
        this.lightGame=lightGame;
    }
    public LightGame getLightGame() {
        return lightGame;
    }
}