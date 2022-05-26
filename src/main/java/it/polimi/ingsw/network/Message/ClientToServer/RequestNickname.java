package it.polimi.ingsw.network.Message.ClientToServer;

public class RequestNickname extends ClientToServer {
    private static final long serialVersionUID= -6929509489095279482L;

    private final String nickName;

    public RequestNickname(String nickName){

        this.nickName = nickName;
    }

    public String getNickname(){
        return nickName;
    }
}