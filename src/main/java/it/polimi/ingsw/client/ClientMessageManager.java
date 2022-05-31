package it.polimi.ingsw.client;

import it.polimi.ingsw.network.Message.Ping;
import it.polimi.ingsw.network.Message.ServerToClient.*;
import it.polimi.ingsw.network.Message.UpdateMessage.AllUpdateMessage;
import it.polimi.ingsw.view.View;

public class ClientMessageManager {
    private final View view;

    public ClientMessageManager(View view) {
        this.view = view;
    }

    public void manageInputToClient(Object object) throws InterruptedException {
        if (object instanceof Ping) {
            return;
        }
        if (object instanceof WaitMessage) {
            view.waitOtherPlayers();
        } else if (object instanceof StartTurnMessage) {
            view.displayTurn();
        } else if (object instanceof SetNumPlayersIsExpertMessage) {
            view.requestNumPlayersIsExpert();
        } else if (object instanceof SetNickMessage) {
            view.requestNickname();
        } else if (object instanceof ClientAcceptedMessage) {
            view.registerClient();
        } else if (object instanceof WinnerMessage message) {
            view.displayWinner(message.getNickname());
        } else if (object instanceof GameStartedMessage) {
            view.startGame();
        } else if (object instanceof WrongNicknameMessage) {
            view.displayWrongNickname();
        } else if (object instanceof WrongTurnMessage) {
            view.displayWrongTurn();
        } else if (object instanceof ClientInputMessage) {
            view.displayResponseMessage();
        } else if (object instanceof AllUpdateMessage m) {
            view.updateAll(m.getLightGame());
        } else if (object instanceof LoginAcceptedMessage) {
            view.playerWait();
        } else if (object instanceof SetAssistantMessage) {
            view.selectAssistantCard();
        } else if (object instanceof SetMovePawnMessage) {
            view.
        } else if (object instanceof SetMoveMotherNature) {
            view.
        } else if (object instanceof SetCloudMessage) {
            view.
        } else if (object instanceof DisconnectionMessage) {
            view.
        } else if (object instanceof EndGameMessage) {
            view.
        } else if (object instanceof EndTurnMessage) {
            view.
        } else if (object instanceof InvalidNumPlayerMessage) {
            view.
        } else if (object instanceof NewCurrentPlayerMessage) {
            view.
        } else if (object instanceof TurnOrderMessage) {
            view.
        }else if(object instanceof WrongNumPlayerIsExpertMessage){
            view.
        }else if(object instanceof WrongSameAssistantMessage){
            view.
        }
        else throw new IllegalArgumentException();
    }
}