package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class RoundController {
    private ArrayList<Player> roundOrder;
    private TurnController turnController;
    private Player lastPlayer;
    private boolean exeChooseCloud;
    private HashMap<String, Boolean> exeAssistantPhase = new HashMap<>();
    private boolean exeEndTurn;
    private boolean exeMoveStudent;
    private boolean exeMoveMotherNature;
    private boolean exeCharacterCard;

    public RoundController(ArrayList<Player> players) {
        this.roundOrder = players;
        this.turnController = new TurnController(players);
        lastPlayer = players.get(players.size() - 1);
        this.exeChooseCloud = false;
        int i;
        for (i = 0; i < roundOrder.size(); i++) {
            exeAssistantPhase.put(roundOrder.get(i).getNickname(), false);
        }
        this.exeEndTurn = false;
        this.exeMoveStudent = false;
        this.exeMoveMotherNature = false;
        this.exeCharacterCard = false;
    }

    public void setExeEndTurn(boolean exeEndTurn) {
        this.exeEndTurn = exeEndTurn;
    }

    public void setExeCharacterCard(boolean exeCharacterCard) {
        this.exeCharacterCard = exeCharacterCard;
    }

    public boolean getExeCharacterCard() {
        return exeCharacterCard;
    }

    public void setExeAssistantPhase(String nickname) {
        exeAssistantPhase.put(nickname, true);
    }

    public void setExeChooseCloud(boolean exeChooseCloud) {
        this.exeChooseCloud = exeChooseCloud;
    }

    public void setExeMoveMotherNature(boolean exeMoveMotherNature) {
        this.exeMoveMotherNature = exeMoveMotherNature;
    }

    public void setExeMoveStudent(boolean exeMoveStudent) {
        this.exeMoveStudent = exeMoveStudent;
    }

    public boolean getExeEndTurn() {
        return exeEndTurn;
    }

    public boolean getExeMoveStudent() {
        return exeMoveStudent;
    }

    public boolean getExeMoveMotherNature() {
        return exeMoveMotherNature;
    }

    public HashMap<String, Boolean> getExeAssistantPhase() {
        return exeAssistantPhase;
    }

    public boolean getExeChooseCloud() {
        return exeChooseCloud;
    }

    public Player getLastPlayer() {
        return lastPlayer;
    }

    public TurnController getTurnController() {
        return turnController;
    }

    public ArrayList<Player> getRoundOrder() {
        return roundOrder;
    }

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
