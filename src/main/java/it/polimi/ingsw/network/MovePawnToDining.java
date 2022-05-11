package it.polimi.ingsw.network;


public class MovePawnToDining extends ClientToServer{
    public final int diningRoom;

    public MovePawnToDining(int diningRoom) {
        this.diningRoom = diningRoom;
    }
    public int getDiningRoom() {
        return diningRoom;
    }
}
