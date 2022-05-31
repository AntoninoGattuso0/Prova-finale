package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

public class StartTurnMessage extends ServerToClient implements Serializable {
        @Serial
        private static final long serialVersionUID = 6259107496654840777L;
        private final String actualPlayer;
        public StartTurnMessage(String actualPlayer) {
                this.actualPlayer=actualPlayer;
        }
        public String getActualPlayer() {
                return actualPlayer;
        }
}
