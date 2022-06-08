package it.polimi.ingsw.network.Message.ClientToServer;

import java.io.Serial;
import java.io.Serializable;

public class MoveMotherNatureMessage extends ClientToServer implements Serializable {
    @Serial
    private static final long serialVersionUID = 8471854035572910652L;
    private final int island;

    public MoveMotherNatureMessage(int island) {
        this.island = island;
    }

    public int getIsland() {
        return island;
    }
}