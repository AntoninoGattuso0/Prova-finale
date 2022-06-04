package it.polimi.ingsw.view.GUI.warnings;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Objects;

public class GameStarted {

    private Pane rootFXML;

    public GameStarted(){
        try{
            rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/GameStarted.fxml")));
        }catch(
                IOException e){
            e.printStackTrace();
        }
    }

    public Pane getRootFXML() {
        return rootFXML;
    }
}
