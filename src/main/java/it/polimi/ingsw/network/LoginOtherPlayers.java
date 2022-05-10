package it.polimi.ingsw.network;

public class LoginOtherPlayers extends Message{

    private String nickname;

    public LoginOtherPlayers(String nickname){
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}.