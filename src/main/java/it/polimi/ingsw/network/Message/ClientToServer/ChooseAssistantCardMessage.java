package it.polimi.ingsw.network.Message.ClientToServer;

import java.io.Serial;
import java.io.Serializable;

public class ChooseAssistantCardMessage extends ClientToServer implements Serializable {
    @Serial
    private static final long serialVersionUID = 8398621548495004770L;
    private final int assistant;

    public ChooseAssistantCardMessage(int assistant) {
        this.assistant = assistant;
    }

    public int getAssistant() {
        return assistant;
    }
}
