package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class WinnerSceneController {
    public javafx.scene.text.Text NickPlayer;
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
    //C'è UN BOTTONE CHE TI FA USCIRE NEL FILE FXML. GIUSTO O SBAGLIATO IN BASE ALLA CLI? CONTROLLATE E MODIFICATE IN CASO
    //risolto -> l'ho cancellato :)

}
