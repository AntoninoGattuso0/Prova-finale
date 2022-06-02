package it.polimi.ingsw.network.Message.ServerToClient;

import it.polimi.ingsw.client.ModelLight.LightPlayer;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class TurnOrderMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID= 6847035424917439806L;
    public ArrayList<LightPlayer> players;
    public TurnOrderMessage(ArrayList<LightPlayer> players){
        this.players=players;
    }
    public ArrayList<LightPlayer> getPlayers() {
        return players;
    }
}
