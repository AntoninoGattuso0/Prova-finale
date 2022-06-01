package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serializable;

public class WaitLoginMessage extends ServerToClient implements Serializable {
    private static final long serialVersionUID= -8438804012725567073L;
    private final String nickname;
    public WaitLoginMessage(String nickname){
        this.nickname=nickname;
    }
    public String getNickname() {
        return nickname;
    }
}
