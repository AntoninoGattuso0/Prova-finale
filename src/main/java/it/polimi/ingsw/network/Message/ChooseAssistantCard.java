package it.polimi.ingsw.network.Message;

public class ChooseAssistantCard extends ClientToServer {
    private final int character;

    public ChooseAssistantCard(int character) {
        this.character = character;
    }

    public int getCharacter() {
        return character;
    }
}
