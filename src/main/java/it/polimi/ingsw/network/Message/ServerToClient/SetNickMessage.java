package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

public class SetNickMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID= -6395071198017174131L;
    private final String message;
    public SetNickMessage(){
        message="Dimmi il nickname";
    }
    public String getMessage() {
        return message;
    }
}
