package it.polimi.ingsw.view.GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Objects;

//apre il file contente la scena in cui cè scritto che si aspettano altri giocatori

public class WaitingPlayers {

    private Pane rootFXML;

    public WaitingPlayers(){
        try{
            rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/WaitingPlayers.fxml")));
        }catch(
                IOException e){
            e.printStackTrace();
        }
    }

    public Pane getRootFXML() {
        return rootFXML;
    }
}
