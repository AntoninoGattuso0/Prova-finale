package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.*;
import it.polimi.ingsw.network.VirtualView;

import java.util.ArrayList;

public class Controller {
    private RoundController roundController;
    private boolean endGame;
    private boolean isExpert;
    private Game game;
    private final UserInput userInput;
    private final VirtualView virtualView;
    private final ArrayList<Player> players;
    private final Player currentPlayer;
    public Controller(Game game,UserInput userInput,VirtualView virtualView,ArrayList<Player> players){
        this.game=game;
        this.virtualView=virtualView;
        this.userInput=userInput;
        this.players=players;
        this.currentPlayer=players.get(0);
        this.endGame=false;
        this.roundController=new RoundController(players);
    }
    public void checkNickname(String nickname){

    }

    public RoundController getRoundController(){
        return this.roundController;
    }

    public Game getGame(){
        return this.game;
    }

    public boolean getEndGame(){
        return endGame;
    }

    public void setIsExpert(boolean isExpert){
        this.isExpert = isExpert;
    }

    public boolean getIsExpert(){
        return this.isExpert;
    }

    public void administrEnd() {
        String nick="";
        int i;
        endGame=true;
        for(i=0;i<game.getPlayers().size();i++){
            if(game.getPlayers().get(i).getActive()==true){
                nick=game.getPlayers().get(i).getNickname();
            }
        }
        virtualView.playerWinForQuitting(nick);
    }

    public void AdministrDisconnectionInSet(String userNickname) {
        endGame= true;
        virtualView.sendDisconectionInSet(userNickname);
    }
}
