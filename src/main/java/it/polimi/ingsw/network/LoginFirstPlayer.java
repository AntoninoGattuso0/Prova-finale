package it.polimi.ingsw.network;

public class LoginFirstPlayer extends Message{

    private String nickname;
    private final int numPlayers;
    private final boolean isExpert;


    public LoginFirstPlayer(String nickname, int numPlayers, boolean isExpert ){
        this.nickname = nickname;
        this.numPlayers = numPlayers;
        this.isExpert = isExpert;
    }

    public int getNumPlayers(){
        return numPlayers;
    }

    public boolean isExpert(){
        return isExpert;
    }

    public String getNickname() {
        return nickname;
    }
}