package it.polimi.ingsw.view.GUI;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.network.Message.ClientToServer.*;
import it.polimi.ingsw.view.GUI.warnings.*;
import it.polimi.ingsw.view.View;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.Objects;



public class Gui implements View {

    private boolean isExpert;
    private LightGame lightGame;
    private SocketNetworkHandler socketNetworkHandler;
    private GameTable gameTable = new GameTable();

    public void setSocketNetworkHandler(SocketNetworkHandler socketNetworkHandler) {
        this.socketNetworkHandler = socketNetworkHandler;
    }

    public LightGame getLightGame() {
        return lightGame;
    }

    public SocketNetworkHandler getSocketNetworkHandler() {
        return socketNetworkHandler;
    }

    @Override
    public void startGame() {

    }

    //per le altre funzioni che sono scritte sono uguali a questa
    @Override
    public void requestNickname() {
        RequestNickPlayers requestNickPlayers = new RequestNickPlayers();
        Platform.runLater(()->TransitionScene.setRequestNickPlayers(requestNickPlayers)); //setta come scena quella tra parentesi
        Platform.runLater(TransitionScene::switchRequestNickPlayers); //switcha su questa scena in cui richiede il nick
        socketNetworkHandler.sendMessage(new RequestNickname(requestNickPlayers.getNick()));  //queste due righe sono come quelle della cli
        socketNetworkHandler.setNicknameThisPlayer(requestNickPlayers.getNick());

    }

    @Override
    public void requestNumPlayersIsExpert() {
        NumOfPlayerIsExpert numPlayersIsExpert = new NumOfPlayerIsExpert();
        Platform.runLater(()->TransitionScene.setNumOfPlayersIsExpert(numPlayersIsExpert));
        Platform.runLater(TransitionScene::switchToNumOfPlayerIsExpert);
        socketNetworkHandler.sendMessage(new RequestNumPlayersIsExpert(numPlayersIsExpert.getNumPlayer(), numPlayersIsExpert.isExpert()));
        socketNetworkHandler.setNicknameThisPlayer(numPlayersIsExpert.getNickname());
    }

    @Override
    public void requestMovePawn(String nickname, int numPawnMoved) {

    }

    @Override
    public void requestCharacterCard(String nickname, boolean bool) {

    }

    @Override
    public void displayNick() {

    }

    @Override
    public void displayNumPlayers() {

    }

    @Override
    public void displayIsExpert() {

    }

    @Override
    public void displayAssistantCard(int player) {

    }

    @Override
    public void displayCloud() {

    }

    @Override
    public void displayIslands() {

    }

    @Override
    public void displaySchoolBoard() {

    }

    @Override
    public void sendNick(String nickname) {

    }

    @Override
    public void displayCharacterCard() {

    }

    @Override
    public void displayWinner(String nickname) {
        WinnerScene winnerScene = new WinnerScene(nickname);
        Platform.runLater(()->TransitionScene.setWinnerScene(winnerScene));
        Platform.runLater(TransitionScene::switchToWinnerScene);
    }

    @Override
    public void displayNetError() {

    }

    @Override
    public void displayWrongNickname() {

    }

    @Override
    public void displayWrongTurn() {

    }

    @Override
    public void displayStartTurn() {

    }


    @Override
    public void updateAll(LightGame object) {

    }

    @Override
    public void displayAll() {

    }

    @Override
    public void displayStartRound() {

    }


    //è provvisorio non vi spaventate :)
    @Override
    public void selectCloud(String nickname) {
        if (Objects.equals(nickname, socketNetworkHandler.getNicknameThisPlayer())) {
                socketNetworkHandler.sendMessage(new ChooseCloudMessage(gameTable.getCloudSelected()));
        }else{
            new WarningCloud();
        }


    }

    @Override
    public void selectAssistantCard(String nickname) {

    }

    @Override
    public void requestMoveMotherNature(String nickname) {

    }

    @Override
    public void registerClient() {

    }

    @Override
    public void waitOtherPlayers() {
        WaitingPlayers waitingPlayers = new WaitingPlayers();
        Platform.runLater(()->TransitionScene.setWaitingPlayers(waitingPlayers));
        Platform.runLater(TransitionScene::switchToWaitingPlayers);

    }

    @Override
    public void playerWait() {

    }

    @Override
    public void newGameStart() {

    }

    @Override
    public void lobbyFull() {

    }

    @Override
    public void turnOrder(ArrayList<String> players) {

    }

    @Override
    public void startTurn(ArrayList<String> players, String actualPlayer) {

    }
    @Override
    public void displayOnePlayerBoard(String nickname) {

    }

    @Override
    public void disconnectionAll(String playerDisconnected) {

    }

    @Override
    public void wrongSameAssistantMessage() {

    }

}
