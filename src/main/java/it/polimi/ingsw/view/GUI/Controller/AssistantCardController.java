package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.network.Message.ClientToServer.ChooseAssistantCardMessage;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class AssistantCardController {
    Gui gui;
    @FXML public Pane assistantCards;
    public void setGui(Gui gui){this.gui=gui;}

    public void setDisableAll(){
        for(Node assistant : assistantCards.getChildren()){
            assistant.setDisable(true);
        }
    }
    public void setAble(int n){
        String name = "#AssistantCard" + n;
        assistantCards.lookup(name).setDisable(false);
    }
    public void setVisible(int n){
        String name= "#AssistantCard"+n;
        assistantCards.lookup(name).setVisible(true);
    }
    public void setInvisibile(int n){
        String name= "#AssistantCard"+n;
        assistantCards.lookup(name).setVisible(false);
    }
    public void setInvisibileAll() {
        for (Node assistant : assistantCards.getChildren()) {
            assistant.setVisible(false);
        }
    }
        public void assistant1Select () {
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(1));
        }
        public void assistant2Select () {
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(2));
        }
        public void assistant3Select () {
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(3));
        }
        public void assistant4Select () {
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(4));
        }
        public void assistant5Select () {
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(5));
        }
        public void assistant6Select () {
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(6));
        }
        public void assistant7Selected () {
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(7));
        }
        public void assistant8Select () {
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(8));
        }
        public void assistant9Select () {
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(9));
        }
        public void assistant10Select () {
            gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(10));
        }
    }
