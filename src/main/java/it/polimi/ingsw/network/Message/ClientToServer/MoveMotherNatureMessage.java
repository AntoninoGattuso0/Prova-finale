package it.polimi.ingsw.network.Message.ClientToServer;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the client to server with the steps for MoveMotherNature
 */
public class MoveMotherNatureMessage extends ClientToServer implements Serializable {
    @Serial
    private static final long serialVersionUID = 8471854035572910652L;
    private final int steps;

    public MoveMotherNatureMessage(int steps) {
        this.steps = steps;
    }

    public int getIsland() {
        return steps;
    }
}