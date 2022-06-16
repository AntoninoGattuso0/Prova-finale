package it.polimi.ingsw.view.GUI;


import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.network.Message.ClientToServer.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GameTable {
    private Pane rootFXML;
    private SocketNetworkHandler socketNetworkHandler;
    private LightGame lightGame;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private int cloudSelected;
    boolean cloudIsAlreadySelected = false;

    @FXML private List<ImageView> islands;
    @FXML private List<ImageView> motherNature;
    @FXML private List<ImageView> greenPawns;
    @FXML private List<ImageView> redPawns;
    @FXML private List<ImageView> yellowPawns;
    @FXML private List<ImageView> pinkPawns;
    @FXML private List<ImageView> bluePawns;
    @FXML private List<Text> textGreen;
    @FXML private List<Text> textRed;
    @FXML private List<Text> textYellow;
    @FXML private List<Text> textPink;
    @FXML private List<Text> textBlue;

    @FXML private List<ImageView> blackTowers;
    @FXML private List<ImageView> whiteTowers;
    @FXML private List<ImageView> greyTowers;

    @FXML private List<ImageView> clouds;
    @FXML private List<ImageView> greenPawnClouds;
    @FXML private List<ImageView> redPawnClouds;
    @FXML private List<ImageView> yellowPawnClouds;
    @FXML private List<ImageView> pinkPawnClouds;
    @FXML private List<ImageView> bluePawnClouds;

    @FXML private List<ImageView> characterCards;

    @FXML private List<ImageView> greenSchool0;
    @FXML private List<ImageView> redSchool0;
    @FXML private List<ImageView> yellowSchool0;
    @FXML private List<ImageView> pinkSchool0;
    @FXML private List<ImageView> blueSchool0;
    @FXML private List<ImageView> blackTowersSchool0;


    public GameTable(){
        try{
            rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/GameTable.fxml")));
        }catch(IOException e){
        e.printStackTrace();
        }

        List<ImageView> buttonAssistants = new ArrayList<>();
        for(int i = 1; i < 11; i++){
            buttonAssistants.add((ImageView) rootFXML.lookup("AssistantCard" + i));
        }
        //quando il cursore arriva su un assistant card diventa a forma di mano
        for(ImageView imageAssistant : buttonAssistants){
            imageAssistant.setOnMouseEntered(mouseEvent -> imageAssistant.setCursor(Cursor.HAND));
            imageAssistant.setOnMouseExited(mouseEvent -> imageAssistant.setCursor(Cursor.DEFAULT));
        }

        //questo devo vedere se metterlo in una funzione e poi richiamarlo dalla GUI
        //o se mettere direttamente nella gui
        boolean alreadySelected = false;
        for(ImageView imageAssistant : buttonAssistants){
            if(!alreadySelected){
                imageAssistant.setOnMouseClicked(mouseEvent -> {
                    int AssistantCard = buttonAssistants.indexOf(imageAssistant);
                    socketNetworkHandler.sendMessage(new ChooseAssistantCardMessage(AssistantCard));
                });
                alreadySelected = true;
            }
        }


        for(int i = 0; i < 12; i++){
            islands.add((ImageView) rootFXML.lookup("island" + i));
            motherNature.add((ImageView) rootFXML.lookup("motherNature" + i));
            //Aggiunge le immagini delle pedine alle liste del colore corrispondenete
            greenPawns.add((ImageView) rootFXML.lookup("green" + i));
            redPawns.add((ImageView) rootFXML.lookup("red" + i));
            yellowPawns.add((ImageView) rootFXML.lookup("yellow" + i));
            pinkPawns.add((ImageView) rootFXML.lookup("pink" + i));
            bluePawns.add((ImageView) rootFXML.lookup("blue" + i));
            //aggiunge le torri del colore corrispondente
            blackTowers.add((ImageView) rootFXML.lookup("blackTower" + i));
            whiteTowers.add((ImageView) rootFXML.lookup("whiteTower" + i));
            greyTowers.add((ImageView) rootFXML.lookup("greyTowers" + i));

            textGreen.add((Text) rootFXML.lookup("textGreen" + i));
            textRed.add((Text) rootFXML.lookup("textRed" + i));
            textYellow.add((Text) rootFXML.lookup("textYellow" + i));
            textPink.add((Text) rootFXML.lookup("textPink" + i));
            textBlue.add((Text) rootFXML.lookup("textBlue" + i));
        }

        //setta tutte le pedine e madre natura invisibili all'inizio
        for(ImageView greenPawn : greenPawns)
            greenPawn.setVisible(false);
        for(ImageView redPawn : redPawns)
            redPawn.setVisible(false);
        for(ImageView yellowPawn : yellowPawns)
            yellowPawn.setVisible(false);
        for(ImageView pinkPawn : pinkPawns)
            pinkPawn.setVisible(false);
        for(ImageView pinkPawn : pinkPawns)
            pinkPawn.setVisible(false);

        for(ImageView mNature : motherNature)
            mNature.setVisible(false);
        //setta le torri non visibili
        for(ImageView blackTower : blackTowers)
            blackTower.setVisible(false);
        for(ImageView whiteTower : whiteTowers)
            whiteTower.setVisible(false);
        for(ImageView greyTower : greyTowers)
            greyTower.setVisible(false);

        //setta il testo delle pedine non visibili
        for(Text greenText : textGreen)
            greenText.setVisible(false);
        for(Text redText : textRed)
            redText.setVisible(false);
        for(Text yellowText : textYellow)
            yellowText.setVisible(false);
        for(Text pinkText : textPink)
            pinkText.setVisible(false);
        for(Text blueText : textBlue)
            blueText.setVisible(false);

        for(int i = 0; i < 4; i++){
            clouds.add((ImageView) rootFXML.lookup("cloud" + i));
            clouds.get(i).setVisible(false);
        }
        for(int i = 0; i < lightGame.getNumPlayers(); i++)
            clouds.get(i).setVisible(true);

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                greenPawnClouds.add((ImageView) rootFXML.lookup("greenCloud" + i + j));
                redPawnClouds.add((ImageView) rootFXML.lookup("redCloud" + i + j));
                yellowPawnClouds.add((ImageView) rootFXML.lookup("yellowCloud" + i + j));
                pinkPawnClouds.add((ImageView) rootFXML.lookup("pinkCloud" + i + j));
                bluePawnClouds.add((ImageView) rootFXML.lookup("blueCloud" + i + j));
            }
        }
        for(int i = 0; i < 12; i++){
            greenPawnClouds.get(i).setVisible(false);
            redPawnClouds.get(i).setVisible(false);
            yellowPawnClouds.get(i).setVisible(false);
            pinkPawnClouds.get(i).setVisible(false);
            bluePawnClouds.get(i).setVisible(false);
        }

        //quando il cursore arriva su una cloud diventa a forma di mano
        for(ImageView cloud : clouds){
            cloud.setOnMouseEntered(mouseEvent -> cloud.setCursor(Cursor.HAND));
            cloud.setOnMouseExited(mouseEvent -> cloud.setCursor(Cursor.DEFAULT));
        }

        //questo devo vedere se metterlo in una funzione e poi richiamarlo dalla GUI
        //o se mettere direttamente nella gui
        for(ImageView cloud : clouds){
            if(!cloudIsAlreadySelected){  //vorrei che fosse se falso entri dentro l'if (scritto cosi E GIUSTO o no?)
                cloud.setOnMouseClicked(mouseEvent -> cloudSelected = clouds.indexOf(cloud));
                cloudIsAlreadySelected = true;
            }
        }

        // da vedere come fare add image
        /*for(int j = 0; j < 3; j++){
            characterCards.add((ImageView) rootFXML.lookup("characterCard" + j));
            characterCards.get(j).setVisible(false);
        }
        if(lightGame.getIsExpert()){
            for(ImageView characterCard : characterCards)


        }*/

        for(int i = 0; i < 10; i++){
            greenSchool0.add((ImageView) rootFXML.lookup("schoolGreen" + i));
            redSchool0.add((ImageView) rootFXML.lookup("schoolRed" + i));
            yellowSchool0.add((ImageView) rootFXML.lookup("schoolYellow" + i));
            pinkSchool0.add((ImageView) rootFXML.lookup("schoolPink" + i));
            blueSchool0.add((ImageView) rootFXML.lookup("schoolBlue" + i));
            greenSchool0.get(i).setVisible(false);
            redSchool0.get(i).setVisible(false);
            yellowSchool0.get(i).setVisible(false);
            pinkSchool0.get(i).setVisible(false);
            blueSchool0.get(i).setVisible(false);
        }
        for(int i = 0; i < 8; i++){
            blackTowersSchool0.add((ImageView) rootFXML.lookup("blackTowerSchool" + i));
            blackTowers.get(i).setVisible(false);

        }

    }


    //settato nel costruttore le pedine presenti invibili all'inizio
    //poi quando vengono randomizzate le pedine  e MN all'inizio del gioco, vengono settate su visibiili
    //io l'ho fatto poi è da vedere se funziona ;)
    @FXML
    public void displayInitialGameTable(){
         for(int i = 0; i < 12; i++){
             if(lightGame.getIslands().get(i).getGreenPawn()>0){
                 greenPawns.get(i).setVisible(true);
                 textGreen.get(i).setVisible(true);
                 textGreen.get(i).setText("1");
             }else if(lightGame.getIslands().get(i).getRedPawn()>0){
                 redPawns.get(i).setVisible(true);
                 textRed.get(i).setVisible(true);
                 textRed.get(i).setText("1");
             }else if(lightGame.getIslands().get(i).getYellowPawn()>0){
                 yellowPawns.get(i).setVisible(true);
                 textYellow.get(i).setVisible(true);
                 textYellow.get(i).setText("1");
             }else if(lightGame.getIslands().get(i).getPinkPawn()>0){
                 pinkPawns.get(i).setVisible(true);
                 textPink.get(i).setVisible(true);
                 textPink.get(i).setText("1");
             }else if(lightGame.getIslands().get(i).getBluePawn()>0){
                 bluePawns.get(i).setVisible(true);
                 textBlue.get(i).setVisible(true);
                 textBlue.get(i).setText("1");
             }
             if(lightGame.getIslands().get(i).getMotherNature())
                 motherNature.get(i).setVisible(true);
         }
    }

    public void switchToAssistantCard(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/AssistantCard.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToCharacterCard(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/CharacterCard.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public int getCloudSelected() {
        return cloudSelected;
    }

    public boolean cloudIsAlreadySelected() {
        return cloudIsAlreadySelected;
    }

    public Pane getRootFXML() {
        return rootFXML;
    }
}