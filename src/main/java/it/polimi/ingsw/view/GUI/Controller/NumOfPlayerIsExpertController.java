package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class NumOfPlayerIsExpertController {
    Gui gui;
    public NumOfPlayerIsExpertController(Gui gui){this.gui=gui;}

    @FXML Pane numPlayerIsExpert;

    public void setNumPlayerIsExpert(boolean visible){
        for(Node num : numPlayerIsExpert.getChildren())
            num.setVisible(visible);
    }
}
