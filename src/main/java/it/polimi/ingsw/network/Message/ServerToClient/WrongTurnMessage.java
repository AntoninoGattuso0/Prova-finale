package it.polimi.ingsw.network.Message.ServerToClient;

import it.polimi.ingsw.network.Message.ServerToClient.ServerToClient;

public class WrongTurnMessage extends ServerToClient {
    private static final long serialVersionUID = -9116043505813593296L;
    private final String message="Wrong Turn";
    public String getMessage() {
        return message;
    }
}
