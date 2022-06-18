package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class DisplayTurnController {
    Gui gui;

    public DisplayTurnController(Gui gui){this.gui=gui;}

    @FXML Pane displayTurn;

    public void setDisplayTurn(boolean visible) {
        for(Node turn : displayTurn.getChildren())
            turn.setVisible(visible);
    }
}
