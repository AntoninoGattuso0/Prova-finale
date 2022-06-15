package it.polimi.ingsw.controller;

import it.polimi.ingsw.client.ModelLight.LightDiningRoom;
import it.polimi.ingsw.client.ModelLight.LightEntrance;
import it.polimi.ingsw.client.ModelLight.LightPlayer;
import it.polimi.ingsw.client.ModelLight.LightTowerSpace;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.network.ClientHandlerInterface;
import it.polimi.ingsw.network.Message.ServerToClient.*;
import it.polimi.ingsw.network.Message.UpdateMessage.AllUpdateMessage;
import it.polimi.ingsw.network.VirtualView;

import java.util.ArrayList;
import java.util.Objects;

public class Controller {
    private RoundController roundController;
    private boolean endGame;
    private boolean isExpert;
    private Game game;
    private boolean contr;
    private int c;
    private int counterRound;
    private final ArrayList<String> orderNamePlayers;
    private final VirtualView virtualView;
    private ArrayList<Player> players;
    private ArrayList<LightPlayer> playersLight;
    private ArrayList<ClientHandlerInterface> clients;

    public Controller(Game game, VirtualView virtualView, ArrayList<ClientHandlerInterface> clients) {
        this.game = game;
        this.isExpert = game.getIsExpert();//Manca il controllo della assistantphase nello startround DA NINO PER NINO
        this.virtualView = virtualView;
        this.orderNamePlayers = new ArrayList<>();
        this.players = new ArrayList<>();
        this.players.addAll(game.getPlayers());
        this.endGame = false;
        this.contr = false;
        this.c=0;
        this.counterRound=0;
        this.playersLight = new ArrayList<>();
        this.roundController = new RoundController(game.getPlayers());
        this.clients = clients;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public RoundController getRoundController() {
        return this.roundController;
    }

    public Game getGame() {
        return this.game;
    }

    /**Update everything from the Game to the LightGame
     *
     */
    public void updateThisPlayersLight() {
        for (Player player : players) {
            PhaseTurn phaseTurn = player.getCurrentPhase();
            LightDiningRoom lightDining = new LightDiningRoom(player.getDiningRoom().getNumBlue(), player.getDiningRoom().getNumGreen(), player.getDiningRoom().getNumPink(), player.getDiningRoom().getNumRed(), player.getDiningRoom().getNumYellow());
            LightTowerSpace lightTowerSpace = new LightTowerSpace(player.getTowerSpace().getColorTower(), player.getTowerSpace().getNumTower());
            LightEntrance lightEntrance = new LightEntrance(player.getEntrance().getNumPawn(), player.getEntrance().getGreenPawn(), player.getEntrance().getRedPawn(), player.getEntrance().getYellowPawn(), player.getEntrance().getPinkPawn(), player.getEntrance().getBluePawn());
            playersLight.add(new LightPlayer(player.getNickname(), player.getNumCoin(), player.getDeckAssistant(), player.getCurrentAssistant(), lightEntrance, lightTowerSpace, lightDining, phaseTurn));
        }
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setOrderNamePlayers(ArrayList<Player> players) {
        orderNamePlayers.clear();
        for (int i = 0; i < players.size(); i++) {
            orderNamePlayers.add(players.get(i).getNickname());
        }
    }
    public int getCounterRound() {
        return counterRound;
    }
    public ArrayList<String> getOrderNamePlayers() {
        return orderNamePlayers;
    }

    public void setPlayer(ArrayList<Player> players) {
        this.players=players;
    }

    public synchronized void startRound() {
        this.counterRound++;
        players = roundController.getRoundOrder();
        updateThisPlayersLight();
        setOrderNamePlayers(players);
        virtualView.setActualPlayer(roundController.getRoundOrder().get(0).getNickname());
        virtualView.sendBroadcast(new TurnOrderMessage(orderNamePlayers));
        int i;
        for (i = 0; i < players.size(); i++) {
            game.getPlayers().get(i).setCurrentPhase(PhaseTurn.USE_ASSISTANT);
            game.getPlayers().get(i).setCurrentAssistant(null);
        }
        virtualView.sendBroadcast(new AllUpdateMessage(game.getLightGame()));
        virtualView.sendBroadcast(new SetAssistantMessage(players.get(0).getNickname()));
    }

    public synchronized void startTurn(Player player) {
        if (player.getCurrentPhase() == PhaseTurn.MOVE_STUDENT) {
            virtualView.sendBroadcast(new SetMovePawnMessage(player.getNickname(), 0));
        } else if (player.getCurrentPhase() == PhaseTurn.MOVE_MOTHER_NATURE) {
            virtualView.sendBroadcast( new SetMoveMotherNature(player.getNickname()));
        } else if (player.getCurrentPhase() == PhaseTurn.CHOOSE_CLOUD) {
            virtualView.sendBroadcast( new SetCloudMessage(player.getNickname()));
        } else if (player.getCurrentPhase() == PhaseTurn.END_TURN) {
            setOrderNamePlayers(getRoundController().getRoundOrder());
            virtualView.sendBroadcast( new EndTurnMessage(getOrderNamePlayers(),player.getNickname()));
            if(Objects.equals(player.getNickname(), getRoundController().getLastPlayer().getNickname())){
                int i;
                this.c=0;
                    for (i = 0; i < game.getClouds().size(); i++) {
                        game.getClouds().get(i).refillCloud(game.getStudentBag(), game);
                }
                    if(game.getStudentBag().getNum()==0){
                        player=game.finish(false);
                        virtualView.sendBroadcast(new WinnerMessage(player.getNickname()));
                        virtualView.updateWin(player.getNickname());
                    }else {
                        startRound();
                    }
            }else{
                this.c=this.c+1;
                virtualView.sendBroadcast(new AllUpdateMessage(game.getLightGame()));
                virtualView.sendBroadcast(new SetMovePawnMessage(roundController.getRoundOrder().get(this.c).getNickname(),0));
            }
        }else if(player.getCurrentPhase()==PhaseTurn.USE_CHARACTER){
            virtualView.sendBroadcast(new SetCharacterCardMessage(player.getNickname(),false));
        }
    }
}