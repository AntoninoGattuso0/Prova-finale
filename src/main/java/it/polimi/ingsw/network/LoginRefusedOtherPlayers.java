package it.polimi.ingsw.network;

public class LoginRefusedOtherPlayers extends Message{

    private final String LoginRefusedOtherPlayer;

    public LoginRefusedOtherPlayers(String LoginRefusedOtherPlayers){
        this.LoginRefusedOtherPlayer = LoginRefusedOtherPlayers;
    }

    public String getLoginRefusedFirstPlayer(){
        return LoginRefusedOtherPlayer;
    }
}
