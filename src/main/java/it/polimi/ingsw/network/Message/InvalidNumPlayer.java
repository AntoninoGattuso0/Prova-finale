package it.polimi.ingsw.network.Message;

public class InvalidNumPlayer extends ServerToClient {
    private final String invalidNumPlayer;


    public InvalidNumPlayer() {
        this.invalidNumPlayer = "Number players Error";
    }

    public String getInvalidNumPlayer() {
        return invalidNumPlayer;
    }
}
