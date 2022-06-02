package it.polimi.ingsw.network.Message.ServerToClient;

import it.polimi.ingsw.model.Player;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class TurnOrderMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID= 6847035424917439806L;
    public ArrayList<Player> players;
    public TurnOrderMessage(ArrayList<Player> players){
        this.players=players;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
}
