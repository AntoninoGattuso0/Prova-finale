package it.polimi.ingsw.network.Message;


public class ChooseCharacterCardMessage extends ClientToServer{
    private static final long serialVersionUID = 1697722215574451634L;
    private final int numCharacter;
    public ChooseCharacterCardMessage(int numCharacter){
        this.numCharacter=numCharacter;
    }
    public int getNumCharacter(){
        return numCharacter;
    }
}
