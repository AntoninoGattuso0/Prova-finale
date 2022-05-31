package it.polimi.ingsw.network.Message.ServerToClient;

import it.polimi.ingsw.model.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class TurnOrderMessage extends ServerToClient implements Serializable {
    private static final long serialVersionUID= 7069158417058358621L;
    public ArrayList<Player> players;
    public TurnOrderMessage(ArrayList<Player> players){
        this.players=players;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
}
