package it.polimi.ingsw.client;

import it.polimi.ingsw.network.Message.*;
import it.polimi.ingsw.view.View;
import it.polimi.ingsw.model.*;

public class MessageManager {
    private final View view;
    public MessageManager(View view){
        this.view=view;
    }
    public void manageInputToClient(Object object, Game game){   // ho aggiunto game per poterlo passare come parametro ad alcune funzioni
        if(object instanceof Ping){
            return;
        }
        if(object instanceof ChooseCloudMessage){   // per esempio qui, prova a vedere se va bene - R
            view.requestCloud(game);
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
            view.updatePawnToDining(message.getNumDiningRoom(),message.getArrayPawn());
        }else if(object instanceof MovePawnToIslandMessage){
            MovePawnToIslandMessage message = (MovePawnToIslandMessage) object;
            view.updatePawnToIsland(message.getIsland(),message.getArrayPawn());
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
        }else if(object instanceof ClientInputResponse){
            view.displayResponseMessage(((ClientInputMessage) object).getErrorMessage());
        }else if(object instanceof FetchNameMessage){
            view.displayFetchNameMessage();
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}