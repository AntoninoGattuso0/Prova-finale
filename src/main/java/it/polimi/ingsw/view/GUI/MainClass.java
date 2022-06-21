package it.polimi.ingsw.view.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainClass extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/NumOfPlayerIsExpert.fxml")));
            Scene sc = new Scene(root);
            stage.setScene(sc);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
