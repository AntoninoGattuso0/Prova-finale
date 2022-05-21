package it.polimi.ingsw.network.Message;

public class MoveMotherNatureMessage extends ClientToServer {
    private static final long serialVersionUID = 3281504012596996411L;
    private final int island;

    public MoveMotherNatureMessage(int island) {
        this.island = island;
    }

    public int getIsland() {
        return island;
    }
}