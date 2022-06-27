package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class WarningNicknameController {
    Gui gui;

    @FXML Pane warningNickname;
    @FXML ImageView okButton;
    public void setGui(Gui gui) {
        this.gui = gui;
    }
    public void setWarningNickname(boolean visible){
            warningNickname.setVisible(visible);
    }
    public void setOkButton(){
        okButton.setDisable(false);
        okButton.setVisible(true);
    }

    public void onButtonClicked(MouseEvent mouseEvent) {
        gui.requestNickname();
    }
}
