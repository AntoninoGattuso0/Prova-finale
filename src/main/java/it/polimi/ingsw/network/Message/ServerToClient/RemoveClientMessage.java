package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

public class RemoveClientMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID= 8814584660572306735L;
    private final String message;
    public RemoveClientMessage(String message){
        this.message=message;
    }
    public String getMessage() {
        return message;
    }
}
