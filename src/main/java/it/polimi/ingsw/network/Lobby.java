package it.polimi.ingsw.network;

import it.polimi.ingsw.controller.Controller;
import it.polimi.ingsw.controller.UserInput;
import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.Island;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.network.Message.Message;
import it.polimi.ingsw.network.Message.ServerToClient.*;
import it.polimi.ingsw.network.Message.UpdateMessage.AllUpdateMessage;
import it.polimi.ingsw.observer.ConnectionObserver;
import it.polimi.ingsw.observer.EndGameObserver;

import java.util.ArrayList;
import java.util.Objects;

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
    private final ServerMessageMenager serverMessageMenager;

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
        serverMessageMenager=new ServerMessageMenager(this);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public boolean isLobbySett() {
        return lobbySett;
    }

    public void addClient(ClientHandlerInterface client) {
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
                client.sendObject(new GameStartedMessage());
                lobbyOk = true;
            }
            lock.notifyAll();
        }
        if (lobbyOk) {
            newGame(game);
        }
    }

    @Override
    public void updateDisconnection(ClientHandlerInterface clientHandler) {
        if (controller.getEndGame() != true) {
            if (lobbySett) {
                updateDisconnectionInSet(clientHandler);
            } else if (lobbyOk) {
                updateDisconnectionInGame(clientHandler);
            }
        } else {
            closeConnection(clientHandler);
            if (clients.size() == 1 || clients.size() == 0) {
                endGame.administrEndGame();
            }
        }
    }

    private synchronized void closeConnection(ClientHandlerInterface clientHandler) {
        System.out.println("Server unregistering client.");
        virtualView.removeClientInVirtualView(clientHandler, clientHandler.getUserNickname());
        players.remove(getPlayerByNick(clientHandler.getUserNickname()));
        clients.remove(clientHandler);
        System.out.println(clientHandler.getUserNickname() + "'s client unregistered\n");
    }

    private void updateDisconnectionInSet(ClientHandlerInterface clientHandler) {
        System.out.println("A client disconnects in set-phase. The lobby is closed\n");
        deregisterConn(clientHandler);
        if (players.size() == 1) {
            endGame.administrEndGame();
        } else {
            controller.AdministrDisconnectionInSet(clientHandler.getUserNickname());
        }
    }

    private Player getPlayerByNick(String nick) {
        for (Player player : players) {
            if (player.getNickname().equals(nick)) {
                return player;
            }
        }
        return null;
    }

    private void updateDisconnectionInGame(ClientHandlerInterface clientHandler) {
        int i, c = 0;
        getPlayerByNick(clientHandler.getUserNickname()).setActive(false);
        virtualView.sendAllQuitPlayer(clientHandler.getUserNickname());
        for (i = 0; i < players.size(); i++) {
            if (players.get(i).getActive()) {
                c++;
            }
        }
        if (c == 0) {
            deregisterConn(clientHandler);
            endGame.administrEndGame();
        } else if (c == 1) {
            System.out.println("Only one active player in start game");
            controller.administrEnd();
        }
    }

    private void deregisterConn(ClientHandlerInterface clientHandler) {
    }

    public boolean isLobbyOk() {
        return lobbyOk;
    }

    //inserisco i player nell'array nomi, e li creo anche nel gioco
    public synchronized void loginUser(ClientHandlerInterface loginClient) {
        loginClient.setTurn(true);
        if(numPlayer==0) {
            loginClient.sendObject(new SetNickMessage());
        }
    }

    public void endGame(Lobby lobby) {
        for (String nickname : namePlayer) {
            namePlayer.remove(nickname);
        }
        lobby = null;
    }

    public void newGame(Game game) {
        controller = new Controller(game, userInput, virtualView, players);
        controller.sendUpdate();
    }

    public synchronized void insertNickname(String nickname, ClientHandler clientHandler) {
            if (nickname == null) {
                clientHandler.sendObject(new WrongNicknameMessage());
                clientHandler.sendObject(new SetNickMessage());
                return;
            } else {
                int i;
                for (i = 0; i < namePlayer.size(); i++) {
                    if (nickname == namePlayer.get(i)) {
                        clientHandler.sendObject(new WrongNicknameMessage());
                        clientHandler.sendObject(new SetNickMessage());
                        return;
                    }
                }
                namePlayer.add(nickname);
                clientHandler.setUserNickname(nickname);
                if (namePlayer.size() == 1) {
                    clientHandler.sendObject(new SetNumPlayersIsExpertMessage());
                    return;
                }
                Game.newPlayer(nickname, game);
                System.out.println("SERVER: " + nickname + " is joining!\n");
                clientHandler.sendObject(new LoginAcceptedMessage());
                clientHandler.setTurn(false);
                addClient(clientHandler);
            }
        }

    public synchronized void insertNumPlayersIsExpert(int numPlayers, boolean isExpert, ClientHandler clientHandler) {
        if (numPlayer < 2 || numPlayer > 4) {
            clientHandler.sendObject(new WrongNumPlayerIsExpertMessage());
            clientHandler.sendObject(new SetNumPlayersIsExpertMessage());
            return;
        }
        game = new Game(numPlayer, isExpert);
        Game.newPlayer(namePlayer.get(0), game);
        System.out.println("SERVER: " + namePlayer.get(0) + " is joining!\n");
        clientHandler.sendObject(new LoginAcceptedMessage());
        clientHandler.setTurn(false);
        addClient(clientHandler);
    }

    public void selectAssistantCard(int assistant, ClientHandler clientHandler) {
        int i;
        int contr = -1;
        for (i = 0; i < namePlayer.size(); i++) {
            if (game.getPlayers().get(i).getNickname() == clientHandler.getUserNickname()) {
                contr = game.getPlayers().get(i).useAssistant(game, game.getPlayers().get(i), game.getPlayers().get(i).getDeckAssistant().get(assistant));
            }
        }
        if (contr == 0) {
            clientHandler.sendObject(new WrongNotAssistantMessage());
        } else if (contr == 1) {
            clientHandler.sendObject(new AllUpdateMessage(game.getLightGame()));
        } else if (contr == 2) {
            clientHandler.sendObject(new WrongSameAssistantMessage());
        }
    }

    public void useCharacter(int num, int numberPawn, int numIsland, ArrayList<ColorPawn> colorPawn, ClientHandler clientHandler) {
        int i;
        int c;
        Island island = null;
        if (numIsland != -1) {
            island = game.getIslands().get(numIsland);
        }
        game.getCharacterCards().get(num - 1).getUseEffect().useEffect(game, numberPawn, island, game.getPlayers().get(findPlayer(game, clientHandler)), colorPawn);
        clientHandler.sendObject(new AllUpdateMessage(game.getLightGame()));
    }

    public int findPlayer(Game game, ClientHandler clientHandler) {
        int i;
        for (i = 0; i < namePlayer.size(); i++) {
            if (Objects.equals(game.getPlayers().get(i).getNickname(), clientHandler.getUserNickname())) {
                return i;
            }
        }
        return i = -1;
    }

    public void selectCloud(int cloud, ClientHandler clientHandler) {
        int i;
        game.getPlayers().get(findPlayer(game, clientHandler)).getEntrance().chooseCloud(game.getClouds().get(cloud), game, game.getPlayers().get(findPlayer(game, clientHandler)));
        clientHandler.sendObject(new AllUpdateMessage(game.getLightGame()));
    }
    public void moveMotherNature(int island, ClientHandler clientHandler) {
        Island island1 = game.getIslands().get(island);
        game.moveMotherNature(island1);
        clientHandler.sendObject(new AllUpdateMessage(game.getLightGame()));
    }

    public void movePawnToDining(int numPawn, ArrayList<ColorPawn> arrayPawn, ClientHandler clientHandler) {
        int i;
        int numplayer = findPlayer(game, clientHandler);
        for (i = 0; i < numPawn; i++) {
            game.getPlayers().get(numplayer).getDiningRoom().addPawnToDiningRoom(arrayPawn.get(i), game.getPlayers().get(numplayer), game);
        }
        clientHandler.sendObject(new AllUpdateMessage(game.getLightGame()));
    }

    public void movePawnToIsland(int island, int numPawn, ArrayList<ColorPawn> arrayPawn, ClientHandler clientHandler) {
        int numPlayer = findPlayer(game, clientHandler);
        int i;
        for (i = 0; i < numPawn; i++) {
            game.getPlayers().get(numPlayer).getEntrance().movePawnToIsland(arrayPawn.get(i), game.getIslands().get(island), game);
        }
        clientHandler.sendObject(new AllUpdateMessage(game.getLightGame()));
    }

    public void processMessage(ClientHandler clientHandler, Message m) {
        if(!lobbyOk){
                serverMessageMenager.ManageInputToServer(clientHandler, m);
        }else{
            if(Objects.equals(clientHandler.getUserNickname(), controller.getRoundController().getTurnController().getCurrPlayer().getNickname())){
                serverMessageMenager.ManageInputToServer(clientHandler,m);
            }else{
                clientHandler.sendObject(new WrongTurnMessage());
            }
        }
    }
}