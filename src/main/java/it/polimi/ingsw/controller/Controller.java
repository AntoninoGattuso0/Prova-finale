package it.polimi.ingsw.controller;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.network.ClientHandlerInterface;
import it.polimi.ingsw.network.Lobby;
import it.polimi.ingsw.network.Message.ServerToClient.*;
import it.polimi.ingsw.network.Message.UpdateMessage.AllUpdateMessage;
import it.polimi.ingsw.network.VirtualView;

import java.util.ArrayList;

public class Controller {
    private RoundController roundController;
    private boolean endGame;
    private boolean isExpert;
    private Game game;
    private final UserInput userInput;
    private final VirtualView virtualView;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private ArrayList<ClientHandlerInterface> clients;
    public Controller(Game game, UserInput userInput, VirtualView virtualView, ArrayList<Player> players, ArrayList<ClientHandlerInterface> clients){
        this.game=game;
        this.isExpert=game.getIsExpert();
        this.virtualView=virtualView;
        this.userInput=userInput;
        this.players=new ArrayList<>();
        this.players.addAll(players);
        this.currentPlayer=players.get(0);
        this.endGame=false;
        this.roundController=new RoundController(players);
        this.clients=clients;
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

    public boolean getIsExpert(){
        return this.isExpert;
    }

    public void administrEnd() {
        String nick="";
        endGame=true;
        virtualView.playerWinForQuitting(nick);
    }
    public void updateCurrentPlayer(){
        currentPlayer=players.get((players.indexOf(currentPlayer)+1)%players.size());
    }

    public void sendUpdate(){
        virtualView.sendBroadcast(new AllUpdateMessage(game.getLightGame()));
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
    public void startRound(){
        boolean finish;
        players=roundController.getRoundOrder();
        virtualView.setActualPlayer(roundController.getRoundOrder().get(0).getNickname());
        currentPlayer=roundController.getRoundOrder().get(0);
        int i;
        for(i=0;i<players.size();i++) {
            players.get(i).setCurrentPhase(PhaseTurn.USE_ASSISTANT);
        }
        virtualView.startRound(currentPlayer.getNickname());
        players=roundController.newRoundOrder(players,game);
        virtualView.sendBroadcast(new TurnOrderMessage(players));
        for(i=0;i<players.size();){
                finish=startTurn(players.get(i));
                if(finish){
                    i++;
                }
            }
        }
    public boolean startTurn(Player player) {
        boolean e = false;
        while (player.getCurrentPhase() != PhaseTurn.END_TURN && e) {
            if (player.getCurrentPhase() == PhaseTurn.MOVE_STUDENT) {
                for (ClientHandlerInterface client : clients) {
                    if (player.getNickname().equals(client.getUserNickname())) {
                        virtualView.sendMessage(client, new SetMovePawnMessage());
                    }
                }
            } else if (player.getCurrentPhase() == PhaseTurn.MOVE_MOTHER_NATURE) {
                for (ClientHandlerInterface client : clients) {
                    if (player.getNickname().equals(client.getUserNickname())) {
                        virtualView.sendMessage(client, new SetMoveMotherNature());
                    }
                }
            } else if (player.getCurrentPhase() == PhaseTurn.CHOOSE_CLOUD) {
                for (ClientHandlerInterface client : clients) {
                    if (player.getNickname().equals(client.getUserNickname())) {
                        virtualView.sendMessage(client, new SetCloudMessage());
                    }
                }
            } else if (player.getCurrentPhase() == PhaseTurn.END_TURN) {
                for (ClientHandlerInterface client : clients) {
                    if (player.getNickname().equals(client.getUserNickname())) {
                        virtualView.sendMessage(client, new EndTurnMessage());
                    }
                }
            }
            roundController.getTurnController().setPhaseTurn(player, e, roundController, game);
        }
        return e;
    }
    public void play(Game game, Lobby lobby){
        String winnerIs;
        while (players.size()==game.getTotPlayer()&&!lastTurn()){
            startRound();
            if(currentPlayer.getActive()){
                startTurn(currentPlayer);
            }
            updateCurrentPlayer();
        }
        winnerIs=game.finish().getNickname();
        endGame=true;
        virtualView.updateWin(winnerIs);
    }
}