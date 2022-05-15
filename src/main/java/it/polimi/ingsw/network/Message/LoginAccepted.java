package it.polimi.ingsw.network.Message;


public class LoginAccepted extends ServerToClient {
    private static final long serialVersionUID= 4527051988827220120L;
    private final String nickname;

    public String getNickname() {
        return nickname;
    }

    public LoginAccepted(String nickname) {
        this.nickname = nickname;
    }
}
