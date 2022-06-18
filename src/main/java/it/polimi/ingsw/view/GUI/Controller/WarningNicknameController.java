package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class WarningNicknameController {
    Gui gui;
    public WarningNicknameController(Gui gui){this.gui=gui;}

    @FXML
    Pane warningNickname;

    public void setWarningNickname(boolean visible){
        for(Node nickname : warningNickname.getChildren())
            nickname.setVisible(visible);
    }
}
