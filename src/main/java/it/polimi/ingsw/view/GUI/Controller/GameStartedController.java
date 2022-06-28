package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class GameStartedController {
    Gui gui;
    @FXML Pane gameStarted;

    public void setGameText(boolean visible){
        for(Node game : gameStarted.getChildren()){
            game.setVisible(visible);
        }
    }
    public void setGui(Gui gui) {
        this.gui = gui;
    }
}
