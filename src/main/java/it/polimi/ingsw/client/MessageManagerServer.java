package it.polimi.ingsw.client;

import it.polimi.ingsw.network.Message.*;
import it.polimi.ingsw.network.Message.ClientToServer.MoveMotherNatureMessage;
import it.polimi.ingsw.network.Message.ClientToServer.MovePawnToDiningMessage;
import it.polimi.ingsw.network.Message.ClientToServer.*;
import it.polimi.ingsw.network.Message.ServerToClient.*;
import it.polimi.ingsw.network.Message.UpdateMessage.*;
import it.polimi.ingsw.view.View;

public class MessageManagerServer {
    private final View view;
    public MessageManagerServer(View view){
        this.view=view;
    }
    public void manageInputToClient(Object object){   // ho aggiunto game per poterlo passare come parametro ad alcune funzioni
        if(object instanceof Ping){                             //LEGGI LA MIA RISPOSTA SOTTO
            return;
        }
        if(object instanceof ChooseCloudMessage){// QUESTO MANAGER GESTISCE MESSAGGI, QUELLO CHE ARRVIA IN INGRESSO è UN TIPO DI MESSAGGIO. QUINDI CAPISCI CHE UN CLIENT NON PUò INVIARE UN "GAME"
            ChooseCloudMessage cloud= (ChooseCloudMessage) object;
            view.selectCloud(cloud.getCloud()); //QUESTO TI RESTITUISCE UN INTERO SU CUI DEVE LAVORARE LA FUNZIONE UPDATE
        }else if(object instanceof WaitMessage){
            view.waitOtherPlayers(((WaitMessage) object).getMessage());
        }else if(object instanceof StartTurnMessage){
            view.displayTurn((StartTurnMessage) object);
        }else if(object instanceof SetNumPlayersMessage){
            view.requestNumPlayers();
        }else if(object instanceof SetNickMessage){
            view.requestNickname();
        }else if(object instanceof SetIsExpertMessage){
            view.requestIsExpert();
        }else if(object instanceof MovePawnToDiningMessage){
            MovePawnToDiningMessage message=(MovePawnToDiningMessage) object;
            view.updatePawnToDining(message.getNumPawn(),message.getArrayPawn());
        }else if(object instanceof MovePawnToIslandMessage){
            MovePawnToIslandMessage message = (MovePawnToIslandMessage) object;
            view.updatePawnToIsland(message.getIsland(),message.getNumPawn(),message.getArrayPawn());
        }else if(object instanceof MoveMotherNatureMessage){
            MoveMotherNatureMessage step= (MoveMotherNatureMessage) object;
            view.updateMoveMotherNature(step.getIsland());
       }else if(object instanceof ClientAcceptedMessage){
               view.registerClient((ClientAcceptedMessage) object );
        }else if(object instanceof WinnerMessage){
            view.displayWinner(((WinnerMessage) object).getMessage());
        }else if(object instanceof GameStartedMessage){
            view.startGame();
        }else if(object instanceof WrongNicknameMessage){
            view.displayWrongNickname();
        }else if(object instanceof WrongTurnMessage){
            view.displayWrongTurn();
        }else if(object instanceof NicknameUpdateMessage){
            view.updateNickname((NicknameUpdateMessage) object);
        }else if(object instanceof ClientInputMessage){
            view.displayResponseMessage(((ClientInputMessage) object).getErrorMessage());
        }else if(object instanceof ChooseAssistantCardMessage){
            ChooseAssistantCardMessage assistant= (ChooseAssistantCardMessage) object;
            view.selectAssistantCard(assistant.getAssistant());
        }else if(object instanceof IslandUpdateMessage){
            view.updateIsland((IslandUpdateMessage) object);
        }else if(object instanceof CloudUpdateMessage){
            view.updateCloud((CloudUpdateMessage) object);
        }else if(object instanceof AssistantCardUpdateMessage){
            view.updateAssistantCard((AssistantCardUpdateMessage) object);
        }else if(object instanceof DiningRoomUpdateMessage){
            view.updateDiningRoom((DiningRoomUpdateMessage) object);
        }else if(object instanceof EntranceUpdateMessage){
            view.updateEntrance((EntranceUpdateMessage) object);
        }else if(object instanceof TowerSpaceUpdateMessage){
            view.updateTowerSpace((TowerSpaceUpdateMessage) object);
        }else if(object instanceof AllUpdateMessage){
            view.updateAll((AllUpdateMessage) object);
        }else if(object instanceof ProfTableUpdateMessage){
            view.updateProfTable((ProfTableUpdateMessage) object);
        }else if(object instanceof CharacterCardUpdateMessage){
            view.updateCharacterCard((CharacterCardUpdateMessage) object);
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}