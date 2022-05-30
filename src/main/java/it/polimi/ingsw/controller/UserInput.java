package it.polimi.ingsw.controller;

import it.polimi.ingsw.network.Message.Message;

public class UserInput {//DA RIVEDERE
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
    public void updateNick(String nick){
        this.nickName=nick;
    }
    public void updateNewMessage(Message message){
        this.message=message;
    }
    public String getNickName() {
        return nickName;
    }
    public int getPlayersNum() {
        return playersNum;
    }
    public void updatePlayersNum(int num){
        this.playersNum=num;
    }
}
