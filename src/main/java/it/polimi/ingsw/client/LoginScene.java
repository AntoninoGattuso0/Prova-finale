package it.polimi.ingsw.client;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginScene {

    public TextField usernameBox;
    public TextField serverIpBox;
    public TextField serverPortBox;
    public Button connectBtn;

    public void inizialize(){
        serverIpBox.setText("127.0.0.1");
        serverPortBox.setText("5555");
    }

    public void connectButtonClicked(ActionEvent event){
        if(usernameBox.getText().length() == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Inserisci username valido ", ButtonType.OK);
            alert.showAndWait();
            return;
        }


    }
}
