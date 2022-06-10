package it.polimi.ingsw.network;

import it.polimi.ingsw.network.Message.ClientToServer.*;
import it.polimi.ingsw.network.Message.Ping;


public class ServerMessageMenager {
    private final Lobby lobby;

    public ServerMessageMenager(Lobby lobby) {
     this.lobby=lobby;
    }

    public void ManageInputToServer(ClientHandler clientHandler, Object object) {
         if (object instanceof ChooseCharacterCardMessage c) {
             lobby.useCharacter(c.getNumCharacter(),c.getNumPawn(),c.getNumIsland(),c.getColorPawns(),clientHandler,c.getCheck());
        }else if(object instanceof ChooseCloudMessage cloud) {
             lobby.selectCloud(cloud.getCloud(),clientHandler);
        } else if (object instanceof MoveMotherNatureMessage move) {
             lobby.moveMotherNature(move.getIsland(),clientHandler);
        } else if (object instanceof MovePawnToDiningMessage m) {
             lobby.movePawnToDining(m.getNumPawn(),m.getArrayPawn(),clientHandler);
        } else if (object instanceof MovePawnToIslandMessage m) {
             lobby.movePawnToIsland(m.getIsland(),m.getNumPawn(),m.getArrayPawn(),clientHandler);
        } else if (object instanceof RequestNickname) {
            lobby.insertNickname(((RequestNickname) object).getNickname(),clientHandler);
        } else if (object instanceof RequestNumPlayersIsExpert) {
            lobby.insertNumPlayersIsExpert(((RequestNumPlayersIsExpert) object).getNumPlayers(), ((RequestNumPlayersIsExpert) object).getIsExpert(), clientHandler);
        }else if(object instanceof ChooseAssistantCardMessage m) {
             lobby.selectAssistantCard(m.getAssistant(), clientHandler);
         }else if(object instanceof RequestNicknameAfterFirstLoginMessage){
             lobby.insertNickname(((RequestNicknameAfterFirstLoginMessage) object).getNickname(),clientHandler);
         }else if(object instanceof Ping){
         }else if(object instanceof iHaveToDisconnectMessage){
             //
         }
        else throw new IllegalArgumentException();
    }
}
