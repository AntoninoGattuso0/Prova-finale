package it.polimi.ingsw.network;

import it.polimi.ingsw.model.CharacterCard;

public class ChooseAssistantCard extends ClientToServer{
    private final CharacterCard character;

    public ChooseAssistantCard(CharacterCard character) {
        this.character = character;
    }

    public CharacterCard getCharacter() {
        return character;
    }
}
