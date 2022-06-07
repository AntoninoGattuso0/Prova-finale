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

    public void manageInputToClient(Object object, SocketNetworkHandler socketNetworkHandler) throws InterruptedException {
        if (object instanceof WaitMessage) {
            socketNetworkHandler.getView().waitOtherPlayers();
        } else if (object instanceof StartTurnMessage) {
            socketNetworkHandler.getView().displayTurn();
        } else if (object instanceof SetNumPlayersIsExpertMessage) {
            socketNetworkHandler.getView().requestNumPlayersIsExpert();
        } else if (object instanceof SetNickMessage) {
            socketNetworkHandler.getView().requestNickname();
        } else if (object instanceof ClientAcceptedMessage) { //Serve per dire al player che è entrato in lobby
            socketNetworkHandler.getView().registerClient();
        } else if (object instanceof WinnerMessage message) {
            socketNetworkHandler.getView().displayWinner(message.getNickname());
        } else if (object instanceof GameStartedMessage) { //Serve a dire che il game è iniziato
            socketNetworkHandler.getView().newGameStart();
        } else if (object instanceof WrongNicknameMessage) {
            socketNetworkHandler.getView().displayWrongNickname();
        } else if (object instanceof WrongTurnMessage) {
            socketNetworkHandler.getView().displayWrongTurn();
        } else if (object instanceof ClientInputMessage) {
            socketNetworkHandler.getView().displayResponseMessage();
        } else if (object instanceof AllUpdateMessage m) {
            socketNetworkHandler.getView().updateAll(m.getLightGame());
        } else if (object instanceof LoginAcceptedMessage) {// serve a dire all' ultimo player che è entrato in lobby e che era l'ultimo player che mancava
            socketNetworkHandler.getView().playerWait();
        } else if (object instanceof SetAssistantMessage) {
            socketNetworkHandler.getView().selectAssistantCard(((SetAssistantMessage) object).getNickname());
        }else if(object instanceof SetMovePawnMessage) {
            socketNetworkHandler.getView().requestMovePawn(((SetMovePawnMessage) object).getNickname(),((SetMovePawnMessage) object).getNumPawnMoved());
        } else if (object instanceof SetMoveMotherNature) {
           socketNetworkHandler.getView().requestMoveMotherNature(((SetMoveMotherNature) object).getNickname());
        } else if (object instanceof SetCloudMessage) {
           socketNetworkHandler.getView().selectCloud(((SetCloudMessage) object).getNickname());
        } else if (object instanceof DisconnectionMessage) {
            // socketNetworkHandler.getView().
        } /*else if (object instanceof EndGameMessage) {
           //socketNetworkHandler.getView().
        }*/ else if (object instanceof EndTurnMessage) {
          // socketNetworkHandler.getView().
        } else if (object instanceof InvalidNumPlayerMessage) {
            // socketNetworkHandler.getView().
        } else if (object instanceof NewCurrentPlayerMessage) {
            // socketNetworkHandler.getView().
        }else if(object instanceof WrongNumPlayerIsExpertMessage){
             socketNetworkHandler.getView().displayWrongNickname();
        }/*else if(object instanceof WrongSameAssistantMessage){
           // socketNetworkHandler.getView().
        }*/else if(object instanceof WaitLoginMessage){
            socketNetworkHandler.getView().sendNick(((WaitLoginMessage) object).getNickname());
        }else if(object instanceof LobbyFullMessage){
            socketNetworkHandler.getView().lobbyFull();
        }else if(object instanceof Ping){
        }else if(object instanceof TurnOrderMessage){
            socketNetworkHandler.getView().turnOrder(((TurnOrderMessage) object).getPlayersOrder());
        }
        else throw new IllegalArgumentException();
    }
}