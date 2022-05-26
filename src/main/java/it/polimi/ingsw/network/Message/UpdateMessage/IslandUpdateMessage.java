package it.polimi.ingsw.network.Message.UpdateMessage;

import it.polimi.ingsw.model.Island;
import it.polimi.ingsw.network.Message.ServerToClient.ServerToClient;

import java.util.ArrayList;

public class IslandUpdateMessage extends ServerToClient {
    private static final long serialVersionUID= 5892022955076211714L;
    private final ArrayList<Island> islands;
    public IslandUpdateMessage(ArrayList<Island> islands){
        this.islands=islands;
    }
    public ArrayList<Island> getIslands() {
        return islands;
    }
}
