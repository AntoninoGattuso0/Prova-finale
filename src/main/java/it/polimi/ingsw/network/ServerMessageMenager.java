package it.polimi.ingsw.network;

import it.polimi.ingsw.network.Message.ClientToServer.*;
import it.polimi.ingsw.network.Message.Ping;


public class ServerMessageMenager {
    private final Lobby lobby;

    public ServerMessageMenager(Lobby lobby) {
     this.lobby=lobby;
    }

    public void ManageInputToServer(ClientHandler clientHandler, Object object) {
        if (object instanceof Ping) {
            return;
        }
        if (object instanceof ChooseCloudMessage) {
        } else if (object instanceof ChooseCharacterCardMessage) {
            ChooseCharacterCardMessage c = (ChooseCharacterCardMessage) object;
            lobby.useCharacter(c.getNumCharacter(),c.getNumPawn(),c.getNumIsland(),c.getColorPawns(),clientHandler);
        }else if(object instanceof ChooseCloudMessage) {
            ChooseCloudMessage cloud = (ChooseCloudMessage) object;
            lobby.selectCloud(cloud.getCloud(),clientHandler);
        } else if (object instanceof MoveMotherNatureMessage) {
            MoveMotherNatureMessage move = (MoveMotherNatureMessage) object;
            lobby.moveMotherNature(move.getIsland(),clientHandler);
        } else if (object instanceof MovePawnToDiningMessage) {
            MovePawnToDiningMessage m= (MovePawnToDiningMessage) object;
            lobby.movePawnToDining(m.getNumPawn(),m.getArrayPawn(),clientHandler);
        } else if (object instanceof MovePawnToIslandMessage) {
            MovePawnToIslandMessage m=(MovePawnToIslandMessage) object;
            lobby.movePawnToIsland(m.getIsland(),m.getNumPawn(),m.getArrayPawn(),clientHandler);
        } else if (object instanceof RequestNickname) {
            lobby.insertNickname(((RequestNickname) object).getNickname(),clientHandler);
        } else if (object instanceof RequestNumPlayersIsExpert) {
            lobby.insertNumPlayersIsExpert(((RequestNumPlayersIsExpert) object).getNumPlayers(), ((RequestNumPlayersIsExpert) object).getIsExpert(), clientHandler);
        }else if(object instanceof ChooseAssistantCardMessage){
            ChooseAssistantCardMessage m=(ChooseAssistantCardMessage) object;
            lobby.selectAssistantCard(m.getAssistant(),clientHandler);
        }
        else throw new IllegalArgumentException();
    }
}
