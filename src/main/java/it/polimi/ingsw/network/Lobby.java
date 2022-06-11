package it.polimi.ingsw.network;

import it.polimi.ingsw.controller.Controller;
import it.polimi.ingsw.controller.PhaseTurn;
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
    private Controller controller;
    private ArrayList<String> namePlayer;
    private ArrayList<Player> players;
    private final VirtualView virtualView;
    private boolean contr;
    private int numPlayers;
    private int numPawnExe;
    private EndGameObserver endGame;
    private boolean lobbyOk;
    private final ArrayList<ClientHandlerInterface> clients;
    private boolean isExpert;
    private boolean numinsert;
    private final Object lock;
    private Game game;
    private final ServerMessageMenager serverMessageMenager;
    public Lobby() {
        lock = new Object();
        namePlayer = new ArrayList<>();
        virtualView = new VirtualView();
        clients = new ArrayList<>();
        players = new ArrayList<>();
        numinsert=false;
        numPlayers = 0;
        contr=false;
        lobbyOk = false;
        serverMessageMenager=new ServerMessageMenager(this);
        numPawnExe=0;
    }

    public ArrayList<ClientHandlerInterface> getClients() {
        return clients;
    }
    public Controller getController() {
        return controller;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void addClient(ClientHandlerInterface client) {
        synchronized (lock) {
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
        controller = new Controller(game, virtualView, clients);
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

    public synchronized void selectAssistantCard(int assistant, ClientHandler clientHandler) {// modificare la funzione in player. se non viene eliminato come lo gestisco?
            int i;
            int contr = -1;
            i = findPlayer(game, clientHandler);
            contr = game.getPlayers().get(i).useAssistant(game, game.getPlayers().get(i), game.getPlayers().get(i).getDeckAssistant().get(assistant));
            if (contr == 0) {
                clientHandler.sendObject(new WrongNotAssistantMessage(controller.getRoundController().getRoundOrder().get(i).getNickname()));
            } else if (contr == 1) {
                virtualView.sendBroadcast(new AllUpdateMessage(game.getLightGame()));
                if (Objects.equals(controller.getPlayers().get(players.size()-1).getNickname(), clientHandler.getUserNickname())) {
                   players= controller.getRoundController().newRoundOrder(game);
                   controller.setPlayer(players);
                    controller.setOrderNamePlayers(players);
                    virtualView.sendBroadcast(new TurnOrderMessage(controller.getOrderNamePlayers()));
                    controller.startTurn(players.get(0));
                } else {
                    for(i=0; !Objects.equals(players.get(i).getNickname(), clientHandler.getUserNickname());i++);
                    virtualView.sendBroadcast(new SetAssistantMessage(players.get(i+1).getNickname()));
                }
            } else if (contr == 2) {
                clientHandler.sendObject(new WrongSameAssistantMessage(controller.getRoundController().getRoundOrder().get(i).getNickname()));
            }
    }

    public synchronized void useCharacter(int num, int numberPawn, int numIsland, ArrayList<ColorPawn> colorPawn, ClientHandler clientHandler,boolean v) {
        if (v) {
            Island island = null;
            if (numIsland != -1) {
                island = game.getIslands().get(numIsland);
            }
            game.getCharacterCards().get(num).getUseEffect().useEffect(game, numberPawn, island, game.getPlayers().get(findPlayer(game, clientHandler)), colorPawn);
            clientHandler.sendObject(new AllUpdateMessage(game.getLightGame()));
        }
            if (game.getPlayers().get(findPlayer(game, clientHandler)).getCurrentPhase() == PhaseTurn.USE_CHARACTER) {
                game.getPlayers().get(findPlayer(game, clientHandler)).setCurrentPhase(PhaseTurn.END_TURN);
            }
            int i;
            for (i = 0; !Objects.equals(controller.getRoundController().getRoundOrder().get(i).getNickname(), clientHandler.getUserNickname()); i++);
            controller.startTurn(game.getPlayers().get(findPlayer(game,clientHandler)));
    }

    public int findPlayer(Game game, ClientHandler clientHandler) {
        int i;
        for (i = 0; i < game.getPlayers().size(); i++) {
            if (Objects.equals(game.getPlayers().get(i).getNickname(), clientHandler.getUserNickname())) {
                return i;
            }
        }
        return i = -1;
    }

    public synchronized void selectCloud(int cloud, ClientHandler clientHandler) {
        if(game.getPlayers().get(findPlayer(game,clientHandler)).getCurrentPhase()==PhaseTurn.CHOOSE_CLOUD) {
            game.getPlayers().get(findPlayer(game, clientHandler)).getEntrance().chooseCloud(game.getClouds().get(cloud), game, game.getPlayers().get(findPlayer(game, clientHandler)));
            game.getPlayers().get(findPlayer(game,clientHandler)).setCurrentPhase(PhaseTurn.USE_CHARACTER);
            virtualView.sendBroadcast(new AllUpdateMessage(game.getLightGame()));
            controller.startTurn(game.getPlayers().get(findPlayer(game,clientHandler)));
        }else{
            clientHandler.sendObject(new WrongTurnMessage());
        }

    }
    public synchronized void moveMotherNature(int island, ClientHandler clientHandler) {
        Player player;
        if(game.getPlayers().get(findPlayer(game,clientHandler)).getCurrentPhase()== PhaseTurn.MOVE_MOTHER_NATURE) {
            int i;
            for(i=0;!game.getIslands().get(i).getMotherNature();i++);
            i += island;
            if(i>game.getIslands().size()-1){
                i=i-game.getIslands().size()-1;
            }
            game.moveMotherNature(game.getIslands().get(i));
            game.topInfluence(game.getIslands().get(i),game);
            if(controller.getCounterRound()==10) {
                player=game.finish(true);
            }else{
                player=game.finish(false);
            }
            if(player==null) {
                virtualView.sendBroadcast(new AllUpdateMessage(game.getLightGame()));
                game.getPlayers().get(findPlayer(game, clientHandler)).setCurrentPhase(PhaseTurn.CHOOSE_CLOUD);
                controller.startTurn(game.getPlayers().get(findPlayer(game, clientHandler)));
            }else{
                virtualView.sendBroadcast(new WinnerMessage(player.getNickname()));
                //endGame.administrEndGame();
            }
        }else{
            clientHandler.sendObject(new WrongTurnMessage());
        }
    }

    public synchronized void movePawnToDining(int numPawn, ArrayList<ColorPawn> arrayPawn, ClientHandler clientHandler) {
        int i;//questa funzione muove le pedine verso la diningroom attraverso la funzione addPawnToDiningRoom (riga 303), fa l'update di tutto e poi chiama la funzione movement (riga 306), se non è il suo turno manda un messaggio di errore (non pensarci per adesso)
        int numPlayer = findPlayer(game, clientHandler);
        if(game.getPlayers().get(numPlayer).getCurrentPhase()==PhaseTurn.MOVE_STUDENT) {
            for (i = 0; i < numPawn; i++) {
                game.getPlayers().get(numPlayer).getDiningRoom().addPawnToDiningRoom(arrayPawn.get(i), game.getPlayers().get(numPlayer), game);
                game.moveProf();
            }
            virtualView.sendBroadcast(new AllUpdateMessage(game.getLightGame()));
            movement(numPawn, clientHandler, numPlayer);
        }else{
            clientHandler.sendObject(new WrongTurnMessage());
        }
    }
    public synchronized void movePawnToIsland(int island, int numPawn, ArrayList<ColorPawn> arrayPawn, ClientHandler clientHandler) {
        int numPlayer = findPlayer(game, clientHandler); //questa funzione è praticamente la "copia" parallela della funzione sopra, solo che sposta le pedine verso una specifica isola
        int i;
        if(game.getPlayers().get(numPlayer).getCurrentPhase()==PhaseTurn.MOVE_STUDENT) {
            for (i = 0; i < numPawn; i++) {
                game.getPlayers().get(numPlayer).getEntrance().movePawnToIsland(arrayPawn.get(i), game.getIslands().get(island), game);
            }
            virtualView.sendBroadcast(new AllUpdateMessage(game.getLightGame()));
            movement(numPawn, clientHandler, numPlayer);
        }else{
            clientHandler.sendObject(new WrongTurnMessage());
        }
    }

    public synchronized void movement(int numPawn, ClientHandler clientHandler, int numPlayer) {
        numPawnExe=numPawnExe+numPawn;// questa funzione gestisce le pedine spostate. ogni volta che arriva un messaggio di movimento, somma le pedine spostate alla variabile numpawnexe.
        if(numPlayers==2||numPlayers==4){
            if(numPawnExe==3){// le pedine sono 3 se i player sono 2 o 4 (ho pensato io a questo sulla CLI riga 264)
                game.getPlayers().get(findPlayer(game,clientHandler)).setCurrentPhase(PhaseTurn.MOVE_MOTHER_NATURE);//setto la fase successiva
                controller.startTurn(game.getPlayers().get(numPlayer));//mando il messaggio broadcast della mothernature
                numPawnExe=0;//setto a zero per permettere lo spostamento al prossimo player
            }else{
                clientHandler.sendObject(new SetMovePawnMessage(clientHandler.getUserNickname(),numPawnExe));//se le pedine totali spostate non sono 3 reinvio il messaggio
            }
        } else if(numPlayers==3) {
            if (numPawnExe == 4) {//le pedine sono 4 se i player sono 3 (ho pensato io a questo sulla CLI riga 267)
                game.getPlayers().get(findPlayer(game,clientHandler)).setCurrentPhase(PhaseTurn.MOVE_MOTHER_NATURE);
                controller.startTurn(game.getPlayers().get(numPlayer));
                numPawnExe=0;
            }else{
                clientHandler.sendObject(new SetMovePawnMessage(clientHandler.getUserNickname(),numPawnExe));//se le pedine totali spostate non sono 4 reinvio il messaggio
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
                    serverMessageMenager.ManageInputToServer(clientHandler, m);
            }else{
                clientHandler.sendObject(new LobbyFullMessage());
                clientHandler.closeConnect(clientHandler.getUserNickname());
                closeConnection(clientHandler);
            }
        }
    }
    }