package it.polimi.ingsw.network.Message.UpdateMessage;

import it.polimi.ingsw.model.CharacterCard;

import java.util.ArrayList;

public class CharacterCardUpdateMessage {
    private static final long serialVersionUID= -311633869817273652L;
    private final ArrayList<CharacterCard> characterCards;
    public CharacterCardUpdateMessage(ArrayList<CharacterCard> characterCards){
        this.characterCards=characterCards;
    }
    public ArrayList<CharacterCard> getCharacterCards() {
        return characterCards;
    }
}
