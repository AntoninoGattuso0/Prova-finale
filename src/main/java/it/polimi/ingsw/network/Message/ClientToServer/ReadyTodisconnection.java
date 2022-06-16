package it.polimi.ingsw.network.Message.ClientToServer;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the client to server to tell it is ready to disconnect
 */
public class ReadyTodisconnection extends ClientToServer implements Serializable {
    @Serial
    private static final long serialVersionUID= 3988028597247944506L;
}
