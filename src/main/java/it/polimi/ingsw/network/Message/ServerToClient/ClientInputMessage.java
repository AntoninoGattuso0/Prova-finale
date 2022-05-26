package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

public class ClientInputMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID= -4560553615619388577L;
    private final String error;
    public ClientInputMessage(String error){
        this.error=error;
    }
    public String getErrorMessage(){
        return error;
    }
}
