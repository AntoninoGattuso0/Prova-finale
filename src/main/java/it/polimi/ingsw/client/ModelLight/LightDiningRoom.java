package it.polimi.ingsw.client.ModelLight;

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
    }

    public void update(DiningRoomUpdateMessage message){

    }
}
