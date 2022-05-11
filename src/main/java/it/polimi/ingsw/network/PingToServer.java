package it.polimi.ingsw.network;

public class PingToServer extends ClientToServer{
    private final String message;

    public PingToServer() {
        this.message = "";
    }

    public String getMessage(){
        return message;
    }

}
