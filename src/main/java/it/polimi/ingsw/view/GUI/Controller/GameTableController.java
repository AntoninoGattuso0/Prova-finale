package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.model.ColorTower;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.ArrayList;
public class GameTableController {
    @FXML BorderPane showSchool1;
    @FXML BorderPane showSchool2;
    @FXML BorderPane showSchool3;
    @FXML BorderPane showSchool0;
    @FXML BorderPane showAssistant;
    @FXML BorderPane showCharacterCard;
    @FXML Button CharacterCardButton;
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
    @FXML
    Pane gameTable;

    @FXML Text turnOf;
    @FXML Text messages;
    FXMLLoader fxmlLoader;
    SchoolBoard0Controller schoolBoard0Controller;
    AssistantCardController assistantCardController;
    CharacterCardController characterCardController;
    SchoolBoard1Controller schoolBoard1Controller;
    SchoolBoard2Controller schoolBoard2Controller;
    SchoolBoard3Controller schoolBoard3Controller;
    public BorderPane getShowSchool0(){return showSchool0;}
    public BorderPane getShowAssistant(){return showAssistant;}
    public BorderPane getShowCharacterCard(){return showCharacterCard;}
    public Pane getGameTablePane(){return gameTable;}
    public void setGui(Gui gui) {
        this.gui = gui;
    }

