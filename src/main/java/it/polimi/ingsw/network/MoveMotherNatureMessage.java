package it.polimi.ingsw.network;

import it.polimi.ingsw.model.Island;

public class MoveMotherNatureMessage extends ClientToServer{
    private final Island island;

    public MoveMotherNatureMessage( Island island) {
        this.island = island;
    }

    public Island getIsland() {
        return island;
    }
}
