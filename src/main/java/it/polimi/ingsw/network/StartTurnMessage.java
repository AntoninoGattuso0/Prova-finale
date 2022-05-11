package it.polimi.ingsw.network;

import it.polimi.ingsw.model.Player;

public class StartTurnMessage extends ServerToClient{
    private final Player currentPlayer;

    public StartTurnMessage(Player currentPlayer){
        this.currentPlayer = currentPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public String getMessage(){
        return currentPlayer.getNickname() + "it's your turn!";
    }
}