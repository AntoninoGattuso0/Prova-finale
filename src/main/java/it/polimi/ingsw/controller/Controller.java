package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.*;

public class Controller {
    private RoundController roundController;
    private boolean isExpert;
    private Game game;

    public void checkNickname(String nickname){

    }

    public RoundController getRoundController(){
        return this.roundController;
    }

    public Game getGame(){
        return this.game;
    }

    public void checkEndGame(){

    }

    public void setIsExpert(boolean isExpert){
        this.isExpert = isExpert;
    }

    public boolean getIsExpert(){
        return this.isExpert;
    }
}
