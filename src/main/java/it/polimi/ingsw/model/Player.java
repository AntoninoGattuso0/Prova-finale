package it.polimi.ingsw.model;

import java.util.ArrayList;

public class Player {
    private String nickname;
    protected int numCoin;
    protected ArrayList<AssistantCard> deckAssistant= new ArrayList<>(10);
    protected AssistantCard currentAssistant;
    protected Entrance entrance;
    protected DiningRoom diningRoom;
    protected TowerSpace towerSpace;
    Player(String nick){
        nickname=nick;
        numCoin=0;

    }
    public boolean checkNumStepMotherNature(int num){
        boolean b;
        if(currentAssistant.getStep()<num){
            b=false;
        }else{
            b=true;
        }
        return b;
    }
    // modifica UML: chooseCloud dovrebbe scegliere una nuvola  e spostare le pedine in entrance. quindi va fatto nella classe entrance.
    // public void chooseCloud(Cloud cloud){}//
    public void useCaracter(CharacterCard card){ //se Character non è una classe, non posso passare niente in ignresso di quel tipo
        int i;
            i=Game.cards.indexOf(card);
             //   Game.cards.get(i).useEffect();
        }
    public void useAssistant(){

        int i;
        int contr=0;
        for(i=0;i<deckAssistant.size() && contr==0;i++) {
            if (deckAssistant.get(i).getCardValue() == currentAssistant.getCardValue()){
                deckAssistant.remove(i);
                contr=1;
            }
        }
    }
    public void chooseNick(String nickname){

    }
    //ho aggiunto il metodo discarded a Player e l'ho tolto da AssistanceCard//
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
