package it.polimi.ingsw.model;

import java.util.ArrayList;

public class Player {
    private String nickname;
    protected int numCoin;
    private ArrayList<AssistantCard> deckAssistant= new ArrayList<>(10);
    private SchoolBoard schoolBoard;
    private AssistantCard currentAssistant;
    public void checkNumStepMotherNature(int movemntsMotherNature,int num){

    }
    public void chooseCloud(Cloud cloud){

    }
    public void useCaracter(Character card){

    }
    public void useAssistance(AssistantCard card){

    }
    public void chooseNick(String nickname){

    }
    //ho aggiunto il metodo discarded a Player e l'ho da AssistanceCard
    public void discarded(currentAssistant){
        int i;
        int contr==0;
        for(i=0;i!=deckAssistant.size()&&contr==0;i++) {
            if(currentAssistant.getCardValue()==deckAssistant.get(i).getCardValue()){
                contr==1;
                deckAssistant.remove(i);
            }
        }
    }
}
