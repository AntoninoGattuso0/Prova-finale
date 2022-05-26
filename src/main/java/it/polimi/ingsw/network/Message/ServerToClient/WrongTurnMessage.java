package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

public class WrongTurnMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID = -9116043505813593296L;
    private final String message="Wrong Turn";
    public String getMessage() {
        return message;
    }
}
