package it.polimi.ingsw.view.GUI;

import it.polimi.ingsw.network.Message.ClientToServer.RequestNickname;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class RequestNickPlayers {
    Gui gui;
    @FXML
    private Pane requestNick;
    @FXML private ImageView joinButton;
    @FXML private TextField nickname;
    public void setJoinButtonAble(){
        joinButton.setDisable(false);
        joinButton.setVisible(true);
    }

    //Viene Cliccato join. viene inviato il nome al server
    public void buttonClickNickname(MouseEvent mouseEvent) {
        gui.getSocketNetworkHandler().sendMessage(new RequestNickname(nickname.getText()));
        System.out.println(nickname.getText());
    }
}