package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when the client has to choose the step
 */
public class SetMoveMotherNature extends ServerToClient implements Serializable {
    @Serial
    private final static long serialVersionUID= -5686811956756917575L;
    private String nickname;
    public SetMoveMotherNature(String nickname){
        this.nickname=nickname;
    }

    public String getNickname() {
        return nickname;
    }
}
