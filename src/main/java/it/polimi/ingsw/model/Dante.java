package it.polimi.ingsw.model;

public class Dante extends CharacterCard{
    public void updateStepMN(AssistantCard currentAssistant){
        int step;
        step=currentAssistant.getStep()+2;
        currentAssistant.setStep(step);
    }
}
