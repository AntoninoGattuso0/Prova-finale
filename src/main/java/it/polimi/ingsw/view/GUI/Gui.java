package it.polimi.ingsw.view.GUI;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.network.Message.ClientToServer.ReadyTodisconnection;
import it.polimi.ingsw.network.Message.ClientToServer.RequestNicknameAfterFirstLoginMessage;
import it.polimi.ingsw.view.GUI.Controller.*;
import it.polimi.ingsw.view.GUI.warnings.WarningNicknameController;
import it.polimi.ingsw.view.View;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

//HO VISTO CHE HAI USATO ALCUNE VOLTE SCENE=NEW SCENE(NEW LABEL(ERROR))
//SE VUOI POSSO CREARE UN FXML COSI? SCRIVIMELO SU WHATSAPP SE SERVE

public class Gui extends Application implements View {


    private LightGame lightGame;
    private Stage stage;
    private static String addressSock;
    private SocketNetworkHandler socketNetworkHandler;
    private GameTableController gameTable;
    private AssistantCardController assistantCardController;
    private CharacterCardController characterCardController;
    private NumOfPlayerIsExpertController numOfPlayerIsExpertController;
    private WaitingPlayersController waitingPlayersController;
    private WinnerSceneController winnerScene;
    private WarningNicknameController warningNicknameController;
    private GameStartedController gameStartedController;
    private RequestNickPlayersController requestNickPlayersController;
    private LobbyIsFullController lobbyIsFullController;
    private FXMLLoader fxmlLoader;
    private int pedineDaSpostare;
    private int numPawnMove;
    private boolean endGame=false;

    SchoolBoard0Controller schoolBoard0Controller;
    SchoolBoard1Controller schoolBoard1Controller;
    SchoolBoard2Controller schoolBoard2Controller;
    SchoolBoard3Controller schoolBoard3Controller;

    public Gui() {
    }
    public LightGame getLightGame(){return this.lightGame;}

