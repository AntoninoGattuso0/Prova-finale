package it.polimi.ingsw.network.Message;

public class PlayerQuitMessage extends ServerToClient{
    private final String message;
    public PlayerQuitMessage(String s){
        this.message=s;
    }
    public String getMessage() {
        return message;
    }
}
