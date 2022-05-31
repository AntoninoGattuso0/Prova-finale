package it.polimi.ingsw.View.GUI;

import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.network.Message.ClientToServer.RequestNickname;
import it.polimi.ingsw.network.Message.ClientToServer.RequestNumPlayersIsExpert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;


public class NumOfPlayerIsExpert{
    private SocketNetworkHandler socketNetworkHandler;
    private Pane rootFXML;
    private final ImageView readyButton;
    private int numPlayer;
    private boolean expert;
    private String nickname;


    @FXML
    private Label title;
    @FXML
    private Label nick;
    @FXML
    private Label numOfPlayer;
    @FXML
    private Label isExpert;
    @FXML
    private TextField nickPlayer;
    @FXML
    private ComboBox<String> numPlayerBox;
    @FXML
    private CheckBox expertMode;
    @FXML
    private CheckBox notExpertMode;

    public NumOfPlayerIsExpert(){
        try{
            rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/NumOfPlayerIsExpert.fxml")));
        }catch(IOException e){
            e.printStackTrace();
        }

        readyButton = (ImageView) rootFXML.lookup("#readyButton");
        ObservableList<String> numPlayers = FXCollections.observableArrayList("2","3","4");
        numPlayerBox.setItems(numPlayers);

        readyButton.setOnMouseClicked(mouseEvent -> {
            String num = numPlayerBox.getValue();
            switch(num){
                case "2":
                    numPlayer = 2;
                    break;
                case "3":
                    numPlayer = 3;
                    break;
                case "4":
                    numPlayer = 4;
            }
        });

        if(expertMode.isSelected())
            expert = true;
        else if(notExpertMode.isSelected())
            expert = false;

        socketNetworkHandler.sendMessage(new RequestNumPlayersIsExpert(numPlayer, expert));

        nickname = nickPlayer.getText();
        socketNetworkHandler.sendMessage(new RequestNickname(nickname));

    }

    public Pane getRootFXML(){
        return rootFXML;
    }

}