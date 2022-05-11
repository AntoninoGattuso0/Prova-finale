package it.polimi.ingsw.network;

import it.polimi.ingsw.model.Player;

public class StartTurnMessage extends ServerToClient{
    private final String currentPlayer;

    public StartTurnMessage(String currentPlayer){
        this.currentPlayer = currentPlayer;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public String getMessage(){
        return currentPlayer + "it's your turn!";
    }
}