package it.polimi.ingsw.model;

//ce la faremo
public class Dante extends CharacterCard{
    Dante(){
        coinPrice=1;
    }
    public void useEffect(AssistantCard currentAssistant){
        int step;
        step=currentAssistant.getStep()+2;
        currentAssistant.setStep(step);
    }
}
