package it.polimi.ingsw.view.GUI;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class RequestNickPlayers {
    Gui gui;
    @FXML
    private Pane requestNick;
    @FXML public ImageView joinButton;
    public void setJoinButtonAble(){
        joinButton.setDisable(false);
        joinButton.setVisible(true);
    }

    public Pane getRequestNick() {
        return requestNick;
    }

    public void buttonClickNickname(MouseEvent mouseEvent) {
    }
}