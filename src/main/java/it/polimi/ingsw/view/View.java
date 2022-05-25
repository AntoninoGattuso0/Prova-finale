package it.polimi.ingsw.view;

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

    void displayNick();// DA MODIFICARE TUTTI I GAME, VEDI COSA HO SCRITTO IN MESSAGE MANAGER
    void displayNumPlayers(int numPlayers);
    void displayIsExpert();
    void displayAssistantCard(Player player);
    void displayCloud();
    void displayIslands();
    void displaySchoolBoard();
    void displayCharacterCard(Game game);

    //ogni volta che si cambia qualcosa di queste dobbiamo aggiornarle e poi richiamare display
    void updateAssistantCard(AssistantCardUpdateMessage assistant);
    void updateCloud(CloudUpdateMessage cloud);
    void updateDiningRoom(DiningRoomUpdateMessage object);
    void updateEntrance();
    void updateIsland(IslandUpdateMessage m);
    void updateProfTable();
    void updateTowerSpace();
    void updateNickname(NicknameUpdateMessage m);
    void updateCharacterCard();

    void registerClient(ClientAcceptedMessage m);


    void updateNumPlayers();
    void requestNickname();
    void requestNumPlayers();
    void requestIsExpert();


    void waitOtherPlayers(String object);

    void displayWinner(String winner);


    void displayNetError();
    // void displayTurn(StartTurnMessage object);
    void displayWrongNickname();

    void updatePawnToDining(int numDiningRoom, ArrayList<ColorPawn> arrayPawn);

    void updatePawnToIsland(int island, int numPawn, ArrayList<ColorPawn> arrayPawn);

    void requestMoveMotherNature(int island);
    void updateMoveMotherNature(int island);

    void displayWrongTurn();

    void displayFetchNameMessage();

    void displayTurn(StartTurnMessage object);

    void displayResponseMessage(String errorMessage);

    void selectCloud(int cloud);

    void selectAssistantCard(int assistant);

    void updateTowerSpace(TowerSpaceUpdateMessage object);

    void updateEntrance(EntranceUpdateMessage object);

    void updateAll(AllUpdateMessage object);
}

//CLI E GUI dovranno implementare quest interfaccia