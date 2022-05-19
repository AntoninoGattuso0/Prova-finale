package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.*;
import it.polimi.ingsw.network.Lobby;
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
    private Player currentPlayer;
    public Controller(Game game,UserInput userInput,VirtualView virtualView,ArrayList<Player> players){
        this.game=game;
        this.isExpert=game.getIsExpert();
        this.virtualView=virtualView;
        this.userInput=userInput;
        this.players=new ArrayList<>();
        this.players.addAll(players);
        this.currentPlayer=players.get(0);
        this.endGame=false;
        this.roundController=new RoundController(players);
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
        virtualView.playerWinForQuitting(nick);
    }
    public void updateCurrentPlayer(){
        currentPlayer=players.get((players.indexOf(currentPlayer)+1)%players.size());
    }
    public void AdministrDisconnectionInSet(String userNickname) {
        endGame= true;
        virtualView.sendDisconectionInSet(userNickname);
    }
    public boolean lastTurn() {
        boolean i=false;
        if (roundController.getTurnController().getCurrPlayer().equals(roundController.getLastPlayer())&&roundController.getLastPlayer().getDeckAssistant().size()==0) {
            i=true;
        }
        return i;
    }
    public void startTurn(Player currentPlayer){
        virtualView.setActualPlayer(currentPlayer.getNickname());
        virtualView.startTurn();
        //FUNZIONE CHE GESTISCE TUTTO IL TURNO FINO ALLA FINE
        virtualView.endTurn();
    }
    public void play(Game game, Lobby lobby){
        String winnerIs;
        while (players.size()==game.getTotPlayer()&&!lastTurn()){
            if(currentPlayer.getActive()){
                startTurn(currentPlayer);
            }
            updateCurrentPlayer();
        }
        winnerIs=game.finish().getNickname();//CREARE IN GAME UNA FUNZIONE CHE CALCOLA IL VICITORE ALLA FINE DEL GIOCO (DEVE RITORNARE UN PLAYER)
        endGame=true;
        virtualView.updateWin(winnerIs);
    }                                        //3 CASI: CASO IN CUI PLAYER HA FINITO LE TORRI, CASO IN CUI FINISCONO LE PEDINE, CASO IN CUI FINISCONO GLI ASSSISTENTI
}
