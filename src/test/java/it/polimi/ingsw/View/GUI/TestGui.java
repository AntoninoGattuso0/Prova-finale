package it.polimi.ingsw.View.GUI;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.view.GUI.GameTable;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
class TestGui extends Application {
    public void start(Stage primaryStage) throws Exception{
        Game game=new Game(2,true);
        Gui gui=new Gui();
        game.start(game);
        game.newPlayer("a",game);
        game.newPlayer("b",game);
        GameTable gameTable=new GameTable(gui);
        Parent root= FXMLLoader.load(getClass().getResource("resources/FXML/GameTable.fxml" ));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}