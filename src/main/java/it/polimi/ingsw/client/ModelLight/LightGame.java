package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.model.Island;
import it.polimi.ingsw.model.ProfTable;

import java.io.Serializable;
import java.util.ArrayList;

public class LightGame implements Serializable {
    private ProfTable profTable;
    private  ArrayList<LightCloud> clouds;
    private  ArrayList<LightPlayer> players;
    private  ArrayList<Island> islands;
    private int numPlayers;
    public LightGame(){
        this.clouds=new ArrayList<>();
        this.players=new ArrayList<>();
        this.islands=new ArrayList<>();
        this.numPlayers=-1;
        this.profTable=null;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public void setProfTable(ProfTable profTable) {
        this.profTable = profTable;
    }
    public ProfTable getProfTable() {
        return profTable;
    }
    public void setIslands(ArrayList<Island> islands) {
        this.islands = islands;
    }
    public void setClouds(ArrayList<LightCloud> clouds) {
        this.clouds = clouds;
    }
    public void setPlayers(ArrayList<LightPlayer> players) {
        this.players = players;
    }

    public int getNumPlayers() {
        return numPlayers;
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
