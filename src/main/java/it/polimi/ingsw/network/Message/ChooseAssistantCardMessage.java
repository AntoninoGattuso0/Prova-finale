package it.polimi.ingsw.network.Message;

public class ChooseAssistantCardMessage extends ClientToServer {
    private final int assistant;

    public ChooseAssistantCardMessage(int assistant) {
        this.assistant = assistant;
    }

    public int getAssistant() {
        return assistant;
    }
}
