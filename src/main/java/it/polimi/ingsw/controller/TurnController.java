package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Player;

import java.util.ArrayList;

public class TurnController {
    private ArrayList<Player> order;
    private Player currPlayer;
    public TurnController(ArrayList<Player> roundOrder){
        order=new ArrayList<Player>();
        order.addAll(roundOrder);
        setCurrPlayer(roundOrder.get(0));
    }
    public PhaseTurn getPhase(){
        return this.currPlayer.getCurrentPhase();
    }
    public synchronized ArrayList<Player> TurnOrder(RoundController roundController,Game game){
       order= roundController.newRoundOrder(game);
       return order;
    }

    public synchronized void setPhaseTurn(Player player,boolean e,RoundController roundController,Game game){
        if(player.getCurrentPhase()==PhaseTurn.MOVE_MOTHER_NATURE&&e){
            player.setCurrentPhase(PhaseTurn.CHOOSE_CLOUD);
        }else if(player.getCurrentPhase()==PhaseTurn.MOVE_STUDENT&&e) {
            player.setCurrentPhase(PhaseTurn.MOVE_MOTHER_NATURE);
        }else if(player.getCurrentPhase()==PhaseTurn.CHOOSE_CLOUD&&e) {
            player.setCurrentPhase(PhaseTurn.END_TURN);
        } else if(player.getCurrentPhase()==PhaseTurn.END_TURN&&e){
            player.setCurrentPhase(PhaseTurn.USE_ASSISTANT);
        }
    }
    public void setCurrPlayer(Player currPlayer) {
        this.currPlayer = currPlayer;
    }
    public Player getCurrPlayer() {
        return currPlayer;
    }
    }
