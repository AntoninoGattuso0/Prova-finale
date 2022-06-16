package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when the client  needs to move the pawns
 */
public class SetMovePawnMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID= -4109068540423704447L;
    private int numPawnMoved;
    private String nickname;

    public SetMovePawnMessage(String nickname,int numPawnMoved) {
        this.numPawnMoved = numPawnMoved;
        this.nickname=nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public int getNumPawnMoved() {
        return numPawnMoved;
    }
}
