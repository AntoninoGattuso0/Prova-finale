package it.polimi.ingsw.network.Message.ServerToClient;


public class LoginAcceptedMessage extends ServerToClient {
    private static final long serialVersionUID= 4527051988827220120L;
    private final String nickname;

    public String getNickname() {
        return nickname;
    }

    public LoginAcceptedMessage(String nickname) {
        this.nickname = nickname;
    }
}
