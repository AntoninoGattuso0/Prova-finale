package it.polimi.ingsw.view.GUI;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.network.Message.ClientToServer.RequestNicknameAfterFirstLoginMessage;
import it.polimi.ingsw.network.Message.ClientToServer.RequestNumPlayersIsExpert;
import it.polimi.ingsw.view.GUI.Controller.AssistantCardController;
import it.polimi.ingsw.view.GUI.warnings.WarningCloud;
import it.polimi.ingsw.view.View;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;



public class Gui extends Application implements View {
    private LightGame lightGame;
    private Stage stage;
    private static String addressSock;
    private SocketNetworkHandler socketNetworkHandler;
   // private GameTable gameTable = new GameTable(this);
   private final AssistantCardController assistantCardController=new AssistantCardController();
    //private final CharacterCardController characterCardController = new CharacterCardController();
    private RequestNickPlayers requestNickPlayers;
    private FXMLLoader fxmlLoader;

    // private ChooseAction chooseAction=new ChooseAction();
    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;
        startGame();
    }
    @Override
    public void startGame() {
        socketNetworkHandler=new SocketNetworkHandler(this);
        socketNetworkHandler.updateConnection(addressSock, String.valueOf(4000));
        socketNetworkHandler.run();
    }
    public static void setAddress(String address){
        addressSock=address;
    }

    //per le altre funzioni che sono scritte sono uguali a questa
    @Override
    public void requestNickname() {
        Platform.runLater(()-> {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/RequestNickPlayers.fxml"));
            Scene scene;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                scene = new Scene(new Label("Error"));
            }
            stage.setScene(scene);
            requestNickPlayers = fxmlLoader.getController();
            requestNickPlayers.setJoinButtonAble();
            stage.show();
        });
    }
    @Override
    public void requestNumPlayersIsExpert() {
        NumOfPlayerIsExpert numPlayersIsExpert = new NumOfPlayerIsExpert();
        Platform.runLater(()->TransitionScene.setNumOfPlayersIsExpert(numPlayersIsExpert));
        Platform.runLater(TransitionScene::switchToNumOfPlayerIsExpert);
        socketNetworkHandler.sendMessage(new RequestNumPlayersIsExpert(numPlayersIsExpert.getNumPlayer(), numPlayersIsExpert.isExpert()));
        socketNetworkHandler.setNicknameThisPlayer(numPlayersIsExpert.getNickname());
    }
    public SocketNetworkHandler getSocketNetworkHandler() {
        return socketNetworkHandler;
    }
    @Override
    public void requestMovePawn(String nickname, int numPawnMoved) {
    }

    @Override
    public void requestCharacterCard(String nickname, boolean bool) {
        int i;
        for(i=0;i<lightGame.getNumPlayers()&&!(lightGame.getPlayers().get(i).getNickname().equals(nickname));i++);
        int player =i;
        if(Objects.equals(nickname,socketNetworkHandler.getNicknameThisPlayer())){
            if(!bool){
                if(lightGame.getIsExpert()){
                   // pannellodiscrittura.writetext("Clicca si se vuoi giocare un characterCard e no per non giocarlo");
                }
            }
            if(bool){
                displayCharacterCard();
               // pannellodiscrittura.writetest("Scegli il CharacterCard da utilizzare");
            }
        }
    }

    @Override
    public void displayNick() {

    }

    @Override
    public void displayNumPlayers() {

    }

    @Override
    public void displayIsExpert() {

    }

    @Override
    public void displayAssistantCard(int player) {
        int j;
        assistantCardController.setDisableAll();
        assistantCardController.setInvisibileAll();
       for(j=0;j<lightGame.getPlayers().get(player).getDeckAssistant().size();j++){
           int n=lightGame.getPlayers().get(player).getDeckAssistant().get(j).getCardValue();
           assistantCardController.setAble(n);
           assistantCardController.setVisible(n);
       }
    }

    @Override
    public void displayCloud() {

    }

    @Override
    public void displayIslands() {

    }

    @Override
    public void displaySchoolBoard() {

    }

    @Override
    public void sendNick(String nickname) {
        if(nickname !=null){
            socketNetworkHandler.sendMessage(new RequestNicknameAfterFirstLoginMessage(nickname));
        }
    }

    @Override
    public void displayCharacterCard() {
        int i;
        int coin=0;
        int player;
        for(i=0; !Objects.equals(socketNetworkHandler.getNicknameThisPlayer(), lightGame.getPlayers().get(i).getNickname()); i++);
        player=i;
        for(i=0;i<lightGame.getCharacterCards().size();i++){
            switch (lightGame.getCharacterCards().get(i).getNumCard()){
                case 0 -> coin=lightGame.getAntonio().getCoinPrice();
                case 1 -> coin=lightGame.getBarbara().getCoinPrice();
                case 2 -> coin=lightGame.getCiro().getCoinPrice();
                case 3 -> coin=lightGame.getDante().getCoinPrice();
                case 4 -> coin=lightGame.getErnesto().getCoinPrice();
                case 5 -> coin=lightGame.getFelix().getCoinPrice();
                case 6 -> coin=lightGame.getGiuseppe().getCoinPrice();
                case 7 -> coin=lightGame.getIvan().getCoinPrice();
                case 8 -> coin=lightGame.getLancillotto().getCoinPrice();
                case 9 -> coin=lightGame.getMaria().getCoinPrice();
                case 10 -> coin=lightGame.getNicola().getCoinPrice();
                case 11 -> coin=lightGame.getOmnia().getCoinPrice();
            }
            //characterCardController.setVisible(i);
           // characterCardController.setCoinVisible(i,true);
            if(coin<lightGame.getPlayers().get(player).getNumCoin()){
                //characterCardController.setAble(i);
            }
        }
    }

    @Override
    public void displayWinner(String nickname) {
        WinnerScene winnerScene = new WinnerScene(nickname);
        Platform.runLater(()->TransitionScene.setWinnerScene(winnerScene));
        Platform.runLater(TransitionScene::switchToWinnerScene);
    }

    @Override
    public void displayNetError() {

    }

    @Override
    public void displayWrongNickname() {

    }

    @Override
    public void displayWrongTurn() {

    }

    @Override
    public void displayStartTurn() {

    }


    @Override
    public void updateAll(LightGame object) {
        this.lightGame=object;
    }

    @Override
    public void displayAll() {

    }

    @Override
    public void displayStartRound() {

    }


    //è provvisorio non vi spaventate :)
    @Override
    public void selectCloud(String nickname) {
        if (Objects.equals(nickname, socketNetworkHandler.getNicknameThisPlayer())) {
              //  socketNetworkHandler.sendMessage(new ChooseCloudMessage(gameTable.getCloudSelected()));
        }else{
            new WarningCloud();
        }
    }

    @Override
    public void selectAssistantCard(String nickname) {
        int i;
        if(Objects.equals(nickname,socketNetworkHandler.getNicknameThisPlayer())){
            for(i=0;!Objects.equals(lightGame.getPlayers().get(i).getNickname(),nickname);i++);
            //pannellodiscrittura.vritetext("scegli l'assistente");
            displayAssistantCard(i);
        }else{
            //Pannellodiscrittura.writetext(socketNetworkHandler.getNicknameThisPlayer()+"sta scegliendo l'Assistente");
        }
    }

    @Override
    public void requestMoveMotherNature(String nickname) {

    }

    @Override
    public void registerClient() {

    }

    @Override
    public void waitOtherPlayers() {
        WaitingPlayers waitingPlayers = new WaitingPlayers();
        Platform.runLater(()->TransitionScene.setWaitingPlayers(waitingPlayers));
        Platform.runLater(TransitionScene::switchToWaitingPlayers);

    }

    @Override
    public void setSocketNetworkHandler(SocketNetworkHandler socketNetworkHandler) {
    }

    @Override
    public void playerWait() {

    }

    @Override
    public void newGameStart() {

    }

    @Override
    public void lobbyFull() {

    }

    @Override
    public void turnOrder(ArrayList<String> players) {

    }

    @Override
    public void startTurn(ArrayList<String> players, String actualPlayer) {

    }
    @Override
    public void displayOnePlayerBoard(String nickname) {

    }

    @Override
    public void disconnectionAll(String playerDisconnected) {

    }

    @Override
    public void wrongSameAssistantMessage() {

    }

}
