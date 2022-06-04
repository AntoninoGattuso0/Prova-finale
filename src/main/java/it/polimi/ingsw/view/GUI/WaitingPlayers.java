package it.polimi.ingsw.view.GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Objects;

public class WaitingPlayers {

    private Pane rootFXML;

    public WaitingPlayers(){
        try{
            rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/WaitingPlayers.fxml")));
        }catch(
                IOException e){
            e.printStackTrace();
        }
    }

    public Pane getRootFXML() {
        return rootFXML;
    }
}
