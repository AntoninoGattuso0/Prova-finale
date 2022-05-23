package it.polimi.ingsw.network.Message.UpdateMessage;

import it.polimi.ingsw.model.AssistantCard;
import it.polimi.ingsw.network.Message.ServerToClient;

import java.util.ArrayList;

public class AssistantCardUpdateMessage extends ServerToClient {
    private static final long serialVersionUID = -5496227881234310994L;
    private final ArrayList<AssistantCard> deckAssistant;

    public AssistantCardUpdateMessage(ArrayList<AssistantCard> deckAssistant) {
    this.deckAssistant=deckAssistant;
    }
    public ArrayList<AssistantCard> getDeck() {
        return deckAssistant;
    }
}