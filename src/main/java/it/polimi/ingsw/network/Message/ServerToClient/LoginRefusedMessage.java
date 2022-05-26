package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

public class LoginRefusedMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID = -5604170525970363492L;
    private final String LoginRefused;
    public LoginRefusedMessage(){this.LoginRefused = "Error Login!";}
    public String getLoginRefused(){
        return LoginRefused;
    }
}