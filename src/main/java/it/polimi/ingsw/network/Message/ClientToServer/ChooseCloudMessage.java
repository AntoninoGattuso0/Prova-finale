package it.polimi.ingsw.network.Message.ClientToServer;

import java.io.Serial;

public class ChooseCloudMessage extends ClientToServer {
    @Serial
    private static final long serialVersionUID = 5696698093812135553L;
    private final int cloud;

    public ChooseCloudMessage(int cloud) {
        this.cloud = cloud;
    }

    public int getCloud() {
        return cloud;
    }
}
