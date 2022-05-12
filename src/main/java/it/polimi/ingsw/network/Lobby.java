package it.polimi.ingsw.network;

import it.polimi.ingsw.controller.Controller;
import it.polimi.ingsw.controller.UserInput;
import it.polimi.ingsw.network.Message.*;

import java.util.ArrayList;

public class Lobby {//DA COMPLETARE
    private ArrayList<String> namePlayer;
    private final VirtualView virtualView;
    private final UserInput userInput;
    private int numPlayer;
    private boolean lobbyOk;
    private final ArrayList<ClientHandler> clients;
    private boolean lobbySett;
    private boolean joinClient;
    private Controller controller;
    private boolean isExpert;

    public Lobby() {
        namePlayer = new ArrayList<>();
        virtualView = new VirtualView();
        userInput=new UserInput();
        clients = new ArrayList<>();
        numPlayer = -1;
        lobbyOk = false;
        lobbySett = false;
        joinClient = false;
        virtualView.addObserver(userInput);

    }

    public void loginUser(ClientHandler loginClient) {
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
        }
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