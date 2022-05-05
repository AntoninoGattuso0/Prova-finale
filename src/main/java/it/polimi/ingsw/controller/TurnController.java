package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.Player;

import java.util.ArrayList;

public class TurnController {
    private PhaseTurn currPhaseTurn;
    private int currPlayer;


    public PhaseTurn getPhase(){
        return this.currPhaseTurn;
    }

    public void NextPhase(){
        if(currPhaseTurn == PhaseTurn.MOVE_STUDENT)
            this.currPhaseTurn = PhaseTurn.MOVE_MOTHER_NATURE;
        else if(currPhaseTurn == PhaseTurn.MOVE_MOTHER_NATURE)
            this.currPhaseTurn = PhaseTurn.CHOOSE_CLOUD;
        else if(currPhaseTurn == PhaseTurn.CHOOSE_CLOUD)
            this.currPhaseTurn = PhaseTurn.END_TURN;
    }
}
