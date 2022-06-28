package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class WaitingPlayersController {
    Gui gui;
    @FXML  Pane waitingPlayers;

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public void setWaitingPlayers(boolean visible){
            waitingPlayers.setVisible(visible);
    }

}

