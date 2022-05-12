package it.polimi.ingsw.network.Message;

public class DisconnectionMessage extends ServerToClient {
    private final String playerDisconnected;

    public DisconnectionMessage(String playerDisconnected) {
        this.playerDisconnected = playerDisconnected;
    }

    public String getPlayerDisconnected() {
        return playerDisconnected+" is disconnected";
    }
}
