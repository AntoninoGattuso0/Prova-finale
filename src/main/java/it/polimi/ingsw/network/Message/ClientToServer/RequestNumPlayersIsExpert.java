package it.polimi.ingsw.network.Message.ClientToServer;

public class RequestNumPlayersIsExpert extends ClientToServer {
    private static final long serialVersionUID = -2479289539897028423L;

    private final int numPlayers;
    private final boolean isExpert;

    public RequestNumPlayersIsExpert(int numPlayers,boolean isExpert){
        this.numPlayers = numPlayers;
        this.isExpert=isExpert;
    }
    public boolean getIsExpert() {
        return isExpert;
    }
    public int getNumPlayers(){
        return numPlayers;
    }
}
