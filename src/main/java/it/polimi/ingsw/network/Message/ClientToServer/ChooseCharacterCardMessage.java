package it.polimi.ingsw.network.Message.ClientToServer;


import java.io.Serial;
import java.io.Serializable;

public class ChooseCharacterCardMessage extends ClientToServer implements Serializable {
    @Serial
    private static final long serialVersionUID = 1697722215574451634L;
    private final int numCharacter;
    public ChooseCharacterCardMessage(int numCharacter){
        this.numCharacter=numCharacter;
    }
    public int getNumCharacter(){
        return numCharacter;
    }
}
