package it.polimi.ingsw.model;

import it.polimi.ingsw.client.ModelLight.LightDiningRoom;
import it.polimi.ingsw.client.ModelLight.LightEntrance;
import it.polimi.ingsw.client.ModelLight.LightPlayer;
import it.polimi.ingsw.client.ModelLight.LightTowerSpace;

import java.util.ArrayList;
public class Player {
    private String nickname;
    private boolean active;
    private int numCoin;
    protected ArrayList<AssistantCard> deckAssistant= new ArrayList<>(10); //mi servirebbe protected o un metodo per accedervi
    private AssistantCard currentAssistant;
    protected Entrance entrance;
    protected DiningRoom diningRoom;
    protected TowerSpace towerSpace;
    public void setNickname(String nick){
        this.nickname=nick;
    }
    public String getNickname() {
        return nickname;
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
        LightPlayer lightPlayer=new LightPlayer();
        LightDiningRoom lightDining=new LightDiningRoom();
        LightTowerSpace lightTowerSpace= new LightTowerSpace();
        LightEntrance lightEntrance= new LightEntrance();
        lightPlayer.setCurrentAssistant(currentAssistant);
        lightPlayer.setNickname(nickname);
        lightDining.setNumBlue(diningRoom.getNumBlue());
        lightDining.setNumGreen(diningRoom.getNumGreen());
        lightDining.setNumPink(diningRoom.getNumPink());
        lightDining.setNumRed(diningRoom.getNumRed());
        lightDining.setNumYellow(diningRoom.getNumYellow());
        lightEntrance.setBluePawn(entrance.getBluePawn());
        lightEntrance.setGreenPawn(entrance.getGreenPawn());
        lightEntrance.setPinkPawn(entrance.getPinkPawn());
        lightEntrance.setRedPawn(entrance.getRedPawn());
        lightEntrance.setYellowPawn(entrance.getYellowPawn());
        lightEntrance.setNumPwan(entrance.getNumPawn());
        lightTowerSpace.setColorTower(towerSpace.getColorTower());
        lightTowerSpace.setNumTower(lightTowerSpace.getNumTower());
        return lightPlayer;
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
        if(currentAssistant.getStep()<num){
            b=false;
        }else{
            b=true;
        }
        return b;
    }
    // modifica UML: chooseCloud dovrebbe scegliere una nuvola  e spostare le pedine in entrance. quindi va fatto nella classe entrance.
    // public void chooseCloud(Cloud cloud){}//
    public void useAssistant(Game game,Player player,AssistantCard currentAssistant) {
        int i, contr = 0;
        for (i = 0; i < game.getPlayers().size(); i++) {
            if (game.getPlayers().get(i) != player) {
                if (game.getPlayers().get(i).currentAssistant!=null && game.getPlayers().get(i).currentAssistant== player.currentAssistant) {
                    contr = 2;
                }
            }
        }
        if (contr == 0) {
            for (i = 0; i < player.deckAssistant.size() && contr == 0; i++) {
                if (player.deckAssistant.size() != 1 && player.deckAssistant.get(i).getCardValue() == currentAssistant.getCardValue()) {
                    player.setCurrentAssistant(currentAssistant);
                    player.deckAssistant.remove(i);
                    contr = 1;
                }
            }
        }
    }
    public void chooseNick(String nickname){
    }
}