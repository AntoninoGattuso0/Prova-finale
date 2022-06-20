/*package it.polimi.ingsw.view.GUI.warnings;

import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class WarningNickname {
    private Pane rootFXML;
    private final ImageView okButton;

    public WarningNickname(){
        try{
            rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/WarningNickname.fxml")));
        }catch(IOException e){
            e.printStackTrace();
        }

        okButton = (ImageView) rootFXML.lookup("#okButton");
        okButton.setOnMouseEntered(mouseEvent -> okButton.setCursor(Cursor.HAND));
        okButton.setOnMouseExited(mouseEvent ->  okButton.setCursor(Cursor.DEFAULT));


        //spostare in una funzione?
        Stage stage = new Stage();
        Scene scene = new Scene(rootFXML);
        stage.setTitle("WARNING!");

        okButton.setOnMouseClicked(event -> stage.close());

        stage.setScene(scene);
        stage.show();
    }

    public Pane getRootFXML() {
        return rootFXML;
    }
}
*/