package it.polimi.ingsw.network.Message;

import java.io.Serial;
import java.io.Serializable;

public class Ping extends Message implements Serializable {
    @Serial
    private static final long serialVersionUID = -474661319892953280L;
    private final String message="";
    public String getMessage(){
        return message;
    }

}
