package it.polimi.ingsw.network.Message;

import it.polimi.ingsw.network.Message.ServerToClient.*;

public class ClientAcceptedMessage extends ServerToClient {
    private static final long serialVersionUID = -7645947343781872995L;
    private final String nickname;
    public ClientAcceptedMessage(String nickname){
        this.nickname=nickname;
    }
    public String getNickname(){
        return nickname;
    }
}
