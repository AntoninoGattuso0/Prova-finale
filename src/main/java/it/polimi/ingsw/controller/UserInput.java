package it.polimi.ingsw.controller;

import it.polimi.ingsw.network.Message.Message;
import it.polimi.ingsw.observer.ViewObserver;

public class UserInput implements ViewObserver {//DA RIVEDERE
    private Message message;
    private String nickName;
    public UserInput(){
        nickName=null;
    }
    public Message getMessage() {
        return message;
    }
    @Override
    public void updateNick(String nick){
        this.nickName=nick;
    }
    @Override
    public void updateMessage(Message message){
        this.message=message;
    }
}
