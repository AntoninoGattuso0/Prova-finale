package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when the client has to choose the numPlayer and mode
 */
public class SetNumPlayersIsExpertMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID= -6403764458208105552L;
    }

