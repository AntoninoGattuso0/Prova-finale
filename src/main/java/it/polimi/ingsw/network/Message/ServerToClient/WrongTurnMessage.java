package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when it's not his turn
 */
public class WrongTurnMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID = 7448204087325393644L;
}
