package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

public class WinnerMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID = -4487293668030628453L;
    String nickname;
    public WinnerMessage(String nickname){
        this.nickname=nickname;
    }
    public String getNickname() {
        return nickname;
    }
}
