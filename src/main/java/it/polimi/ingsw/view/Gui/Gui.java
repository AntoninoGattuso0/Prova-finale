package it.polimi.ingsw.view.Gui;

import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.network.Message.ClientAcceptedMessage;
import it.polimi.ingsw.network.Message.StartTurnMessage;
import it.polimi.ingsw.network.Message.UpdateMessage.*;
import it.polimi.ingsw.observer.ViewObservable;
import it.polimi.ingsw.view.View;

import javafx.application.Platform;

import java.util.ArrayList;

public class Gui extends ViewObservable implements View {
    @Override
    public void startGame() {

    }

    @Override
    public void loginPlayers() {

    }

    @Override
    public void displayNick() {

    }

    @Override
    public void displayNumPlayers(int numPlayers) {

    }

    @Override
    public void displayIsExpert() {

    }

    @Override
    public void displayAssistantCard(Player player) {

    }

    @Override
    public void displayCloud() {

    }

    @Override
    public void displayIslands(Game game) {

    }

    @Override
    public void displaySchoolBoard(Game game) {

    }

    @Override
    public void displayCharacterCard(Game game) {

    }

    @Override
    public void updateAssistantCard(AssistantCardUpdateMessage assistant) {

    }

    @Override
    public void updateCloud(CloudUpdateMessage cloud) {

    }

    @Override
    public void updateDiningRoom(DiningRoomUpdateMessage object) {

    }

    @Override
    public void updateEntrance() {

    }

    @Override
    public void updateIsland(IslandUpdateMessage m) {

    }

    @Override
    public void updateProfTable() {

    }

    @Override
    public void updateTowerSpace() {

    }

    @Override
    public void updateNickname(NicknameUpdateMessage m) {

    }

    @Override
    public void updateCharacterCard() {

    }

    @Override
    public void registerClient(ClientAcceptedMessage m) {

    }

    @Override
    public void updateNumPlayers() {

    }

    @Override
    public void requestNickname() {

    }

    @Override
    public void requestNumPlayers() {

    }

    @Override
    public void requestIsExpert() {

    }

    @Override
    public void waitOtherPlayers(String object) {

    }

    @Override
    public void displayWinner(String winner) {

    }

    @Override
    public void displayNetError() {

    }

    @Override
    public void displayWrongNickname() {

    }

    @Override
    public void updatePawnToDining(int numDiningRoom, ArrayList<ColorPawn> arrayPawn) {

    }

    @Override
    public void updatePawnToIsland(int island, int numPawn, ArrayList<ColorPawn> arrayPawn) {

    }

    @Override
    public void requestMoveMotherNature(int island) {

    }

    @Override
    public void updateMoveMotherNature(int island) {

    }

    @Override
    public void displayWrongTurn() {

    }

    @Override
    public void displayFetchNameMessage() {

    }

    @Override
    public void displayTurn(StartTurnMessage object) {

    }

    @Override
    public void displayResponseMessage(String errorMessage) {

    }

    @Override
    public void selectCloud(int cloud) {

    }

    @Override
    public void selectAssistantCard(int assistant) {

    }

    @Override
    public void updateTowerSpace(TowerSpaceUpdateMessage object) {

    }

    @Override
    public void updateEntrance(EntranceUpdateMessage object) {

    }
}
