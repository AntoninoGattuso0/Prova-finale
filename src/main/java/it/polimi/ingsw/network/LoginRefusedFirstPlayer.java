package it.polimi.ingsw.network;

public class LoginRefusedFirstPlayer extends Message{

    private final String LoginRefusedFirstPlayer;

    public LoginRefusedFirstPlayer(String LoginRefusedFirstPlayer){
        this.LoginRefusedFirstPlayer = LoginRefusedFirstPlayer;
    }

    public String getLoginRefusedFirstPlayer(){
        return LoginRefusedFirstPlayer;
    }


}
