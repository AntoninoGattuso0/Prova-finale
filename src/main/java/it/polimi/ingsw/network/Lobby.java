package it.polimi.ingsw.network;

import it.polimi.ingsw.controller.Controller;
import it.polimi.ingsw.controller.UserInput;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.network.Message.*;
import it.polimi.ingsw.observer.ConnectionObserver;
import it.polimi.ingsw.observer.EndGameObserver;

import java.util.ArrayList;

public class Lobby implements ConnectionObserver {//DA COMPLETARE
    private Controller controller;
    private ArrayList<String> namePlayer;
    private final ArrayList<Player> players;
    private final VirtualView virtualView;
    private final UserInput userInput;
    private EndGameObserver endGame;
    private int numPlayer;
    private boolean lobbyOk;
    private final ArrayList<ClientHandlerInterface> clients;
    private boolean lobbySett;
    private boolean isExpert;
    private final Object lock;
   private Game game;
    public Lobby() {
        lock = new Object();
        namePlayer = new ArrayList<>();
        virtualView = new VirtualView();
        userInput = new UserInput();
        clients = new ArrayList<>();
        players = new ArrayList<>();
        numPlayer = 0;
        lobbyOk = false;
        lobbySett = false;
        virtualView.addObserver(userInput);
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public boolean isLobbySett() {
        return lobbySett;
    }

    public void addClient(ClientHandlerInterface client){
        synchronized (lock) {
            String nick;
            client.addObserver(this);
            clients.add(client);
            nick = client.getUserNickname();
            virtualView.addClientInVirtualView(client, nick);
            players.add(new Player(nick, game));
            if (clients.size() != numPlayer) {
                client.sendObject(new WaitMessage("Waiting other players"));
            } else {
                client.sendObject(new GameStartedMessage());
                lobbyOk = true;
            }
            lock.notifyAll();
        }
        if(lobbyOk){
            newGame(game);
        }
    }
    @Override
    public void updateDisconnection(ClientHandlerInterface clientHandler){
        if(controller.getEndGame()!=true){
            if(lobbySett){
                updateDisconnectionInSet(clientHandler);
            }else if(lobbyOk){
                updateDisconnectionInGame(clientHandler);}
        }else{
            closeConnection(clientHandler);
            if(clients.size()==1||clients.size()==0){
                endGame.administrEndGame();
            }
        }
    }
    private synchronized void closeConnection(ClientHandlerInterface clientHandler) {
        System.out.println("Server unregistering client.");
        virtualView.removeClientInVirtualView(clientHandler,clientHandler.getUserNickname());
        players.remove(getPlayerByNick(clientHandler.getUserNickname()));
        clients.remove(clientHandler);
        System.out.println(clientHandler.getUserNickname()+"'s client unregistered\n");
    }
    private void updateDisconnectionInSet(ClientHandlerInterface clientHandler) {
        System.out.println("A client disconnects in set-phase. The lobby is closed\n");
        deregisterConn(clientHandler);
        if(players.size()==1){
            endGame.administrEndGame();
        }else{
            controller.AdministrDisconnectionInSet(clientHandler.getUserNickname());
        }
    }
    private Player getPlayerByNick(String nick){
        for(Player player: players) {
            if (player.getNickname().equals(nick)) {
                return player;
            }
        }
        return null;
    }
    private void updateDisconnectionInGame(ClientHandlerInterface clientHandler) {
        int i,c=0;
        getPlayerByNick(clientHandler.getUserNickname()).setActive(false);
        virtualView.sendAllQuitPlayer(clientHandler.getUserNickname());
        for(i=0;i<players.size();i++){
            if(players.get(i).getActive()){
                c++;
            }
        }
        if(c==0){
            deregisterConn(clientHandler);
            endGame.administrEndGame();
        }else if(c==1){
            System.out.println("Only one active player in start game");
            controller.administrEnd();
        }
    }

    private void deregisterConn(ClientHandlerInterface clientHandler) {
    }
    public boolean isLobbyOk(){return lobbyOk;}
    //inserisco i player nell'array nomi, e li creo anche nel gioco
    public void loginUser(ClientHandlerInterface loginClient){
        int i;
        String nickname;
        Message nickMessage;
        loginClient.setTurn(true);
        loginClient.sendObject(new SetNickMessage());
        nickMessage = loginClient.read();
        if (nickMessage == null) {
            return;
        }
        nickname = ((RequestNickname) nickMessage).getNickname();
        for (i = 0; i < namePlayer.size(); i++) {
            while (namePlayer.get(i).equals(nickname)) {
                loginClient.sendObject(new SetNickMessage());
                nickMessage = loginClient.read();
                if (nickMessage == null) {
                    return;
                }
                nickname = ((RequestNickname) nickMessage).getNickname();
            }
        }
        namePlayer.add(nickname);
        loginClient.setUserNickname(nickname);
        if(namePlayer.size()==1){
            loginClient.sendObject(new SetNumPlayersMessage());
            nickMessage=loginClient.read();
            numPlayer=((RequestNumPlayers) nickMessage).getNumPlayers();
            while(numPlayer<2||numPlayer>4){
                loginClient.sendObject(new SetNumPlayersMessage());
                nickMessage=loginClient.read();
                numPlayer=((RequestNumPlayers) nickMessage).getNumPlayers();
            }
                loginClient.sendObject(new SetIsExpertMessage());
                isExpert=((RequestIsExpert) nickMessage).getIsExpert();
                game=new Game(numPlayer,isExpert);
        }
        Game.newPlayer(nickname,game);
        System.out.println("SERVER: "+nickname+" is joining!\n");
        loginClient.sendObject(new LoginAcceptedMessage(nickname));
        loginClient.setTurn(false);
        addClient(loginClient);
    }
    public void endGame(Lobby lobby){
        for(String nickname: namePlayer){
            namePlayer.remove(nickname);
        }
        lobby = null;
    }
    public void newGame(Game game){
        controller=new Controller(game,userInput,virtualView,players);
        controller.sendUpdate();
    }
}