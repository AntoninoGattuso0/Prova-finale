package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when the numPlayers is wrong
 */
public class InvalidNumPlayerMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID = 7710998878582336555L;
}
