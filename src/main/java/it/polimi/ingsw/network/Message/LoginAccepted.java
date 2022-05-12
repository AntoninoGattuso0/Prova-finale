package it.polimi.ingsw.network.Message;

public class LoginAccepted extends ServerToClient {
    private final String nickname;

    public String getNickname() {
        return nickname;
    }

    public LoginAccepted(String nickname) {
        this.nickname = nickname;
    }
}
