package it.polimi.ingsw.observer;

import it.polimi.ingsw.network.Message.Message;

public interface ViewObserver {//DA COMPLETARE
    void updateNick(String nick);
    void updateMessage(Message message);
    void updatePlayersNum(int num);
}
//virualView observer nei confronti del model
//networkHandler (tutti gli handler) sono observer di view e Controller