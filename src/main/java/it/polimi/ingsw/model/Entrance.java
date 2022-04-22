package it.polimi.ingsw.model;

import java.util.*;

public class Entrance {

    protected int numPawn = 0;        //numero di pedine totali presenti all'entrata della plancia

    //numero di pedine per ogni colore, inizialmente sono zero, poi in base al numero di player vengono aggiunte pedine in maniera randomica
    protected int greenPawn = 0;
    protected int bluePawn = 0;
    protected int pinkPawn = 0;
    protected int yellowPawn = 0;
    protected int redPawn = 0;

    // modifiche all'UML:ho aggiunto setter per definire quante sono le pedine che devono esserci in Entrance
    //all'inizio del gioco e dopo che ho fatto refill da una nuvola
    public void setNumPawn(){
        if(Game.totPlayer == 2 || Game.totPlayer == 4) this.numPawn = 9;
        else if(Game.totPlayer == 3) this.numPawn = 7;
    }

//metodo che ritorna quante pedine sono presenti all'ingresso
    public int getNumPawn(){ return this.numPawn; }              //utile? questo metodo sarebbe utile se da qualche parte qualcuno lo usasse,
                                                                // ma essendo protected e non private ci possono accedere tutte le calssi del model

    //modifiche all'UML: il ritorno di check è boolean
    //metodo che controlla in base al numero di Players se ci sono ancora 4 o 5 pedine all'ingresso
    public boolean checkNum(){
        if((Game.totPlayer == 2 || Game.totPlayer == 4) && numPawn > 3 )
            return true;
       else if(Game.totPlayer == 3 && numPawn > 4)
            return true;
       else return false;
    }

    public void movePawnToIsland(ColorPawn colorPawn, Island island){
            //tutti questi spostamenti sono possibili se il numero di pedine all'entrata è 4 o 5 in base ai giocatori
            if(Objects.equals(colorPawn.toString(), "GREEN") && this.greenPawn > 0){  //altrimenti cosa succede se la pedina verde non c'è?
                island.greenPawn++;
                this.greenPawn--;
                this.numPawn--;
            }else if(Objects.equals(colorPawn.toString(), "RED") && this.redPawn > 0){
                island.redPawn++;
                this.redPawn--;
                this.numPawn--;
            }else  if(Objects.equals(colorPawn.toString(), "YELLOW") && this.yellowPawn > 0){
                island.yellowPawn++;
                this.yellowPawn--;
                this.numPawn--;
            }else if(Objects.equals(colorPawn.toString(), "PINK") && this.pinkPawn > 0){
                island.pinkPawn++;
                this.pinkPawn--;
                this.numPawn--;
            }else if(Objects.equals(colorPawn.toString(), "BLUE") && this.bluePawn > 0){
                island.bluePawn++;
                this.bluePawn--;
                this.numPawn--;
            }else {
                System.out.println("Errore: non esistono pedine di questo colore nell'ingresso");  //penso sia una cosa del controller
            }
        }

    public void moveToIsland(int n, ColorPawn colorPawn, Island island) {
        //n = numero di pedine che si vogliono spostare da entrance a island
        //la somma di n pedine da spostare da entrance verso l'isola e da entance verso diningroom deve essere 3 o 4
        //controller?
        if((Game.totPlayer == 2 || Game.totPlayer == 4) && (n > 0 &&  n < 4 )){
            while(n != 0){
                movePawnToIsland(colorPawn, island);
                n--;
            }
        }
            if(Game.totPlayer == 3 && (n > 0 &&  n < 5 )){
                while(n != 0){
                    movePawnToIsland(colorPawn, island);
                    n--;
                }
        }
    }

    public void chooseCloud (Cloud cloud){

        if(cloud.numPawn!=0 && !checkNum()){      //utile o no il controllo di numPawn? (controller)
            this.greenPawn += cloud.greenPawn;
            this.redPawn += cloud.redPawn;
            this.yellowPawn += cloud.yellowPawn;
            this.pinkPawn += cloud.pinkPawn;
            this.bluePawn += cloud.bluePawn;
            setNumPawn();

            cloud.numPawn = 0;
            cloud.greenPawn = 0;
            cloud.redPawn = 0;
            cloud.yellowPawn = 0;
            cloud.pinkPawn = 0;
            cloud.bluePawn = 0;

        }
    }
}