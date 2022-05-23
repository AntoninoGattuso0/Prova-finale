package it.polimi.ingsw.network.Message.UpdateMessage;

import it.polimi.ingsw.model.Cloud;
import it.polimi.ingsw.network.Message.ServerToClient;

import java.util.ArrayList;

public class CloudUpdateMessage extends ServerToClient {
    private static final long serialVersionUID= 4977483397535396736L;
    private ArrayList<Cloud> clouds;
    public CloudUpdateMessage(ArrayList<Cloud> clouds){
        this.clouds=clouds;
    }
    public ArrayList<Cloud> getClouds() {
        return clouds;
    }
}