    public GameTableController getGameTable(){return this.gameTable;}

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
            requestNickPlayersController = fxmlLoader.getController();
            requestNickPlayersController.setGui(this);
            requestNickPlayersController.setJoinButtonAble();
            stage.show();
        });
    }
    @Override
    public void requestNumPlayersIsExpert() {
        Platform.runLater(()-> {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/NumOfPlayerIsExpert.fxml"));
            Scene scene;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                scene = new Scene(new Label("Error"));
            }
            stage.setScene(scene);
            numOfPlayerIsExpertController=new NumOfPlayerIsExpertController();
            numOfPlayerIsExpertController=fxmlLoader.getController();
            numOfPlayerIsExpertController.setGui(this);
            numOfPlayerIsExpertController.setNumPlayerIsExpert();
            stage.show();
        });
    }
    public SocketNetworkHandler getSocketNetworkHandler() {
        return socketNetworkHandler;
    }
    @Override
    public void requestMovePawn(String nickname, int numPawnMoved) {
        //si devono settare i bottoni aggiunti nella gametable e stampargli "clicca "isole" per ecc..., clicca "dining" per...ecc"

        //IO METTEREI setText("CHOOSE YOUR ACTION")
        //NOME BOTTONI MoveToIsland, MoveToDining, ChooseCharacter
        //TI FACCIO UN AUDIO PER SPIEGARTI COME HO PENSATO A QUESTO

    }

    @Override
    public void requestCharacterCard(String nickname, boolean bool) {
        int i;
        for(i=0;i<lightGame.getNumPlayers()&&!(lightGame.getPlayers().get(i).getNickname().equals(nickname));i++);
        int player =i;
        if(Objects.equals(nickname,socketNetworkHandler.getNicknameThisPlayer())){
            if(!bool){
                if(lightGame.getIsExpert()){
                   //pannellodiscrittura.writetext("Clicca si se vuoi giocare un characterCard e no per non giocarlo");

                    //SE E ESPERTO MOSTRA IL BOTTONE DEI CHARACTR CARD
                    //IO LO METTEREI TRA LE ALTRE AZIONI DA SCEGLIERE
                    //TIPO SCEGLI AZIONE E LI C'E SCRITTO SPOSTARE PEDINA SU ISOLA O DINING O USARE CHARACT
                    //SE SCEGLIE DI SPOSTARE LE PEDINE FA VEDERE 1, 2, 3, 4
                    //DOPO CHE HA SCELTO QUANTE E FA QUESTE MOSSE
                    //FA VEDERE DI NUOVO CHOOSE ACTION DOVE FA VEDERE DI NUOVO COME PRIMA RIGA 130
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
        stage.show();
     //  for(j=0;j<lightGame.getPlayers().get(player).getDeckAssistant().size();j++){
          // int n=lightGame.getPlayers().get(player).getDeckAssistant().get(j).getCardValue();
           //assistantCardController.setAble(n);
           //assistantCardController.setVisible(n);
    //   }
    }

    @Override
    public void displayCloud() {

    }

    @Override
    public void displayIslands() {
        //va gestito con il game table totale

    }

    @Override
    public void displaySchoolBoard() {
        //non penso serva ma in caso va lasciata vuota
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
            //characterCardController.setCoinVisible(i,true);
            if(coin<lightGame.getPlayers().get(player).getNumCoin()){
              //  characterCardController.setAble(i);
            }
        }
    }

    @Override
    public void displayWinner(String nickname) {
        int i;
        int j;
        for (i = 0; !Objects.equals(lightGame.getPlayers().get(i).getNickname(), nickname); i++) ;
        if (lightGame.getPlayers().size() == 4) {
            for (j = i; lightGame.getPlayers().get(i).getTowerSpace().getColorTower() != lightGame.getPlayers().get(j).getTowerSpace().getColorTower(); j++);
            nickname=lightGame.getPlayers().get(i).getNickname()+" and "+lightGame.getPlayers().get(j).getNickname();
        }
        String finalNickname = nickname;
        Platform.runLater(() -> {
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
                winnerScene = fxmlLoader.getController();
                winnerScene.setGui(this);
                winnerScene.setNicknameWinner(finalNickname);
                winnerScene.setWinnerScene(true);
                stage.show();
            });
        }

    @Override
    public void displayNetError() {

    }

    @Override
    public void displayWrongNickname() {
        Platform.runLater(() -> {
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
            warningNicknameController= fxmlLoader.getController();
            warningNicknameController.setGui(this);
            warningNicknameController.setOkButton();
            warningNicknameController.setWarningNickname(true);
            stage.show();
        });
    }

    @Override
    public void displayWrongTurn() {
        //quando saprò come gestire la game table la inserisco come testo in caso di errore nel fare mosse non durante il suo turno

        //RISPOSTA: IN BASSO A SINISTRA HO MESSO UN TESTO MOFICABILE
        //POTREMMO FARE CHE PER GLI ERRORI SI METTE IL MESSAGGIO IN ROSSO
        //per cambiare colore messaggio penso che si possa usare setFill
        //messaggio da far vedere per farcelo stare nella schermata setText("IT'S NOT YOUR TURN")

    }

    @Override
    public void updateAll(LightGame object) {
        this.lightGame=object;
        int i;
        int c=0;
        for(i=0;i<lightGame.getNumPlayers();i++){
            c++;
        }
        if(numPawnMove!=0){
            if(c==0){
                displayStartRound();
            }
        }
    }

    @Override
    public void displayAll() {

    }

    @Override
    public void displayStartRound() {

    }
    @Override
    public void selectCloud(String nickname) {
        //gestire con gametable
    }

    @Override
    public void selectAssistantCard(String nickname) {

        //si deve capire come gestire il gameTableController
        int i;
        if(Objects.equals(nickname,socketNetworkHandler.getNicknameThisPlayer())){
            for(i=0;!Objects.equals(lightGame.getPlayers().get(i).getNickname(),nickname);i++);
            
            displayAssistantCard(i);
        }else{
            //Pannellodiscrittura.writetext(socketNetworkHandler.getNicknameThisPlayer()+" CHOOSE AN ASSISTANT");
        }
    }

    @Override
    public void requestMoveMotherNature(String nickname) {
        //va gestito sempre capendo come funziona il game table
    }

    @Override
    public void registerClient() {

    }

    @Override
    public void waitOtherPlayers() {
        Platform.runLater(()-> {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/WaitingPlayers.fxml"));
            Scene scene;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                scene = new Scene(new Label("Error"));
            }
            stage.setScene(scene);
            waitingPlayersController=fxmlLoader.getController();
            waitingPlayersController.setGui(this);
            waitingPlayersController.setWaitingPlayers(true);
            requestNickPlayersController.setJoinButtonAble();
            stage.show();
        });


    }

    @Override
    public void setSocketNetworkHandler(SocketNetworkHandler socketNetworkHandler) {
    }

    @Override
    //va bene vuota
    public void playerWait() {

    }

    @Override
    public void newGameStart() {
        gameStartedController=new GameStartedController();
        if (lightGame.getNumPlayers() == 2 || lightGame.getNumPlayers() == 4) {
            pedineDaSpostare = 3;
            numPawnMove = 3;
        } else {
            pedineDaSpostare = 4;
            numPawnMove = 4;

        }
        Platform.runLater(()-> {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/GameStarted.fxml"));
            Scene scene;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                scene = new Scene(new Label("Error"));
            }
            stage.setScene(scene);
            gameStartedController=fxmlLoader.getController();
           gameStartedController.setGui(this);
           gameStartedController.setGameText(true);
            stage.show();
        });
    }

    @Override
    public void lobbyFull(){
        lobbyIsFullController=new LobbyIsFullController();
        Platform.runLater(()-> {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/LobbyIsFull.fxml"));
            Scene scene;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                scene = new Scene(new Label("Error"));
            }
            stage.setScene(scene);
            lobbyIsFullController=fxmlLoader.getController();
            stage.show();
        });
        socketNetworkHandler.closeConnection();
    }

    @Override
    public void turnOrder(ArrayList<String> players) {


        Platform.runLater(()-> {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/GameTable.fxml"));
            Scene scene=null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                scene = new Scene(new Label("Error"));
            }
            gameTable=fxmlLoader.getController();
            gameTable.setGui(this);
            gameTable.inizializeBorderPane();
            gameTable.setTurnOf(players);
            gameTable.setPawnVisible();
            gameTable.setMotherNatureVisible();
            gameTable.setAllIslands(true,false);
            gameTable.setCloudVisible();
            gameTable.setTowers();
            gameTable.setButtonOff();
            gameTable.setProhibited();
            gameTable.setAssistantSchoolBoardCharacter();
            stage.setScene(scene);
            stage.show();
        });

        Platform.runLater(()-> {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/SchoolBoard0.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                scene = new Scene(new Label("Error"));
            }
            schoolBoard0Controller=fxmlLoader.getController();
            schoolBoard0Controller.setGui(this);
            schoolBoard0Controller.setSchoolBoard0();

            gameTable.getShowSchool0().setCenter(schoolBoard0Controller.getSchoolBoard0());
        });
    }

    public Pane getPage(String fileName) {
        Pane view = null;
        try {
            URL fileUrl = getClass().getResource("/"+fileName + ".fxml");
            if (fileUrl == null)
                throw new java.io.FileNotFoundException("Impossibile trovare file");
            view = FXMLLoader.load(fileUrl);
        } catch (Exception e) {
            System.out.println("No Page Found");
        }
        return view;
    }

    @Override
    public void startTurn(ArrayList<String> players, String actualPlayer) {
        if (Objects.equals(actualPlayer, socketNetworkHandler.getNicknameThisPlayer())) {
            //displayEndTurn();
            //va gestito nella parte di testo in gameTable
        }
        int i;
        int j;
        for (j = 0; !Objects.equals(players.get(j), actualPlayer); j++) ;
        if (j< players.size()-1) {
            for (i = j; Objects.equals(players.get(i), actualPlayer); i++) ;
            if (Objects.equals(players.get(i), socketNetworkHandler.getNicknameThisPlayer())) {
                // displayStartTurn();
                //va gestito nella parte di testo in game table
            } else
                System.out.println(players.get(i) + " sta iniziando il suo turno");   //IN ALTO A SINISTRA C'E UN TESTO TURN OF: NOMEPLAYER
        }else{
            //System.out.println("ROUND FINISHED, A NEW ONE BEGINS");  //RISPOSTA: questo e il messaggio da metter come setText per farlo stare all'interno della schermata
            //va gestito nell parte di testo in game table
        }
    }
    @Override
    public void displayOnePlayerBoard(String nickname) {
    //potrei usarla per attivare la singola schoolboard quando un giocatore clicca sulla specifica schoolboard dal menù a tendina
    }

    @Override
    public void disconnectionAll(String playerDisconnected) throws IOException {
    if(!endGame){
        //scrivere nel pannello il fatto che un giocatore è stato disconnesso per problemi

        //RISPOSTA: IN BASSO A SINISTRA HO MESSO UN TESTO MOFICABILE
        //POTREMMO FARE CHE PER GLI ERRORI SI METTE IL MESSAGGIO IN ROSSO
        //per cambiare colore messaggio penso che si possa usare setFill
        //messaggio da far vedere setText("NOMEPLAYER DISCONNECTED PER BOH NETERROR")
        //Puoi mettere il messaggio che vuoi basta che non superi quello del wrongSameAssistant perche esce fuori
    }
        socketNetworkHandler.getOut().reset();
        socketNetworkHandler.getOut().flush();
        socketNetworkHandler.sendMessage(new ReadyTodisconnection());
        socketNetworkHandler.closeConnection();
    }

    @Override
    public void wrongSameAssistantMessage() {
        //parte di testo in gametable:"ERRORE: assistente già usato da un altro player"

        //RISPOSTA: IN BASSO A SINISTRA HO MESSO UN TESTO MOFICABILE
        //POTREMMO FARE CHE PER GLI ERRORI SI METTE IL MESSAGGIO IN ROSSO
        //per cambiare colore messaggio penso che si possa usare setFill
        //messaggio da far vedere per farcelo stare nella schermata setText("ASSISTANTCARD ALREADY SELECTED BY ANOTHER PLAYER")

    }
}