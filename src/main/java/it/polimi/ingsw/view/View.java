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
    void askNumPlayerIsExpert();
    void displayNick(Game game);

    void displayNumPlayers(int numPlayers);
    void displayIsExpert(int isExpert);

    void displayAssistantCard(Player player);
    void displayCloud(Game game);
    void displayIslands(Game game);
    void displaySchoolBoard(Game game);
    void displayCharacterCard();

    //ogni volta che si cambia qualcosa di queste dobbiamo aggiornarle e poi richiamare display
    void updateAssistantCard();
    void updateCloud();
    void updateDiningRoom();
    void updateEntrance();
    void updateIsland();
    void updateProfTable();
    void updateTowerSpace();
    void updateNickname(NickUpdateMessage m);
    void updateCharacterCard();
    void registerClient(ClientAcceptedMessage m);


    void updateNumPlayers();

    void waitOtherPlayers(String waitMessage);
    void displayWinner(String winner);

    void updateCloud();

    void displayNetError();

    void displayTurn(StartTurnMessage object);

    void requestIsExpert();

    void displayWrongNickname();

    void updatePawnToDining(int numDiningRoom, ArrayList<ColorPawn> arrayPawn);

    void updatePawnToIsland(int island, ArrayList<ColorPawn> arrayPawn);

    void updateMoveMotherNature(int island);

    void displayWrongTurn();

    void displayFetchNameMessage();
}

//CLI E GUI dovranno implementare quest interfaccia