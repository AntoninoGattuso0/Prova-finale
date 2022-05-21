package it.polimi.ingsw.network.Message;

public class DisconnectionMessage extends ServerToClient {
    private static final long serialVersionUID = 4161698569112307980L;
    private final String playerDisconnected;

    public DisconnectionMessage(String playerDisconnected) {
        this.playerDisconnected = playerDisconnected;
    }

    public String getPlayerDisconnected() {
        return playerDisconnected+" is disconnected";
    }
}
