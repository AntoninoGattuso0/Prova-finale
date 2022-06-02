package it.polimi.ingsw.network.Message.ClientToServer;

import java.io.Serial;

public class MoveMotherNatureMessage extends ClientToServer {
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