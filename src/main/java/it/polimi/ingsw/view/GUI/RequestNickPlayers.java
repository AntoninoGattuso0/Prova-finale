package it.polimi.ingsw.view.GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class RequestNickPlayers {

    private Pane rootFXML;
    private String nick;
    private final ImageView joinButton;

    @FXML
    private TextField nickPlayer;

    public RequestNickPlayers(){

        try{ //mette
            rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/RequestNickPlayers.fxml")));
        }catch(IOException e){
            e.printStackTrace();
        }

        joinButton = (ImageView) rootFXML.lookup("#joinButton"); // vedi per le righe 33-36 i commenti di numOfPlayerIsExpert

        joinButton.setOnMouseEntered(mouseEvent -> joinButton.setCursor(Cursor.HAND));
        joinButton.setOnMouseExited(mouseEvent -> joinButton.setCursor(Cursor.DEFAULT));

        //prende dal texField il nome del player nel momento in cui schiaccia l'immagine join
        joinButton.setOnMouseClicked(mouseEvent -> nick = nickPlayer.getText());

    }

    public Pane getRootFXML(){
        return rootFXML;
    }

    public String getNick(){
        return nick;
    }
}