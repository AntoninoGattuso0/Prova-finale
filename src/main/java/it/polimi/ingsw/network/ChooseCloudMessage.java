package it.polimi.ingsw.network;

import it.polimi.ingsw.model.Cloud;

public class ChooseCloudMessage extends ClientToServer{
    private final Cloud cloud;

    public ChooseCloudMessage(Cloud cloud) {
        this.cloud = cloud;
    }

    public Cloud getCloud() {
        return cloud;
    }
}
