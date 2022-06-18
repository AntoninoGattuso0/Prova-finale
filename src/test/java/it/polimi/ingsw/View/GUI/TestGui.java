package it.polimi.ingsw.View.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;

class TestGui extends Application {

    public void start(Stage primaryStage) throws Exception {
        BorderPane root=new BorderPane();
        Scene scene=new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("FXML/AssistantCard.fxml")).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}