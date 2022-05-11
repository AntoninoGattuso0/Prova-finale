package it.polimi.ingsw.network;

public class LoginAcceptedOtherPlayers extends ServerToClient{
    private final String nickname;
    private final boolean join;

    public LoginAcceptedOtherPlayers(String nickname, boolean join) {
        this.nickname = nickname;
        this.join = join;
    }
}
