package it.polimi.ingsw.view.GUI;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.model.ColorPawn;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


//NINO GUARDA A RIGA 462, L'AGGIORNAMENTO INIZIALE DI DININGROOM FUNZIONA!!!!!!!!!!!!!!!!
//AGGIORNAMENTI 23/07 ;) ABBIAMO AGGIUNTO DELLE FUNZIONI PER QUANDO VENGONO SELEZIONATI I BOTTONI AL CENTRO DELLA GAMETABLE
//E LE FUNZIONI QUANDO VENGONO SCHIACCIATE LE PEDINE DELL'ENTRATA, O LE ISOLE
//SONO I CASI GENERALI CI MANCANO DEI CONTROLLI E I CASI PARTICOLARI
//DOBBIAMO CONTINUARE DAL FATTO CHE QUANDO IL GIOCATORE SCEGLIE L'ASSISTENTE POI DEVE POTER VEDERE LE SCHOOL
//QUANDO RISOLVIAMO QUALCOSA AGGIORNATE QUESTO COMMENTO COSI E PIU FACILE CAPIRE COSA FACCIAMO
//DA SISTEMARE IL FATTO CHE QUANDO NON E VARIANTE ESPERTO NON DEVE ESSERE VISIBILE IN ALTO A DX IL BOTTONE DELLE CC

public class Gui extends Application implements View {

    //Variabili per salvarsi "quale bottone/pedina/isola è stata cliccata precedentemente
    private ButtonAction buttonClicked;
    private ArrayList<ColorPawn> colorPawns = new ArrayList<>();//colori che si passano per messaggio
    private int islandSelected = -1;
    private int numPawns = -1;//numero pedine che sposta in quel momento verso la dining/isola (inviate per messaggio)
    private int numPawnsCount = -1;
    private int pedineDaSpostare;//da inizializzare (numero fisso, o 3 o 4)

    private LightGame lightGame;
    private Stage stage;
    private static String addressSock;
    private SocketNetworkHandler socketNetworkHandler;
    private GameTableController gameTable;
    private AssistantCardController assistantCardController;
    private CharacterCardController characterCardController;
    private RequestNickPlayersController requestNickPlayersController;
    private FXMLLoader fxmlLoader;

    private int numPawnMove;
    private boolean endGame=false;
    private SchoolBoard0Controller schoolBoard0Controller;
    private SchoolBoard1Controller schoolBoard1Controller;
    private SchoolBoard2Controller schoolBoard2Controller;
    private SchoolBoard3Controller schoolBoard3Controller;
    private FXMLLoader fxmlSchool0;
    private FXMLLoader fxmlAssistant;
    private FXMLLoader fxmlCharacter;
    private FXMLLoader fxmlSchool1;
    private FXMLLoader fxmlSchool2;
    private FXMLLoader fxmlSchool3;

    public Gui() {
    }


    public ButtonAction getButtonClicked(){return this.buttonClicked;}
    public ArrayList<ColorPawn> getColorPawns(){return this.colorPawns;}
    public int getIslandSelected(){return this.islandSelected;}
    public int getNumPawns(){return this.numPawns;}
    public int getPedineDaSpostare(){return this.pedineDaSpostare;}

    public int getNumPawnMove() {
        return numPawnMove;
    }

    public int getNumPawnsCount() {return numPawnsCount;}

    public void setNumPawnsCount(int numPawnsCount) {this.numPawnsCount = numPawnsCount;}

    public void setButtonClicked(ButtonAction buttonClicked){this.buttonClicked = buttonClicked;}
    public void setColorPawns(ArrayList<ColorPawn> colorPawns){this.colorPawns = colorPawns;}
    public void setIslandSelected(int islandSelected){this.islandSelected = islandSelected;}
    public void setNumPawns(int numpawns){this.numPawns = numpawns;}
    public void setPedineDaSpostare(int pedineDaSpostare){this.pedineDaSpostare = pedineDaSpostare;}

    public AssistantCardController getAssistantCardController() {
        return assistantCardController;
    }

