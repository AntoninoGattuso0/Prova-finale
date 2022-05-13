package it.polimi.ingsw.network.Message;

public class LoginNumPlayerIsExp extends ClientToServer {
    private static final long serialVersionUID= -6929509489095279482L;

    private final int numPlayers;
    private final boolean isExpert;

    public LoginNumPlayerIsExp( int numPlayers, boolean isExpert){
        this.numPlayers = numPlayers;
        this.isExpert = isExpert;
    }
    public int getNumPlayers(){
        return numPlayers;
    }
    public boolean getIsExpert(){
        return isExpert;
    }
}