package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

public class SetAssistantMessage extends ServerToClient implements Serializable{
    @Serial
    private static final long serialVersionUID= -7670862571469110376L;
    private final String nickname;
    private final String currentPlayer;
    public SetAssistantMessage(String nickname,String currentPlayer){
        this.nickname=nickname;
        this.currentPlayer=currentPlayer;
    }
    public String getNickname() {
        return nickname;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }
}
