package it.polimi.ingsw.network.Message;

public class PlayerQuitMessage extends ServerToClient{
    private static final long serialVersionUID = -3662066932133189733L;
    private final String message;
    public PlayerQuitMessage(String s){
        this.message=s;
    }
    public String getMessage() {
        return message;
    }
}
