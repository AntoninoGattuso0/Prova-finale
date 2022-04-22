package it.polimi.ingsw.model;

public class Dante {
    public void useEffect(AssistantCard currentAssistant){
        int step;
        step=currentAssistant.getStep()+2;
        currentAssistant.setStep(step);
    }
}
