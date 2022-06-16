package it.polimi.ingsw.network.Message.ClientToServer;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the client to server when the client wait for the nickname to be accepted
 */
public class RequestNicknameAfterFirstLoginMessage extends ClientToServer implements Serializable {
    @Serial
    private static final long serialVersionUID= -7749598423238883884L;
    private final String nickName;
    public RequestNicknameAfterFirstLoginMessage(String nickName){
        this.nickName = nickName;
    }
    public String getNickname(){
        return nickName;
    }
}
