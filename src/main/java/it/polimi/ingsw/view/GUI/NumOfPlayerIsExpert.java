package it.polimi.ingsw.view.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Cursor;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

/*the first player logged has to insert the number of players
    and if the game is expert or not
 */
public class NumOfPlayerIsExpert{
    private Pane rootFXML;
    @FXML
    private final ImageView joinButton;
    private int numPlayer;
    private final boolean expert;
    private final String nickname;

    @FXML
    private TextField nickPlayer;
    @FXML
    private ChoiceBox<String> numPlayerBox;
    @FXML
    private CheckBox expertMode;

    public NumOfPlayerIsExpert(){
        try{
            rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/NumOfPlayerIsExpert.fxml")));
        }catch(IOException e){
            e.printStackTrace();
        }

        joinButton = (ImageView) rootFXML.lookup("#joinButton");
        ObservableList<String> numPlayers = FXCollections.observableArrayList("2","3","4");
        numPlayerBox.setItems(numPlayers);

        joinButton.setOnMouseEntered(mouseEvent -> joinButton.setCursor(javafx.scene.Cursor.HAND));
        joinButton.setOnMouseExited(mouseEvent -> joinButton.setCursor(Cursor.DEFAULT));

        nickname = nickPlayer.getText();
        expert = expertMode.isSelected();

        joinButton.setOnMouseClicked(mouseEvent -> {
            String num = numPlayerBox.getValue();
            switch (num) {
                case "2" -> numPlayer = 2;
                case "3" -> numPlayer = 3;
                case "4" -> numPlayer = 4;
            }
        });
    }

    public Pane getRootFXML(){
        return rootFXML;
    }
    public String getNickname(){
        return nickname;
    }
    public boolean isExpert() {
        return expert;
    }
    public int getNumPlayer() {
        return numPlayer;
    }

}