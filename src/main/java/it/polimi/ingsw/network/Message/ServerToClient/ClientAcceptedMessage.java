package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

public class ClientAcceptedMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID = 6819809874900833034L;
    private final String nickname;
    public ClientAcceptedMessage(String nickname){
        this.nickname=nickname;
    }
    public String getNickname(){
        return nickname;
    }
}

