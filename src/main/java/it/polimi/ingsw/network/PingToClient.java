package it.polimi.ingsw.network;

public class PingToClient extends ServerToClient{
    private final String message;

    public PingToClient() {
        this.message = "";
    }

    public String getMessage(){
        return message;
    }

}
