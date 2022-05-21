package it.polimi.ingsw.view;

import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.network.Message.ClientAcceptedMessage;
import it.polimi.ingsw.network.Message.StartTurnMessage;

import java.util.ArrayList;

public interface View {

    void startGame();
    void loginPlayers();

    void askNumPlayer();

    void displayNick(Game game);
    void displayNumPlayers(int numPlayers);
    void displayIsExpert(int isExpert);
    void displayAssistantCard(Player player);
    void displayCloud(Game game);
    void displayIslands(Game game);
    void displaySchoolBoard(Game game);
    void displayCharacterCard(Game game);

    //ogni volta che si cambia qualcosa di queste dobbiamo aggiornarle e poi richiamare display
    void updateAssistantCard(int assistant);
    void updateCloud(int cloud);
    void updateDiningRoom();
    void updateEntrance();
    void updateIsland();
    void updateProfTable();
    void updateTowerSpace();
    void updateNickname(NickUpdateMessage m);
    void updateCharacterCard();

    void registerClient(ClientAcceptedMessage m);


    void updateNumPlayers();
    void requestNickname();
    void requestNumPlayers();
    void requestCloud(Game game);
    void requestIsExpert();


    void waitOtherPlayers(String object);

    void displayWinner(String winner);

    void updateCloud();

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
}

//CLI E GUI dovranno implementare quest interfaccia