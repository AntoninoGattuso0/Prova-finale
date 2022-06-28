package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Player;

import java.util.ArrayList;

/**
 * set the order of the players
 */
public class RoundController {
    private ArrayList<Player> roundOrder;
    private Player lastPlayer;

    public RoundController(ArrayList<Player> players) {
        this.roundOrder = players;
        lastPlayer = players.get(players.size() - 1);
    }

    public Player getLastPlayer() {
        return lastPlayer;
    }

    public ArrayList<Player> getRoundOrder() {
        return this.roundOrder;
    }

    /**This function decides the order of the player (it depends on the AssistantCard used)
     * @param game
     * @return ArrayList Player containing the order of the players
     */
    public synchronized ArrayList<Player> newRoundOrder(Game game) {
        int i, j, w, k;
        ArrayList<Player> tempArray = new ArrayList<>(game.getTotPlayer());
        for (i = game.getTotPlayer() - 1, k = 0; k < game.getPlayers().size(); k++) {
            tempArray.add(k, game.getPlayers().get(i));
            if (k == (game.getTotPlayer() - 1)) {
                this.lastPlayer = game.getPlayers().get(k);
            }
            i--;
        }
        for (i = 0; i < game.getPlayers().size(); i++) {
            w = 0;
            for (j = 0; j < game.getPlayers().size(); j++) {
                if ((j != i) && (game.getPlayers().get(i).getCurrentAssistant().getCardValue() > game.getPlayers().get(j).getCurrentAssistant().getCardValue())) {
                    w++;
                }
            }
            tempArray.set(w, game.getPlayers().get(i));
            if ((game.getTotPlayer() - 1) == w) {
                this.lastPlayer = game.getPlayers().get(i);
            }
        }
        this.roundOrder = tempArray;
        return roundOrder;
    }
}
