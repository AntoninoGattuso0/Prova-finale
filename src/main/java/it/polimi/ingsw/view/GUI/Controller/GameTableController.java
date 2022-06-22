package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.model.ColorTower;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
public class GameTableController {
    @FXML BorderPane showSchool1;
    @FXML BorderPane showSchool2;
    @FXML BorderPane showSchool3;
    @FXML BorderPane showSchool0;
    @FXML BorderPane showAssistant;
    @FXML BorderPane showCharacterCard;
    @FXML Button CharacterCard;
    @FXML ChoiceBox<String> SchoolBoard;
    @FXML Button AssistantCardButton;
    @FXML Button fourthButton;
    @FXML Button thirdButton;
    @FXML Button secondButton;
    @FXML Button firstButton;
    @FXML Pane messagesActions;
    @FXML Text textRed0;
    @FXML Text textBlue0;
    @FXML Text textYellow11;
    @FXML Text textGreen11;
    @FXML Text textBlue11;
    @FXML Text textRed11;
    @FXML Text textPink11;
    @FXML Text textPink10;
    @FXML Text textYellow10;
    @FXML Text textGreen10;
    @FXML Text textBlue10;
    @FXML Text textRed10;
    @FXML Text textPink9;
    @FXML Text textYellow9;
    @FXML Text textGreen9;
    @FXML Text textBlue9;
    @FXML Text textRed9;
    @FXML Text textPink8;
    @FXML Text textYellow8;
    @FXML Text textGreen8;
    @FXML Text textBlue8;
    @FXML Text textRed8;
    @FXML Text textYellow7;
    @FXML Text textGreen7;
    @FXML Text textBlue7;
    @FXML Text textPink7;
    @FXML Text textRed7;
    @FXML Text textYellow6;
    @FXML Text textPink6;
    @FXML Text textGreen6;
    @FXML Text textBlue6;
    @FXML Text textRed6;
    @FXML Text textYellow5;
    @FXML Text textGreen5;
    @FXML Text textBlue5;
    @FXML Text textRed5;
    @FXML Text textPink5;
    @FXML Text textYellow4;
    @FXML Text textPink4;
    @FXML Text textGreen4;
    @FXML Text textBlue4;
    @FXML Text textRed4;
    @FXML Text textPink3;
    @FXML Text textYellow3;
    @FXML Text textGreen3;
    @FXML Text textBlue3;
    @FXML Text textRed3;
    @FXML Text textPink2;
    @FXML Text textYellow2;
    @FXML Text textGreen2;
    @FXML Text textBlue2;
    @FXML Text textRed2;
    @FXML Text textPink1;
    @FXML Text textYellow1;
    @FXML Text textGreen1;
    @FXML Text textBlue1;
    @FXML Text textRed1;
    @FXML Text textPink0;
    @FXML Text textYellow0;
    @FXML Text textGreen0;
    Gui gui;
    LightGame lightGame;
    @FXML
    Pane gameTable;

