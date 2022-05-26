package it.polimi.ingsw.network.Message.UpdateMessage;

import it.polimi.ingsw.model.ProfTable;

public class ProfTableUpdateMessage {
    private static final long serialVersionUID= -4729037842800985068L;
    private final ProfTable profTable;
    public ProfTableUpdateMessage(ProfTable profTable){
        this.profTable=profTable;
    }
    public ProfTable getProfTable() {
        return profTable;
    }
}
