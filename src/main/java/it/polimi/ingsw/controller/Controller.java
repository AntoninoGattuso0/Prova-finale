package it.polimi.ingsw.controller;

import it.polimi.ingsw.client.ModelLight.*;
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
    private ArrayList<LightPlayer> playersLight;
    private Player currentPlayer;
    private ArrayList<ClientHandlerInterface> clients;
    public Controller(Game game, UserInput userInput, VirtualView virtualView, ArrayList<Player> players, ArrayList<ClientHandlerInterface> clients){
        this.game=game;
        this.isExpert=game.getIsExpert();//Manca il controllo della assistantphase nello startround DA NINO PER NINO
        this.virtualView=virtualView;
        this.userInput=userInput;
        this.players=new ArrayList<>();
        this.players.addAll(players);
        this.currentPlayer=players.get(0);
        this.endGame=false;
        this.playersLight=new ArrayList<>();
        this.roundController=new RoundController(players);
        this.clients=clients;
    }
    public ArrayList<Player> getPlayers() {
        return players;
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

    public void updateThisPlayersLight() {
        for(Player player: players){
            LightDiningRoom lightDining=new LightDiningRoom(player.getDiningRoom().getNumBlue(),player.getDiningRoom().getNumGreen(),player.getDiningRoom().getNumPink(),player.getDiningRoom().getNumRed(),player.getDiningRoom().getNumYellow());
            LightTowerSpace lightTowerSpace= new LightTowerSpace(player.getTowerSpace().getColorTower(),player.getTowerSpace().getNumTower());
            LightEntrance lightEntrance= new LightEntrance(player.getEntrance().getNumPawn(),player.getEntrance().getGreenPawn(),player.getEntrance().getRedPawn(),player.getEntrance().getYellowPawn(),player.getEntrance().getPinkPawn(),player.getEntrance().getBluePawn());
            playersLight.add(new LightPlayer(player.getNickname(),player.getNumCoin(),player.getDeckAssistant(),player.getCurrentAssistant(),lightEntrance,lightTowerSpace,lightDining));
        }
    }

    public void startRound(){

        boolean finish;
        players=roundController.getRoundOrder();
        updateThisPlayersLight();
        virtualView.setActualPlayer(roundController.getRoundOrder().get(0).getNickname());
        currentPlayer=roundController.getRoundOrder().get(0);
        virtualView.sendBroadcast(new TurnOrderMessage(playersLight));
        int i;
        for(i=0;i<players.size();i++) {
            players.get(i).setCurrentPhase(PhaseTurn.USE_ASSISTANT);
        }
        for(i=0;i<players.size();i++) {
                if (!(getRoundController().getExeAssistantPhase().get(players.get(i).getNickname()))) {
                    virtualView.startRound(players.get(i).getNickname());
                    while (!getRoundController().getExeAssistantPhase().get(players.get(i).getNickname()));
                }
        }
        players=roundController.newRoundOrder(players,game);
        updateThisPlayersLight();
        virtualView.sendBroadcast(new TurnOrderMessage(playersLight));
        for(i=0;i<players.size();){
                finish=startTurn(players.get(i));
                if(finish){
                    roundController.setExeEndTurn(false);
                    i++;
                }
            }
        }
    public boolean startTurn(Player player) {
            boolean e=false;
            while (player.getCurrentPhase() != PhaseTurn.END_TURN) {
            if (player.getCurrentPhase() == PhaseTurn.MOVE_STUDENT) {
                for (ClientHandlerInterface client : clients) {
                    if (player.getNickname().equals(client.getUserNickname())) {
                        virtualView.sendMessage(client, new SetMovePawnMessage(0));
                    }
                }
                 e= roundController.getExeMoveStudent();
            } else if (player.getCurrentPhase() == PhaseTurn.MOVE_MOTHER_NATURE) {
                for (ClientHandlerInterface client : clients) {
                    if (player.getNickname().equals(client.getUserNickname())) {
                        virtualView.sendMessage(client, new SetMoveMotherNature());
                    }
                }
                e=roundController.getExeMoveMotherNature();
            } else if (player.getCurrentPhase() == PhaseTurn.CHOOSE_CLOUD) {
                for (ClientHandlerInterface client : clients) {
                    if (player.getNickname().equals(client.getUserNickname())) {
                        virtualView.sendMessage(client, new SetCloudMessage());
                    }
                }
                e=roundController.getExeChooseCloud();
            } else if (player.getCurrentPhase() == PhaseTurn.END_TURN) {
                for (ClientHandlerInterface client : clients) {
                    if (player.getNickname().equals(client.getUserNickname())) {
                        virtualView.sendMessage(client, new EndTurnMessage());
                    }
                }
            }
            roundController.getTurnController().setPhaseTurn(player, e, roundController, game);
            e=false;
        }
            roundController.setExeChooseCloud(false);
            roundController.setExeMoveStudent(false);
            roundController.setExeMoveMotherNature(false);
        return roundController.getExeEndTurn();
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