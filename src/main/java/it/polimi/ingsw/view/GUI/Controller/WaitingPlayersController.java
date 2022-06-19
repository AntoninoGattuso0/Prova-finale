package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class WaitingPlayersController {
    Gui gui;
    public WaitingPlayersController(Gui gui){this.gui=gui;}

    @FXML
    Pane waitingPlayers;

    public void setWaitingPlayers(boolean visible){
        for(Node players : waitingPlayers.getChildren())
            players.setVisible(visible);
    }
}