package it.polimi.ingsw.network.Message.ClientToServer;

public class LoginSettMessage extends ClientToServer {
    private static final long serialVersionUID = 790152804682116373L;
    private final String nickname;
    private final boolean join;


    public LoginSettMessage(String nickname, boolean join){
        this.nickname = nickname;
        this.join=join;
    }

    public String getNickname() {
        return nickname;
    }
    public boolean getJoin(){ return join;}
}