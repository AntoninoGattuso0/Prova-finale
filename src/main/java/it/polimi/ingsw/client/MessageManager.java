package it.polimi.ingsw.client;

import it.polimi.ingsw.network.Message.*;
import it.polimi.ingsw.view.*;
import java.util.ArrayList;

public class MessageManager {
    private final View view;
    public MessageManager(View view){
        this.view=view;
    }
    public void manageInputToclient(Object object){
        if(object instanceof Ping){
            return;
        }
        if(object instanceof ChooseCloudMessage){
            view.requestCloud();
        }else if(object instanceof WaitMessage){
            view.waitOtherPlayers(((WaitMessage) object).getMessage());
        }else if(object instanceof StartTurnMessage){
            view.dysplayTurn((StartTurnMessage) object);
        }else if(object instanceof SetNumPlayers){
            view.requestNumPlayers();
        }else if(object instanceof SetNickMessage){
            view.requestNickname();
        }else if(object instanceof SetIsExpert){
            view.requestIsExpert();
        }else if(object instanceof MovePawnToDining){
            view.requestPawnToDining();
        }else if(object instanceof MovePawnToIsland){
            view.requestPawnToIsland();
        }else if(object instanceof MoveMotherNatureMessage){
            view.requestMoveMotherNature();
       }else if(object instanceof ClientAcceptedMessage){
               view.registerClient((ClientAcceptedMessage) object );
        }else if(object instanceof WinnerMessage){
            view.displayWinner(((WinnerMessage) object).getMessage());
        }else if(object instanceof GameStarted){
            view.startGame();
        }else if(object instanceof WrongNickname){
            view.dysplayWrongNickname();

        }
        else{
            throw new IllegalArgumentException();
        }
    }
}