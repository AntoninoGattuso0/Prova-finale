package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when the lobby is not full
 */
public class WaitMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID = 5759788297984679349L;
}
