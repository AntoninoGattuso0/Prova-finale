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

public class Lobby implements ConnectionObserver {//DA COMPLETARE: PROMEMORIA----
    private Controller controller;                 //SETTARE I BOOLEANI PER IL ROUNDCONTROLLER -DA NINO PER NINO
    private ArrayList<String> namePlayer;
    private ArrayList<Player> players;
    private final VirtualView virtualView;
    private final UserInput userInput;
    private boolean contr;
    private int numPlayers;
    private int numPawnExe;
    private EndGameObserver endGame;
    private boolean lobbyOk;
    private final ArrayList<ClientHandlerInterface> clients;
    private boolean lobbySett;
    private boolean isExpert;
    private boolean numinsert;
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
        numinsert=false;
        numPlayers = 0;
        contr=false;
        lobbyOk = false;
        lobbySett = false;
        serverMessageMenager=new ServerMessageMenager(this);
        numPawnExe=0;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public boolean isLobbySett() {
        return lobbySett;
    }

    public void addClient(ClientHandlerInterface client) {
        synchronized (lock) {
            client.addObserver(this);
            clients.add(client);
            int i;
            for (i = 0; i < clients.size() && clients.get(i) != client; i++) ;
            client.setUserNickname(namePlayer.get(i));
            virtualView.addClientInVirtualView(client);
            if (clients.size() != numPlayers) {
                client.sendObject(new ClientAcceptedMessage());
                client.sendObject(new WaitMessage());
            } else {
                this.players = game.getPlayers();
                client.sendObject(new ClientAcceptedMessage());
                client.sendObject(new LoginAcceptedMessage());
                lobbyOk = true;
            }
            if (lobbyOk) {
                virtualView.sendBroadcast(new AllUpdateMessage(game.getLightGame()));
                virtualView.sendBroadcast(new GameStartedMessage());
                newGame(game);
            }
            lock.notifyAll();
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
        virtualView.removeClientInVirtualView(clientHandler);
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
                loginClient.sendObject(new SetNickMessage());
    }

    public void endGame(Lobby lobby) {
        for (String nickname : namePlayer) {
            namePlayer.remove(nickname);
        }
        lobby = null;
    }

    public void newGame(Game game) {
        controller = new Controller(game, userInput, virtualView, players, clients);
        controller.sendUpdate();
        controller.startRound();
    }

    public synchronized void insertNickname(String nickname, ClientHandler clientHandler) {
            if (!contr || numinsert) {
                if (nickname == null) {
                    clientHandler.sendObject(new WrongNicknameMessage());
                    clientHandler.sendObject(new SetNickMessage());
                    return;
                } else {
                    contr = true;
                    int i;
                    if (numinsert && namePlayer.size() == numPlayers) {
                        clientHandler.sendObject(new LobbyFullMessage());
                        clientHandler.closeConnect(nickname);
                        return;
                    }
                    for (i = 0; i < namePlayer.size(); i++) {
                        if (nickname.equals(namePlayer.get(i))) {
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
                    game.newPlayer(nickname, game);
                    System.out.println("SERVER: " + nickname + " is joining!\n");
                    clientHandler.setTurn(false);
                    addClient(clientHandler);
                }
            } else {
                clientHandler.sendObject(new WaitLoginMessage(nickname));
            }
    }

    public synchronized void insertNumPlayersIsExpert(int numPlayers, boolean isExpert, ClientHandler clientHandler) {
            if (numPlayers < 2 || numPlayers > 4) {
                clientHandler.sendObject(new WrongNumPlayerIsExpertMessage());
                clientHandler.sendObject(new SetNumPlayersIsExpertMessage());
                return;
            }
            this.numPlayers = numPlayers;
            this.isExpert = isExpert;
            game = new Game(numPlayers, isExpert);
            game.start(game);
            game.newPlayer(namePlayer.get(0), game);
            System.out.println("SERVER: " + namePlayer.get(0) + " is joining!\n");
            clientHandler.setTurn(false);
            addClient(clientHandler);
            numinsert = true;
        }

    public void selectAssistantCard(int assistant, ClientHandler clientHandler) {
        int i;
        int contr = -1;
        //POTREI METTERE UN CONTROLLO LATO SERVER MA NON SERVE DATO CHE C'è GIà LATO CLIENT NINO PER NINO
                for (i=0;!Objects.equals(game.getPlayers().get(i).getNickname(), clientHandler.getUserNickname());i++);
                    if (Objects.equals(game.getPlayers().get(i).getNickname(), clientHandler.getUserNickname())) {
                        contr = game.getPlayers().get(i).useAssistant(game, game.getPlayers().get(i), game.getPlayers().get(i).getDeckAssistant().get(assistant));
                    }
            if (contr == 0) {
                clientHandler.sendObject(new WrongNotAssistantMessage());
            } else if (contr == 1) {
                if(controller.getRoundController().getLastPlayer()!=controller.getRoundController().getRoundOrder().get(i))
                controller.getRoundController().getTurnController().setCurrPlayer(controller.getRoundController().getRoundOrder().get(i+1));
                controller.getRoundController().getTurnController().setPhaseTurn(game.getPlayers().get(i),true,controller.getRoundController(),game);
                clientHandler.sendObject(new AllUpdateMessage(game.getLightGame()));
                if(i==numPlayers-1){
                            return;
                }else
                virtualView.sendBroadcast(new SetAssistantMessage(controller.getRoundController().getRoundOrder().get(i+1).getNickname()));
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
        controller.getRoundController().setExeCharacterCard(true);
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
        controller.getRoundController().setExeChooseCloud(true);
        clientHandler.sendObject(new AllUpdateMessage(game.getLightGame()));

    }
    public void moveMotherNature(int island, ClientHandler clientHandler) {
        Island island1 = game.getIslands().get(island);
        game.moveMotherNature(island1);
        controller.getRoundController().setExeMoveMotherNature(true);
        clientHandler.sendObject(new AllUpdateMessage(game.getLightGame()));

    }

    public void movePawnToDining(int numPawn, ArrayList<ColorPawn> arrayPawn, ClientHandler clientHandler) {
        int i;
        int numplayer = findPlayer(game, clientHandler);
        for (i = 0; i < numPawn; i++) {
            game.getPlayers().get(numplayer).getDiningRoom().addPawnToDiningRoom(arrayPawn.get(i), game.getPlayers().get(numplayer), game);
        }
        clientHandler.sendObject(new AllUpdateMessage(game.getLightGame()));
        numPawnExe=numPawnExe+numPawn;
        if(numPlayers==2||numPlayers==4){
            if(numPawnExe==3){
                controller.getRoundController().setExeMoveStudent(true);
                numPawnExe=0;
            }else{
                clientHandler.sendObject(new SetMovePawnMessage(clientHandler.getUserNickname(),numPawnExe));
            }
        } else if(numPlayers==3) {
            if(numPawnExe==4) {
                controller.getRoundController().setExeMoveStudent(true);
                numPawnExe=0;
            }else {
                clientHandler.sendObject(new SetMovePawnMessage(clientHandler.getUserNickname(),numPawnExe));
            }
        }
        }
    public void movePawnToIsland(int island, int numPawn, ArrayList<ColorPawn> arrayPawn, ClientHandler clientHandler) {
        int numPlayer = findPlayer(game, clientHandler);
        int i;
        for (i = 0; i < numPawn; i++) {
            game.getPlayers().get(numPlayer).getEntrance().movePawnToIsland(arrayPawn.get(i), game.getIslands().get(island), game);
        }
        clientHandler.sendObject(new AllUpdateMessage(game.getLightGame()));
        numPawnExe=numPawnExe+numPawn;
        if(numPlayers==2||numPlayers==4){
            if(numPawnExe==3){
                controller.getRoundController().setExeMoveStudent(true);
                numPawnExe=0;
            }else{
                clientHandler.sendObject(new SetMovePawnMessage(clientHandler.getUserNickname(),numPawnExe));
            }
        } else if(numPlayers==3) {
            if (numPawnExe == 4) {
                controller.getRoundController().setExeMoveStudent(true);
                numPawnExe=0;
            }else{
                clientHandler.sendObject(new SetMovePawnMessage(clientHandler.getUserNickname(),numPawnExe));
            }
        }
    }

    public void processMessage(ClientHandler clientHandler, Message m) {
        if(!lobbyOk){
                serverMessageMenager.ManageInputToServer(clientHandler, m);
        }else{
            int i;
            i=findPlayer(game,clientHandler);
            if(i!=-1) {
                if (Objects.equals(clientHandler.getUserNickname(), controller.getRoundController().getTurnController().getCurrPlayer().getNickname())) {
                    serverMessageMenager.ManageInputToServer(clientHandler, m);
                } else {
                    clientHandler.sendObject(new WrongTurnMessage());
                }
            }else{
                clientHandler.sendObject(new LobbyFullMessage());
                clientHandler.closeConnect(clientHandler.getUserNickname());
                closeConnection(clientHandler);
            }
        }
    }
}