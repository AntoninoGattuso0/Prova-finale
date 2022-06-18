package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class WinnerSceneController {
    Gui gui;
    public  WinnerSceneController(Gui gui){this.gui=gui;}

    @FXML
    Pane winnerScene;

    public void setWinnerScene(boolean visible){
        for(Node winner : winnerScene.getChildren())
            winner.setVisible(visible);
    }
}
