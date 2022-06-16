package it.polimi.ingsw.network.Message.ServerToClient;


import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when the client is accepted
 */
public class LoginAcceptedMessage extends ServerToClient implements Serializable {
   @Serial
    private static final long serialVersionUID= -5313275229249551738L;
}
