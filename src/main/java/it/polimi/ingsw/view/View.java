package it.polimi.ingsw.view;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.SocketNetworkHandler;

import java.io.IOException;
import java.util.ArrayList;

public interface View {
    void startGame();

    void requestNickname();

    void requestNumPlayersIsExpert();

    void requestMovePawn(String nickname,int numPawnMoved);

    void requestCharacterCard(String nickname,boolean bool);

    void displayNick();

    void displayNumPlayers();

    void displayIsExpert();

    void displayAssistantCard(int player);

    void displayCloud();

    void displayIslands();

    void displaySchoolBoard();

    void sendNick(String nickname);

    void displayCharacterCard();

    void displayWinner(String nickname) throws IOException;

    void displayNetError();

    void displayWrongNickname();

    void displayWrongTurn();

    void updateAll(LightGame object);
    void displayAll();

    void displayStartRound();

    void selectCloud(String nickname);

    void selectAssistantCard(String nickname);

    void requestMoveMotherNature(String nickname);

    void registerClient();

    void waitOtherPlayers();

    void setSocketNetworkHandler(SocketNetworkHandler socketNetworkHandler);

    void playerWait();

    void newGameStart();

    void lobbyFull();

    void turnOrder(ArrayList<String> orderNamePLayers);

    void startTurn(ArrayList<String> players, String actualPlayer);

    void displayOnePlayerBoard(String nickname);

    void disconnectionAll(String playerDisconnected) throws IOException;

    void wrongSameAssistantMessage();
}
//CLI E GUI dovranno implementare quest interfaccia