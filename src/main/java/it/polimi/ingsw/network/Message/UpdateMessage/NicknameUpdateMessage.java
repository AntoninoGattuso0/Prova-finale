package it.polimi.ingsw.network.Message.UpdateMessage;

import it.polimi.ingsw.network.Message.ServerToClient.ServerToClient;

import java.util.ArrayList;

public class NicknameUpdateMessage extends ServerToClient {
    private static final long serialVersionUID= -4729216641846140159L;
    private final ArrayList<String> nicknames;
    public NicknameUpdateMessage(ArrayList<String> nicknames){
        this.nicknames=nicknames;
    }

    public ArrayList<String> getNicknames() {
        return nicknames;
    }
}
