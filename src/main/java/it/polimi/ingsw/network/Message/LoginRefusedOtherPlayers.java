package it.polimi.ingsw.network.Message;

public class LoginRefusedOtherPlayers extends ServerToClient {

    private final String LoginRefusedOtherPlayer;

    public LoginRefusedOtherPlayers(String LoginRefusedOtherPlayers){
        this.LoginRefusedOtherPlayer = LoginRefusedOtherPlayers;
    }

    public String getLoginRefusedFirstPlayer(){
        return LoginRefusedOtherPlayer;
    }
}
