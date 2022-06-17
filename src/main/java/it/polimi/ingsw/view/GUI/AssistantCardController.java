package it.polimi.ingsw.view.GUI;

import it.polimi.ingsw.network.Message.ClientToServer.ChooseAssistantCardMessage;

import java.util.Objects;

public class AssistantCardController {
    Gui gui;
    public AssistantCardController(Gui gui){
        this.gui=gui;
    }
    public void assistant1Select() {

    }
    public void assistant2Select() {

    }

    public void assistant3Select() {
        gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(1));
    }

    public void assistant4Select() {
        gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(1));
    }

    public void assistant5Select() {
        gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(1));
    }

    public void assistant6Select() {
        gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(1));
    }

    public void assistant7Selected() {
        gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(1));
    }

    public void assistant8Select() {
        gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(1));
    }

    public void assistant9Select() {
        gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(1));
    }

    public void assistant10Select() {
        gui.getSocketNetworkHandler().sendMessage(new ChooseAssistantCardMessage(1));
    }
    public int findPlayer(){
        int i;
        for (i=0; !Objects.equals(gui.getLightGame().getPlayers().get(i).getNickname(), gui.getSocketNetworkHandler().getNicknameThisPlayer()); i++);
        return i;
    }
}
