package it.polimi.ingsw.network.Message;

public class LoginRefusedFirstPlayer extends ServerToClient {

    private final String LoginRefusedFirstPlayer;

    public LoginRefusedFirstPlayer(String LoginRefusedFirstPlayer){
        this.LoginRefusedFirstPlayer = LoginRefusedFirstPlayer;
    }

    public String getLoginRefusedFirstPlayer(){
        return LoginRefusedFirstPlayer;
    }


}
