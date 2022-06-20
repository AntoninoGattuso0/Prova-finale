/*
package it.polimi.ingsw.view.GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;

//apre la scena in cui ce scritto chi è il vincitore
public class WinnerScene {
    private Pane rootFXML;
    private final ImageView exitButton;

    public WinnerScene(String nickPlayerWinner){
        try{
            rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/WinnerScene.fxml")));
        }catch(
        IOException e){
            e.printStackTrace();
        }

        Text nickWinner = (Text) rootFXML.lookup("#nickPlayer");  //id del testo modificabile in cui si mette il nome del player
        nickWinner.setText(nickPlayerWinner);  //qua si scrive il nome del vincitore all'interno della scena in base a quello che viene passato come ingresso del costruttore, vedi anche la funzione associata in gui
        exitButton = (ImageView) rootFXML.lookup("#exitButton");  //id del bottone exit
        exitButton.setOnMouseEntered(mouseEvent -> exitButton.setCursor(Cursor.HAND));  //qua solita cosa del cursore che cambia se arriva sopra l'immagine
        exitButton.setOnMouseExited(mouseEvent -> exitButton.setCursor(Cursor.DEFAULT));


        /*exitButton.setOnMouseClicked(mouseEvent -> {
           //funzione del clientManager
        });*/
//    }
/*
    public Pane getRootFXML() {
        return rootFXML;
    }
}
*/
