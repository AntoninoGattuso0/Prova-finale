package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;
public class SetMovePawnMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID= -4109068540423704447L;
    private int numPawnMoved;

    public SetMovePawnMessage(int numPawnMoved) {
        this.numPawnMoved = numPawnMoved;
    }
    public int getNumPawnMoved() {
        return numPawnMoved;
    }
}
