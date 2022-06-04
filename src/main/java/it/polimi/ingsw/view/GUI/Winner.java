package it.polimi.ingsw.view.GUI;

import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.network.Message.ClientToServer.RequestNickname;
import it.polimi.ingsw.view.GUI.warnings.WarningNickname;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;

public class Winner {
    private SocketNetworkHandler socketNetworkHandler;
    private Pane rootFXML;
    private final ImageView exitButton;

    public Winner(String nick){
        try{
            rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/RequestNickPlayers.fxml")));
        }catch(
        IOException e){
            e.printStackTrace();
        }

        Text NickWinner = (Text) rootFXML.lookup("#nickPlayer");
        exitButton = (ImageView) rootFXML.lookup("#exitButton");
        exitButton.setOnMouseEntered(mouseEvent -> exitButton.setCursor(Cursor.HAND));
        exitButton.setOnMouseExited(mouseEvent -> exitButton.setCursor(Cursor.DEFAULT));

        exitButton.setOnMouseClicked(mouseEvent -> {
           //funzione del clientManager
        });
    }

}
