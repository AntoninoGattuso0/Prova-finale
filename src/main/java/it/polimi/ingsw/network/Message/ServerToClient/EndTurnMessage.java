package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class EndTurnMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID = -8399908476119148036L;
    private ArrayList<String> players;
    private String actualPlayer;

    public EndTurnMessage(ArrayList<String> players,String actualPlayer) {
        this.players = players;
        this.actualPlayer=actualPlayer;
    }

    public String getActualPlayer() {
        return actualPlayer;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }
}
