package it.polimi.ingsw.network.Message;

public class ClientAcceptedMessage extends ServerToClient{
    private final String nickname;
    public ClientAcceptedMessage(String nickname){
        this.nickname=nickname;
    }
    public String getNickname(){
        return nickname;
    }
}
