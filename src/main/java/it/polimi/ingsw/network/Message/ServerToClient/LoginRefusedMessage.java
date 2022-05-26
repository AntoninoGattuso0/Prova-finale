package it.polimi.ingsw.network.Message.ServerToClient;

public class LoginRefusedMessage extends ServerToClient {
    private static final long serialVersionUID = -5604170525970363492L;
    private final String LoginRefused;
    public LoginRefusedMessage(){this.LoginRefused = "Error Login!";}
    public String getLoginRefused(){
        return LoginRefused;
    }
}