package it.polimi.ingsw.network.Message;

public class Ping extends Message {
    private static final long serialVersionUID = -474661319892953280L;
    private final String message="";
    public String getMessage(){
        return message;
    }

}
