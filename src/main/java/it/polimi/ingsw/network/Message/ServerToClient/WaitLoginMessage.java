package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client for nickname ping-pong
 */
public class WaitLoginMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID= -8438804012725567073L;
    private final String nickname;
    public WaitLoginMessage(String nickname){
        this.nickname=nickname;
    }
    public String getNickname() {
        return nickname;
    }
}
