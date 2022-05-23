package it.polimi.ingsw.network.Message;

public class RemoveClientMessage {
    public static final long serialVersionUID= 6899493760211430812L;
    private final String message;
    public RemoveClientMessage(String message){
        this.message=message;
    }
    public String getMessage() {
        return message;
    }
}
