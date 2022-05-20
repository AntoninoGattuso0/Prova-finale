package it.polimi.ingsw.network.Message;

public class WrongTurnMessage extends ServerToClient{
    private final String message="Wrong Turn";
    public String getMessage() {
        return message;
    }
}
