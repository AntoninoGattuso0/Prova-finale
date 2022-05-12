package it.polimi.ingsw.network.Message;

public class LoginOtherPlayers extends ClientToServer {

    private final String nickname;
    private final boolean join;


    public LoginOtherPlayers(String nickname,boolean join){
        this.nickname = nickname;
        this.join=join;
    }

    public String getNickname() {
        return nickname;
    }
}