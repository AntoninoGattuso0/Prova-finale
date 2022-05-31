package it.polimi.ingsw.view;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.SocketNetworkHandler;

public interface View {
    void startGame();
    void requestNickname();

    void requestNumPlayersIsExpert();


    void displayNick();
    void displayNumPlayers();
    void displayIsExpert();

    void displayAssistantCard(int player);
    void displayCloud();
    void displayIslands();
    void displaySchoolBoard();
    void displayCharacterCard();

    void displayWinner(String nickname);

    void displayNetError();
    void displayWrongNickname();
    void displayWrongTurn();
    void displayTurn();
    void displayResponseMessage();
    void updateAll(LightGame object);
    void selectCloud();
    void selectAssistantCard();

    void requestMoveMotherNature();

    void registerClient();
    void waitOtherPlayers();

    void setSocketNetworkHandler(SocketNetworkHandler socketNetworkHandler);

    void playerWait();
}

//CLI E GUI dovranno implementare quest interfaccia