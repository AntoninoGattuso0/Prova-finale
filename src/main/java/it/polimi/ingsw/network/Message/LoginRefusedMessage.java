package it.polimi.ingsw.network.Message;

public class LoginRefusedMessage extends ServerToClient {
    private final String LoginRefused;
    public LoginRefusedMessage(){this.LoginRefused = "Error Login";}
    public String getLoginRefused(){
        return LoginRefused;
    }
}