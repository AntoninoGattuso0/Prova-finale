package it.polimi.ingsw.network;

import it.polimi.ingsw.model.DiningRoom;
import it.polimi.ingsw.model.Player;

public class MovePawnToDining extends ClientToServer{

    public final Player player;
    public final DiningRoom diningRoom;

    public MovePawnToDining(Player player, DiningRoom diningRoom) {
        this.player = player;
        this.diningRoom = diningRoom;
    }
}
