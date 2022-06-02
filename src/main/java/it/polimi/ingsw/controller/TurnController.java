package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Player;

import java.util.ArrayList;
import java.util.Objects;

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
    public void TurnOrder(RoundController roundController,Game game){
        order=roundController.newRoundOrder(order,game);
    }
    public void setPhaseTurn(Player player,boolean e,RoundController roundController,Game game){
        if(player.getCurrentPhase()==PhaseTurn.USE_ASSISTANT&&e){
            if(Objects.equals(player.getNickname(), order.get(order.size()-1).getNickname())){
                TurnOrder(roundController,game);
            }
            player.setCurrentPhase(PhaseTurn.MOVE_STUDENT);
        } else if(player.getCurrentPhase()==PhaseTurn.MOVE_MOTHER_NATURE&&e){
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
