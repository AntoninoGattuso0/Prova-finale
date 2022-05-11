package it.polimi.ingsw.network;

public class LoginFirstPlayer extends ClientToServer{
    private static final long serialVersionUID= -6929509489095279482L;
    private final String nickname;
    private final int numPlayers;
    private final boolean isExpert;
    private final boolean join;


    public LoginFirstPlayer(String nickname, int numPlayers, boolean isExpert, boolean join ){
        this.nickname = nickname;
        this.numPlayers = numPlayers;
        this.isExpert = isExpert;
        this.join=join;
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