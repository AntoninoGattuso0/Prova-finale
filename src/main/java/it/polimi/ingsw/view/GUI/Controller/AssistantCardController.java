package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.network.Message.ClientToServer.ChooseAssistantCardMessage;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.Objects;

public class AssistantCardController {
    Gui gui;
    @FXML public Pane assistantCards;
    public void setGui(Gui gui){this.gui=gui;
   }

    public Pane getAssistantCards(){return assistantCards;}

    public void setAssistantCards(String nick){
        setInvisibileAll();
        setDisableAll();
        int j;
        int k;
        for(j=0; !Objects.equals(gui.getLightGame().getPlayers().get(j).getNickname(), nick); j++);
        for(int i = 0; i < gui.getLightGame().getPlayers().get(j).getDeckAssistant().size(); i++){
            String name = "AssistantCard" + gui.getLightGame().getPlayers().get(j).getDeckAssistant().get(i).getCardValue();
            for(Node assistant : assistantCards.getChildren()){
                    if(assistant.getId().equals(name)) {
                        assistant.setOpacity(1);
                        assistant.setVisible(true);
                    }
        }
        }
        for(k=0;k<gui.getLightGame().getPlayers().size();k++){
            if(gui.getLightGame().getPlayers().get(k).getCurrentAssistant()!=null){
                assistantCards.getChildren().get(gui.getLightGame().getPlayers().get(k).getCurrentAssistant().getCardValue()-1).setOpacity(0.6D);
            }
        }
    }
    public void setDisableAll(){
        for(Node assistant : assistantCards.getChildren()){
            assistant.setDisable(true);
        }
    }
    public void setAsssistantsAble(String nick){
        int j;
        int k;
        for(j=0; !Objects.equals(gui.getLightGame().getPlayers().get(j).getNickname(), nick); j++);
        for(int i = 0; i < gui.getLightGame().getPlayers().get(j).getDeckAssistant().size(); i++){
            String name = "AssistantCard" + gui.getLightGame().getPlayers().get(j).getDeckAssistant().get(i).getCardValue();
            for(Node assistant : assistantCards.getChildren()){
                    if(assistant.getId().equals(name)) {
                        assistant.setDisable(false);
                    }
            }
        }
        for(k=0;k<gui.getLightGame().getPlayers().size();k++){
            if(gui.getLightGame().getPlayers().get(k).getCurrentAssistant()!=null){
                assistantCards.getChildren().get(gui.getLightGame().getPlayers().get(k).getCurrentAssistant().getCardValue()-1).setDisable(true);
            }
        }
    }
    public void setInvisibileAll() {
        for (Node assistant : assistantCards.getChildren()) {
            assistant.setVisible(false);
        }
    }
        public void assistant1Select () {
            int i;
            int j;
            for(i=0; !Objects.equals(gui.getSocketNetworkHandler().getNicknameThisPlayer(), gui.getLightGame().getPlayers().get(i).getNickname()); i++);
            for(j=0;1!=gui.getLightGame().getPlayers().get(i).getDeckAssistant().get(j).getCardValue();j++);
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(j));
            gui.assistantSelected();
        }
        public void assistant2Select () {
            int i;
            int j;
            for(i=0; !Objects.equals(gui.getSocketNetworkHandler().getNicknameThisPlayer(), gui.getLightGame().getPlayers().get(i).getNickname()); i++);
            for(j=0;2!=gui.getLightGame().getPlayers().get(i).getDeckAssistant().get(j).getCardValue();j++);
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(j));
            gui.assistantSelected();
        }
        public void assistant3Select () {
            int i;
            int j;
            for(i=0; !Objects.equals(gui.getSocketNetworkHandler().getNicknameThisPlayer(), gui.getLightGame().getPlayers().get(i).getNickname()); i++);
            for(j=0;3!=gui.getLightGame().getPlayers().get(i).getDeckAssistant().get(j).getCardValue();j++);
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(j));
            gui.assistantSelected();
        }
        public void assistant4Select () {
            int i;
            int j;
            for(i=0; !Objects.equals(gui.getSocketNetworkHandler().getNicknameThisPlayer(), gui.getLightGame().getPlayers().get(i).getNickname()); i++);
            for(j=0;4!=gui.getLightGame().getPlayers().get(i).getDeckAssistant().get(j).getCardValue();j++);
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(j));
            gui.assistantSelected();
        }
        public void assistant5Select () {
            int i;
            int j;
            for(i=0; !Objects.equals(gui.getSocketNetworkHandler().getNicknameThisPlayer(), gui.getLightGame().getPlayers().get(i).getNickname()); i++);
            for(j=0;5!=gui.getLightGame().getPlayers().get(i).getDeckAssistant().get(j).getCardValue();j++);
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(j));
            gui.assistantSelected();
        }
        public void assistant6Select () {
            int i;
            int j;
            for(i=0; !Objects.equals(gui.getSocketNetworkHandler().getNicknameThisPlayer(), gui.getLightGame().getPlayers().get(i).getNickname()); i++);
            for(j=0;6!=gui.getLightGame().getPlayers().get(i).getDeckAssistant().get(j).getCardValue();j++);
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(j));
            gui.assistantSelected();
        }
        public void assistant7Selected () {
            int i;
            int j;
            for(i=0; !Objects.equals(gui.getSocketNetworkHandler().getNicknameThisPlayer(), gui.getLightGame().getPlayers().get(i).getNickname()); i++);
            for(j=0;7!=gui.getLightGame().getPlayers().get(i).getDeckAssistant().get(j).getCardValue();j++);
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(j));
            gui.assistantSelected();
        }
        public void assistant8Select () {
            int i;
            int j;
            for(i=0; !Objects.equals(gui.getSocketNetworkHandler().getNicknameThisPlayer(), gui.getLightGame().getPlayers().get(i).getNickname()); i++);
            for(j=0;8!=gui.getLightGame().getPlayers().get(i).getDeckAssistant().get(j).getCardValue();j++);
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(j));
            gui.assistantSelected();
        }
        public void assistant9Select () {
           int i;
           int j;
            for(i=0; !Objects.equals(gui.getSocketNetworkHandler().getNicknameThisPlayer(), gui.getLightGame().getPlayers().get(i).getNickname()); i++);
            for(j=0;9!=gui.getLightGame().getPlayers().get(i).getDeckAssistant().get(j).getCardValue();j++);
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(j));
            gui.assistantSelected();
        }
        public void assistant10Select () {
            int i;
            int j;
            for(i=0; !Objects.equals(gui.getSocketNetworkHandler().getNicknameThisPlayer(), gui.getLightGame().getPlayers().get(i).getNickname()); i++);
            for(j=0;10!=gui.getLightGame().getPlayers().get(i).getDeckAssistant().get(j).getCardValue();j++);
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(j));
            gui.assistantSelected();
        }

        public void assistant1Entered() {
            for(Node assistant : assistantCards.getChildren()){
                if(assistant.getId().equals("AssistantCard1")){
                    assistant.setOnMouseEntered(mouseEvent -> assistant.setCursor(Cursor.HAND));
                }
            }
        }
        public void assistant2Entered() {
            for(Node assistant : assistantCards.getChildren()){
                if(assistant.getId().equals("AssistantCard2")){
                    assistant.setOnMouseEntered(mouseEvent -> assistant.setCursor(Cursor.HAND));
                }
            }
        }
        public void assistant3Entered() {
            for(Node assistant : assistantCards.getChildren()){
                if(assistant.getId().equals("AssistantCard3")){
                    assistant.setOnMouseEntered(mouseEvent -> assistant.setCursor(Cursor.HAND));
                }
            }
        }
        public void assistant4Entered() {
            for(Node assistant : assistantCards.getChildren()){
                if(assistant.getId().equals("AssistantCard4")){
                    assistant.setOnMouseEntered(mouseEvent -> assistant.setCursor(Cursor.HAND));
                }
            }
        }
        public void assistant5Entered() {
            for(Node assistant : assistantCards.getChildren()){
                if(assistant.getId().equals("AssistantCard5")){
                    assistant.setOnMouseEntered(mouseEvent -> assistant.setCursor(Cursor.HAND));
                }
            }
        }
        public void assistant6Entered() {
            for(Node assistant : assistantCards.getChildren()){
                if(assistant.getId().equals("AssistantCard6")){
                    assistant.setOnMouseEntered(mouseEvent -> assistant.setCursor(Cursor.HAND));
                }
            }
        }
        public void assistant7Entered() {
            for(Node assistant : assistantCards.getChildren()){
                if(assistant.getId().equals("AssistantCard7")){
                    assistant.setOnMouseEntered(mouseEvent -> assistant.setCursor(Cursor.HAND));
                }
            }
        }
        public void assistant8Entered() {
            for(Node assistant : assistantCards.getChildren()){
                if(assistant.getId().equals("AssistantCard8")){
                    assistant.setOnMouseEntered(mouseEvent -> assistant.setCursor(Cursor.HAND));
                }
            }
        }

        public void assistant9Entered() {
            for(Node assistant : assistantCards.getChildren()){
                if(assistant.getId().equals("AssistantCard9")){
                    assistant.setOnMouseEntered(mouseEvent -> assistant.setCursor(Cursor.HAND));
                }
            }
        }
        public void assistant10Entered() {
            for(Node assistant : assistantCards.getChildren()){
                if(assistant.getId().equals("AssistantCard10")){
                    assistant.setOnMouseEntered(mouseEvent -> assistant.setCursor(Cursor.HAND));
                }
            }
        }
}