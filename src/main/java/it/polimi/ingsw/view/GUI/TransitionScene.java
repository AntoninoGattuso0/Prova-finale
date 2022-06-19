package it.polimi.ingsw.view.GUI;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TransitionScene {

    private static Stage mainStage;  //stage contiene le scene
    private static Scene numOfPlayersIsExpert;
    private static Scene requestNickPlayers;
    private static Scene gameTable;
    private static Scene waitingPlayers;
    private static Scene winnerScene;


//Setta lo stage iniziale che sara l'immagine di GameStarted
    public static void setMainStage(Stage mainStage){
        TransitionScene.mainStage = mainStage;
    }

    //setta come scena la pagina di richiesta di num player e se è esperto
    //public static void setNumOfPlayersIsExpert(NumOfPlayerIsExpert numOfPlayersIsExpert){
    //    TransitionScene.numOfPlayersIsExpert = new Scene(numOfPlayersIsExpert.getRootFXML());
   // }

    //setta come scena la pagina in cui chiede il nick al player
    public static void setRequestNickPlayers(RequestNickPlayers requestNickPlayers) {
      //  TransitionScene.requestNickPlayers = new Scene(requestNickPlayers.getRootFXML());
    }

    //setta come scena tutta la gameTable che sarebbe la scena dove si vedono le isole nuvole etc
    public static void setGameTable(GameTable gameTable) {
        TransitionScene.gameTable = new Scene(gameTable.getRootFXML());
    }
    //setta come scena la schermata di waiting for other players
    public static void setWaitingPlayers(WaitingPlayers waitingPlayers) {
    //    TransitionScene.waitingPlayers = new Scene(waitingPlayers.getRootFXML());
    }
    //setta come scena la schermata chi e il vincitore
    public static void setWinnerScene(WinnerScene winnerScene) {
        TransitionScene.winnerScene = new Scene(winnerScene.getRootFXML());
    }


    //tutte le funzioni qua sotto permettono di switchare scena passando dalla scena attuale a quella tra parentesi di switchScene
    private static void switchScene(Scene scene){
        Platform.runLater(()-> mainStage.setScene(scene));
    }

    public static void switchToNumOfPlayerIsExpert(){switchScene(numOfPlayersIsExpert);}
    public static void switchToWaitingPlayers(){switchScene(waitingPlayers);}
    public static void switchRequestNickPlayers(){
        switchScene(requestNickPlayers);
    }
    public static void switchToGameTable(){
        switchScene(gameTable);
    }
    public static void switchToWinnerScene(){
        switchScene(winnerScene);
    }



}