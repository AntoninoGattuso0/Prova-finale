package it.polimi.ingsw.client;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.network.Message.ServerToClient.*;
import it.polimi.ingsw.network.Message.UpdateMessage.*;
import it.polimi.ingsw.view.View;

public class ClientMessageManager {
    private final View view;
    public ClientMessageManager(View view){
        this.view=view;
    }
    public void manageInputToClient(Object object){   // ho aggiunto game per poterlo passare come parametro ad alcune funzioni
        if(object instanceof Ping){                             //LEGGI LA MIA RISPOSTA SOTTO
            return;
        }
        if(object instanceof WaitMessage){
            view.waitOtherPlayers();
        }else if(object instanceof StartTurnMessage){
            view.displayTurn();
        }else if(object instanceof SetNumPlayersIsExpertMessage){
            view.requestNumPlayers();
        }else if(object instanceof SetNickMessage){
            view.requestNickname();
        }else if(object instanceof SetIsExpertMessage){
            view.requestIsExpert();
       }else if(object instanceof ClientAcceptedMessage){
               view.registerClient((ClientAcceptedMessage) object );
        }else if(object instanceof WinnerMessage){
            view.displayWinner();
        }else if(object instanceof GameStartedMessage){
            view.startGame();
        }else if(object instanceof WrongNicknameMessage){
            view.displayWrongNickname();
        }else if(object instanceof WrongTurnMessage){
            view.displayWrongTurn();
        }else if(object instanceof ClientInputMessage){
            view.displayResponseMessage();
        }else if(object instanceof AllUpdateMessage){
            AllUpdateMessage game=(AllUpdateMessage) object;
            view.updateAll(game.getLightGame());

        }else if(object instanceof CharacterCardUpdateMessage) {
            view.updateCharacterCard();
        }
         else   throw new IllegalArgumentException();
        }
    }