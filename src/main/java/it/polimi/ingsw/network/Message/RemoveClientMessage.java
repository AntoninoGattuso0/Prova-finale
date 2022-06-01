package it.polimi.ingsw.network.Message;

import java.io.Serializable;

public class RemoveClientMessage implements Serializable {
    public static final long serialVersionUID= 242273729670073895L;
    private final String message;
    public RemoveClientMessage(String message){
        this.message=message;
    }
    public String getMessage() {
        return message;
    }
}
