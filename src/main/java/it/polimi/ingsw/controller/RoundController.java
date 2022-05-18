package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.*;
import java.util.ArrayList;

public class RoundController {
    private ArrayList<Player> roundOrder;
    private TurnController turnController;

    public RoundController(ArrayList<Player> players) {
        this.roundOrder = players;
    }
    public void setRoundOrder(Player player, int num) {
        roundOrder.set(num, player);
    }
    private ArrayList<Player> newRoundORder(ArrayList<Player> players, Game game) {
        int i, j, k, w;
        for (i = 0; i < players.size(); i++) {
            w = 0;
            for (k = 0; players.get(i).equals(game.getPlayers().get(k)); k++) ;
            for (j = 0; j < players.size(); j++) {
                if (game.getPlayers().get(k).getCurrentAssistant().getCardValue() > game.getPlayers().get(j).getCurrentAssistant().getCardValue()) {
                    w++;
                }
            }
            if(i==0){roundOrder.clear();}
            setRoundOrder(players.get(i), w);
        }
        return roundOrder;
    }
}
