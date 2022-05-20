package it.polimi.ingsw.network.Message;

public class MovePawnToIslandMessage extends ClientToServer {
    public final int island;


    public MovePawnToIslandMessage(int island) {
        this.island = island;
    }

    public int getIsland() {
        return island;
    }
}
