package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class TurnOrderMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID= 6847035424917439806L;
    public ArrayList<String> players;
    public TurnOrderMessage(ArrayList<String> players){
        this.players=players;
    }

    public ArrayList<String> getPlayersOrder() {
        return players;
    }

}
