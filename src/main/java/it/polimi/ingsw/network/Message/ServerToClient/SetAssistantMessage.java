package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when client has to choose the assistant
 */
public class SetAssistantMessage extends ServerToClient implements Serializable{
    @Serial
    private static final long serialVersionUID= -7670862571469110376L;
    private final String nickname;
    public SetAssistantMessage(String nickname){
        this.nickname=nickname;
    }
    public String getNickname() {
        return nickname;
    }
}
