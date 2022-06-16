package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when the Assistant is the same of another player
 */
public class WrongSameAssistantMessage extends ServerToClient implements Serializable {
    @Serial
    private final static long serialVersionUID= -4348716159877235751L;
    private final String nickname;
    public WrongSameAssistantMessage(String nickname){
        this.nickname=nickname;
    }
    public String getNickname() {
        return nickname;
    }
}
