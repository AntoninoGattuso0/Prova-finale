package it.polimi.ingsw.network.Message.ServerToClient;

public class InvalidNumPlayerMessage extends ServerToClient {
    private static final long serialVersionUID = -8586276804689416722L;
    private final String invalidNumPlayer;


    public InvalidNumPlayerMessage() {
        this.invalidNumPlayer = "Number players Error";
    }

    public String getInvalidNumPlayer() {
        return invalidNumPlayer;
    }
}
