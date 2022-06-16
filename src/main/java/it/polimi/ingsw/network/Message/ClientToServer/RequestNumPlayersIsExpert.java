package it.polimi.ingsw.network.Message.ClientToServer;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the client to server when the first player select number of players and mode
 */
public class RequestNumPlayersIsExpert extends ClientToServer implements Serializable {
    @Serial
    private static final long serialVersionUID = -3349291186535169304L;

    private final int numPlayers;
    private final boolean isExpert;

    public RequestNumPlayersIsExpert(int numPlayers,boolean isExpert){
        this.numPlayers = numPlayers;
        this.isExpert=isExpert;
    }
    public boolean getIsExpert() {
        return isExpert;
    }
    public int getNumPlayers(){
        return numPlayers;
    }
}
