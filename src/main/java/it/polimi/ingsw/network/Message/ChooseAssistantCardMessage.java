package it.polimi.ingsw.network.Message;

public class ChooseAssistantCardMessage extends ClientToServer {
    private final int character;

    public ChooseAssistantCardMessage(int character) {
        this.character = character;
    }

    public int getCharacter() {
        return character;
    }
}
