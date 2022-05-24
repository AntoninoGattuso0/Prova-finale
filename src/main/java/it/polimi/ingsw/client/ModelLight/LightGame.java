package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.model.Island;

import java.io.Serializable;
import java.util.ArrayList;

public class LightGame implements Serializable {
    private final ArrayList<LightCloud> clouds;
    private final ArrayList<LightPlayer> players;
    private final ArrayList<Island> islands;
    public LightGame(ArrayList<LightPlayer> players,ArrayList<LightCloud> clouds,ArrayList<Island> islands){
        this.clouds=clouds;
        this.players=players;
        this.islands=islands;
    }
    public ArrayList<Island> getIslands() {
        return islands;
    }
    public ArrayList<LightCloud> getClouds() {
        return clouds;
    }
    public ArrayList<LightPlayer> getPlayers() {
        return players;
    }
}
