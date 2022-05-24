package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.model.*;

import java.io.Serializable;
import java.util.ArrayList;

public class LightPlayer implements Serializable {

    private String nickname;
    private int numCoin;
    private final ArrayList<AssistantCard> deckAssistant;
    private AssistantCard currentAssistant;
    private LightEntrance entrance;
    private LightDiningRoom diningRoom;
    private LightTowerSpace towerSpace;
    private final ArrayList<LightPlayer> clientsLight;
    private ArrayList<LightCloud> clouds;
    private ArrayList<Island> islands;


    public LightPlayer() {
        this.nickname=null;
        this.numCoin=-1;
        this.deckAssistant = new ArrayList<>();
        this.currentAssistant= new AssistantCard();
        this.clientsLight = new ArrayList<>();
        this.entrance = new LightEntrance();
        this.diningRoom = new LightDiningRoom();
        this.towerSpace = new LightTowerSpace();
    }
    public void setNickname(String nickname){
        this.nickname=nickname;
    }
    public void setNumCoin(int numCoin) {
        this.numCoin = numCoin;
    }
    public void setCurrentAssistant(AssistantCard currentAssistant) {
        this.currentAssistant = currentAssistant;
    }

    public void setClouds(ArrayList<LightCloud> clouds) {
        this.clouds = clouds;
    }

    public void setDiningRoom(LightDiningRoom diningRoom) {
        this.diningRoom = diningRoom;
    }

    public void setEntrance(LightEntrance entrance) {
        this.entrance = entrance;
    }

    public void setTowerSpace(LightTowerSpace towerSpace) {
        this.towerSpace = towerSpace;
    }

    public void setIslands(ArrayList<Island> islands) {
        this.islands = islands;
    }
}
