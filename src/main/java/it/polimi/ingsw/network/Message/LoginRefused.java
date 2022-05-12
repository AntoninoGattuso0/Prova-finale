package it.polimi.ingsw.network.Message;

public class LoginRefused extends ServerToClient {

    private final String LoginRefused;

    public LoginRefused(String LoginRefused){
        this.LoginRefused = LoginRefused;
    }

    public String getLoginRefused(){
        return LoginRefused;
    }


}
