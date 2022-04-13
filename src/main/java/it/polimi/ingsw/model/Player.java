package it.polimi.ingsw.model;

import java.util.ArrayList;

public class Player {
    private String nickname;
    protected int numCoin;
    protected ArrayList<AssistantCard> deckAssistant= new ArrayList<>(10);
    private AssistantCard currentAssistant;
    protected Entrance entrance;
    protected DiningRoom diningRoom;
    protected TowerSpace towerSpace;
    public boolean checkNumStepMotherNature(int num){
        boolean b;
        if(currentAssistant.stepMotherNature<num){
            b=false;
        }else{
            b=true;
        }
        return b;
    }
    // modifica UML: chooseCloud dovrebbe scegleire una nuvola  e spostare le pedine in entrance. quindi va fatto nella classe entrance.
    // public void chooseCloud(Cloud cloud){}//
    public void useCaracter(Character card){

    }
    public void useAssistant(){
        int i;
        int contr=0;
        for(i=0;i<deckAssistant.size()&&contr==0;i++) {
            if (deckAssistant.get(i).cardValue == currentAssistant.cardValue){
                deckAssistant.remove(i);
            }
        }
    }
    public void chooseNick(String nickname){

    }
    //ho aggiunto il metodo discarded a Player e l'ho da AssistanceCard//
    public void discarded(AssistantCard currentAssistant ){
        int i;
        int contr=0;
        for(i=0;i!=deckAssistant.size()&&contr==0;i++) {
            if(currentAssistant.getCardValue()==deckAssistant.get(i).getCardValue()){
                contr=1;
                deckAssistant.remove(i);
            }
        }
    }
}
