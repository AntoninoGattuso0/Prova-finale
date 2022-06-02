package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.*;
import java.util.ArrayList;

public class RoundController {
    private ArrayList<Player> roundOrder;
    private TurnController turnController;
    private Player lastPlayer;
    private boolean exeChooseCloud;
    private boolean exeAssistantPhase;
    private boolean exeEndTurn;
    private boolean exeMoveStudent;
    private boolean exeMoveMotherNature;
    public RoundController(ArrayList<Player> players) {
        this.roundOrder = players;
        this.turnController=new TurnController(players);
        lastPlayer=players.get(players.size()-1);
        this.exeChooseCloud=false;
        this.exeAssistantPhase=false;
        this.exeEndTurn=false;
        this.exeMoveStudent=false;
        this.exeMoveMotherNature=false;
    }

    public void setExeEndTurn(boolean exeEndTurn) {
        this.exeEndTurn = exeEndTurn;
    }
    public void setExeAssistantPhase(boolean exeAssistantPhase) {
        this.exeAssistantPhase = exeAssistantPhase;
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
    public boolean getExeEndTurn(){
        return exeEndTurn;
    }
    public boolean getExeMoveStudent(){
        return exeMoveStudent;
    }
    public boolean getExeMoveMotherNature(){
        return exeMoveMotherNature;
    }
    public boolean getExeAssistantPhase(){
        return exeAssistantPhase;
    }
    public boolean getExeChooseCloud(){
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
