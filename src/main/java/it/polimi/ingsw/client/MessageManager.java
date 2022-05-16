package it.polimi.ingsw.client;

import it.polimi.ingsw.network.Message.*;

public class MessageManager {
    private final View view;
    public MessageManager(View view){
        this.view=view;
    }
    public void manageInputToclient(Object object){
        if(object instanceof Ping){
            return;
        }
       if(object instanceof LoginAccepted){
            view.registerClient((LoginAccepted) object);
        }else if(object instanceof ChooseCloudMessage){
            view.
        }else if(object instanceof WaitMessage){
            view.
        }else if(object instanceof StartTurnMessage){
            view.
        }else if(object instanceof SetNumPlayers){
            view.
        }else if(object instanceof SetNickMessage){
            view.
        }else if(object instanceof SetIsExpert){
            view.
        }else if(object instanceof MovePawnToDining){
            view.
        }else if(object instanceof MovePawnToIsland){
            view.
        }else if(object instanceof MoveMotherNatureMessage){
            view.
        }else if(object instanceof RemoveClient){
            view.
       }else if(object instanceof ClientAcceptedMessage){
               view.
        }else{
            throw new IllegalArgumentException();
        }
    }
}