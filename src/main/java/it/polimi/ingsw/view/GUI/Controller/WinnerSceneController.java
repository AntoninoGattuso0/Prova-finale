package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * Controller for the winner's scene
 */
public class WinnerSceneController {
    @FXML javafx.scene.text.Text NickPlayer;
    Gui gui;
    @FXML
    Pane winnerScene;
    public void setGui(Gui gui) {
        this.gui = gui;
    }
    public void setWinnerScene(boolean visible){
        for(Node winner : winnerScene.getChildren())
            winner.setVisible(visible);
    }
    public void setNicknameWinner(String nick){
        NickPlayer.setText(nick);
    }

}

