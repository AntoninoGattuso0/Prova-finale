package it.polimi.ingsw.network.Message;

public class LoginSettMessage extends ClientToServer {

    private final String nickname;
    private final boolean join;


    public LoginSettMessage(String nickname, boolean join){
        this.nickname = nickname;
        this.join=join;
    }

    public String getNickname() {
        return nickname;
    }
}