package it.polimi.ingsw.network;

import it.polimi.ingsw.controller.Controller;
import java.util.ArrayList;
import it.polimi.ingsw.network.Message.*;
import it.polimi.ingsw.view.VirtualView;

public class Lobby {//DA COMPLETARE
    private final VirtualView virtualView;
    private final int numPlayer;
    private boolean lobbyOk;
    private final ArrayList<HandlerClient> clients;
    private boolean lobbySett;
    private boolean joinClient;
    private Controller controller;

    public Lobby(){
        virtualView=new VirtualView();
        clients=new ArrayList<>();
        numPlayer=-1;
        lobbyOk=false;
        lobbySett=false;
        joinClient=false;
        virtualView.addObserver(UserInput);
    }
    public void loginUser(HandlerClient loginClient){
        String nickname;
        Message nickMessage;
        loginClient.setTurn(true);
        loginClient.sendObject(new SetNickMessage());
        nickMessage=loginClient.read();
        if(nickMessage==null){
            return;
        }
        nickname=((LoginSettMessage) nickMessage ).getNickname();
        joinClient= ((LoginSettMessage) nickMessage).
    }
}
