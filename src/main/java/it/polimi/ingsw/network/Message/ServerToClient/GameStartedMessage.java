package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when the game started
 */
public class GameStartedMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID = 8335090669774965622L;
}
