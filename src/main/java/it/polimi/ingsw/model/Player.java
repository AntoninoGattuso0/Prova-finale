package it.polimi.ingsw.model;

import java.util.ArrayList;

public class Player {
    private int IDplayer;
    private final String nickname;
    private int numCoin;
    private ArrayList<AssistantCard> deckAssistant= new ArrayList<>(10);
    private AssistantCard currentAssistant;
    private Entrance entrance;
    private DiningRoom diningRoom;
    private TowerSpace towerSpace;
    Player(String nick, int ID) {
        int j, k;
        IDplayer=ID;
        nickname=nick;
        if (Game.isExpert) numCoin = 1;
        else numCoin = -1;
        //creazione assistenti
        k = 1;
        //aggiunta assistenti
        for (j = 1; j < 11; j++) {
            AssistantCard assistant = new AssistantCard();
            assistant.setCardValue(j);
            if (j == 3 || j == 5 || j == 7 || j == 9) k++;
            assistant.setStep(k);
            deckAssistant.add(assistant);
            //collegamento a tower, dining and entrance
            entrance = new Entrance();
            entrance.setNumPawn();
            diningRoom = new DiningRoom();
            towerSpace = new TowerSpace();
        }
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
    public int useCharacter(CharacterCard card){ //se Character non è una classe, non posso passare niente in ignresso di quel tipo
        int i;
            i=Game.cards.indexOf(card);
            return i;
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