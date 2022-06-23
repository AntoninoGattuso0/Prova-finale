package it.polimi.ingsw.view.GUI.Controller;
import it.polimi.ingsw.network.Message.ClientToServer.ChooseAssistantCardMessage;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
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
        int j;
        int k;
        for(j=0; !Objects.equals(gui.getLightGame().getPlayers().get(j).getNickname(), nick); j++);
        for(int i = 0; i < gui.getLightGame().getPlayers().get(j).getDeckAssistant().size(); i++){
            String name = "AssistantCard" + gui.getLightGame().getPlayers().get(j).getDeckAssistant().get(i).getCardValue();
            for(Node assistant : assistantCards.getChildren()){
                for(k=0;k<gui.getLightGame().getPlayers().size();k++){
                    if(assistant.getId().equals(name))
                    assistant.setVisible(true);
            }
        }
        }
        for(k=0;k<gui.getLightGame().getPlayers().size();k++){
            System.out.println("fuori");
            if(gui.getLightGame().getPlayers().get(k).getCurrentAssistant()!=null){
                System.out.println("dentro");
                assistantCards.getChildren().get(gui.getLightGame().getPlayers().get(k).getCurrentAssistant().getCardValue()-1).setOpacity(0.6D);
            }
        }
    }

    public void setDisableAll(){
        for(Node assistant : assistantCards.getChildren()){
            assistant.setDisable(true);
        }
    }

    public void setInvisibleAll(){
        for(Node assistant : assistantCards.getChildren())
            assistant.setVisible(false);
    }
    public void setAble(int n){
        String name = "AssistantCard" + n;
        assistantCards.lookup(name).setDisable(false);
    }

    public void setVisible(int n){
        String name= "AssistantCard"+n;
        for(Node assistant : assistantCards.getChildren()){
            if(assistant.getId().equals(name))
                assistant.setVisible(true);
        }
    }
    public void setInvisibile(int n){
        String name= "AssistantCard"+n;
        for(Node assistant : assistantCards.getChildren()){
            if(assistant.getId().equals(name))
                assistant.setVisible(false);
        }
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
