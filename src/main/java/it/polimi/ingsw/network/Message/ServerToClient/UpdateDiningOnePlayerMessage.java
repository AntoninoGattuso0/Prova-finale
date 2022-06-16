package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client to update one LightDiningRoom
 */
public class UpdateDiningOnePlayerMessage extends ServerToClient implements Serializable {
    @Serial
    private final static long serialVersionUID= -368561353976972788L;
    private String nickname;
    public UpdateDiningOnePlayerMessage(String nickname){
        this.nickname=nickname;
    }

    public String getNickname() {
        return nickname;
    }
}
