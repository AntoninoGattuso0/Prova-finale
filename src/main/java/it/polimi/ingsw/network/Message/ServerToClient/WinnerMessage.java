package it.polimi.ingsw.network.Message.ServerToClient;

public class WinnerMessage extends ServerToClient {
    private static final long serialVersionUID = -2356374239620830380L;
    private final String message;
    public WinnerMessage(String nick){
        this.message= "The Winner is "+ nick;
    }

    public String getMessage() {
        return message;
    }
}
