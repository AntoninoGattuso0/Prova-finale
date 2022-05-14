package it.polimi.ingsw.model;
import java.util.ArrayList;
public class Player {
    private String nickname;
    private int numCoin;
    protected ArrayList<AssistantCard> deckAssistant= new ArrayList<>(10); //mi servirebbe protected o un metodo per accedervi
    private AssistantCard currentAssistant;
    protected Entrance entrance;
    protected DiningRoom diningRoom;
    protected TowerSpace towerSpace;
    public void setNickame(String nick){
        this.nickname=nick;
    }
    public String getNickname() {
        return nickname;
    }

    public DiningRoom getDiningRoom(){
        return this.diningRoom;
    }

    public ArrayList<AssistantCard> getDeckAssistant(){

        return this.deckAssistant;
    }

    public Player(String nick, Game game) {
        int j, k;
        setNickame(nick);
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