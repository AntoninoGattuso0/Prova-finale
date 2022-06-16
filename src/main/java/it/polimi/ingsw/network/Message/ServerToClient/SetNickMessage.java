package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when the client has to choose the nickname
 */
public class SetNickMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID= 8606207455667433697L;
}
