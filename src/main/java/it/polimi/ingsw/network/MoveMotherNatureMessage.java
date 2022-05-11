package it.polimi.ingsw.network;

public class MoveMotherNatureMessage extends ClientToServer{
    private final int num;

    public MoveMotherNatureMessage(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
