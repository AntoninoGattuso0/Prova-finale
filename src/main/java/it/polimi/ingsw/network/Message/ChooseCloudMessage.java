package it.polimi.ingsw.network.Message;

public class ChooseCloudMessage extends ClientToServer {
    private final int cloud;

    public ChooseCloudMessage(int cloud) {
        this.cloud = cloud;
    }

    public int getCloud() {
        return cloud;
    }
}
