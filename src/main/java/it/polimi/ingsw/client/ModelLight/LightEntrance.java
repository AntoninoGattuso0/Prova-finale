package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.model.Entrance;
import it.polimi.ingsw.network.Message.UpdateMessage.EntranceUpdateMessage;

public class LightEntrance {

    private int greenPawn;
    private int bluePawn;
    private int pinkPawn;
    private int yellowPawn;
    private int redPawn;

    public LightEntrance(Entrance entrance){
        this.greenPawn = entrance.getGreenPawn();
        this.redPawn = entrance.getRedPawn();
        this.yellowPawn = entrance.getYellowPawn();
        this.pinkPawn = entrance.getPinkPawn();
        this.bluePawn = entrance.getBluePawn();
    }

    public int getGreenPawn() {
        return greenPawn;
    }

    public int getRedPawn() {
        return redPawn;
    }

    public int getYellowPawn() {
        return yellowPawn;
    }

    public int getPinkPawn() {
        return pinkPawn;
    }

    public int getBluePawn() {
        return bluePawn;
    }

    public void update(EntranceUpdateMessage message){
        this.greenPawn = message.getEntrance().getGreenPawn();
        this.redPawn = message.getEntrance().getRedPawn();
        this.yellowPawn = message.getEntrance().getYellowPawn();
        this.pinkPawn = message.getEntrance().getPinkPawn();
        this.bluePawn = message.getEntrance().getBluePawn();
    }
}