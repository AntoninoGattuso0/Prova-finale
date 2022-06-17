package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class SchoolBoard1Controller {
    Gui gui;

    public SchoolBoard1Controller(Gui gui){this.gui=gui;}

    @FXML Pane schoolBoard1;

    public void setSchoolBoard0(boolean visible){
        for(Node schoolBoard : schoolBoard1.getChildren()){
            schoolBoard.setVisible(visible);
        }
    }
}
