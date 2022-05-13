package it.polimi.ingsw.network.Message;

public class WaitMessage extends ServerToClient{
    private final String message;

    public WaitMessage() {
        this.message ="waiting for other players" ;
    }

    public String getMessage() {
        return message;
    }
}
