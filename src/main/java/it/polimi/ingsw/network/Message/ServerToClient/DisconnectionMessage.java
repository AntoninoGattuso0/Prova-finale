package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when one player disconnects
 */
public class DisconnectionMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID = -6946629890988723330L;
    private final String playerDisconnected;

    public DisconnectionMessage(String playerDisconnected) {
        this.playerDisconnected = playerDisconnected;
    }

    public String getPlayerDisconnected() {
        return playerDisconnected;
    }
}
