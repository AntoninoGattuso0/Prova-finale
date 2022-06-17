package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class SchoolBoard0Controller {
    Gui gui;

    public SchoolBoard0Controller(Gui gui){this.gui=gui;}

    @FXML Pane schoolBoard0;

    public void setSchoolBoard0(boolean visible){
        for(Node schoolBoard : schoolBoard0.getChildren()){
            schoolBoard.setVisible(visible);
        }
    }
}
