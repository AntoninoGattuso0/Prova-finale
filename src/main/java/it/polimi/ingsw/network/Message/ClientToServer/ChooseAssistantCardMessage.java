package it.polimi.ingsw.network.Message.ClientToServer;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the client to server with the Assistant
 */
public class ChooseAssistantCardMessage extends ClientToServer implements Serializable {
    @Serial
    private static final long serialVersionUID = 2694186732178419185L;
    private final int assistant;

    public ChooseAssistantCardMessage(int assistant) {
        this.assistant = assistant;
    }

    public int getAssistant() {
        return assistant;
    }
}
