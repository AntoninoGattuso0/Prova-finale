package it.polimi.ingsw.view.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

        @Override
        public void start(Stage primaryStage) throws IOException {
            Parent root = FXMLLoader.load(
                    getClass().getResource("FXML/NumOfPlayerIsExpert.fxml"));
            Scene sc = new Scene(root);
            primaryStage.setScene(sc);
            primaryStage.sizeToScene();
            primaryStage.show();
        }
}

