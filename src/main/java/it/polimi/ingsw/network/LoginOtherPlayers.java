package it.polimi.ingsw.network;

public class LoginOtherPlayers extends ClientToServer{

    private String nickname;

    public LoginOtherPlayers(String nickname){
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}