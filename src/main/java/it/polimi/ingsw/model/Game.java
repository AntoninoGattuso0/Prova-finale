package it.polimi.ingsw.model;


import java.util.ArrayList;
import java.util.Random;

public class Game {
    private ArrayList<Player> Players;
    private int totPlayer;
    private Cloud[] cloud = new Cloud[4];
    private ArrayList<Island> island;
    private boolean isExpert;
    private CharacterCard[] card = new CharacterCard[3];

    private void start();

    public void newPlayer();

    public void moveMotherNature(int num);

    public void unifyIsland();

    public void topInfluence(int topIsland);

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

