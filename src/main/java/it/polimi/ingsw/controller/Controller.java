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

public class Controller {
    private RoundController roundController;
    private boolean endGame;
    private boolean isExpert;
    private Game game;
    private boolean contr;
    private final ArrayList<String> orderNamePlayers;
    private final UserInput userInput;
    private final VirtualView virtualView;
    private ArrayList<Player> players;
    private ArrayList<LightPlayer> playersLight;
    private Player currentPlayer;
    private ArrayList<ClientHandlerInterface> clients;

    public Controller(Game game, UserInput userInput, VirtualView virtualView, ArrayList<ClientHandlerInterface> clients) {
        this.game = game;
        this.isExpert = game.getIsExpert();//Manca il controllo della assistantphase nello startround DA NINO PER NINO
        this.virtualView = virtualView;
        this.userInput = userInput;
        this.orderNamePlayers = new ArrayList<>();
        this.players = new ArrayList<>();
        this.players.addAll(game.getPlayers());
        this.currentPlayer = game.getPlayers().get(0);
        this.endGame = false;
        this.contr = false;
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

    public boolean getEndGame() {
        return endGame;
    }

    public boolean getIsExpert() {
        return this.isExpert;
    }

    public void administrEnd() {
        String nick = "";
        endGame = true;
        virtualView.playerWinForQuitting(nick);
    }

    public void updateCurrentPlayer() {
        currentPlayer = players.get((players.indexOf(currentPlayer) + 1) % players.size());
    }

    public void sendUpdate() {
        virtualView.sendBroadcast(new AllUpdateMessage(game.getLightGame()));
    }

    public void AdministrDisconnectionInSet(String userNickname) {
        endGame = true;
        virtualView.sendDisconectionInSet(userNickname);
    }

    public boolean lastTurn() {
        boolean i = false;
        if (roundController.getTurnController().getCurrPlayer().equals(roundController.getLastPlayer()) && roundController.getLastPlayer().getDeckAssistant().size() == 0) {
            i = true;
        }
        return i;
    }

    public void updateThisPlayersLight() {
        for (Player player : game.getPlayers()) {
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
    public void setOrderNamePlayers(ArrayList<Player> players){
        for (int i = 0; i < players.size(); i++) {
            orderNamePlayers.add(players.get(i).getNickname());
        }
    }
    public ArrayList<String> getOrderNamePlayers() {
        return orderNamePlayers;
    }

    public synchronized void startRound() {
        players = roundController.getRoundOrder();
        updateThisPlayersLight();
        setOrderNamePlayers(players);
        virtualView.setActualPlayer(roundController.getRoundOrder().get(0).getNickname());
        currentPlayer = roundController.getRoundOrder().get(0);
        virtualView.sendBroadcast(new TurnOrderMessage(orderNamePlayers));
        int i;
        for (i = 0; i < players.size(); i++) {
            game.getPlayers().get(i).setCurrentPhase(PhaseTurn.USE_ASSISTANT);
            roundController.setExeAssistantPhase(game.getPlayers().get(i).getNickname());
        }
        virtualView.sendBroadcast(new SetAssistantMessage(players.get(0).getNickname()));
    }

    public synchronized void startTurn( Player player) {
        System.out.println("ci sono");
            if (player.getCurrentPhase() == PhaseTurn.MOVE_STUDENT) {
                for (ClientHandlerInterface client : clients) {
                    if (player.getNickname().equals(client.getUserNickname())) {
                        virtualView.sendMessage(client, new SetMovePawnMessage(player.getNickname(), 0));
                    }
                }
            } else if (player.getCurrentPhase() == PhaseTurn.MOVE_MOTHER_NATURE) {
                for (ClientHandlerInterface client : clients) {
                    if (player.getNickname().equals(client.getUserNickname())) {
                        virtualView.sendMessage(client, new SetMoveMotherNature(player.getNickname()));
                    }
                }
            } else if (player.getCurrentPhase() == PhaseTurn.CHOOSE_CLOUD) {
                for (ClientHandlerInterface client : clients) {
                    if (player.getNickname().equals(client.getUserNickname())) {
                        virtualView.sendMessage(client, new SetCloudMessage(player.getNickname()));
                    }
                }
            } else if (player.getCurrentPhase() == PhaseTurn.END_TURN) {
                for (ClientHandlerInterface client : clients) {
                    if (player.getNickname().equals(client.getUserNickname())) {
                        virtualView.sendMessage(client, new EndTurnMessage());
                    }
                }
        }
    }

}