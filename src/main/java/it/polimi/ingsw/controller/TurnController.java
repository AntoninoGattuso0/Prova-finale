package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.Player;

public class TurnController {
    private PhaseTurn currPhaseTurn;
    private int currPlayer;


    public PhaseTurn getPhase(){
        return this.currPhaseTurn;
    }

    public void setCurrPhaseTurn(PhaseTurn currPhaseTurn) {
        this.currPhaseTurn = currPhaseTurn;
    }

    public void nextPhase(){
        if(getPhase() == PhaseTurn.MOVE_STUDENT)
           setCurrPhaseTurn(PhaseTurn.MOVE_MOTHER_NATURE);
        else if(getPhase() == PhaseTurn.MOVE_MOTHER_NATURE)
            setCurrPhaseTurn(PhaseTurn.CHOOSE_CLOUD);
        else if(getPhase() == PhaseTurn.CHOOSE_CLOUD)
           setCurrPhaseTurn(PhaseTurn.END_TURN);
    }
    public void thisphase(Player player, PhaseTurn current){
        if (current==PhaseTurn.MOVE_STUDENT){

        }
    }
}
