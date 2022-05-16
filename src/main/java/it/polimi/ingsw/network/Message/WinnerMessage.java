package it.polimi.ingsw.network.Message;

public class WinnerMessage extends ServerToClient{
    private final String message;
    public WinnerMessage(String nick){
        this.message= "The Winner is "+ nick;
    }
}
