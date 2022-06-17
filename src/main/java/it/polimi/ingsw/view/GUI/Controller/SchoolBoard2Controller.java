package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class SchoolBoard2Controller {
    Gui gui;

    public SchoolBoard2Controller(Gui gui){this.gui=gui;}

    @FXML Pane schoolBoard2;

    public void setSchoolBoard2(boolean visible){
        for(Node schoolBoard : schoolBoard2.getChildren()){
            schoolBoard.setVisible(visible);
        }
    }
}