    //Setta l'ordine del turno in alto a sinistra
    public void setTurnOf(ArrayList<String> player) {
        int i;
        turnOf.setText("TURN ORDER:\n"+player.get(0)+"\n");
        for (i = 1; i < player.size(); i++)
            turnOf.setText(turnOf.getText()+player.get(i) + "\n");
    }
    public void setMessages(String messages) {
        this.messages.setText(messages);
    }
    public void setAllIslands(boolean visible, boolean disabled) {
        for (int i = 0; i < gui.getLightGame().getIslands().size(); i++) {
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
        CharacterCardButton.setVisible(true);
        CharacterCardButton.setDisable(false);
        SchoolBoard.setVisible(true);
        int i;
        for(i=0;i<gui.getLightGame().getPlayers().size();i++) {
            SchoolBoard.getItems().add("Board "+gui.getLightGame().getPlayers().get(i).getNickname());
            // if the item of the list is changed
            SchoolBoard.getSelectionModel().selectedIndexProperty().addListener((ov, value, new_value) -> {
                // set the SchoolBoard for the selected item
                if((int)new_value == 0){
                    schoolBoard0Controller= gui.getSchoolBoard0Controller();
                    schoolBoard0Controller.setSchoolBoard0();
                    showSchool0.setCenter(schoolBoard0Controller.getSchoolBoard0());
                    showSchool0.setVisible(true);
                    showAssistant.setVisible(false);
                    showCharacterCard.setVisible(false);
                    showSchool1.setVisible(false);
                    showSchool2.setVisible(false);
                    showSchool3.setVisible(false);
                }
                else if((int)new_value == 1){
                    schoolBoard1Controller= gui.getSchoolBoard1Controller();
                    schoolBoard1Controller.setSchoolBoard1();
                    showSchool1.setCenter(schoolBoard1Controller.getSchoolBoard1());
                    showAssistant.setVisible(false);
                    showCharacterCard.setVisible(false);
                    showSchool0.setVisible(false);
                    showSchool1.setVisible(true);
                    showSchool2.setVisible(false);
                    showSchool3.setVisible(false);
                }
                else if((int)new_value == 2){
                    schoolBoard2Controller= gui.getSchoolBoard2Controller();
                    schoolBoard2Controller.setSchoolBoard2();
                    showSchool2.setCenter(schoolBoard2Controller.getSchoolBoard2());
                    showAssistant.setVisible(false);
                    showCharacterCard.setVisible(false);
                    showSchool0.setVisible(false);
                    showSchool1.setVisible(false);
                    showSchool2.setVisible(true);
                    showSchool3.setVisible(false);
                }
                else if((int)new_value == 3){
                    schoolBoard3Controller= gui.getSchoolBoard3Controller();
                    schoolBoard3Controller.setSchoolBoard3();
                    showSchool3.setCenter(schoolBoard3Controller.getSchoolBoard3());
                    showSchool3.setVisible(true);
                    showAssistant.setVisible(false);
                    showCharacterCard.setVisible(false);
                    showSchool0.setVisible(false);
                    showSchool1.setVisible(false);
                    showSchool2.setVisible(false);;
                }

            });
        }
    }
    public void setChooseViewOff(){
        SchoolBoard.setDisable(true);
        AssistantCardButton.setDisable(true);
        CharacterCardButton.setDisable(true);
    }

    public void setShowAssistant() {
        showSchool0.setVisible(false);
        showCharacterCard.setVisible(false);
        showSchool1.setVisible(false);
        showSchool2.setVisible(false);
        showSchool3.setVisible(false);
        assistantCardController=gui.getAssistantCardController();
        showAssistant.setCenter(assistantCardController.getAssistantCards());
        showAssistant.setVisible(true);
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
        if(gui.getLightGame().getPlayers().size()==3){
            gameTable.lookup("#cloud3").setVisible(false);
        }else if(gui.getLightGame().getPlayers().size()==2){
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
            n=gui.getLightGame().getClouds().get(i).getGreenPawn();
            while(n>0){
                gameTable.lookup("#greenCloud"+i+k).setVisible(true);
                k++;
                n--;
            }
            n=gui.getLightGame().getClouds().get(i).getRedPawn();
            while(n>0){
                gameTable.lookup("#redCloud"+i+k).setVisible(true);
                k++;
                n--;
            }
            n=gui.getLightGame().getClouds().get(i).getYellowPawn();
            while(n>0){
                gameTable.lookup("#yellowCloud"+i+k).setVisible(true);
                k++;
                n--;
            }
            n=gui.getLightGame().getClouds().get(i).getPinkPawn();
            while(n>0){
                gameTable.lookup("#pinkCloud"+i+k).setVisible(true);
                k++;
                n--;
            }
            n=gui.getLightGame().getClouds().get(i).getBluePawn();
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
        for(i=0;i<gui.getLightGame().getIslands().size();i++){
            if(gui.getLightGame().getIslands().get(i).getProhibited()){
                gameTable.lookup("#prohibited"+ i).setVisible(true);
            }else{
                gameTable.lookup("#prohibited"+i).setVisible(false);
            }
        }
    }
    public void setTowers() {
        int i;
        String name=null;
        for (i = 0; i < gui.getLightGame().getIslands().size(); i++) {
            String text = "#textIsland" + String.valueOf(i);
            if (gui.getLightGame().getIslands().get(i).getTower()) {
                if (gui.getLightGame().getIslands().get(i).getColorTower() == ColorTower.BLACK) {
                    name = "#blackTower" + String.valueOf(i);
                    gameTable.lookup("#whiteTower" + String.valueOf(i)).setVisible(false);
                    gameTable.lookup("#greyTower" + String.valueOf(i)).setVisible(false);
                } else if (gui.getLightGame().getIslands().get(i).getColorTower() == ColorTower.WHITE) {
                    name = "#whiteTower" + String.valueOf(i);
                    gameTable.lookup("#blackTower" + String.valueOf(i)).setVisible(false);
                    gameTable.lookup("#greyTower" + String.valueOf(i)).setVisible(false);
                } else if (gui.getLightGame().getIslands().get(i).getColorTower() == ColorTower.GREY) {
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

    public void switchToAssistantCard() {
        showCharacterCard.setVisible(false);
        showSchool0.setVisible(false);
        showSchool1.setVisible(false);
        showSchool2.setVisible(false);
        showSchool3.setVisible(false);
        Platform.runLater(()-> {
                    assistantCardController = gui.getAssistantCardController();
                    assistantCardController.setAssistantCards(gui.getSocketNetworkHandler().getNicknameThisPlayer());
                    showAssistant.setCenter(assistantCardController.getAssistantCards());
            showAssistant.setVisible(true);
                });
    }
    public void switchToCharacterCard(MouseEvent mouseEvent) {
        showAssistant.setVisible(false);
        showSchool0.setVisible(false);
        showSchool1.setVisible(false);
        showSchool2.setVisible(false);
        showSchool3.setVisible(false);
        Platform.runLater(()-> {
            characterCardController=gui.getCharacterCardController();
            characterCardController.setCharacterCards();
            showCharacterCard.setCenter(characterCardController.getCharacterCards());
            showCharacterCard.setVisible(true);
        });
    }



    public void initializeBorderPane(){
        Platform.runLater(()->{
        assistantCardController=gui.getAssistantCardController();
        showAssistant.setCenter(assistantCardController.getAssistantCards());
        showAssistant.setVisible(false);
        characterCardController= gui.getCharacterCardController();
        showCharacterCard.setCenter(characterCardController.getCharacterCards());
        showCharacterCard.setVisible(false);
        schoolBoard0Controller= gui.getSchoolBoard0Controller();
        showSchool0.setCenter(schoolBoard0Controller.getSchoolBoard0());
        showSchool0.setVisible(false);
        schoolBoard1Controller=gui.getSchoolBoard1Controller();
        showSchool1.setCenter(schoolBoard1Controller.getSchoolBoard1());
        showSchool1.setVisible(false);
        if(gui.getLightGame().getNumPlayers()>2){
            schoolBoard2Controller= gui.getSchoolBoard2Controller();
            showSchool2.setCenter(schoolBoard2Controller.getSchoolBoard2());
            showSchool2.setVisible(false);
        }
        if(gui.getLightGame().getNumPlayers()>3){
           schoolBoard3Controller= gui.getSchoolBoard3Controller();
            showSchool3.setCenter(schoolBoard3Controller.getSchoolBoard3());
            showSchool3.setVisible(false);
        }
        });
    }
    public void island0Select(MouseEvent mouseEvent) {
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
        gameTable.lookup("#cloud0").setVisible(false);
    }
    public void cloud1select(MouseEvent mouseEvent) {
        gameTable.lookup("#cloud0").setVisible(false);
    }
    public void cloud2select(MouseEvent mouseEvent) {
        gameTable.lookup("#cloud").setVisible(false);
    }
    public void cloud3select(MouseEvent mouseEvent) {
        gameTable.lookup("#cloud3").setVisible(false);
    }

    public void islandButton(MouseEvent mouseEvent) {
        
    }

    public void characterButton(MouseEvent mouseEvent) {
    }

    public void diningButton(MouseEvent mouseEvent) {
    }
}