package it.polimi.ingsw.model;


import java.util.ArrayList;
import java.util.Random;

public class Game {
    private ArrayList<Player> players = new ArrayList<>(4);
    private int totPlayer;
    private Cloud[] cloud = new Cloud[4];
    private ArrayList<Island> islands = new ArrayList<>(12);
    private boolean isExpert;
    private CharacterCard[] card = new CharacterCard[3];

    private void start(){
        int i;
        for(i=0, i<11, i++){
            Island island = new Island();
            islands.add(island);
        }
        for(i=0, i<totPlayer-1, i++){
            Player player = new Player();
            players.add(player);
        }
        Random rnd = new Random();
        int n = rnd.nextInt(12);
        islands.get(n).setMotherNatureTrue();
    };

    public void newPlayer(){
        for(int i=0, i<totPlayer, i++)
        Player player1 = new Player();
        players.add(player1);
};

    public void moveMotherNature(int num);

    public void unifyIsland();

    public void topInfluence(int toIsland);

    public void endGame();

    public void setCard(CharacterCard card){
        int i;
        Random count = new Random();
        int num = count.nextInt(11);
        for(i=0, i<4, i++){
        card[i] = num;
    };

    public int moveProf();
}