    public GameTableController getGameTable() {
        return gameTable;
    }
    public CharacterCardController getCharacterCardController() {
        return characterCardController;
    }
    public SchoolBoard0Controller getSchoolBoard0Controller() {
        return schoolBoard0Controller;
    }
    public SchoolBoard1Controller getSchoolBoard1Controller() {
        return schoolBoard1Controller;
    }
    public SchoolBoard2Controller getSchoolBoard2Controller() {
        return schoolBoard2Controller;
    }
    public SchoolBoard3Controller getSchoolBoard3Controller() {
        return schoolBoard3Controller;
    }
    public LightGame getLightGame(){return this.lightGame;}

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
            NumOfPlayerIsExpertController numOfPlayerIsExpertController=new NumOfPlayerIsExpertController();
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
        Platform.runLater(()-> {
            if(Objects.equals(nickname,socketNetworkHandler.getNicknameThisPlayer())) {
                schoolBoard1Controller.setSchoolBoard1();
                schoolBoard0Controller.setSchoolBoard0();
                if(schoolBoard2Controller!=null)
                    schoolBoard2Controller.setSchoolBoard2();
                if(schoolBoard3Controller!=null)
                    schoolBoard3Controller.setSchoolBoard3();
                gameTable.setMessages("CHOOSE YOUR ACTION");
                gameTable.setButtonForRequestMovePawn();
            }else{
                gameTable.setMessages(nickname+" IS IN MOVE PAWN PHASE");
            }
        });
    }

    @Override
    public void requestCharacterCard(String nickname, boolean bool) {
        Platform.runLater(()-> {
            if(Objects.equals(nickname,socketNetworkHandler.getNicknameThisPlayer())) {
                gameTable.setLastCCMessage();;
            }else{
                gameTable.setMessages(nickname+" IS IN CHOOSING PHASE");
            }
        });
    }



        /*int i;
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
        }*/

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
        // stage.show();
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
            WinnerSceneController winnerScene = fxmlLoader.getController();
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
            WarningNicknameController warningNicknameController= fxmlLoader.getController();
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
        Platform.runLater(()-> {
            if (schoolBoard1Controller != null) {
                schoolBoard1Controller.setSchoolBoard1();
                schoolBoard0Controller.setSchoolBoard0();
                if (schoolBoard2Controller != null) {
                    schoolBoard2Controller.setSchoolBoard2();
                }
                if (schoolBoard2Controller != null) {
                    schoolBoard3Controller.setSchoolBoard3();
                }
                assistantCardController.setAssistantCards(socketNetworkHandler.getNicknameThisPlayer());
                characterCardController.setCharacterCards();
                gameTable.setMotherNatureVisible();
                gameTable.setAllIslands(true);
                gameTable.setProfessor();
                gameTable.setCloudVisible();
            }
        });
    }

    @Override
    public void displayAll() {
    }

    @Override
    public void displayStartRound() {
    }
    @Override
    public void selectCloud(String nickname) {


        Platform.runLater(()->{
            if(Objects.equals(nickname, socketNetworkHandler.getNicknameThisPlayer())) {
                gameTable.setButtonOff();
                gameTable.getWhatToDo().setText("Choose Cloud");
                gameTable.setMessages("CHOOSE CLOUD");
                gameTable.setCloudVisible();
                gameTable.setCloudAble();
            }else{
                gameTable.setMessages(nickname+" CHOOSE CLOUD");
            }
        });
    }

    @Override
    public void selectAssistantCard(String nickname) {
        Platform.runLater(()-> {
            if(Objects.equals(nickname,socketNetworkHandler.getNicknameThisPlayer())){
                gameTable.setChooseViewOff();
                gameTable.setShowAssistant();
                gameTable.setMessages("CHOOSE AN ASSISTANT");

            }else{
                gameTable.setMessages(nickname+" IS CHOOSING AN ASSISTANT");
            }
        });
    }

    @Override
    public void requestMoveMotherNature(String nickname) {
        Platform.runLater(()->{
        if(Objects.equals(socketNetworkHandler.getNicknameThisPlayer(), nickname)){
            int i;
            for(i=0; !Objects.equals(nickname, lightGame.getPlayers().get(i).getNickname()); i++);
            gameTable.setMessages("MOVE MOTHER NATURE: MAX "+ lightGame.getPlayers().get(i).getCurrentAssistant().getStep());
            setButtonClicked(ButtonAction.MOTHERNATURE);
            gameTable.setIslandForMotherNature(lightGame.getPlayers().get(i).getCurrentAssistant().getStep());
        }else{
            gameTable.setMessages(nickname + " IS IN MOVE MOTHER NATURE PHASE");
        }
    });
    }

    @Override
    public void registerClient() {

    }
    public void assistantSelected(){
        Platform.runLater(()-> {
            assistantCardController.setDisableAll();
            gameTable.initializeBorderPane();
            gameTable.setChooseViewOn();
        });
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
            WaitingPlayersController waitingPlayersController=fxmlLoader.getController();
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
            GameStartedController gameStartedController=fxmlLoader.getController();
            gameStartedController.setGui(this);
            gameStartedController.setGameText(true);
            stage.show();
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/GameTable.fxml"));;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                scene = new Scene(new Label("Error"));
            }
            gameTable=fxmlLoader.getController();
            gameTable.setGui(this);
            gameTable.setPawnVisible();
            gameTable.setMotherNatureVisible();
            gameTable.setAllIslands(false);
            gameTable.setCloudVisible();
            gameTable.setTowers();
            gameTable.setButtonOff();
            gameTable.setProhibited();
            gameTable.setAssistantSchoolBoardCharacter();
            gameTable.initializeBorderPane();
            stage.setScene(scene);
            stage.show();
        });

        Platform.runLater(()-> {
            fxmlSchool0= new FXMLLoader();
            fxmlSchool0.setLocation(getClass().getResource("/SchoolBoard0.fxml"));
            try {
                fxmlSchool0.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            schoolBoard0Controller=fxmlSchool0.getController();
            schoolBoard0Controller.setGui(this);
            schoolBoard0Controller.setSchoolBoard0();
            fxmlSchool1= new FXMLLoader();
            fxmlSchool1.setLocation(getClass().getResource("/SchoolBoard1.fxml"));
            try {
                fxmlSchool1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            schoolBoard1Controller=fxmlSchool1.getController();
            schoolBoard1Controller.setGui(this);
            schoolBoard1Controller.setSchoolBoard1();
            if(lightGame.getNumPlayers()>2) {
                fxmlSchool2 = new FXMLLoader();
                fxmlSchool2.setLocation(getClass().getResource("/SchoolBoard2.fxml"));
                try {
                    fxmlSchool2.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                schoolBoard2Controller = fxmlSchool2.getController();
                schoolBoard2Controller.setGui(this);
                schoolBoard2Controller.setSchoolBoard2();
            }
            if(lightGame.getNumPlayers()>3) {
                fxmlSchool3 = new FXMLLoader();
                fxmlSchool3.setLocation(getClass().getResource("/SchoolBoard3.fxml"));
                try {
                    fxmlSchool3.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                schoolBoard3Controller = fxmlSchool3.getController();
                schoolBoard3Controller.setGui(this);
                schoolBoard3Controller.setSchoolBoard3();
            }
            fxmlAssistant= new FXMLLoader();
            fxmlAssistant.setLocation(getClass().getResource("/AssistantCard.fxml"));
            try {
                fxmlAssistant.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assistantCardController = fxmlAssistant.getController();
            assistantCardController.setGui(this);
            assistantCardController.setAssistantCards(this.getSocketNetworkHandler().getNicknameThisPlayer());
            gameTable.getShowAssistant().setCenter(assistantCardController.getAssistantCards());
            gameTable.getShowAssistant().getCenter().setVisible(true);
            gameTable.getShowSchool0().setCenter(schoolBoard0Controller.getSchoolBoard0());
            gameTable.getShowSchool0().getCenter().setVisible(true);
            if(lightGame.getIsExpert()) {
                fxmlCharacter = new FXMLLoader();
                fxmlCharacter.setLocation(getClass().getResource("/CharacterCard.fxml"));
                try {
                    fxmlCharacter.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (lightGame.getIsExpert()) {
                    characterCardController = fxmlCharacter.getController();
                    characterCardController.setGui(this);
                    characterCardController.setCharacterCards();
                    gameTable.getShowCharacterCard().setCenter(characterCardController.getCharacterCards());
                    gameTable.getShowCharacterCard().getCenter().setVisible(true);
                }
            }
        });

    }


    @Override
    public void lobbyFull(){
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
            LobbyIsFullController lobbyIsFullController=fxmlLoader.getController();
            stage.show();
        });
        socketNetworkHandler.closeConnection();
    }

    @Override
    public void turnOrder(ArrayList<String> players) {
        Platform.runLater(()-> {
            gameTable.setTurnOf(players);
        });
    }
    @Override
    public void startTurn(ArrayList<String> players, String actualPlayer) {
        if (Objects.equals(actualPlayer, socketNetworkHandler.getNicknameThisPlayer())) {
            //displayEndTurn();
            //va gestito nella parte di testo in gameTable
        }
        Platform.runLater(() -> {
            int i;
            int j;
            for (j = 0; !Objects.equals(players.get(j), actualPlayer); j++) ;
            if (j< players.size()-1) {
                for (i = j; Objects.equals(players.get(i), actualPlayer); i++) ;
                if (Objects.equals(players.get(i), socketNetworkHandler.getNicknameThisPlayer())) {
                    // displayStartTurn();
                    //va gestito nella parte di testo in game table
                } else {
                    gameTable.setMessages(players.get(i) + " START YOUR TURN");
                }
            }else {
                gameTable.setMessages("ROUND FINISHED, A NEW ONE BEGINS");
            }
        });
    }
    @Override
    public void displayOnePlayerBoard(String nickname) {
        //potrei usarla per attivare la singola schoolboard quando un giocatore clicca sulla specifica schoolboard dal menù a tendina
    }


    @Override
    public void disconnectionAll(String playerDisconnected) throws IOException {
        if(!endGame){
            gameTable.setMessages(playerDisconnected+ " DISCONNECTED FROM THE GAME.");

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