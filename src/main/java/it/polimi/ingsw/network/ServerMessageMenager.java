package it.polimi.ingsw.network;

import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.network.Message.ClientToServer.*;
import it.polimi.ingsw.network.Message.Ping;


public class ServerMessageMenager {
    private final SocketNetworkHandler socketNetworkHandler;

    public ServerMessageMenager(SocketNetworkHandler socketNetworkHandler) {
        this.socketNetworkHandler = socketNetworkHandler;
    }

    public void ManageInputToServer(Lobby lobby, ClientHandler clientHandler, Object object) {
        if (object instanceof Ping) {
            return;
        }
        if (object instanceof ChooseCloudMessage) {
        } else if (object instanceof ChooseCharacterCardMessage) {
            ChooseCharacterCardMessage chooseCharacterCardMessage = (ChooseCharacterCardMessage) object;
            lobby.useCharacter(chooseCharacterCardMessage.getNumCharacter());
        }
        if (object instanceof ChooseCloudMessage) {
            ChooseCloudMessage cloud = (ChooseCloudMessage) object;
            lobby.selectCloud(cloud.getCloud());
        } else if (object instanceof MoveMotherNatureMessage) {
            MoveMotherNatureMessage move = (MoveMotherNatureMessage) object;
            lobby.moveMotherNature(move.getIsland());

        } else if (object instanceof MovePawnToDiningMessage) {

        } else if (object instanceof MovePawnToIslandMessage) {

        } else if (object instanceof RequestIsExpert) {
            lobby.setupIsExpert(((RequestIsExpert) object).getIsExpert());

        } else if (object instanceof RequestNickname) {
            lobby.insertNickname(((RequestNickname) object).getNickname());
        } else if (object instanceof RequestNumPlayers)
            lobby.insertNumPlayers(((RequestNumPlayers) object).getNumPlayers());
        else throw new IllegalArgumentException();
    }
}
