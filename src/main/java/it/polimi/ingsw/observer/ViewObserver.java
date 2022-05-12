package it.polimi.ingsw.observer;

import it.polimi.ingsw.network.Message;

public interface ViewObserver {//DA COMPLETARE
    void updateNick(String nick);
    void updateMessage(Message message);
}
