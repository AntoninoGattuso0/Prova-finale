package it.polimi.ingsw.network.Message;

public class LoginRefused extends ServerToClient {
    private final String LoginRefused;
    public LoginRefused(){this.LoginRefused = "Error Login";}
    public String getLoginRefused(){
        return LoginRefused;
    }
}