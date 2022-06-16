package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client for update the LightDiningRooms
 */
public class UpdateDiningMessage extends ServerToClient implements Serializable {
    @Serial
    private final static long serialVersionUID= 2613546325038963509L;
}
