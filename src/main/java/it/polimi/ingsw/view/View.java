package it.polimi.ingsw.view;

import it.polimi.ingsw.client.ModelLight.LightGame;
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
    void displayNetError();
    void displayWrongNickname();
    void displayWrongTurn();
    void displayFetchNameMessage();
    void displayTurn();
    void displayResponseMessage();


    //ogni volta che si cambia qualcosa di queste dobbiamo aggiornarle e poi richiamare display
    void updateAssistantCard();
    void updateCloud();
    void updateIsland();
    void updateEntrance();
    void updateDiningRoom();
    void updateProfTable();
    void updateTowerSpace();
    void updateCharacterCard();

    void updateAll(LightGame object);
    void registerClient();
    void waitOtherPlayers();
}

//CLI E GUI dovranno implementare quest interfaccia