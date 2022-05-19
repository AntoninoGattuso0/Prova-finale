package it.polimi.ingsw.network.Message;

public class ChooseCharacterCard extends ClientToServer{
    private final int numCharacter;
    public ChooseCharacterCard(int numCharacter){
        this.numCharacter=numCharacter;
    }
    public int getNumCharacter(){
        return numCharacter;
    }
}
