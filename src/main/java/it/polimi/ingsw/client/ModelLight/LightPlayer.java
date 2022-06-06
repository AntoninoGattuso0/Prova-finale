package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.controller.PhaseTurn;
import it.polimi.ingsw.model.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class LightPlayer implements Serializable {
    @Serial
    private static final long serialVersionUID= 6825325939760723288L;

    private String nickname;
    private int numCoin;
    private ArrayList<AssistantCard> deckAssistant;
    private AssistantCard currentAssistant;
    private LightEntrance entrance;
    private LightDiningRoom diningRoom;
    private LightTowerSpace towerSpace;
    private PhaseTurn currentPhase;

    public LightPlayer(String nickname,int numCoin,ArrayList<AssistantCard> deckAssistant,AssistantCard currentAssistant,LightEntrance lightEntrance, LightTowerSpace LightTowerSpace, LightDiningRoom lightDiningRoom,PhaseTurn currentPhase) {
        this.nickname=nickname;
        this.numCoin=numCoin;
        this.deckAssistant =deckAssistant;
        this.currentAssistant=currentAssistant;
        this.entrance =lightEntrance;
        this.diningRoom =lightDiningRoom;
        this.towerSpace =LightTowerSpace;
        this.currentPhase=currentPhase;
    }

    public PhaseTurn getCurrentPhase() {
        return currentPhase;
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
    public void setNumCoin(int numCoin){this.numCoin = numCoin;}

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
