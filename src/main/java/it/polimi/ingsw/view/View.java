package it.polimi.ingsw.view;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.SocketNetworkHandler;

import java.util.ArrayList;

public interface View {
    void startGame();

    void requestNickname();

    void requestNumPlayersIsExpert();

    void requestMovePawnToDiningRoom(int pawn);
    void requestMovePawnToIsland(int pawn);
    void requestMovePawn(String nickname,int numPawnMoved);
    void requestMotherNaturMove(String nickname);
    void requestCloud(String nickname);

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

    void displayWinner(String nickname);

    void displayNetError();

    void displayWrongNickname();

    void displayWrongTurn();

    void displayStartTurn();

    void displayEndRound();

    void displayResponseMessage();

    void updateAll(LightGame object);
    void displayAll();
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

    void displayDisconnection(String playerDisconnected);

    void displayOnePlayerBoard(String nickname);
}
//CLI E GUI dovranno implementare quest interfaccia