package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.network.Message.UpdateMessage.DiningRoomUpdateMessage;
import it.polimi.ingsw.model.DiningRoom;

public class LightDiningRoom {
    int[][] position;
    private int numGreen;
    private int numRed;
    private int numYellow;
    private int numPink;
    private int numBlue;

    public int getNumGreen() {
        return numGreen;
    }

    public int getNumRed() {
        return numRed;
    }

    public int getNumYellow() {
        return numYellow;
    }

    public int getNumPink() {
        return numPink;
    }

    public int getNumBlue() {
        return numBlue;
    }

    public LightDiningRoom(){
        this.numGreen = 0;
        this.numRed = 0;
        this.numYellow = 0;
        this.numPink = 0;
        this.numBlue = 0;
        position = new int[5][10];
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 10; j++)
        position[i][j] = 0;
    }

    public void update(DiningRoomUpdateMessage message){
        this.numGreen = message.getDiningRoom().getNumGreen();
        this.numRed = message.getDiningRoom().getNumRed();
        this.numYellow = message.getDiningRoom().getNumYellow();
        this.numPink = message.getDiningRoom().getNumPink();
        this.numBlue = message.getDiningRoom().getNumBlue();
    }
}
