package it.polimi.ingsw.network;

public class InvalidNumPlayer extends ServerToClient{
    private final int invalidNumPlayer;


    public InvalidNumPlayer(int invalidNumPlayer) {
        this.invalidNumPlayer = invalidNumPlayer;
    }

    public int getInvalidNumPlayer() {
        return invalidNumPlayer;
    }
}
