package it.polimi.ingsw.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Antonio {
    protected int numPawnAntonio;
    protected int greenPawn;
    protected int redPawn;
    protected int yellowPawn;
    protected int pinkPawn;
    protected int bluePawn;

    public void checkStudent() {
        Random rnd = new Random();
        ArrayList<String> refillPawn = Game.createArrayPawn();
        if (StudentBag.num > 0) {
            int random = rnd.nextInt(refillPawn.size());
            if (Objects.equals(refillPawn.get(random), "GREEN")) {
                greenPawn++;
                numPawnAntonio++;
                StudentBag.num--;
                StudentBag.greenNum--;
                if (StudentBag.greenNum == 0) {
                    refillPawn.remove(random);
                }
            } else if (Objects.equals(refillPawn.get(random), "RED")) {
                redPawn++;
                numPawnAntonio++;
                StudentBag.num--;
                StudentBag.redNum--;
                if (StudentBag.redNum == 0) {
                    refillPawn.remove(random);
                }
            } else if (Objects.equals(refillPawn.get(random), "YELLOW")) {
                yellowPawn++;
                numPawnAntonio++;
                StudentBag.num--;
                StudentBag.yellowNum--;
                if (StudentBag.yellowNum == 0) {
                    refillPawn.remove(random);
                }
            } else if (Objects.equals(refillPawn.get(random), "PINK")) {
                pinkPawn++;
                numPawnAntonio++;
                StudentBag.num--;
                StudentBag.pinkNum--;
                if (StudentBag.pinkNum == 0) {
                    refillPawn.remove(random);
                }
            } else if (Objects.equals(refillPawn.get(random), "BLUE")) {
                bluePawn++;
                numPawnAntonio++;
                StudentBag.num--;
                StudentBag.blueNum--;
                if (StudentBag.blueNum == 0) {
                    refillPawn.remove(random);
                }
            }
        }
    }
    public void useEffect(ColorPawn colorPawn, Island island) {
        if (Objects.equals(colorPawn.toString(), "GREEN") && this.greenPawn > 0) {  //altrimenti cosa succede se la pedina verde non c'è?
            island.greenPawn++;
            this.greenPawn--;
            this.numPawnAntonio--;
        } else if (Objects.equals(colorPawn.toString(), "RED") && this.redPawn > 0) {
            island.redPawn++;
            this.redPawn--;
            this.numPawnAntonio--;
        } else if (Objects.equals(colorPawn.toString(), "YELLOW") && this.yellowPawn > 0) {
            island.yellowPawn++;
            this.yellowPawn--;
            this.numPawnAntonio--;
        } else if (Objects.equals(colorPawn.toString(), "PINK") && this.pinkPawn > 0) {
            island.pinkPawn++;
            this.pinkPawn--;
            this.numPawnAntonio--;
        } else if (Objects.equals(colorPawn.toString(), "BLUE") && this.bluePawn > 0) {
            island.bluePawn++;
            this.bluePawn--;
            this.numPawnAntonio--;
        } else {
            System.out.println("errore colore non presente in entrata");
        }
        checkStudent();
    }
}
