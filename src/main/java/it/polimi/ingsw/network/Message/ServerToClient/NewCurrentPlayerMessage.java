package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

public class NewCurrentPlayerMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID = 5174636856074373081L;
    private final String currentPlayer;
    private final String nextPlayer;

    public NewCurrentPlayerMessage(String currentPlayer, String nextPlayer){
        this.currentPlayer = currentPlayer;
        this.nextPlayer = nextPlayer;
    }

    public String getNextPlayer() {
        return currentPlayer + "is disconnected, " + nextPlayer + " it's your turn!";
    }
}
