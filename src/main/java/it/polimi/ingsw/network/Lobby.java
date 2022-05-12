package it.polimi.ingsw.network;

import it.polimi.ingsw.controller.Controller;
import java.util.ArrayList;

import it.polimi.ingsw.network.Message.*;
import it.polimi.ingsw.view.VirtualView;

public class Lobby {//DA COMPLETARE
    private ArrayList<String> name;
    private final VirtualView virtualView;
    private final int numPlayer;
    private boolean lobbyOk;
    private final ArrayList<HandlerClient> clients;
    private boolean lobbySett;
    private boolean joinClient;
    private Controller controller;

    public Lobby() {
        name = new ArrayList<>();
        virtualView = new VirtualView();
        clients = new ArrayList<>();
        numPlayer = -1;
        lobbyOk = false;
        lobbySett = false;
        joinClient = false;
        virtualView.addObserver(UserInput);
    }

    public void loginUser(HandlerClient loginClient) {
        int i = 0;
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
        for (i = 0; i < name.size(); i++) {
            while (name.get(i) == nickname) {
                loginClient.sendObject(new SetNickMessage());
                nickMessage = loginClient.read();
                if (nickMessage == null) {
                    return;
                }
                nickname = ((LoginSettMessage) nickMessage).getNickname();
                joinClient = ((LoginSettMessage) nickMessage).getJoin();
            }
        }
        name.add(nickname);
        loginClient.setUserNickname(nickname);
        System.out.println("SERVER: "+nickname+" is joining!\n");
        loginClient.sendObject(new LoginAccepted(nickname));
        if(name.size()==1){
            int num;
            boolean isExpert;
            loginClient.sendObject(new SetNumPlayers());
            num=((LoginNumPlayerIsExp) nickMessage).getNumPlayers();
        }
        loginClient.setTurn(false);
    }
}