package it.polimi.ingsw.view.GUI;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.network.Message.ClientToServer.RequestNickname;
import it.polimi.ingsw.network.Message.ClientToServer.RequestNumPlayersIsExpert;
import it.polimi.ingsw.view.GUI.warnings.WarningNickname;
import it.polimi.ingsw.view.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutionException;


public class Gui implements View {

    private boolean isExpert;
    private LightGame lightGame;
    private SocketNetworkHandler socketNetworkHandler;

    public void setSocketNetworkHandler(SocketNetworkHandler socketNetworkHandler) {
        this.socketNetworkHandler = socketNetworkHandler;
    }


    @Override
    public void startGame() {

    }

    @Override
    public void requestNickname() {
        //try{
            RequestNickPlayers requestNickPlayers = new RequestNickPlayers();
            socketNetworkHandler.sendMessage(new RequestNickname(requestNickPlayers.getNick()));
            socketNetworkHandler.setNicknameThisPlayer(requestNickPlayers.getNick());
        /*}catch (ExecutionException e){
            new WarningNickname();
        }*/
    }

    @Override
    public void requestNumPlayersIsExpert() {
        NumOfPlayerIsExpert requestNumPlayersIsExpert = new NumOfPlayerIsExpert();
        socketNetworkHandler.sendMessage(new RequestNumPlayersIsExpert(requestNumPlayersIsExpert.getNumPlayer(), requestNumPlayersIsExpert.isExpert()));
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
    public void displayEndRound() {

    }

    @Override
    public void displayResponseMessage() {

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

    @Override
    public void selectCloud(String nickname) {

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
    public void displayDisconnection(String playerDisconnected) {

    }

    @Override
    public void displayOnePlayerBoard(String nickname) {

    }

    @Override
    public void disconnectionAll(String playerDisconnected) {

    }

    @Override
    public void endgame() {

    }

    @Override
    public void invalidNumPlayer() {

    }

    @Override
    public void wrongSameAssistantMessage() {

    }

}
