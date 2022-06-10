package it.polimi.ingsw.view.GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;


//mostra al player attuale che è il suo turno e può scegliere l'assistente
public class DisplayTurn {
        private Pane rootFXML;
        private final Button selectAssistant;

        public DisplayTurn(String TurnOf){
            try{
                rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/DisplayTurn.fxml")));
            }catch(
                    IOException e){
                e.printStackTrace();
            }

            Text displayTurn = (Text) rootFXML.lookup("#turnText");
            displayTurn.setText(TurnOf);
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