package it.polimi.ingsw.model;

import it.polimi.ingsw.client.ModelLight.LightEntrance;

import java.util.*;
public class Entrance {
    private int numPawn;       //numero di pedine totali presenti all'entrata della plancia
    //numero di pedine per ogni colore, inizialmente sono zero, poi in base al numero di player vengono aggiunte pedine in maniera randomica
    private int greenPawn;
    private int bluePawn;
    private int pinkPawn;
    private int yellowPawn;
    private int redPawn;

    public int getNumPawn(){
        return numPawn;
    }
    public int getGreenPawn() {
        return greenPawn;
    }
    public int getRedPawn(){
        return redPawn;
    }
    public int getYellowPawn() {
        return yellowPawn;
    }
    public int getPinkPawn() {
        return pinkPawn;
    }
    public int getBluePawn() {
        return bluePawn;
    }
    public void setNumPawn(int numPawn) {
        this.numPawn = numPawn;
    }
    public void setGreenPawn(int greenPawn) {
        this.greenPawn = greenPawn;
    }
    public void setRedPawn(int redPawn) {
        this.redPawn = redPawn;
    }
    public void setYellowPawn(int yellowPawn) {
        this.yellowPawn = yellowPawn;
    }
    public void setPinkPawn(int pinkPawn) {
        this.pinkPawn = pinkPawn;
    }
    public void setBluePawn(int bluePawn) {
        this.bluePawn = bluePawn;
    }

    public Entrance(Game game){
       setGreenPawn(0);
       setBluePawn(0);
       setPinkPawn(0);
       setYellowPawn(0);
       setRedPawn(0);
       Random rnd = new Random();
        if(game.totPlayer == 2 || game.totPlayer == 4)
            setNumPawn(7);
        else if(game.totPlayer == 3)
            setNumPawn(9);
        int i,k;
        for(i = 0; i < getNumPawn(); i++){
            ArrayList<String> entrancePawn = game.createArrayPawn(game.studentBag);
            if (game.studentBag.getNum() > 0 && entrancePawn.size() > 0) {
                int random = rnd.nextInt(entrancePawn.size());
                if (Objects.equals(entrancePawn.get(random), game.m.get(0)) && game.studentBag.getGreenNum() > 0) {//verde
                    setGreenPawn(getGreenPawn() + 1);
                    k = game.studentBag.getNum() - 1;
                    game.studentBag.setNum(k);
                    k = game.studentBag.getGreenNum() - 1;
                    game.studentBag.setGreenNum(k);
                    if(game.studentBag.getGreenNum() == 0) entrancePawn.remove(random);
                } else if (Objects.equals(entrancePawn.get(random), game.m.get(1)) && game.studentBag.getRedNum() > 0) {//rosso
                    setRedPawn(getRedPawn() + 1);
                    k = game.studentBag.getNum() - 1;
                    game.studentBag.setNum(k);
                    k = game.studentBag.getRedNum() - 1;
                    game.studentBag.setRedNum(k);
                    if(game.studentBag.getRedNum() == 0) entrancePawn.remove(random);
                } else if (Objects.equals(entrancePawn.get(random), game.m.get(2)) && game.studentBag.getYellowNum() > 0) {//giallo
                    setYellowPawn(getYellowPawn() + 1);
                    k = game.studentBag.getNum() - 1;
                    game.studentBag.setNum(k);
                    k = game.studentBag.getYellowNum() - 1;
                    game.studentBag.setYellowNum(k);
                    if(game.studentBag.getYellowNum() == 0) entrancePawn.remove(random);
                } else if (Objects.equals(entrancePawn.get(random), game.m.get(3)) && game.studentBag.getPinkNum() > 0) {//rosa
                    setPinkPawn(getPinkPawn() + 1);
                    k = game.studentBag.getNum() - 1;
                    game.studentBag.setNum(k);
                    k = game.studentBag.getPinkNum() - 1;
                    game.studentBag.setPinkNum(k);
                    if(game.studentBag.getPinkNum() == 0) entrancePawn.remove(random);
                } else if (Objects.equals(entrancePawn.get(random), game.m.get(4)) && game.studentBag.getBlueNum() > 0) {//blu
                    setBluePawn(getBluePawn() + 1);
                    k = game.studentBag.getNum() - 1;
                    game.studentBag.setNum(k);
                    k = game.studentBag.getBlueNum() - 1;
                    game.studentBag.setBlueNum(k);
                    if(game.studentBag.getBlueNum() == 0) entrancePawn.remove(random);
                }
            }
        }
    }

