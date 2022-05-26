package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

public class WaitMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID = 6996567351995052545L;
    private final String message;

    public WaitMessage(String message) {
        this.message =message ;
    }

    public String getMessage() {
        return message;
    }
}
