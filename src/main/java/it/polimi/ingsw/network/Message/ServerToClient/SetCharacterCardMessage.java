package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

public class SetCharacterCardMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID= -4212857290122813426L;
    private final String nickname;
    private final boolean bool;
    public SetCharacterCardMessage(String nickname,boolean bool){
        this.nickname=nickname;
        this.bool=bool;
    }
    public String getNickname() {
        return nickname;
    }

    public boolean isBool() {
        return bool;
    }
}
