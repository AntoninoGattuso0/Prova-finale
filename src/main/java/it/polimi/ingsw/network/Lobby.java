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
    private final ArrayList<ClientHandlerIntefrace> clients;
    private boolean lobbySett;
    private boolean joinClient;
    private boolean isExpert;
    private final Object lock;
   private Game game;
    public Lobby() {
        lock=new Object();
        namePlayer = new ArrayList<>();
        virtualView = new VirtualView();
        userInput=new UserInput();
        clients = new ArrayList<>();
        players=new ArrayList<>();
        numPlayer =0;
        lobbyOk = false;
        lobbySett = false;
        joinClient = false;
        virtualView.addObserver(userInput);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addClientToList(ClientHandlerIntefrace client, Lobby lobby){
        String nickname;
        loginUser(client);
        nickname=client.getUserNickname();
        if(nickname!=null){
            if(!joinClient){
                newLobby(client);
            }else{
                joiningInLobby(client,lobby);
            }
        }
    }
    private void newLobby(ClientHandlerIntefrace client){
            Lobby lobby=new Lobby();
            lobby.addClient(client);
    }
    public void addClient(ClientHandlerIntefrace client){
        synchronized (lock) {
            String nick;
            client.addObserver(this);
            clients.add(client);
            nick = client.getUserNickname();
            virtualView.addClientInVirtualView(client, nick);
            players.add(new Player(nick, game));
            if (clients.size() != numPlayer) {
                client.sendObject(new WaitMessage());
            } else {
                client.sendObject(new GameStarted());
                lobbyOk = true;
            }
            lock.notifyAll();
        }
        if(lobbyOk){
            newGame();
        }
    }
    @Override
    public void updateDisconnection(ClientHandlerIntefrace clientHandler){
        if(controller.getEndGame()!=true){
            if(lobbySett){
                updateDisconnectionInSet(clientHandler);
            }else if(lobbyOk){
                updateDisconnectionInGame(clientHandler);}
        }else{
            CloseConnection(clientHandler);
            if(clients.size()==1||clients.size()==0){
                endGame.administrEndGame();
            }
        }
    }

    private void CloseConnection(ClientHandlerIntefrace clientHandler) {
        System.out.println("Server unregistering client.");
        virtualView.removeClientInVirtualView(clientHandler,clientHandler.getUserNickname());
        players.remove(getPlayerByNick(clientHandler.getUserNickname()));
        clients.remove(clientHandler);
        System.out.println(clientHandler.getUserNickname()+"'s client unregistered\n");
    }

    private void updateDisconnectionInSet(ClientHandlerIntefrace clientHandler) {
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
    private void updateDisconnectionInGame(ClientHandlerIntefrace clientHandler) {
        int i,c=0;
        getPlayerByNick(clientHandler.getUserNickname()).setActive(false);
        virtualView.sendAllQuitPlayer(clientHandler.getUserNickname());
        for(i=0;i<players.size();i++){
            if(players.get(i).getActive()==true){
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

    private void deregisterConn(ClientHandlerIntefrace clientHandler) {
    }

    private void joiningInLobby(ClientHandlerIntefrace client, Lobby lobby){
            int i;
            for(i=0;!namePlayer.get(i).equals(client.getUserNickname());i++);
            if(namePlayer.get(i).equals(client.getUserNickname())){
                lobby.addClient(client);
            }
    }
    public boolean isLobbyOk(){return lobbyOk;}
    //inserisco i player nell'array nomi, e li creo anche nel gioco
    public void loginUser(ClientHandlerIntefrace loginClient){
        int i;
        String nickname;
        Message nickMessage;
        loginClient.setTurn(true);
        loginClient.sendObject(new SetNickMessage());
        nickMessage = loginClient.read();
        if (nickMessage == null) {
            return;
        }
        nickname = ((LoginSettMessage) nickMessage).getNickname();
        joinClient = ((LoginSettMessage) nickMessage).getJoin();
        for (i = 0; i < namePlayer.size(); i++) {
            while (namePlayer.get(i).equals(nickname)) {
                loginClient.sendObject(new SetNickMessage());
                nickMessage = loginClient.read();
                if (nickMessage == null) {
                    return;
                }
                nickname = ((LoginSettMessage) nickMessage).getNickname();
                joinClient = ((LoginSettMessage) nickMessage).getJoin();
            }
        }
        namePlayer.add(nickname);
        loginClient.setUserNickname(nickname);
        if(namePlayer.size()==1){
            loginClient.sendObject(new SetNumPlayers());
            nickMessage=loginClient.read();
            numPlayer=((LoginNumPlayerIsExp) nickMessage).getNumPlayers();
            while(numPlayer<2||numPlayer>4){
                loginClient.sendObject(new SetNumPlayers());
                nickMessage=loginClient.read();
                numPlayer=((LoginNumPlayerIsExp) nickMessage).getNumPlayers();
            }
                loginClient.sendObject(new SetIsExpert());
                isExpert=((LoginNumPlayerIsExp) nickMessage).getIsExpert();
                game=new Game(numPlayer,isExpert);
                controller=new Controller(game);
        }
        Game.newPlayer(nickname,game);
        System.out.println("SERVER: "+nickname+" is joining!\n");
        loginClient.sendObject(new LoginAccepted(nickname));
        loginClient.setTurn(false);
    }
    public void endGame(Lobby lobby){
        for(String nickname: namePlayer){
            namePlayer.remove(nickname);
        }
        lobby = null;
    }
    public void newGame(){
        
    }
}