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


        joinButton = (ImageView) rootFXML.lookup("#joinButton");  //questo è l'id che permette di accedere all'immagine selezionabile chiamata joinButton, vedi cartella images
        ObservableList<String> numPlayers = FXCollections.observableArrayList("2","3","4");  // Lista contentente il numero di players che puo essere selezionato
        numPlayerBox.setItems(numPlayers);  //setta i numeri 2,3,4 all'interno del menu a tendina

        //se entra dentro l'immagine del bottone il cursore diventa a forma di mano
        joinButton.setOnMouseEntered(mouseEvent -> joinButton.setCursor(javafx.scene.Cursor.HAND));
        //se esce dall'immagine del bottone il cursore diventa normale freccia
        joinButton.setOnMouseExited(mouseEvent -> joinButton.setCursor(Cursor.DEFAULT));

        //prende il nick che l'utente inserisce all'interno del textField
        nickname = nickPlayer.getText();
        //se l'utente schiaccia il bottone della modalita E allora questo diventa true
        expert = expertMode.isSelected();

        //quando sciacchia l'immagine del join allora prende il valore del num of players che ce dentro il menu a tendina e li mette dentro un int
        joinButton.setOnMouseClicked(mouseEvent -> {
            String num = numPlayerBox.getValue();
            switch (num) {
                case "2" -> numPlayer = 2;
                case "3" -> numPlayer = 3;
                case "4" -> numPlayer = 4;
            }
        });
    }

//queste funzioni ritornano i valori che vengono settati all'interno del costruttore e li restituisce ai metodi della gui
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