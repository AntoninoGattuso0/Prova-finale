package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when the Assistant not exist
 */
public class WrongNotAssistantMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID= -4739875377736622173L;
    private final String nickname;
    public WrongNotAssistantMessage(String nickname){
        this.nickname=nickname;
    }
    public String getNickname() {
        return nickname;
    }
}
