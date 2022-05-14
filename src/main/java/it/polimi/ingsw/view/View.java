package it.polimi.ingsw.view;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.network.Message.*;

public interface View {

    void startGame();
    void loginPlayers();
    void askNumPlayerIsExpert();
    void displayNick(Game game);

    void displayNumPlayers(int numPlayers);
    void displayIsExpert(int isExpert);
    void waitForPlayers();

    void displayAssistantCard(Player player);
    void displayCloud();
    void displayDiningRoom();
    void displayEntrance();
    void displayIsland();
    void displayProfTable();
    void displayTowerSpace();

    void displayCharacterCard();

    //ogni volta che si cambia qualcosa di queste dobbiamo aggiornarle e poi richiamare display
    void updateAssistantCard();
    void updateCloud();
    void updateDiningRoom();
    void updateEntrance();
    void updateIsland();
    void updateProfTable();
    void updateTowerSpace();

    void updateCharacterCard();


    void displayTurn(StartTurnMessage startTurnMessage);  //mostra di chi è il turno
    void displayWinner(String winner);

}

//CLI E GUI dovranno implementare quest interfaccia