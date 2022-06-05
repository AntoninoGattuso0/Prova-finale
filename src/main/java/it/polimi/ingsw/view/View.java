package it.polimi.ingsw.view;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.ModelLight.LightPlayer;
import it.polimi.ingsw.client.SocketNetworkHandler;

import java.util.ArrayList;

public interface View {
    void startGame();

    void requestNickname();

    void requestNumPlayersIsExpert();

    void requestMovePawnToDiningRoom();
    void requestMovePawnToIsland();
    void requestMovePawn();

    void requestCharacterCard();

    void displayNick();

    void displayNumPlayers();

    void displayIsExpert();

    void displayAssistantCard(int player);

    void displayCloud();

    void displayIslands();

    void displaySchoolBoard();

    void sendNick(String nickname);

    void displayCharacterCard();

    void displayWinner(String nickname);

    void displayNetError();

    void displayWrongNickname();

    void displayWrongTurn();

    void displayTurn();

    void displayResponseMessage();

    void updateAll(LightGame object);

    void selectCloud();

    void selectAssistantCard(String nickname);

    void requestMoveMotherNature();

    void registerClient();

    void waitOtherPlayers();

    void setSocketNetworkHandler(SocketNetworkHandler socketNetworkHandler);

    void playerWait();

    void newGameStart();

    void lobbyFull();

    void turnOrder(ArrayList<LightPlayer> players);
}
//CLI E GUI dovranno implementare quest interfaccia