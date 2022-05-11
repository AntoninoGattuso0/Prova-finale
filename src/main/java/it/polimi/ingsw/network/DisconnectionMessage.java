package it.polimi.ingsw.network;

import it.polimi.ingsw.model.Player;

public class DisconnectionMessage extends ServerToClient{
    private final Player playerDisconnected;

    public DisconnectionMessage(Player playerDisconnected) {
        this.playerDisconnected = playerDisconnected;
    }

    public Player getPlayerDisconnected() {
        return playerDisconnected;
    }
}
