package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

public class InvalidNumPlayerMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID = -8586276804689416722L;
    private final String invalidNumPlayer;


    public InvalidNumPlayerMessage() {
        this.invalidNumPlayer = "Number players Error";
    }

    public String getInvalidNumPlayer() {
        return invalidNumPlayer;
    }
}
