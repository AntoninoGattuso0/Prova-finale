package it.polimi.ingsw.network.Message.UpdateMessage;

import it.polimi.ingsw.client.ModelLight.LightCloud;
import it.polimi.ingsw.network.Message.ServerToClient.ServerToClient;

import java.util.ArrayList;

public class CloudUpdateMessage extends ServerToClient {
    private static final long serialVersionUID= 4977483397535396736L;
    private final ArrayList<LightCloud> clouds;
    public CloudUpdateMessage(ArrayList<LightCloud> clouds){
        this.clouds=clouds;
    }
    public ArrayList<LightCloud> getClouds() {
        return clouds;
    }
}
