package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.model.Cloud;
import it.polimi.ingsw.network.Message.UpdateMessage.CloudUpdateMessage;

import java.util.ArrayList;

public class LightCloud {

    private ArrayList<Cloud> clouds;

    public LightCloud(Cloud cloud){
        this.greenPawn = cloud.getGreenPawn();
        this.redPawn = cloud.getRedPawn();
        this.yellowPawn = cloud.getYellowPawn();
        this.pinkPawn = cloud.getPinkPawn();
        this.bluePawn = cloud.getBluePawn();
        this.numPawn = cloud.getNumPawn();
    }


    public void update(CloudUpdateMessage message){
        this.clouds = message.getClouds();
    }
}
