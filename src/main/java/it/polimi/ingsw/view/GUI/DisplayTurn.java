package it.polimi.ingsw.view.GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;


//mostra al player attuale che è il suo turno e può scegliere l'assistente

//DA RIVEDERE!! perchè l'ordine del turno cambia in base agli assistenti
// e inoltre devo vedere coe gestire la scena in cui fa vedere di chi e il turno e altri messaggi
//perche non puo cambiare tutta la scena ma solo un avviso
public class DisplayTurn {
        private Pane rootFXML;
        private final Button selectAssistant;

        public DisplayTurn(String TurnOf){
            try{
                rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/DisplayTurn.fxml")));
            }catch(
                    IOException e){
                e.printStackTrace();
            }

            Text displayTurn = (Text) rootFXML.lookup("#turnText");  //id che permette di accedere al testo in cui dice di chi e il turno
            displayTurn.setText(TurnOf);    //fa vedere la scritta di chi è il turno in base a quello che viene passato in ingresso
            selectAssistant = (Button)rootFXML.lookup("#selectAssistantButton");
            selectAssistant.setOnMouseEntered(mouseEvent -> selectAssistant.setCursor(Cursor.HAND));
            selectAssistant.setOnMouseExited(mouseEvent -> selectAssistant.setCursor(Cursor.DEFAULT));

            selectAssistant.setOnMouseClicked(mouseEvent -> {
                // da vedere cosa fa una volta schiacciato il bottone
                //potrebbe cambiare scena e far vedere gli assistenti
            });
        }

        public Pane getRootFXML() {
            return rootFXML;
        }
}