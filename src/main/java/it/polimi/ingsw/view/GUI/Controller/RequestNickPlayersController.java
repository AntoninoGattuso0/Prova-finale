package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.network.Message.ClientToServer.RequestNickname;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class
RequestNickPlayersController {
    Gui gui;
    @FXML
    private Pane requestNick;
    @FXML
    private ImageView joinButton;
    @FXML
    private TextField nickname;

    public void setJoinButtonAble() {
        joinButton.setDisable(false);
        joinButton.setVisible(true);
    }

    public void setJoinButtonDisable() {
        joinButton.setVisible(false);
        joinButton.setDisable(true);
    }

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    //Viene Cliccato join: viene inviato il nome al server e il bottone non visibile e non cliccabile
    public void buttonClickNickname(MouseEvent mouseEvent) {
        gui.getSocketNetworkHandler().sendMessage(new RequestNickname(nickname.getText()));
        setJoinButtonDisable();
    }
}
