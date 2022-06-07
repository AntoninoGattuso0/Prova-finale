package it.polimi.ingsw.model;

import it.polimi.ingsw.client.ModelLight.LightDiningRoom;
import it.polimi.ingsw.client.ModelLight.LightEntrance;
import it.polimi.ingsw.client.ModelLight.LightPlayer;
import it.polimi.ingsw.client.ModelLight.LightTowerSpace;
import it.polimi.ingsw.controller.PhaseTurn;

import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private String nickname;
    private boolean active;
    private int numCoin;
    protected ArrayList<AssistantCard> deckAssistant= new ArrayList<>(10); //mi servirebbe protected o un metodo per accedervi
    private AssistantCard currentAssistant;
    protected Entrance entrance;
    protected DiningRoom diningRoom;
    protected TowerSpace towerSpace;
    protected PhaseTurn currentPhase;
    public void setNickname(String nick){
        this.nickname=nick;
    }
    public String getNickname() {
        return nickname;
    }
    public PhaseTurn getCurrentPhase() {
        return currentPhase;
    }
    public void setCurrentPhase(PhaseTurn currentPhase) {
        this.currentPhase = currentPhase;
    }
    public DiningRoom getDiningRoom(){
        return this.diningRoom;
    }
    public Entrance getEntrance(){
        return this.entrance;
    }
    public TowerSpace getTowerSpace(){
        return this.towerSpace;
    }

    public ArrayList<AssistantCard> getDeckAssistant(){
        return this.deckAssistant;
    }
    public LightPlayer getLightPlayer(){
        LightDiningRoom lightDining=new LightDiningRoom(getDiningRoom().getNumBlue(),getDiningRoom().getNumGreen(),getDiningRoom().getNumPink(),getDiningRoom().getNumRed(),getDiningRoom().getNumYellow());
        LightTowerSpace lightTowerSpace= new LightTowerSpace(getTowerSpace().getColorTower(),getTowerSpace().getNumTower());
        LightEntrance lightEntrance= new LightEntrance(getEntrance().getNumPawn(),getEntrance().getGreenPawn(),getEntrance().getRedPawn(),getEntrance().getYellowPawn(),getEntrance().getPinkPawn(),getEntrance().getBluePawn());
        return new LightPlayer(getNickname(),getNumCoin(),getDeckAssistant(),getCurrentAssistant(),lightEntrance,lightTowerSpace,lightDining,currentPhase);
    }
    public void setActive(boolean active) {
        this.active=active;
    }
    public boolean getActive(){
        return this.active;
    }
    public Player(String nick, Game game) {
        setActive(true);
        int j, k;
        setNickname(nick);
        if (game.isExpert) setNumCoin(1);
        else setNumCoin(-1);
        //creazione assistenti
        k = 1;
        //aggiunta assistenti
        for (j = 1; j < 11; j++) {
            AssistantCard assistant = new AssistantCard();
            assistant.setCardValue(j);
            if (j == 3 || j == 5 || j == 7 || j == 9) k++;
            assistant.setStep(k);
            this.deckAssistant.add(assistant);
        }
        this.currentAssistant=null;
            //collegamento a tower, dining and entrance
            this.entrance = new Entrance(game);
            this.diningRoom = new DiningRoom();
            this.towerSpace = new TowerSpace(game);
    }
    public void setCurrentAssistant(AssistantCard currentAssistant) {
        this.currentAssistant = currentAssistant;
    }
    public AssistantCard getCurrentAssistant() {
        return currentAssistant;
    }
    public int getNumCoin() {
        return numCoin;
    }
    public void setNumCoin(int numCoin) {
        this.numCoin = numCoin;
    }
    public boolean checkNumStepMotherNature(int num){
        boolean b;
        if (currentAssistant.getStep() >= num) b = true;
        else b = false;
        return b;
    }
    // modifica UML: chooseCloud dovrebbe scegliere una nuvola  e spostare le pedine in entrance. quindi va fatto nella classe entrance.
    // public void chooseCloud(Cloud cloud){}//
    public int useAssistant(Game game,Player player,AssistantCard Assistant) {
        int i, contr = 0;
        for (i = 0; (i < game.getPlayers().size()) && (contr == 0); i++) {
            if (!Objects.equals(game.getPlayers().get(i).getNickname(), player.getNickname())) {
                if ((game.getPlayers().get(i).currentAssistant != null) && Objects.equals(game.getPlayers().get(i).currentAssistant, Assistant)) {
                    contr = 2;
                }
            }
        }
        if (contr==0) {
            for (i = 0; (i < player.deckAssistant.size()) && (contr == 0); i++) {
                if (player.deckAssistant.size() == 1 || player.deckAssistant.get(i).getCardValue() == Assistant.getCardValue()) {
                    player.setCurrentAssistant(player.deckAssistant.get(i));
                    player.deckAssistant.remove(i);
                    contr = 1;
                }
            }
        }
        return contr;
    }
}