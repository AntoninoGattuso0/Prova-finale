package it.polimi.ingsw.view.Gui;

import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.network.Message.ClientToServer.RequestNickname;
import it.polimi.ingsw.view.GUI.warnings.WarningNickname;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class RequestNickPlayers {

    private SocketNetworkHandler socketNetworkHandler;
    private Pane rootFXML;
    private String nick;
    private final ImageView joinButton;

    @FXML
    private TextField nickPlayer;

    public RequestNickPlayers(){

        try{
            rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML/RequestNickPlayers.fxml")));
        }catch(IOException e){
            e.printStackTrace();
        }

        joinButton = (ImageView) rootFXML.lookup("#joinButton");

        joinButton.setOnMouseEntered(mouseEvent -> joinButton.setCursor(Cursor.HAND));
        joinButton.setOnMouseExited(mouseEvent -> joinButton.setCursor(Cursor.DEFAULT));

        joinButton.setOnMouseClicked(mouseEvent -> {
            nick = nickPlayer.getText();
            if(nick!=null) socketNetworkHandler.sendMessage(new RequestNickname(nick));
            else new WarningNickname();
        });

    }

    public Pane getRootFXML(){
        return rootFXML;
    }

}