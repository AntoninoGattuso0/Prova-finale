package it.polimi.ingsw.network.Message;


public class MovePawnToDiningMessage extends ClientToServer {
    public final int diningRoom;

    public MovePawnToDiningMessage(int diningRoom) {
        this.diningRoom = diningRoom;
    }
    public int getDiningRoom() {
        return diningRoom;
    }
}
