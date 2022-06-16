package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client to update the Islands
 */
public class UpdateIslandsMessage extends ServerToClient implements Serializable {
    @Serial
    private final static long serialVersionUID= 5426012862237199106L;
}
