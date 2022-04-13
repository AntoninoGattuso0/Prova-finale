package it.polimi.ingsw.model;

import java.util.*;

public class Cloud {
    private int numPawn;
    private int greenPawn;
    private int redPawn;
    private int yellowPawn;
    private int pinkPawn;
    private int bluePawn;

    public void getNumPlayer() {
        int numPawn;
    }

    public void refillCloud() {
        int i;
        Random rnd = new Random();
        Map<Integer, String> m = new HashMap<Integer, String>();
        m.put(0, "GREEN");
        m.put(1, "RED");
        m.put(2, "YELLOW");
        m.put(3, "PINK");
        m.put(4, "BLUE");
        ArrayList<String> startingPawn = new ArrayList<>();
        if (StudentBag.greenNum != 0)
            startingPawn.add("GREEN");
        if (StudentBag.redNum != 0)
            startingPawn.add("RED");
        if (StudentBag.yellowNum != 0)
            startingPawn.add("YELLOW");
        if (StudentBag.pinkNum != 0)
            startingPawn.add("PINK");
        if (StudentBag.blueNum != 0)
            startingPawn.add("BLUE");
        for (i = 0; i < numPawn; i++) {
            if (StudentBag.num > 0) {
                int random = rnd.nextInt(startingPawn.size());
                String color = m.get(random);
                if (Objects.equals(startingPawn.get(random), "GREEN")) {
                    greenPawn++;
                    numPawn++;
                    StudentBag.num--;
                    StudentBag.greenNum--;
                    if(StudentBag.greenNum==0){
                        startingPawn.remove(random);
                    }
                } else if (Objects.equals(startingPawn.get(random), "RED")) {
                    redPawn++;
                    numPawn++;
                    StudentBag.num--;
                    StudentBag.redNum--;
                    if(StudentBag.redNum==0){
                        startingPawn.remove(random);
                    }
                } else if (Objects.equals(startingPawn.get(random), "YELLOW")) {
                    yellowPawn++;
                    numPawn++;
                    StudentBag.num--;
                    StudentBag.yellowNum--;
                    if(StudentBag.yellowNum==0){
                        startingPawn.remove(random);
                    }
                } else if (Objects.equals(startingPawn.get(random), "PINK")) {
                    pinkPawn++;
                    numPawn++;
                    StudentBag.num--;
                    StudentBag.pinkNum--;
                    if(StudentBag.pinkNum==0){
                        startingPawn.remove(random);
                    }
                } else if (Objects.equals(startingPawn.get(random), "BLUE")) {
                    bluePawn++;
                    numPawn++;
                    StudentBag.num--;
                    StudentBag.blueNum--;
                    if(StudentBag.blueNum==0){
                        startingPawn.remove(random);
                    }
                }
            }//
        }
    }
}
