package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class CharacterCardController {
    Gui gui;
    public CharacterCardController(Gui gui){
        this.gui=gui;
    }
    @FXML public Pane characterCard;
    public void setDisableAll(){
        for(Node assistant : characterCard.getChildren()){
            assistant.setDisable(true);
        }
    }
}
