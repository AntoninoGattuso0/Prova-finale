package it.polimi.ingsw.model;

import it.polimi.ingsw.controller.PhaseTurn;

import java.util.ArrayList;
import java.util.Objects;

/**
 * the Player contains the Entrance,DiningRoom,TowerSpace and deckAssistant
 * @see Entrance
 * @see DiningRoom
 * @see TowerSpace
 * @see AssistantCard
 */
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

    /**
     * Set if the player is the one who have to do the actions during the turn
     * @param active
     */
    public void setActive(boolean active) {
        this.active=active;
    }

    /**
     * the AssistantCard are created in the constructor of the single player
     * @see AssistantCard
     */
    public Player(String nick, Game game) {
        setActive(true);
        int j, k;
        setNickname(nick);
        if (game.isExpert) setNumCoin(900);
        else setNumCoin(-1);
        k = 1;
        for (j = 1; j < 11; j++) {
            AssistantCard assistant = new AssistantCard();
            assistant.setCardValue(j);
            if (j == 3 || j == 5 || j == 7 || j == 9) k++;
            assistant.setStep(k);
            this.deckAssistant.add(assistant);
        }
        this.currentAssistant=null;
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

    public int useAssistant(Game game,Player player,AssistantCard Assistant) {
        int i, contr = 0;
        for (i = 0; i < game.getPlayers().size(); i++) {
            if (!Objects.equals(game.getPlayers().get(i).getNickname(), player.getNickname())) {
                if ((game.getPlayers().get(i).currentAssistant != null) && Objects.equals(game.getPlayers().get(i).currentAssistant, Assistant) && (player.deckAssistant.size()>1)) {
                    contr = 2;
                    return contr;
                }
            }
        }
        for (i = 0; i < player.deckAssistant.size(); i++) {
            if (player.deckAssistant.size() == 1 || player.deckAssistant.get(i).getCardValue() == Assistant.getCardValue()) {
                player.setCurrentAssistant(player.deckAssistant.get(i));
                player.deckAssistant.remove(i);
                player.setCurrentPhase(PhaseTurn.MOVE_STUDENT);
                contr = 1;
                return contr;
            }
        }
        return contr;
    }
}