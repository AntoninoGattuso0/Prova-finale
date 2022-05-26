package it.polimi.ingsw.network.Message.ClientToServer;

public class ChooseAssistantCardMessage extends ClientToServer {
    private static final long serialVersionUID = 8398621548495004770L;
    private final int assistant;

    public ChooseAssistantCardMessage(int assistant) {
        this.assistant = assistant;
    }

    public int getAssistant() {
        return assistant;
    }
}
