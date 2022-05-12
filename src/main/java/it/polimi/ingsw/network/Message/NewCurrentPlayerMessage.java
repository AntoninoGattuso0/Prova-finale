package it.polimi.ingsw.network.Message;

public class NewCurrentPlayerMessage extends ServerToClient {
    private final String currentPlayer;
    private final String nextPlayer;

    public NewCurrentPlayerMessage(String currentPlayer, String nextPlayer){
        this.currentPlayer = currentPlayer;
        this.nextPlayer = nextPlayer;
    }

    public String getNextPlayer() {
        return currentPlayer + "is disconnected, " + nextPlayer + " it's your turn!";
    }
}
