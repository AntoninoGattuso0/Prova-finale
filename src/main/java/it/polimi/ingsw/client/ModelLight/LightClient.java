package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.model.*;

import java.util.ArrayList;

public class LightClient {

    private final String nickname;
    private final int numCoin;
    private final ArrayList<AssistantCard> deckAssistant;
    private AssistantCard currentAssistant;
    private LightEntrance entrance;
    private LightDiningRoom diningRoom;
    private LightTowerSpace towerSpace;
    private final ArrayList<LightClient> clientsLight;
    private ArrayList<LightCloud> clouds;
    private ArrayList<Island> islands;


    public LightClient(String nickname, int numCoin, ArrayList<AssistantCard> deckAssistant, ArrayList<LightClient> clientsLight, TowerSpace tower, Entrance entrance) {
        this.nickname = nickname;
        this.numCoin = numCoin;
        this.deckAssistant = deckAssistant;
        this.currentAssistant= new AssistantCard();
        this.clientsLight = clientsLight;
        this.entrance = new LightEntrance(entrance);
        this.diningRoom = new LightDiningRoom();
        this.towerSpace = new LightTowerSpace(tower);
    }

}
