package it.polimi.ingsw.network;

public class ChooseCloudMessage extends ClientToServer{
    private final int cloud;

    public ChooseCloudMessage(int cloud) {
        this.cloud = cloud;
    }

    public int getCloud() {
        return cloud;
    }
}
