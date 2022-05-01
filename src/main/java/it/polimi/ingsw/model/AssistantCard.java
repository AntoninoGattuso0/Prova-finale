package it.polimi.ingsw.model;
public class AssistantCard {
    private int cardValue;
    private int stepMotherNature;
    AssistantCard(){
        cardValue=0;
        stepMotherNature=0;
    }
    public int getCardValue(){return cardValue;}
    public void setCardValue(int cardValue){
        this.cardValue = cardValue;
    }
    public int getStep(){
        return stepMotherNature;
    }
    public void setStep(int setStep){
        this.stepMotherNature = setStep;
    }
}
