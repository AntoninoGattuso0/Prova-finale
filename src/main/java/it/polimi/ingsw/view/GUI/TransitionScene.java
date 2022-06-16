package it.polimi.ingsw.view.GUI;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TransitionScene {

    private static Stage mainStage;
    private static Scene numOfPlayersIsExpert;
    private static Scene requestNickPlayers;
    private static Scene gameTable;
    private static Scene waitingPlayers;
    private static Scene winnerScene;

    public static void setMainStage(Stage mainStage){
        TransitionScene.mainStage = mainStage;
    }

    public static void setNumOfPlayersIsExpert(NumOfPlayerIsExpert numOfPlayersIsExpert){
        TransitionScene.numOfPlayersIsExpert = new Scene(numOfPlayersIsExpert.getRootFXML());
    }

    public static void setRequestNickPlayers(RequestNickPlayers requestNickPlayers) {
        TransitionScene.requestNickPlayers = new Scene(requestNickPlayers.getRootFXML());
    }

    public static void setGameTable(GameTable gameTable) {
        TransitionScene.gameTable = new Scene(gameTable.getRootFXML());
    }
    public static void setWaitingPlayers(WaitingPlayers waitingPlayers) {
        TransitionScene.waitingPlayers = new Scene(waitingPlayers.getRootFXML());
    }
    public static void setWinnerScene(WinnerScene winnerScene) {
        TransitionScene.winnerScene = new Scene(winnerScene.getRootFXML());
    }

    private static void swapScene(Scene scene){
        Platform.runLater(()-> mainStage.setScene(scene));
    }

    public static void swapToNumOfPlayerIsExpert(){
        swapScene(numOfPlayersIsExpert);
    }
    public static void swapToWaitingPlayers(){
        swapScene(waitingPlayers);
    }
    public static void swapRequestNickPlayers(){
        swapScene(requestNickPlayers);
    }
    public static void swapToGameTable(){
        swapScene(gameTable);
    }
    public static void swapToWinnerScene(){
        swapScene(winnerScene);
    }



}