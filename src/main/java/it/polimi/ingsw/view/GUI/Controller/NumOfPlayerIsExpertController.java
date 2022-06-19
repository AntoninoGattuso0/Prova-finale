package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.network.Message.ClientToServer.RequestNumPlayersIsExpert;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class NumOfPlayerIsExpertController {
    Gui gui;
    @FXML ChoiceBox<String> numPlayerBox;
    @FXML CheckBox expertMode;
    @FXML ImageView joinButton;
    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public void setNumPlayerIsExpert(boolean visible) {;
        numPlayerBox.getItems().add("2");
        numPlayerBox.getItems().add("3");
        numPlayerBox.getItems().add("4");
        numPlayerBox.setVisible(true);
        expertMode.setVisible(true);
        expertMode.setSelected(true);
        joinButton.setDisable(false);
        joinButton.setVisible(true);
    }

    public void bottomClicked(MouseEvent mouseEvent) {
        int num = -1;
        joinButton.setVisible(false);
        joinButton.setDisable(true);
        switch (numPlayerBox.getValue()) {
            case "2" -> num = 2;
            case "3" -> num = 3;
            case "4" -> num = 4;
        }
        if (num != -1) {
            gui.getSocketNetworkHandler().sendMessage(new RequestNumPlayersIsExpert(num, expertMode.isSelected()));
        } else {
        gui.requestNumPlayersIsExpert();
        }
    }
}
