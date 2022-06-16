package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when the lobby is full
 */
public class LobbyFullMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID= 2228135036982409958L;
}
