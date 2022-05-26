package it.polimi.ingsw.view;

import it.polimi.ingsw.model.CharacterCard;
import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.network.Message.ClientAcceptedMessage;
import it.polimi.ingsw.network.Message.StartTurnMessage;
import it.polimi.ingsw.network.Message.UpdateMessage.*;

import java.util.ArrayList;

public interface View {

    void startGame();
    void loginPlayers();

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

    void displayWinner(String winner);
    void displayNetError();
    void displayWrongNickname();
    void displayWrongTurn();
    void displayFetchNameMessage();
    void displayTurn(StartTurnMessage object);
    void displayResponseMessage(String errorMessage);


    //ogni volta che si cambia qualcosa di queste dobbiamo aggiornarle e poi richiamare display
    void updateAssistantCard(AssistantCardUpdateMessage message);
    void updateCloud(CloudUpdateMessage message);
    void updateIsland(IslandUpdateMessage message);
    void updateEntrance(EntranceUpdateMessage message);
    void updateDiningRoom(DiningRoomUpdateMessage message);
    void updateProfTable(ProfTableUpdateMessage message);
    void updateTowerSpace(TowerSpaceUpdateMessage message);
    void updateCharacterCard(CharacterCardUpdateMessage message);

    void updateNickname(NicknameUpdateMessage m);
    void updateNumPlayers();
    void updateAll(AllUpdateMessage object);

    void selectCloud(int cloud);
    void selectAssistantCard(int assistant);
    void requestMoveMotherNature(int island);

    void updateMoveMotherNature(int island);
    void updatePawnToDining(int numDiningRoom, ArrayList<ColorPawn> arrayPawn);
    void updatePawnToIsland(int island, int numPawn, ArrayList<ColorPawn> arrayPawn);

    void registerClient(ClientAcceptedMessage m);
    void waitOtherPlayers(String object);
}

//CLI E GUI dovranno implementare quest interfaccia