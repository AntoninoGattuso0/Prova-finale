package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class ChooseActionController {
    Gui gui;

    @FXML public Pane chooseAction;

    public void setGui(Gui gui){this.gui = gui;}

    public void setCharacterButton(boolean disabled, boolean visible){
        chooseAction.lookup("characterCardButton").setVisible(visible);
        chooseAction.lookup("characterCardButton").setDisable(disabled);
    }

    public void setMovePawnsBotton(boolean disabled, boolean visible){
        chooseAction.lookup("movePawns").setVisible(visible);
        chooseAction.lookup("movePawns").setDisable(disabled);
    }
}
