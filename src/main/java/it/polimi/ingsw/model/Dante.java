package it.polimi.ingsw.model;

public class Dante extends CharacterCard{
    public void updateStepMN(AssistantCard currentAssistant){
        int step;
        step=currentAssistant.getStep();
        step=step+2;
        currentAssistant.stepMotherNature=step;
    }
}
