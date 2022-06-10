package it.polimi.ingsw.view.GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;


//mostra agli altri giocatori di chi è il turno
public class DisplayTurnForOtherPlayers {
    private Pane rootFXML;

    public DisplayTurnForOtherPlayers(String TurnOf){
        try{
            rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/DisplayTurnForOtherPlayers.fxml")));
        }catch(
                IOException e){
            e.printStackTrace();
        }

        Text displayTurn = (Text) rootFXML.lookup("#turnText");
        displayTurn.setText(TurnOf);
    }
}
