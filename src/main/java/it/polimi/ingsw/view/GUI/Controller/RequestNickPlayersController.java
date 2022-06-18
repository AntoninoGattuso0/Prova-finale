package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class RequestNickPlayersController {
    Gui gui;
    public RequestNickPlayersController(Gui gui){this.gui=gui;}

    @FXML
    Pane requestNick;

    public void setRequestNick(boolean visible){
        for(Node nick : requestNick.getChildren())
            nick.setVisible(visible);
    }
}