    @FXML Text turnOf;
    @FXML Text messages;
    FXMLLoader fxmlLoader;
    SchoolBoard0Controller schoolBoard0Controller;
    AssistantCardController assistantCardController;
    public BorderPane getShowSchool0(){return showSchool0;}
    public BorderPane getShowAssistant(){return showAssistant;}
    public BorderPane getShowCharacterCard(){return showCharacterCard;}
    public void setGui(Gui gui) {
        this.gui = gui;
        this.lightGame = gui.getLightGame();
        this.schoolBoard0Controller = gui.getSchoolBoard0Controller();
        this.assistantCardController = gui.getAssistantCardController();
    }
    //Setta l'ordine del turno in alto a sinistra
    public void setTurnOf(ArrayList<String> player) {
        int i;
        turnOf.setText("TURN ORDER:\n"+player.get(0)+"\n");
        for (i = 1; i < player.size(); i++)
            turnOf.setText(turnOf.getText()+player.get(i) + "\n");
    }
    public void setMessages(Text messages) {
        this.messages = messages;
    }
    public void setAllIslands(boolean visible, boolean disabled) {
        for (int i = 0; i < lightGame.getIslands().size(); i++) {
            String name = "#island" + String.valueOf(i);
            gameTable.lookup(name).setVisible(visible);
            gameTable.lookup(name).setDisable(disabled);
        }
    }
    public void setButtonOff(){
        firstButton.setDisable(true);
        firstButton.setVisible(false);
        secondButton.setVisible(false);
        secondButton.setDisable(true);
        thirdButton.setDisable(true);
        thirdButton.setVisible(false);
        fourthButton.setVisible(false);
        fourthButton.setDisable(true);
        messagesActions.setVisible(false);
        messagesActions.setDisable(true);
    }
    public void setAssistantSchoolBoardCharacter(){
        AssistantCardButton.setDisable(false);
        AssistantCardButton.setVisible(true);
        CharacterCard.setVisible(true);
        CharacterCard.setDisable(false);
        SchoolBoard.setVisible(true);
        int i;
        for(i=0;i<lightGame.getPlayers().size();i++) {
            SchoolBoard.getItems().add("Board "+lightGame.getPlayers().get(i).getNickname());
            // if the item of the list is changed
            SchoolBoard.getSelectionModel().selectedIndexProperty().addListener((ov, value, new_value) -> {
                // set the SchoolBoard for the selected item
                if((int)new_value == 0){
                    showAssistant.setVisible(false);
                    showCharacterCard.setVisible(false);
                    showSchool0.setVisible(true);
                    showSchool1.setVisible(false);
                    showSchool2.setVisible(false);
                    showSchool3.setVisible(false);
                }
                else if((int)new_value == 1){
                    showAssistant.setVisible(false);
                    showCharacterCard.setVisible(false);
                    showSchool0.setVisible(false);
                    showSchool1.setVisible(true);
                    showSchool2.setVisible(false);
                    showSchool3.setVisible(false);
                }
                else if((int)new_value == 2){
                    showAssistant.setVisible(false);
                    showCharacterCard.setVisible(false);
                    showSchool0.setVisible(false);
                    showSchool1.setVisible(false);
                    showSchool2.setVisible(true);
                    showSchool3.setVisible(false);
                }
                else if((int)new_value == 3){
                    showAssistant.setVisible(false);
                    showCharacterCard.setVisible(false);
                    showSchool0.setVisible(false);
                    showSchool1.setVisible(false);
                    showSchool2.setVisible(false);
                    showSchool3.setVisible(true);
                }
            });
        }
    }
    public void setPawnVisible() {
        int n;
        int i;
        int num;
        for (n = 0; n < gui.getLightGame().getIslands().size(); n++) {
            String str="#island"+ n;
            gameTable.lookup(str).setVisible(true);
            for (i = 0; i < 5; i++) {
                if (i == 0) {
                    str="#textGreen"+n;
                    gameTable.lookup(str).setVisible(true);
                    num = gui.getLightGame().getIslands().get(n).getGreenPawn();
                    switch (n) {
                        case 0 -> textGreen0.setText(String.valueOf(num));
                        case 1 -> textGreen1.setText(String.valueOf(num));
                        case 2 -> textGreen2.setText(String.valueOf(num));
                        case 3 -> textGreen3.setText(String.valueOf(num));
                        case 4 -> textGreen4.setText(String.valueOf(num));
                        case 5 -> textGreen5.setText(String.valueOf(num));
                        case 6 -> textGreen6.setText(String.valueOf(num));
                        case 7 -> textGreen7.setText(String.valueOf(num));
                        case 8 -> textGreen8.setText(String.valueOf(num));
                        case 9 -> textGreen9.setText(String.valueOf(num));
                        case 10 -> textGreen10.setText(String.valueOf(num));
                        case 11 -> textGreen11.setText(String.valueOf(num));
                    }
                } else if (i == 1) {
                    num = gui.getLightGame().getIslands().get(n).getRedPawn();
                    switch (n) {
                        case 0 -> textRed0.setText(String.valueOf(num));
                        case 1 -> textRed1.setText(String.valueOf(num));
                        case 2 -> textRed2.setText(String.valueOf(num));
                        case 3 -> textRed3.setText(String.valueOf(num));
                        case 4 -> textRed4.setText(String.valueOf(num));
                        case 5 -> textRed5.setText(String.valueOf(num));
                        case 6 -> textRed6.setText(String.valueOf(num));
                        case 7 -> textRed7.setText(String.valueOf(num));
                        case 8 -> textRed8.setText(String.valueOf(num));
                        case 9 -> textRed9.setText(String.valueOf(num));
                        case 10 -> textRed10.setText(String.valueOf(num));
                        case 11 -> textRed11.setText(String.valueOf(num));
                    }
                } else if (i == 2) {
                    num = gui.getLightGame().getIslands().get(n).getYellowPawn();
                    switch (n) {
                        case 0 -> textYellow0.setText(String.valueOf(num));
                        case 1 -> textYellow1.setText(String.valueOf(num));
                        case 2 -> textYellow2.setText(String.valueOf(num));
                        case 3 -> textYellow3.setText(String.valueOf(num));
                        case 4 -> textYellow4.setText(String.valueOf(num));
                        case 5 -> textYellow5.setText(String.valueOf(num));
                        case 6 -> textYellow6.setText(String.valueOf(num));
                        case 7 -> textYellow7.setText(String.valueOf(num));
                        case 8 -> textYellow8.setText(String.valueOf(num));
                        case 9 -> textYellow9.setText(String.valueOf(num));
                        case 10 -> textYellow10.setText(String.valueOf(num));
                        case 11 -> textYellow11.setText(String.valueOf(num));
                    }
                } else if (i == 3) {
                    num = gui.getLightGame().getIslands().get(n).getPinkPawn();
                    switch (n) {
                        case 0 -> textPink0.setText(String.valueOf(num));
                        case 1 -> textPink1.setText(String.valueOf(num));
                        case 2 -> textPink2.setText(String.valueOf(num));
                        case 3 -> textPink3.setText(String.valueOf(num));
                        case 4 -> textPink4.setText(String.valueOf(num));
                        case 5 -> textPink5.setText(String.valueOf(num));
                        case 6 -> textPink6.setText(String.valueOf(num));
                        case 7 -> textPink7.setText(String.valueOf(num));
                        case 8 -> textPink8.setText(String.valueOf(num));
                        case 9 -> textPink9.setText(String.valueOf(num));
                        case 10 -> textPink10.setText(String.valueOf(num));
                        case 11 -> textPink11.setText(String.valueOf(num));
                    }
                } else if (i == 4) {
                    num = gui.getLightGame().getIslands().get(n).getBluePawn();
                    switch (n) {
                        case 0 -> textBlue0.setText(String.valueOf(num));
                        case 1 -> textBlue1.setText(String.valueOf(num));
                        case 2 -> textBlue2.setText(String.valueOf(num));
                        case 3 -> textBlue3.setText(String.valueOf(num));
                        case 4 -> textBlue4.setText(String.valueOf(num));
                        case 5 -> textBlue5.setText(String.valueOf(num));
                        case 6 -> textBlue6.setText(String.valueOf(num));
                        case 7 -> textBlue7.setText(String.valueOf(num));
                        case 8 -> textBlue8.setText(String.valueOf(num));
                        case 9 -> textBlue9.setText(String.valueOf(num));
                        case 10 -> textBlue10.setText(String.valueOf(num));
                        case 11 -> textBlue11.setText(String.valueOf(num));
                    }
                }
            }
        }
    }
    public void setCloudVisible() {
        int n;
        int i;
        int k=0;
        if(lightGame.getPlayers().size()==3){
            gameTable.lookup("#cloud3").setVisible(false);
        }else if(lightGame.getPlayers().size()==2){
            gameTable.lookup("#cloud3").setVisible(false);
            gameTable.lookup("#cloud2").setVisible(false);
        }
        for (i = 0; i <4; i++) {
            int j;
            for(j=0;j<4;j++) {
                gameTable.lookup("#greenCloud" + i + j).setVisible(false);
                gameTable.lookup("#redCloud" + i + j).setVisible(false);
                gameTable.lookup("#yellowCloud" + i + j).setVisible(false);
                gameTable.lookup("#pinkCloud" + i + j).setVisible(false);
                gameTable.lookup("#blueCloud" + i + j).setVisible(false);
            }
        }
        for (i = 0; i < gui.getLightGame().getPlayers().size(); i++) {
            k=0;
            String name = "#cloud" + i;
            gameTable.lookup(name).setVisible(true);
            gameTable.lookup(name).setDisable(true);
            n=lightGame.getClouds().get(i).getGreenPawn();
            while(n>0){
                gameTable.lookup("#greenCloud"+i+k).setVisible(true);
                k++;
                n--;
            }
            n=lightGame.getClouds().get(i).getRedPawn();
            while(n>0){
                gameTable.lookup("#redCloud"+i+k).setVisible(true);
                k++;
                n--;
            }
            n=lightGame.getClouds().get(i).getYellowPawn();
            while(n>0){
                gameTable.lookup("#yellowCloud"+i+k).setVisible(true);
                k++;
                n--;
            }
            n=lightGame.getClouds().get(i).getPinkPawn();
            while(n>0){
                gameTable.lookup("#pinkCloud"+i+k).setVisible(true);
                k++;
                n--;
            }
            n=lightGame.getClouds().get(i).getBluePawn();
            while(n>0){
                gameTable.lookup("#blueCloud"+i+k).setVisible(true);
                k++;
                n--;
            }
        }
    }
    public void setMotherNatureVisible() {
        int i;
        for (i = 0; i < gui.getLightGame().getIslands().size(); i++) {
            if (gui.getLightGame().getIslands().get(i).getMotherNature()) {
                gameTable.lookup("#motherNature" + i).setVisible(true);
            } else {
                gameTable.lookup("#motherNature" + i).setVisible(false);
            }
        }
    }
    public void setProhibited(){
        int i;
        for(i=0;i<lightGame.getIslands().size();i++){
            if(lightGame.getIslands().get(i).getProhibited()){
                gameTable.lookup("#prohibited"+ i).setVisible(true);
            }else{
                gameTable.lookup("#prohibited"+i).setVisible(false);
            }
        }
    }
    public void setTowers() {
        int i;
        String name=null;
        for (i = 0; i < lightGame.getIslands().size(); i++) {
            String text = "#textIsland" + String.valueOf(i);
            if (lightGame.getIslands().get(i).getTower()) {
                if (lightGame.getIslands().get(i).getColorTower() == ColorTower.BLACK) {
                    name = "#blackTower" + String.valueOf(i);
                    gameTable.lookup("#whiteTower" + String.valueOf(i)).setVisible(false);
                    gameTable.lookup("#greyTower" + String.valueOf(i)).setVisible(false);
                } else if (lightGame.getIslands().get(i).getColorTower() == ColorTower.WHITE) {
                    name = "#whiteTower" + String.valueOf(i);
                    gameTable.lookup("#blackTower" + String.valueOf(i)).setVisible(false);
                    gameTable.lookup("#greyTower" + String.valueOf(i)).setVisible(false);
                } else if (lightGame.getIslands().get(i).getColorTower() == ColorTower.GREY) {
                    name = "#greyTower" + String.valueOf(i);
                    gameTable.lookup("#whiteTower" + String.valueOf(i)).setVisible(false);
                    gameTable.lookup("#blackTower" + String.valueOf(i)).setVisible(false);
                }
                gameTable.lookup(name).setVisible(true);
            } else {
                gameTable.lookup("#whiteTower" + String.valueOf(i)).setVisible(false);
                gameTable.lookup("#blackTower" + String.valueOf(i)).setVisible(false);
                gameTable.lookup("#greyTower" + String.valueOf(i)).setVisible(false);
            }
            gameTable.lookup(text).setVisible(true);
        }
    }
    public void island0Select(MouseEvent mouseEvent) {
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
    public void switchToAssistantCard(MouseEvent mouseEvent) {
        showAssistant.setVisible(true);
        showCharacterCard.setVisible(false);
        showSchool0.setVisible(false);
        showSchool1.setVisible(false);
        showSchool2.setVisible(false);
        showSchool3.setVisible(false);
    }
    public void switchToCharacterCard(MouseEvent mouseEvent) {
        showAssistant.setVisible(false);
        showCharacterCard.setVisible(true);
        showSchool0.setVisible(false);
        showSchool1.setVisible(false);
        showSchool2.setVisible(false);
        showSchool3.setVisible(false);
    }



    public void initializeBorderPane(){
        Pane view = getPage("AssistantCard");
        showAssistant.setCenter(view);
        showAssistant.setVisible(false);
        view = getPage("CharacterCard");
        showCharacterCard.setCenter(view);
        showCharacterCard.setVisible(false);
        view = getPage("SchoolBoard0");
        showSchool0.setCenter(view);
        showSchool0.setVisible(false);
        view = getPage("SchoolBoard1");
        showSchool1.setCenter(view);
        showSchool1.setVisible(false);
        if(lightGame.getNumPlayers()>2){
            view = getPage("SchoolBoard2");
            showSchool2.setCenter(view);
            showSchool2.setVisible(false);
        }
        if(lightGame.getNumPlayers()>3){
            view = getPage("SchoolBoard3");
            showSchool3.setCenter(view);
            showSchool3.setVisible(false);
        }
    }

    public void switchToSchoolBoard(MouseEvent mouseEvent) {
        int num = -1;
        String ciao = SchoolBoard.getValue();
        System.out.println(ciao);
        if(SchoolBoard.getValue() != null) {
            if (SchoolBoard.getValue().equals("Board " + lightGame.getPlayers().get(0).getNickname())) {
                schoolBoard0Controller= gui.getSchoolBoard0Controller();
                schoolBoard0Controller.setSchoolBoard0();

            } else if (SchoolBoard.getValue().equals("Board " + lightGame.getPlayers().get(1).getNickname())) {
                Pane view = getPage("SchoolBoard1");
                showCharacterCard.setCenter(view);
            } else if (SchoolBoard.getValue().equals("Board " + lightGame.getPlayers().get(2).getNickname())) {
                Pane view = getPage("SchoolBoard2");
                showCharacterCard.setCenter(view);
            } else if (SchoolBoard.getValue().equals("Board " + lightGame.getPlayers().get(3).getNickname())) {
                Pane view = getPage("SchoolBoard3");
                showCharacterCard.setCenter(view);
            }
        }
    }
    public void island11Select(MouseEvent mouseEvent) {
    }
    public void island10Select(MouseEvent mouseEvent) {
    }
    public void island9Select(MouseEvent mouseEvent) {
    }
    public void island8Select(MouseEvent mouseEvent) {
    }
    public void island1Select(MouseEvent mouseEvent) {
    }
    public void island2Select(MouseEvent mouseEvent) {
    }
    public void island3Select(MouseEvent mouseEvent) {
    }
    public void island4Select(MouseEvent mouseEvent) {
    }
    public void island5elect(MouseEvent mouseEvent) {
    }
    public void island6Select(MouseEvent mouseEvent) {
    }
    public void island7Select(MouseEvent mouseEvent) {
    }
    public void cloud0select(MouseEvent mouseEvent) {
    }
    public void cloud1select(MouseEvent mouseEvent) {
    }
    public void cloud2select(MouseEvent mouseEvent) {
    }
    public void cloud3select(MouseEvent mouseEvent) {
    }
}
/*package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.model.ColorTower;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class GameTableController {
    @FXML AnchorPane root;
    @FXML BorderPane showSchool1;
    @FXML BorderPane showSchool2;
    @FXML BorderPane showSchool3;
    @FXML BorderPane showSchool0;
    @FXML BorderPane showAssistant;
    @FXML Button CharacterCard;
    @FXML ChoiceBox<String> SchoolBoard;
    @FXML Button AssistantCardButton;
    @FXML Button fourthButton;
    @FXML Button thirdButton;
    @FXML Button secondButton;
    @FXML Button firstButton;
    @FXML Pane messagesActions;
    @FXML Text textRed0;
    @FXML Text textBlue0;
    @FXML Text textYellow11;
    @FXML Text textGreen11;
    @FXML Text textBlue11;
    @FXML Text textRed11;
    @FXML Text textPink11;
    @FXML Text textPink10;
    @FXML Text textYellow10;
    @FXML Text textGreen10;
    @FXML Text textBlue10;
    @FXML Text textRed10;
    @FXML Text textPink9;
    @FXML Text textYellow9;
    @FXML Text textGreen9;
    @FXML Text textBlue9;
    @FXML Text textRed9;
    @FXML Text textPink8;
    @FXML Text textYellow8;
    @FXML Text textGreen8;
    @FXML Text textBlue8;
    @FXML Text textRed8;
    @FXML Text textYellow7;
    @FXML Text textGreen7;
    @FXML Text textBlue7;
    @FXML Text textPink7;
    @FXML Text textRed7;
    @FXML Text textYellow6;
    @FXML Text textPink6;
    @FXML Text textGreen6;
    @FXML Text textBlue6;
    @FXML Text textRed6;
    @FXML Text textYellow5;
    @FXML Text textGreen5;
    @FXML Text textBlue5;
    @FXML Text textRed5;
    @FXML Text textPink5;
    @FXML Text textYellow4;
    @FXML Text textPink4;
    @FXML Text textGreen4;
    @FXML Text textBlue4;
    @FXML Text textRed4;
    @FXML Text textPink3;
    @FXML Text textYellow3;
    @FXML Text textGreen3;
    @FXML Text textBlue3;
    @FXML Text textRed3;
    @FXML Text textPink2;
    @FXML Text textYellow2;
    @FXML Text textGreen2;
    @FXML Text textBlue2;
    @FXML Text textRed2;
    @FXML Text textPink1;
    @FXML Text textYellow1;
    @FXML Text textGreen1;
    @FXML Text textBlue1;
    @FXML Text textRed1;
    @FXML Text textPink0;
    @FXML Text textYellow0;
    @FXML Text textGreen0;
    Gui gui;
    LightGame lightGame;
    @FXML
    Pane gameTable;
    @FXML
    BorderPane showCharacterCard;
    @FXML Text turnOf;
    @FXML Text messages;

    FXMLLoader school2fxmlLoader;
    FXMLLoader assistantLoader;
    FXMLLoader characterLoader;
    FXMLLoader school0fxmlLoader;
    FXMLLoader school1fxmlLoader;
    FXMLLoader school3fxmlLoader;


    int c=0;
    int a=0;
    int sb0=0;
    int sb1=0;
    int sb2=0;
    int sb3=0;
    SchoolBoard0Controller schoolBoard0Controller;
    CharacterCardController characterCardController;
    AssistantCardController assistantCardController;
    SchoolBoard1Controller schoolBoard1Controller;
    SchoolBoard2Controller schoolBoard2Controller;
    SchoolBoard3Controller schoolBoard3Controller;

    public BorderPane getShowSchool0(){return showSchool0;}

    public void setGui(Gui gui) {
        this.gui = gui;
        this.lightGame = gui.getLightGame();
    }
        //Setta l'ordine del turno in alto a sinistra
    public void setTurnOf(ArrayList<String> player) {
        int i;
        turnOf.setText("TURN ORDER:\n"+player.get(0)+"\n");
        for (i = 1; i < player.size(); i++)
            turnOf.setText(turnOf.getText()+player.get(i) + "\n");
    }

    public void setMessages(Text messages) {
        this.messages = messages;
    }

    public void setAllIslands(boolean visible, boolean disabled) {
        for (int i = 0; i < lightGame.getIslands().size(); i++) {
            String name = "#island" + String.valueOf(i);
            gameTable.lookup(name).setVisible(visible);
            gameTable.lookup(name).setDisable(disabled);
        }
    }
    public void setButtonOff(){
        firstButton.setDisable(true);
        firstButton.setVisible(false);
        secondButton.setVisible(false);
        secondButton.setDisable(true);
        thirdButton.setDisable(true);
        thirdButton.setVisible(false);
        fourthButton.setVisible(false);
        fourthButton.setDisable(true);
        messagesActions.setVisible(false);
        messagesActions.setDisable(true);
    }
    public void setAssistantSchoolBoardCharacter(){
        AssistantCardButton.setDisable(false);
        AssistantCardButton.setVisible(true);
        CharacterCard.setVisible(true);
        CharacterCard.setDisable(false);
        SchoolBoard.setVisible(true);
        int i;
        for(i=0;i<lightGame.getPlayers().size();i++) {
            SchoolBoard.getItems().add("Board "+lightGame.getPlayers().get(i).getNickname());
            // if the item of the list is changed
            SchoolBoard.getSelectionModel().selectedIndexProperty().addListener((ov, value, new_value) -> {
            // set the SchoolBoard for the selected item
                if((int)new_value == 0){
                    showAssistant.setVisible(false);
                    showCharacterCard.setVisible(false);
                    showSchool0.setVisible(true);
                    showSchool1.setVisible(false);
                    showSchool2.setVisible(false);
                    showSchool3.setVisible(false);
                }
                else if((int)new_value == 1){
                    showAssistant.setVisible(false);
                    showCharacterCard.setVisible(false);
                    showSchool0.setVisible(false);
                    showSchool1.setVisible(true);
                    showSchool2.setVisible(false);
                    showSchool3.setVisible(false);
                }
                else if((int)new_value == 2){
                    showAssistant.setVisible(false);
                    showCharacterCard.setVisible(false);
                    showSchool0.setVisible(false);
                    showSchool1.setVisible(false);
                    showSchool2.setVisible(true);
                    showSchool3.setVisible(false);
                }
                else if((int)new_value == 3){
                    showAssistant.setVisible(false);
                    showCharacterCard.setVisible(false);
                    showSchool0.setVisible(false);
                    showSchool1.setVisible(false);
                    showSchool2.setVisible(false);
                    showSchool3.setVisible(true);
                }
            });
        }

    }
    public void setPawnVisible() {
        int n;
        int i;
        int num;
        for (n = 0; n < gui.getLightGame().getIslands().size(); n++) {
            String str="#island"+ n;
            gameTable.lookup(str).setVisible(true);
            for (i = 0; i < 5; i++) {

                if (i == 0) {
                     str="#textGreen"+n;
                    gameTable.lookup(str).setVisible(true);
                    num = gui.getLightGame().getIslands().get(n).getGreenPawn();
                    switch (n) {
                        case 0 -> textGreen0.setText(String.valueOf(num));
                        case 1 -> textGreen1.setText(String.valueOf(num));
                        case 2 -> textGreen2.setText(String.valueOf(num));
                        case 3 -> textGreen3.setText(String.valueOf(num));
                        case 4 -> textGreen4.setText(String.valueOf(num));
                        case 5 -> textGreen5.setText(String.valueOf(num));
                        case 6 -> textGreen6.setText(String.valueOf(num));
                        case 7 -> textGreen7.setText(String.valueOf(num));
                        case 8 -> textGreen8.setText(String.valueOf(num));
                        case 9 -> textGreen9.setText(String.valueOf(num));
                        case 10 -> textGreen10.setText(String.valueOf(num));
                        case 11 -> textGreen11.setText(String.valueOf(num));
                    }
                } else if (i == 1) {
                    num = gui.getLightGame().getIslands().get(n).getRedPawn();
                    switch (n) {
                        case 0 -> textRed0.setText(String.valueOf(num));
                        case 1 -> textRed1.setText(String.valueOf(num));
                        case 2 -> textRed2.setText(String.valueOf(num));
                        case 3 -> textRed3.setText(String.valueOf(num));
                        case 4 -> textRed4.setText(String.valueOf(num));
                        case 5 -> textRed5.setText(String.valueOf(num));
                        case 6 -> textRed6.setText(String.valueOf(num));
                        case 7 -> textRed7.setText(String.valueOf(num));
                        case 8 -> textRed8.setText(String.valueOf(num));
                        case 9 -> textRed9.setText(String.valueOf(num));
                        case 10 -> textRed10.setText(String.valueOf(num));
                        case 11 -> textRed11.setText(String.valueOf(num));
                    }
                } else if (i == 2) {
                    num = gui.getLightGame().getIslands().get(n).getYellowPawn();
                    switch (n) {
                        case 0 -> textYellow0.setText(String.valueOf(num));
                        case 1 -> textYellow1.setText(String.valueOf(num));
                        case 2 -> textYellow2.setText(String.valueOf(num));
                        case 3 -> textYellow3.setText(String.valueOf(num));
                        case 4 -> textYellow4.setText(String.valueOf(num));
                        case 5 -> textYellow5.setText(String.valueOf(num));
                        case 6 -> textYellow6.setText(String.valueOf(num));
                        case 7 -> textYellow7.setText(String.valueOf(num));
                        case 8 -> textYellow8.setText(String.valueOf(num));
                        case 9 -> textYellow9.setText(String.valueOf(num));
                        case 10 -> textYellow10.setText(String.valueOf(num));
                        case 11 -> textYellow11.setText(String.valueOf(num));
                    }
                } else if (i == 3) {
                    num = gui.getLightGame().getIslands().get(n).getPinkPawn();
                    switch (n) {
                        case 0 -> textPink0.setText(String.valueOf(num));
                        case 1 -> textPink1.setText(String.valueOf(num));
                        case 2 -> textPink2.setText(String.valueOf(num));
                        case 3 -> textPink3.setText(String.valueOf(num));
                        case 4 -> textPink4.setText(String.valueOf(num));
                        case 5 -> textPink5.setText(String.valueOf(num));
                        case 6 -> textPink6.setText(String.valueOf(num));
                        case 7 -> textPink7.setText(String.valueOf(num));
                        case 8 -> textPink8.setText(String.valueOf(num));
                        case 9 -> textPink9.setText(String.valueOf(num));
                        case 10 -> textPink10.setText(String.valueOf(num));
                        case 11 -> textPink11.setText(String.valueOf(num));
                    }
                } else if (i == 4) {
                    num = gui.getLightGame().getIslands().get(n).getBluePawn();
                    switch (n) {
                        case 0 -> textBlue0.setText(String.valueOf(num));
                        case 1 -> textBlue1.setText(String.valueOf(num));
                        case 2 -> textBlue2.setText(String.valueOf(num));
                        case 3 -> textBlue3.setText(String.valueOf(num));
                        case 4 -> textBlue4.setText(String.valueOf(num));
                        case 5 -> textBlue5.setText(String.valueOf(num));
                        case 6 -> textBlue6.setText(String.valueOf(num));
                        case 7 -> textBlue7.setText(String.valueOf(num));
                        case 8 -> textBlue8.setText(String.valueOf(num));
                        case 9 -> textBlue9.setText(String.valueOf(num));
                        case 10 -> textBlue10.setText(String.valueOf(num));
                        case 11 -> textBlue11.setText(String.valueOf(num));
                    }
                }
            }
        }

    }

    public void setCloudVisible() {
        int n;
        int i;
        int k=0;
        if(lightGame.getPlayers().size()==3){
            gameTable.lookup("#cloud3").setVisible(false);
        }else if(lightGame.getPlayers().size()==2){
            gameTable.lookup("#cloud3").setVisible(false);
            gameTable.lookup("#cloud2").setVisible(false);
        }
        for (i = 0; i <4; i++) {
            int j;
            for(j=0;j<4;j++) {
                gameTable.lookup("#greenCloud" + i + j).setVisible(false);
                gameTable.lookup("#redCloud" + i + j).setVisible(false);
                gameTable.lookup("#yellowCloud" + i + j).setVisible(false);
                gameTable.lookup("#pinkCloud" + i + j).setVisible(false);
                gameTable.lookup("#blueCloud" + i + j).setVisible(false);
            }
        }
        for (i = 0; i < gui.getLightGame().getPlayers().size(); i++) {
            k=0;
            String name = "#cloud" + i;
            gameTable.lookup(name).setVisible(true);
            gameTable.lookup(name).setDisable(true);
            n=lightGame.getClouds().get(i).getGreenPawn();
            while(n>0){
                gameTable.lookup("#greenCloud"+i+k).setVisible(true);
                k++;
                n--;
            }
            n=lightGame.getClouds().get(i).getRedPawn();
            while(n>0){
                gameTable.lookup("#redCloud"+i+k).setVisible(true);
                k++;
                n--;
            }
            n=lightGame.getClouds().get(i).getYellowPawn();
            while(n>0){
                gameTable.lookup("#yellowCloud"+i+k).setVisible(true);
                k++;
                n--;
            }
            n=lightGame.getClouds().get(i).getPinkPawn();
            while(n>0){
                gameTable.lookup("#pinkCloud"+i+k).setVisible(true);
                k++;
                n--;
            }
            n=lightGame.getClouds().get(i).getBluePawn();
            while(n>0){
                gameTable.lookup("#blueCloud"+i+k).setVisible(true);
                k++;
                n--;
            }
        }
    }

    public void setMotherNatureVisible() {
        int i;
        for (i = 0; i < gui.getLightGame().getIslands().size(); i++) {

            if (gui.getLightGame().getIslands().get(i).getMotherNature()) {
                gameTable.lookup("#motherNature" + i).setVisible(true);
            } else {
                gameTable.lookup("#motherNature" + i).setVisible(false);
            }
        }
    }
    public void setProhibited(){
        int i;
        for(i=0;i<lightGame.getIslands().size();i++){
            if(lightGame.getIslands().get(i).getProhibited()){
                gameTable.lookup("#prohibited"+ i).setVisible(true);
            }else{
                gameTable.lookup("#prohibited"+i).setVisible(false);
            }
        }
    }
    public void setTowers() {
        int i;
        String name=null;
        for (i = 0; i < lightGame.getIslands().size(); i++) {
            String text = "#textIsland" + String.valueOf(i);
            if (lightGame.getIslands().get(i).getTower()) {
                if (lightGame.getIslands().get(i).getColorTower() == ColorTower.BLACK) {
                    name = "#blackTower" + String.valueOf(i);
                    gameTable.lookup("#whiteTower" + String.valueOf(i)).setVisible(false);
                    gameTable.lookup("#greyTower" + String.valueOf(i)).setVisible(false);
                } else if (lightGame.getIslands().get(i).getColorTower() == ColorTower.WHITE) {
                    name = "#whiteTower" + String.valueOf(i);
                    gameTable.lookup("#blackTower" + String.valueOf(i)).setVisible(false);
                    gameTable.lookup("#greyTower" + String.valueOf(i)).setVisible(false);
                } else if (lightGame.getIslands().get(i).getColorTower() == ColorTower.GREY) {
                    name = "#greyTower" + String.valueOf(i);
                    gameTable.lookup("#whiteTower" + String.valueOf(i)).setVisible(false);
                    gameTable.lookup("#blackTower" + String.valueOf(i)).setVisible(false);

                }
                gameTable.lookup(name).setVisible(true);
            } else {
                gameTable.lookup("#whiteTower" + String.valueOf(i)).setVisible(false);
                gameTable.lookup("#blackTower" + String.valueOf(i)).setVisible(false);
                gameTable.lookup("#greyTower" + String.valueOf(i)).setVisible(false);
            }
            gameTable.lookup(text).setVisible(true);
        }
    }

   public void island0Select(MouseEvent mouseEvent) {
    }

    public Pane getPage(String fileName) {
        Pane view = null;
        try {
            URL fileUrl = getClass().getResource("/"+fileName + ".fxml");

            if (fileUrl == null)
                throw new java.io.FileNotFoundException("Impossibile trovare file");
            if(Objects.equals(fileName, "AssistantCard") &&a==0) {
                assistantLoader= new FXMLLoader();
                assistantLoader.setLocation(getClass().getResource("/"+fileName+".fxml"));
                assistantCardController=assistantLoader.getController();
                a=1;
            }else if(Objects.equals(fileName, "CharacterCard") &&c==0){
                c=1;
                characterLoader= new FXMLLoader();
                characterLoader.setLocation(getClass().getResource("/"+fileName+".fxml"));
                characterCardController= characterLoader.getController();
            }else if(Objects.equals(fileName, "SchoolBoard0")&&sb0==0){
               school0fxmlLoader= new FXMLLoader();
                school0fxmlLoader.setLocation(getClass().getResource("/"+fileName+".fxml"));
                school0fxmlLoader= school0fxmlLoader.getController();
                sb0=1;
            }else if(Objects.equals(fileName,"SchoolBoard1")&&sb1==0){
                school1fxmlLoader= new FXMLLoader();
                school1fxmlLoader.setLocation(getClass().getResource("/"+fileName+".fxml"));
                school1fxmlLoader= school1fxmlLoader.getController();
                sb1=1;
            }else if(Objects.equals(fileName,"SchoolBoard2")&&sb2==0){
                school2fxmlLoader= new FXMLLoader();
                school2fxmlLoader.setLocation(getClass().getResource("/"+fileName+".fxml"));
                school2fxmlLoader= school0fxmlLoader.getController();
                sb2=1;
            }else if(Objects.equals(fileName,"SchoolBoard3")&&sb3==0) {
                school3fxmlLoader= new FXMLLoader();
                school3fxmlLoader.setLocation(getClass().getResource("/"+fileName+".fxml"));
                school3fxmlLoader= school3fxmlLoader.getController();
                sb3=1;
            }
            view = FXMLLoader.load(fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No Page Found");
        }
    return view;
}
    public void switchToAssistantCard(MouseEvent mouseEvent) {
       showAssistant.setVisible(true);
       showCharacterCard.setVisible(false);
       showSchool0.setVisible(false);
       showSchool1.setVisible(false);
       showSchool2.setVisible(false);
       showSchool3.setVisible(false);
        Platform.runLater(()->{
            assistantCardController.setInvisibile(2);
            assistantCardController.setInvisibile(4);
        });
    }


    public void switchToCharacterCard(MouseEvent mouseEvent) {
        showAssistant.setVisible(false);
        showCharacterCard.setVisible(true);
        showSchool0.setVisible(false);
        showSchool1.setVisible(false);
        showSchool2.setVisible(false);
        showSchool3.setVisible(false);
        Platform.runLater(()->{
            assistantCardController.setInvisibile(2);
            assistantCardController.setInvisibile(4);
        });
    }


public void initializeBorderPane(){
        Platform.runLater(()->{
            Pane view;
            view = getPage("AssistantCard");
            showAssistant.setCenter(view);
            showAssistant.setVisible(false);

            view = getPage("CharacterCard");
            showCharacterCard.setCenter(view);
            showCharacterCard.setVisible(false);

            view = getPage("SchoolBoard0");
            showSchool0.setCenter(view);
            showSchool0.setVisible(false);

            view = getPage("SchoolBoard1");
            showSchool1.setCenter(view);
            showSchool1.setVisible(false);
            if(lightGame.getPlayers().size()>2) {
                view = getPage("SchoolBoard2");
                showSchool2.setCenter(view);
                showSchool2.setVisible(false);
            }
            if(lightGame.getPlayers().size()>3) {
                view = getPage("SchoolBoard3");
                showSchool3.setCenter(view);
                showSchool3.setVisible(false);
            }
            System.out.println("ciao");
        });
        if(assistantCardController==null)
            System.out.println("controller null fuori");
        Platform.runLater(() ->{
            if(assistantCardController==null)
                System.out.println("controller null dentro");
        });
    }

    public void island11Select(MouseEvent mouseEvent) {
    }

    public void island10Select(MouseEvent mouseEvent) {
    }

    public void island9Select(MouseEvent mouseEvent) {
    }

    public void island8Select(MouseEvent mouseEvent) {
    }

    public void island1Select(MouseEvent mouseEvent) {
    }

    public void island2Select(MouseEvent mouseEvent) {
    }

    public void island3Select(MouseEvent mouseEvent) {
    }

    public void island4Select(MouseEvent mouseEvent) {
    }

    public void island5elect(MouseEvent mouseEvent) {
    }

    public void island6Select(MouseEvent mouseEvent) {
    }

    public void island7Select(MouseEvent mouseEvent) {
    }

    public void cloud0select(MouseEvent mouseEvent) {
    }

    public void cloud1select(MouseEvent mouseEvent) {
    }

    public void cloud2select(MouseEvent mouseEvent) {
    }

    public void cloud3select(MouseEvent mouseEvent) {
    }

    public void switchToSchoolBoard0(MouseEvent mouseEvent) throws IOException {
        URL fileUrl = getClass().getResource("/SchoolBoard0.fxml");
        assert fileUrl != null;
        BorderPane view=FXMLLoader.load(fileUrl);
        showAssistant.setCenter(view);
        showAssistant.setVisible(true);
    }

    public void switchToSchoolBoard1(MouseEvent mouseEvent) throws IOException {
        URL fileUrl= getClass().getResource("/SchoolBoard1.fxml");
        assert fileUrl != null;
        BorderPane view=FXMLLoader.load(fileUrl);
        showSchool1.setCenter(view);
        showSchool1.setVisible(true);
    }

    public void switchToSchoolBoard2(MouseEvent mouseEvent) throws IOException {
        URL fileUrl= getClass().getResource("/SchoolBoard2.fxml");
        assert fileUrl != null;
        BorderPane view=FXMLLoader.load(fileUrl);
        showSchool2.setCenter(view);
        showSchool2.setVisible(true);
    }

    public void switchToSchoolBoard3(MouseEvent mouseEvent) throws IOException {
        URL fileUrl= getClass().getResource("/SchoolBoard3.fxml");
        assert fileUrl != null;
        BorderPane view=FXMLLoader.load(fileUrl);
        showSchool3.setCenter(view);
        showSchool3.setVisible(true);
    }}*/

