package it.polimi.ingsw.network.Message;

public class LoginNumPlayerIsExp extends ClientToServer {
    private static final long serialVersionUID= -6929509489095279482L;

    private final String nickname;
    private final int numPlayers;
    private final boolean isExpert;
    private final boolean join;


    public LoginNumPlayerIsExp(String nickname, int numPlayers, boolean isExpert, boolean join ){
        this.numPlayers = numPlayers;
        this.isExpert = isExpert;
    }
    public int getNumPlayers(){
        return numPlayers;
    }
    public boolean isExpert(){
        return isExpert;
    }
}