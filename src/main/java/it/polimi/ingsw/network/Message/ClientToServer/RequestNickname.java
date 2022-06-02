package it.polimi.ingsw.network.Message.ClientToServer;

import java.io.Serial;

public class RequestNickname extends ClientToServer {
    @Serial
    private static final long serialVersionUID= 5123207096423101693L;

    private final String nickName;

    public RequestNickname(String nickName){

        this.nickName = nickName;
    }

    public String getNickname(){
        return nickName;
    }
}