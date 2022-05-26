package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

public class WinnerMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID = -2356374239620830380L;
    private final String message;
    public WinnerMessage(String nick){
        this.message= "The Winner is "+ nick;
    }

    public String getMessage() {
        return message;
    }
}
