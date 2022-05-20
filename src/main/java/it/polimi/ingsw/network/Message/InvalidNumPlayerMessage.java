package it.polimi.ingsw.network.Message;

public class InvalidNumPlayerMessage extends ServerToClient {
    private final String invalidNumPlayer;


    public InvalidNumPlayerMessage() {
        this.invalidNumPlayer = "Number players Error";
    }

    public String getInvalidNumPlayer() {
        return invalidNumPlayer;
    }
}
