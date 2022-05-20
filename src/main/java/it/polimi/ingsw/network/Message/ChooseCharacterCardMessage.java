package it.polimi.ingsw.network.Message;

public class ChooseCharacterCardMessage extends ClientToServer{
    private final int numCharacter;
    public ChooseCharacterCardMessage(int numCharacter){
        this.numCharacter=numCharacter;
    }
    public int getNumCharacter(){
        return numCharacter;
    }
}
