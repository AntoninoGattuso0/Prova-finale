package it.polimi.ingsw.network;

import it.polimi.ingsw.controller.Controller;
import it.polimi.ingsw.controller.UserInput;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.network.Message.*;

import java.util.ArrayList;

public class Lobby {//DA COMPLETARE
    private ArrayList<String> namePlayer;
    private final ArrayList<Player> players;
    private final VirtualView virtualView;
    private final UserInput userInput;
    private int numPlayer;
    private boolean lobbyOk;
    private final ArrayList<ClientHandlerIntefrace> clients;
    private boolean lobbySett;
    private boolean joinClient;
    private Controller controller;
    private boolean isExpert;
    private final Object lock;
   private Game game;
    public Lobby() {
        namePlayer = new ArrayList<>();
        virtualView = new VirtualView();
        userInput=new UserInput();
        clients = new ArrayList<>();
        players=new ArrayList<>();
        numPlayer = -1;
        lobbyOk = false;
        lobbySett = false;
        joinClient = false;
        virtualView.addObserver(userInput);

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
        Thread thread =new Thread(()->{
            Lobby lobby=new Lobby();
            lobby.addClient(client);
        });
        thread.start();
    }
    public void addClient(ClientHandlerIntefrace client){
        synchronized (lock) {
            String nick;
            client.addObserver();
            client.add(client);
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
    private void joiningInLobby(ClientHandlerIntefrace client, Lobby lobby){
        Thread thread=new Thread(()->{
            int i;
            for(i=0;!namePlayer.get(i).equals(client.getUserNickname());i++);
            if(namePlayer.get(i).equals(client.getUserNickname())){
                lobby.joinPlayer(client);
            }
        });
        thread.start();
    }
    public boolean isLobbyOk() {
        return lobbyOk;
    }
    public void loginUser(ClientHandlerIntefrace loginClient) {
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