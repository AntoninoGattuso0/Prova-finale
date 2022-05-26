package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.model.Island;
import it.polimi.ingsw.model.ProfTable;
import it.polimi.ingsw.network.Message.UpdateMessage.*;


import java.io.Serializable;
import java.util.ArrayList;

public class LightGame implements Serializable {
    private ProfTable profTable;
    private  ArrayList<LightCloud> clouds;
    private  ArrayList<LightPlayer> players;
    private  ArrayList<Island> islands;
    private int numPlayers;
    public LightGame(ArrayList<LightCloud> clouds,ArrayList<LightPlayer> players,ArrayList<Island> islands, int numPlayers, ProfTable profTable){
        this.clouds=clouds;
        this.players=players;
        this.islands=islands;
        this.numPlayers=numPlayers;
        this.profTable=profTable;
    }
    public ProfTable getProfTable() {
        return profTable;
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

    public void updateAssistantCard(AssistantCardUpdateMessage message){}
    public void updateCloud(CloudUpdateMessage message){}
    public void updateIsland(IslandUpdateMessage message){}
    public void updateEntrance(EntranceUpdateMessage message){}
    public void updateDiningRoom(DiningRoomUpdateMessage message){}
    public void updateProfTable(ProfTableUpdateMessage message){}
    public void updateTowerSpace(TowerSpaceUpdateMessage message){}
    public void updateCharacterCard(CharacterCardUpdateMessage message){}
}
