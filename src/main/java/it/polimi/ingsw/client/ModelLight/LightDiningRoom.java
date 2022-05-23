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

    public LightDiningRoom(){
        numGreen = 0;
        numRed = 0;
        numYellow = 0;
        numPink = 0;
        numBlue = 0;
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
