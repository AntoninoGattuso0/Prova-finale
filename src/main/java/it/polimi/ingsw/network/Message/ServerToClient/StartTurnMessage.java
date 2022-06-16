package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when the client start turn
 */
public class StartTurnMessage extends ServerToClient implements Serializable {
        @Serial
        private static final long serialVersionUID = -4475083144357282541L;
        private final String actualPlayer;
        public StartTurnMessage(String actualPlayer) {
                this.actualPlayer=actualPlayer;
        }
}
