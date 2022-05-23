package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.model.Cloud;
import it.polimi.ingsw.network.Message.UpdateMessage.CloudUpdateMessage;

public class LightCloud {
    private int numPawn;
    private int greenPawn;
    private int redPawn;
    private int yellowPawn;
    private int pinkPawn;
    private int bluePawn;

    public LightCloud(Cloud cloud){
        this.greenPawn = cloud.getGreenPawn();
        this.redPawn = cloud.getRedPawn();
        this.yellowPawn = cloud.getYellowPawn();
        this.pinkPawn = cloud.getPinkPawn();
        this.bluePawn = cloud.getBluePawn();
        this.numPawn = cloud.getNumPawn();
    }

    public void update(CloudUpdateMessage message){
        this.greenPawn = message.getClouds().get(i).getGreenPawn();
        this.redPawn = message.getClouds().get(igetRedPawn();
        this.yellowPawn = message.getYellowPawn();
        this.pinkPawn = message.getPinkPawn();
        this.bluePawn = message.getBluePawn();
    }
}
