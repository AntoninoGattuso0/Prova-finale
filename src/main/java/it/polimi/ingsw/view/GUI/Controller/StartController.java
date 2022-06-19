package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class StartController {
    @FXML
    Pane pane;

    public void startGame(Gui gui){
        gui.startGame();
    }
}
