package it.polimi.ingsw.network.Message.ClientToServer;

import java.io.Serial;
import java.io.Serializable;

public class iHaveToDisconnectMessage extends ClientToServer implements Serializable {
    @Serial
    private final static long serialVersionUID= 8366332961908529936L;
    private String nickname;
    public iHaveToDisconnectMessage(String nickname){
        this.nickname=nickname;
    }
    public String getNickname() {
        return nickname;
    }
}
