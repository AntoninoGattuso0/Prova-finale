package it.polimi.ingsw.view;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.network.Message.ServerToClient.StartTurnMessage;

public interface View {
    void startGame();
    void requestNickname();
    void requestNumPlayers();

    void requestNumPlayersIsExpert();

    void requestIsExpert();

    void displayNick();
    void displayNumPlayers();
    void displayIsExpert();

    void displayAssistantCard();
    void displayCloud();
    void displayIslands();
    void displaySchoolBoard();
    void displayCharacterCard();

    void displayWinner();

    void displayWinner(String winner);

    void displayNetError();
    void displayWrongNickname();
    void displayWrongTurn();
    void displayFetchNameMessage();
    void displayTurn();
    void displayResponseMessage();


    void displayTurn(StartTurnMessage object);

    void displayResponseMessage(String errorMessage);

    void updateAll(LightGame object);

    void selectCloud();

    void selectAssistantCard();

    void requestMoveMotherNature();

    void registerClient();
    void waitOtherPlayers();

    void setSocketNetworkHandler(SocketNetworkHandler socketNetworkHandler);
}

//CLI E GUI dovranno implementare quest interfaccia