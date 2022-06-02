package it.polimi.ingsw.network.Message.UpdateMessage;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.network.Message.ServerToClient.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

public class AllUpdateMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID= 8897338037071499069L;
    LightGame lightGame;
    public AllUpdateMessage(LightGame lightGame){
        this.lightGame=lightGame;
    }
    public LightGame getLightGame() {
        return lightGame;
    }
}
