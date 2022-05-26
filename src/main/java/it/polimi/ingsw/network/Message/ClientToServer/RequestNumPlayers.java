package it.polimi.ingsw.network.Message.ClientToServer;

public class RequestNumPlayers extends ClientToServer {
    private static final long serialVersionUID = -2479289539897028423L;

    private final int numPlayers;

    public RequestNumPlayers(int numPlayers){
        this.numPlayers = numPlayers;

    }

    public int getNumPlayers(){
        return numPlayers;
    }
}
