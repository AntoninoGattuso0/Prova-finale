package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

public class StartTurnMessage extends ServerToClient implements Serializable {
        @Serial
        private static final long serialVersionUID = 6259107496654840777L;
        private final String currentPlayer;

        public StartTurnMessage(String currentPlayer){
            this.currentPlayer = currentPlayer;
        }

        public String getCurrentPlayer() {
            return currentPlayer;
        }

        public String getMessage(){
            return currentPlayer + "it's your turn!";
        }
    }
