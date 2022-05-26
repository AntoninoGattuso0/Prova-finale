package it.polimi.ingsw.network.Message.ServerToClient;

public class ClientAcceptedMessage extends ServerToClient {
    private static final long serialVersionUID = 6819809874900833034L;
    private final String nickname;
    public ClientAcceptedMessage(String nickname){
        this.nickname=nickname;
    }
    public String getNickname(){
        return nickname;
    }
}

