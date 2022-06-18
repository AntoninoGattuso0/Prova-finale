package it.polimi.ingsw.view.GUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TestGui extends Application {
    private Stage primaryStage;
    private FXMLLoader fxmlLoader;

    @Override
    public void start(Stage primaryStage){
        this.primaryStage=primaryStage;
        init(primaryStage);
    }

    public void init(Stage primaryStage){
        Platform.runLater(()->{
            fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/AssistantCard.fxml"));
            Scene scene=null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(this.primaryStage==null)
                System.out.println("null3");
            primaryStage.setScene(scene);
            primaryStage.show();

        });
    }
}