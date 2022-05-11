package it.polimi.ingsw.network;

import it.polimi.ingsw.model.Island;

public class MovePawnToIsland extends ClientToServer{
    public final Island island;


    public MovePawnToIsland(Island island) {
        this.island = island;
    }

    public Island getIsland() {
        return island;
    }
}
