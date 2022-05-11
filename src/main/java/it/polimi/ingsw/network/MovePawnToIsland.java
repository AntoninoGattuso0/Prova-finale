package it.polimi.ingsw.network;

import it.polimi.ingsw.model.Island;

public class MovePawnToIsland extends ClientToServer{
    public final int island;


    public MovePawnToIsland(int island) {
        this.island = island;
    }

    public int getIsland() {
        return island;
    }
}
