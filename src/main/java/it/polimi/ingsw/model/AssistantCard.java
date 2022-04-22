package it.polimi.ingsw.model;

public class AssistantCard {
    private int cardValue;
    private int stepMotherNature;
    public int getCardValue(){
        return cardValue;
    }
    public int getStep(){
        return stepMotherNature;
    }
    public void setStep(int num){
        this.stepMotherNature=num;
    }
}
