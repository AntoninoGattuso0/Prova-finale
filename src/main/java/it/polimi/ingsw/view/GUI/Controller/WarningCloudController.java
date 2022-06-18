package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class WarningCloudController {
    Gui gui;
    public WarningCloudController(Gui gui){this.gui=gui;}

    @FXML
    Pane warningCloud;

    public void setWarningCloud(boolean visible){
        for(Node cloud : warningCloud.getChildren())
            cloud.setVisible(visible);
    }
}