    // modifiche all'UML:ho aggiunto setter per definire quante sono le pedine che devono esserci in Entrance
    //all'inizio del gioco e dopo che ho fatto refill da una nuvola
    public void startNumPawn(Game game){
        if(game.totPlayer == 2 || game.totPlayer == 4)
            setNumPawn(7);
        else if(game.totPlayer == 3)
            setNumPawn(9);
    }
    //modifiche all'UML: il ritorno di check è boolean
    //metodo che controlla in base al numero di Players se ci sono ancora 4 o 5 pedine all'ingresso
    public boolean checkNum(Game game){
        if((game.totPlayer == 2 || game.totPlayer == 4) && numPawn > 4 )
            return true;
       else if(game.totPlayer == 3 && numPawn > 5)
            return true;
       else return false;
    }
    public void movePawnToIsland(ColorPawn colorPawn, Island island, Game game){
            //tutti questi spostamenti sono possibili se il numero di pedine all'entrata è 4 o 5 in base ai giocatori
               if(Objects.equals(colorPawn.toString(), "GREEN") && this.greenPawn > 0){  //altrimenti cosa succede se la pedina verde non c'è?
                   island.setGreenPawn(island.getGreenPawn() + 1);
                   setGreenPawn(getGreenPawn() - 1);
                   setNumPawn(getNumPawn() - 1);
               }else if(Objects.equals(colorPawn.toString(), "RED") && this.redPawn > 0){
                   island.setRedPawn(island.getRedPawn() + 1);
                   setRedPawn(getRedPawn() - 1);
                   setNumPawn(getNumPawn() - 1);
               }else if(Objects.equals(colorPawn.toString(), "YELLOW") && this.yellowPawn > 0){
                   island.setYellowPawn(island.getYellowPawn() + 1);
                   setYellowPawn(getYellowPawn() - 1);
                   setNumPawn(getNumPawn() - 1);
               }else if(Objects.equals(colorPawn.toString(), "PINK") && this.pinkPawn > 0){
                   island.setPinkPawn(island.getPinkPawn() + 1);
                   setPinkPawn(getPinkPawn() - 1);
                   setNumPawn(getNumPawn() - 1);
               }else if(Objects.equals(colorPawn.toString(), "BLUE") && this.bluePawn > 0){
                   island.setBluePawn(island.getBluePawn() + 1);
                   setBluePawn(getBluePawn() - 1);
                   setNumPawn(getNumPawn() - 1);
               }
            }
        //LEGGIMI :( non va bene il fatto che anche se la funzione viene chiamata n volte viene richiamata sempre su stessa isola e pedina
    public void moveToIsland(int n, ArrayList<ColorPawn> colorPawn, Island island,Game game) {
        //n = numero di pedine che si vogliono spostare da entrance a island
        //la somma di n pedine da spostare da entrance verso l'isola e da entance verso diningroom deve essere 3 o 4
        //controller?
        if((game.totPlayer == 2 || game.totPlayer == 4) && (n > 0 &&  n < 4 )){
            while(n != 0){
                movePawnToIsland(colorPawn.get(n - 1), island, game);
                n--;
                colorPawn.remove(n);
            }
        }
            if(game.totPlayer == 3 && (n > 0 &&  n < 5 )){
                while(n != 0){
                    movePawnToIsland(colorPawn.get(n - 1), island, game);
                    n--;
                    colorPawn.remove(n);
                }
        }
    }
    public void chooseCloud (Cloud cloud,Game game,Player player){
        if(cloud.getNumPawn()!=0 && !checkNum(game)){      //utile o no il controllo di numPawn? (controller)
            player.entrance.setGreenPawn(player.entrance.getGreenPawn() + cloud.getGreenPawn());
            player.entrance.setRedPawn(player.entrance.getRedPawn() + cloud.getRedPawn());
            player.entrance.setYellowPawn(player.entrance.getYellowPawn() + cloud.getYellowPawn());
            player.entrance.setPinkPawn(player.entrance.getPinkPawn() + cloud.getPinkPawn());
            player.entrance.setBluePawn(player.entrance.getBluePawn() + cloud.getBluePawn());
            cloud.setNumPawn(0);
            cloud.setGreenPawn(0);
            cloud.setRedPawn(0);
            cloud.setYellowPawn(0);
            cloud.setPinkPawn(0);
            cloud.setBluePawn(0);
            player.entrance.startNumPawn(game);
        }
    }
    public LightEntrance getLightEntrance(){
        LightEntrance lightEntrance=new LightEntrance(getNumPawn(),getGreenPawn(),getRedPawn(),getYellowPawn(),getPinkPawn(),getBluePawn());
        return lightEntrance;
    }
}