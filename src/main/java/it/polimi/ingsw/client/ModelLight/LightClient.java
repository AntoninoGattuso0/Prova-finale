package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.model.AssistantCard;
import it.polimi.ingsw.model.DiningRoom;

import java.util.ArrayList;

public class LightClient {

    private final String nickname;
    private final int numCoin;
    private final ArrayList<AssistantCard> deckAssistant;
    private LightAssistantCard currentAssistant;
    private LightEntrance entrance;
    private LightDiningRoom diningRoom;
    private LightTowerSpace towerSpace;

    public LightClient(String nickname) {
        this.nickname = nickname;
        this.entrance = new LightEntrance();
        this.diningRoom = new LightDiningRoom();
    }

}
