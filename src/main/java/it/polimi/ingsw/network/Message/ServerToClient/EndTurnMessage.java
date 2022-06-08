package it.polimi.ingsw.network.Message.ServerToClient;

import it.polimi.ingsw.client.ModelLight.LightPlayer;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class EndTurnMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID = -8399908476119148036L;
    private ArrayList<LightPlayer> players;
    private String actualPlayer;

    public EndTurnMessage(ArrayList<LightPlayer> players,String actualPlayer) {
        this.players = players;
        this.actualPlayer=actualPlayer;
    }

    public String getActualPlayer() {
        return actualPlayer;
    }

    public ArrayList<LightPlayer> getPlayers() {
        return players;
    }
}
