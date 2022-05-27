/*package it.polimi.ingsw.view.Gui;

import it.polimi.ingsw.network.ClientHandler;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFXGui extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Gui view = new Gui();
        ClientHandler clientHandler = new ClientHandler(view);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/menu.scene.fxml"));
        Parent rootlayout = null;
        try{
            rootlayout = loader.load();
        } catch (IOException e){
            System.exit(1);
        }

        Scene scene = new Scene(rootlayout);
        stage.setScene(scene);
        stage.setWidth(1280d);
        stage.setHeight(720d);
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setTitle("Eryantis");
        stage.show();

    }

    @Override
    public void stop(){
        Platform.exit();
        System.exit(0);
    }
}
*/