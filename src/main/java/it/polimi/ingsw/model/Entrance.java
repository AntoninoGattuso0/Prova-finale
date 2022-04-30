package it.polimi.ingsw.model;

import java.util.*;
public class Entrance {

    private int numPawn;        //numero di pedine totali presenti all'entrata della plancia

    //numero di pedine per ogni colore, inizialmente sono zero, poi in base al numero di player vengono aggiunte pedine in maniera randomica
    private int greenPawn;
    private int bluePawn;
    private int pinkPawn;
    private int yellowPawn;
    private int redPawn;

    Entrance(){
       greenPawn = 0;
       bluePawn = 0;
       pinkPawn = 0;
       yellowPawn = 0;
       redPawn = 0;
       startNumPawn();
       int j = getNumPawn();
        Random rnd = new Random();
        while (j > 0) {
            ArrayList<String> entrancePawn = Game.createArrayPawn();
            if (StudentBag.getNum() > 0) {
                int random = rnd.nextInt(entrancePawn.size());
                if (Objects.equals(entrancePawn.get(random), Game.m.get(0))) {//verde
                    setGreenPawn(getGreenPawn() + 1);
                    setNumPawn(getNumPawn() + 1);
                    StudentBag.setNum(StudentBag.getNum() - 1);
                    StudentBag.setGreenNum(StudentBag.getGreenNum() - 1);
                    if(StudentBag.getGreenNum()==0) entrancePawn.remove(random);
                } else if (Objects.equals(entrancePawn.get(random), Game.m.get(1))) {//rosso
                    setRedPawn(getRedPawn() + 1);
                    setNumPawn(getNumPawn() + 1);
                    StudentBag.setNum(StudentBag.getNum() - 1);
                    StudentBag.setRedNum(StudentBag.getRedNum() - 1);
                    if(StudentBag.getRedNum()==0) entrancePawn.remove(random);
                } else if (Objects.equals(entrancePawn.get(random), Game.m.get(2))) {//giallo
                    setYellowPawn(getYellowPawn() + 1);
                    setNumPawn(getNumPawn() + 1);
                    StudentBag.setNum(StudentBag.getNum() - 1);
                    StudentBag.setYellowNum(StudentBag.getYellowNum() - 1);
                    if(StudentBag.getYellowNum()==0) entrancePawn.remove(random);
                } else if (Objects.equals(entrancePawn.get(random), Game.m.get(3))) {//rosa
                    setPinkPawn(getPinkPawn() + 1);
                    setNumPawn(getNumPawn() + 1);
                    StudentBag.setNum(StudentBag.getNum() - 1);
                    StudentBag.setPinkNum(StudentBag.getPinkNum() - 1);
                    if(StudentBag.getPinkNum()==0) entrancePawn.remove(random);
                } else if (Objects.equals(entrancePawn.get(random), Game.m.get(4))) {//blu
                    setBluePawn(getBluePawn() + 1);
                    setNumPawn(getNumPawn() + 1);
                    StudentBag.setNum(StudentBag.getNum() - 1);
                    StudentBag.setBlueNum(StudentBag.getBlueNum() - 1);
                    if(StudentBag.getBlueNum()==0) entrancePawn.remove(random);
                }
            }
            j--;
        }
    }

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

    // modifiche all'UML:ho aggiunto setter per definire quante sono le pedine che devono esserci in Entrance
    //all'inizio del gioco e dopo che ho fatto refill da una nuvola
    public void startNumPawn(){
        if(Game.totPlayer == 2 || Game.totPlayer == 4) this.numPawn = 9;
        else if(Game.totPlayer == 3) this.numPawn = 7;
    }

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
                island.setGreenPawn(getGreenPawn() + 1);
                setGreenPawn(getGreenPawn() - 1);
                setNumPawn(getNumPawn() - 1);
            }else if(Objects.equals(colorPawn.toString(), "RED") && this.redPawn > 0){
                island.setRedPawn(getRedPawn() + 1);
                setRedPawn(getRedPawn() - 1);
                setNumPawn(getNumPawn() - 1);
            }else  if(Objects.equals(colorPawn.toString(), "YELLOW") && this.yellowPawn > 0){
                island.setYellowPawn(getYellowPawn() + 1);
                setYellowPawn(getYellowPawn() - 1);
                setNumPawn(getNumPawn() - 1);
            }else if(Objects.equals(colorPawn.toString(), "PINK") && this.pinkPawn > 0){
                island.setPinkPawn(getPinkPawn() + 1);
                StudentBag.setNum(StudentBag.getNum()-1);
                StudentBag.setPinkNum(StudentBag.getPinkNum()-1);
            }else if(Objects.equals(colorPawn.toString(), "BLUE") && this.bluePawn > 0){
                island.setBluePawn(getBluePawn() + 1);
                StudentBag.setNum(StudentBag.getNum()-1);
                StudentBag.setBlueNum(getBluePawn()-1);
            }else {
                System.out.println("Errore: non esistono pedine di questo colore nell'ingresso");  //penso sia una cosa del controller
            }
        }


        //LEGGIMI :( non va bene il fatto che anche se la funzione viene chiamata n volte viene richiamata sempre su stessa isola e pedina
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

        if(cloud.getNumPawn()!=0 && !checkNum()){      //utile o no il controllo di numPawn? (controller)
            setGreenPawn(cloud.getGreenPawn() + 1);
            setRedPawn(cloud.getRedPawn() + 1);
            setYellowPawn(cloud.getYellowPawn() + 1);
            setPinkPawn(cloud.getPinkPawn() + 1);
            setBluePawn(cloud.getBluePawn() + 1);

            startNumPawn();

            cloud.setNumPawn(0);
            cloud.setGreenPawn(0);
            cloud.setRedPawn(0);
            cloud.setYellowPawn(0);
            cloud.setPinkPawn(0);
            cloud.setBluePawn(0);

        }
    }
}