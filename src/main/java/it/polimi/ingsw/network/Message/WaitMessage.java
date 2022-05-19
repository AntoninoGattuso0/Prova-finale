package it.polimi.ingsw.network.Message;

public class WaitMessage extends ServerToClient{
    private final String message;

    public WaitMessage(String message) {
        this.message =message ;
    }

    public String getMessage() {
        return message;
    }
}
