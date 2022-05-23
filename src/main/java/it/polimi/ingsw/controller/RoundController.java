package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.*;
import java.util.ArrayList;

public class RoundController {
    private ArrayList<Player> roundOrder;
    private TurnController turnController;
    private Player lastPlayer;

    public RoundController(ArrayList<Player> players) {
        this.roundOrder = players;
        this.turnController=new TurnController(players);
        lastPlayer=players.get(players.size());
    }

    public Player getLastPlayer() {
        return lastPlayer;
    }

    public TurnController getTurnController() {
        return turnController;
    }

    public void setRoundOrder(Player player, int num) {
        roundOrder.set(num, player);
    }
    public ArrayList<Player> newRoundOrder(ArrayList<Player> players, Game game) {
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
            if(w==game.getTotPlayer()){
                lastPlayer=players.get(i);
            }
        }
        return roundOrder;
    }
}
