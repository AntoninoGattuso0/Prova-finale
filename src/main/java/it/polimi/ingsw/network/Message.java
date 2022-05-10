package it.polimi.ingsw.network;

import java.io.Serializable;

public class Message implements Serializable {
    Object mess;
    public Message(Object message){
        this.mess= message;
    }
}
