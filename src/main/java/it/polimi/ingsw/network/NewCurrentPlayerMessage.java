package it.polimi.ingsw.network;

import it.polimi.ingsw.model.Player;

public class NewCurrentPlayerMessage extends ServerToClient{
    private final Player currentPlayer;
    private final Player nextPlayer;

    public NewCurrentPlayerMessage(Player currentPlayer, Player nextPlayer){
        this.currentPlayer = currentPlayer;
        this.nextPlayer = nextPlayer;
    }

    public String getNextPlayer() {
        return currentPlayer.getNickname() + "is disconnected, " + nextPlayer.getNickname() + " it's your turn!";
    }
}
