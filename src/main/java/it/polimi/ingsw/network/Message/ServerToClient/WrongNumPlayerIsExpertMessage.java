package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when the mode or numPlayer is wrong
 */
public class WrongNumPlayerIsExpertMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID= 4004863516212996718L;
}
