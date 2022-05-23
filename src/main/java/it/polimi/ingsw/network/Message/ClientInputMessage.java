package it.polimi.ingsw.network.Message;

public class ClientInputMessage extends ServerToClient{
    private final String error;
    public ClientInputMessage(String error){
        this.error=error;
    }
    public String getErrorMessage(){
        return error;
    }
}
