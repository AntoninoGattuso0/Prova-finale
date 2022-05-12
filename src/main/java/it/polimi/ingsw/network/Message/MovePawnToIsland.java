package it.polimi.ingsw.network.Message;

public class MovePawnToIsland extends ClientToServer {
    public final int island;


    public MovePawnToIsland(int island) {
        this.island = island;
    }

    public int getIsland() {
        return island;
    }
}
