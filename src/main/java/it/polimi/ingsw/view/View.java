package it.polimi.ingsw.view;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.network.Message.ServerToClient.StartTurnMessage;

public interface View {
    void startGame();
    void requestNickname();
    void requestNumPlayers();
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

    //ogni volta che si cambia qualcosa di queste dobbiamo aggiornarle e poi richiamare display
    void updateAssistantCard();
    void updateCloud();
    void updateIsland();
    void updateEntrance();
    void updateDiningRoom();
    void updateProfTable();
    void updateTowerSpace();
    void updateCharacterCard();

    void updateNickname();

    void updateNumPlayers();

    void updateAll(LightGame object);

    void selectCloud();

    void selectAssistantCard();

    void requestMoveMotherNature();

    void registerClient();
    void waitOtherPlayers();

    void setSocketNetworkHandler(SocketNetworkHandler socketNetworkHandler);
}

//CLI E GUI dovranno implementare quest interfaccia