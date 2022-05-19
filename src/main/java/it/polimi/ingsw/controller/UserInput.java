package it.polimi.ingsw.controller;

import it.polimi.ingsw.network.Message.Message;
import it.polimi.ingsw.observer.ViewObserver;

public class UserInput implements ViewObserver {//DA RIVEDERE
    private Message message;
    private String nickName;
    private int playersNum;
    public UserInput(){
        nickName=null;
        playersNum=0;
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
    public String getNickName() {
        return nickName;
    }
    public int getPlayersNum() {
        return playersNum;
    }
    @Override
    public void updatePlayersNum(int num){
        this.playersNum=num;
    }
}
