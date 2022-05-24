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

    public LightPlayer() {
        this.nickname=null;
        this.numCoin=-1;
        this.deckAssistant = new ArrayList<>();
        this.currentAssistant= new AssistantCard();
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

    public void setLightDiningRoom(LightDiningRoom diningRoom) {
        this.diningRoom = diningRoom;
    }

    public void setLightEntrance(LightEntrance entrance) {
        this.entrance = entrance;
    }

    public void setLightTowerSpace(LightTowerSpace towerSpace) {
        this.towerSpace = towerSpace;
    }

    public String getNickname() {
        return nickname;
    }

    public AssistantCard getCurrentAssistant() {
        return currentAssistant;
    }

    public int getNumCoin() {
        return numCoin;
    }

    public ArrayList<AssistantCard> getDeckAssistant() {
        return deckAssistant;
    }

    public LightDiningRoom getDiningRoom() {
        return diningRoom;
    }

    public LightEntrance getEntrance() {
        return entrance;
    }

    public LightTowerSpace getTowerSpace() {
        return towerSpace;
    }
}
