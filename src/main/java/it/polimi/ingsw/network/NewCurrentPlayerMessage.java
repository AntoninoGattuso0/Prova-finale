package it.polimi.ingsw.network;

import it.polimi.ingsw.model.Player;

public class NewCurrentPlayerMessage extends ServerToClient{
    private final String currentPlayer;
    private final String nextPlayer;

    public NewCurrentPlayerMessage(String currentPlayer, String nextPlayer){
        this.currentPlayer = currentPlayer;
        this.nextPlayer = nextPlayer;
    }

    public String getNextPlayer() {
        return currentPlaye + "is disconnected, " + nextPlayer + " it's your turn!";
    }
}
