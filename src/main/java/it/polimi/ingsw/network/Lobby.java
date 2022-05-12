package it.polimi.ingsw.network;

import it.polimi.ingsw.controller.Controller;
import java.util.ArrayList;
import it.polimi.ingsw.controller.UserInput;
import it.polimi.ingsw.observer.ViewObserver;
import it.polimi.ingsw.view.VirtualView;

public class Lobby {//DA COMPLETARE
    private final VirtualView virtualView;
    private final int numPlayer;
    private boolean lobbyOk;
    private final ArrayList<HandlerClient> clients;
    private boolean lobbySett;
    private Controller controller;
    public Lobby(){
        virtualView=new VirtualView();
        clients=new ArrayList<>();
        numPlayer=-1;
        lobbyOk=false;
        lobbySett=false;
        virtualView.addObserver(UserInput);
    }
}
