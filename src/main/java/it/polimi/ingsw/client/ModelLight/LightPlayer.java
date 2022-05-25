package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.model.*;

import java.io.Serializable;
import java.util.ArrayList;

public class LightPlayer implements Serializable {

    private String nickname;
    private int numCoin;
    private ArrayList<AssistantCard> deckAssistant;
    private AssistantCard currentAssistant;
    private LightEntrance entrance;
    private LightDiningRoom diningRoom;
    private LightTowerSpace towerSpace;

    public LightPlayer(String nickname,int numCoin,ArrayList<AssistantCard> deckAssistant,AssistantCard currentAssistant,LightEntrance lightEntrance, LightTowerSpace LightTowerSpace, LightDiningRoom lightDiningRoom) {
        this.nickname=nickname;
        this.numCoin=numCoin;
        this.deckAssistant =deckAssistant;
        this.currentAssistant=currentAssistant;
        this.entrance =lightEntrance;
        this.diningRoom =lightDiningRoom;
        this.towerSpace =LightTowerSpace;
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
