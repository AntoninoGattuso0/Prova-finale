package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Player;

import java.util.ArrayList;

public class TurnController {
    private PhaseTurn currPhaseTurn;
    private ArrayList<Player> order;
    private Player currPlayer;
    private RoundController roundController;
    public TurnController(ArrayList<Player> roundOrder){
        this.currPhaseTurn=PhaseTurn.USE_ASSISTANT;
        order=new ArrayList<Player>();
        order.addAll(roundOrder);
        setCurrPlayer(roundOrder.get(0));
    }
    //azione che può essere eseguita in qualsiasi momento (usecharactercard)
    public PhaseTurn getPhase(){
        return this.currPhaseTurn;
    }
    public void TurnOrder(RoundController roundController,Game game){
        order=roundController.newRoundOrder(order,game);
    }

    public void setCurrPhaseTurn(PhaseTurn currPhaseTurn) {
        this.currPhaseTurn = currPhaseTurn;
    }
    public void exeAction(PhaseTurn currPhaseTurn){
        if(currPhaseTurn==PhaseTurn.MOVE_MOTHER_NATURE){

        }else if(currPhaseTurn==PhaseTurn.MOVE_STUDENT_TO_ISLAND){

        }else if(currPhaseTurn==PhaseTurn.MOVE_STUDENT_TO_DINDINGROOM){

        }
    }
    public void setCurrPlayer(Player currPlayer) {
        this.currPlayer = currPlayer;
    }
    public Player getCurrPlayer() {
        return currPlayer;
    }
    public void nextPhase(){
    }
    }
