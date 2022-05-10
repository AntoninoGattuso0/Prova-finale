package it.polimi.ingsw.network;

public class Message extends Exception {
    Object mess;
    public Message(Object message){
        this.mess= message;
    }
}
