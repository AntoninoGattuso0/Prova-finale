package it.polimi.ingsw.view.GUI.Controller;
import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.network.Message.ClientToServer.MovePawnToDiningMessage;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class SchoolBoard1Controller {
    Gui gui;

    public void setGui(Gui gui){
        this.gui=gui;
    }

    @FXML Pane schoolBoard1;

    public Pane getSchoolBoard1(){return schoolBoard1;}

    public void setSchoolBoard1(){
        setAllInvisible();
        setEntrance1();
        setDiningRoom1();
        setTower1();
        int n;
        n=gui.getLightGame().getProfTable().getRedProf();
        if(n==1){
            setRedProfessor1(true);
        }
        n=gui.getLightGame().getProfTable().getPinkProf();
        if(n==1){
            setPinkProfessor1(true);
        }
        n=gui.getLightGame().getProfTable().getGreenProf();
        if(n==1){
            setGreenProfessor1(true);
        }
        n=gui.getLightGame().getProfTable().getBlueProf();
        if(n==1){setBlueProfessor1(true);
        }
        n=gui.getLightGame().getProfTable().getYellowProf();
        if(n==1){
            setYellowProfessor1(true);
        }
        setCoin1();
    }

    public void setAllInvisible(){
        for(Node all : schoolBoard1.getChildren()) {
            all.setVisible(false);
            all.setDisable(true);
            if(all.getId().equals("backSchool1"))
                all.setVisible(true);
        }
    }


    //rende le pedine dei colori presenti sul entrata come cliccabili
    public void setEntrance1Clickable(){
        setEntrance1();
        int green = gui.getLightGame().getPlayers().get(1).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard1.getChildren()){
                if(school.getId().equals("entranceGreen1" + i))
                    school.setDisable(false);
            }
        }

        int red = gui.getLightGame().getPlayers().get(1).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceRed1" + i))
                    school.setDisable(false);
            }
        }
        int yellow = gui.getLightGame().getPlayers().get(1).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceYellow1" + i))
                    school.setDisable(false);
            }
        }
        int pink = gui.getLightGame().getPlayers().get(1).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entrancePink1" + i))
                    school.setDisable(false);
            }
        }
        int blue = gui.getLightGame().getPlayers().get(1).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceBlue1" + i))
                    school.setDisable(false);
            }
        }
    }


    public void setEntrance1(){
        int green = gui.getLightGame().getPlayers().get(1).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard1.getChildren()){
                if(school.getId().equals("entranceGreen1" + i))
                    school.setVisible(true);
            }
        }

        int red = gui.getLightGame().getPlayers().get(1).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceRed1" + i))
                    school.setVisible(true);
            }
        }
        int yellow = gui.getLightGame().getPlayers().get(1).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceYellow1" + i))
                    school.setVisible(true);
            }
        }
        int pink = gui.getLightGame().getPlayers().get(1).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entrancePink1" + i))
                    school.setVisible(true);
            }
        }
        int blue = gui.getLightGame().getPlayers().get(1).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceBlue1" + i))
                    school.setVisible(true);
            }
        }
    }

    //le 5 funzioni qui sotto mettono visibile/ non visibili clickabili.. le pedine che passiamo con numColore
    public void greenEntrance1(boolean boolVisibility, boolean boolClickable, int numGreen){
        schoolBoard1.lookup("#entranceGreen1"+ numGreen).setVisible(boolVisibility);
        schoolBoard1.lookup("#entranceGreen1"+ numGreen).setDisable(boolClickable);
    }

    public void redEntrance1(boolean boolVisibility, boolean boolClickable, int numRed){
        schoolBoard1.lookup("#entranceRed1"+ numRed).setVisible(boolVisibility);
        schoolBoard1.lookup("#entranceRed1"+ numRed).setDisable(boolClickable);
    }
    public void yellowEntrance1(boolean boolVisibility, boolean boolClickable, int numYellow){
        schoolBoard1.lookup("#entranceYellow1"+ numYellow).setVisible(boolVisibility);
        schoolBoard1.lookup("#entranceYellow1"+ numYellow).setDisable(boolClickable);
    }
    public void pinkEntrance1(boolean boolVisibility, boolean boolClickable, int numPink){
        schoolBoard1.lookup("#entrancePink1"+ numPink).setVisible(boolVisibility);
        schoolBoard1.lookup("#entrancePink1"+ numPink).setDisable(boolClickable);
    }
    public void blueEntrance1(boolean boolVisibility, boolean boolClickable, int numBlue){
        schoolBoard1.lookup("#entranceBlue1"+ numBlue).setVisible(boolVisibility);
        schoolBoard1.lookup("#entranceBlue1"+ numBlue).setDisable(boolClickable);
    }
    public void setDiningRoom1(){
        int green = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumGreen();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolBoard1Green" + i))
                    school.setVisible(true);
            }
        }
        int red = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumRed();
        for(int i=0; i<red; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolBoard1Red" + i))
                    school.setVisible(true);
            }
        }
        int yellow = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumYellow();
        for(int i=0; i<yellow; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolBoard1Yellow" + i))
                    school.setVisible(true);
            }
        }
        int pink = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumPink();
        for(int i=0; i<pink; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolBoard1Pink" + i))
                    school.setVisible(true);
            }
        }
        int blue = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumBlue();
        for(int i=0; i<blue; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolBoard1Blue" + i))
                    school.setVisible(true);
            }
        }
    }
    //le 5 funzioni qui sotto mettono visibile/ non visibili le pedine delle dining che passiamo con num
    public void greenDining1(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard1.getChildren()) {
            if (school.getId().equals("schoolBoard1Green" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void redDining1(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard1.getChildren()) {
            if (school.getId().equals("schoolBoard1Red" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void yellowDining1(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard1.getChildren()) {
            if (school.getId().equals("schoolBoard1Yellow" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void pinkDining1(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard1.getChildren()) {
            if (school.getId().equals("schoolBoard1Pink" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void blueDining1(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard1.getChildren()) {
            if (school.getId().equals("schoolBoard1Blue" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }

    public void setGreenProfessor1(boolean bool){
        schoolBoard1.lookup("#schoolGreenProf1").setVisible(bool);
    }
    public void setRedProfessor1(boolean bool){
        schoolBoard1.lookup("#schoolRedProf1").setVisible(bool);
    }
    public void setYellowProfessor1(boolean bool){
        schoolBoard1.lookup("#schoolYellowProf1").setVisible(bool);
    }
    public void setPinkProfessor1(boolean bool){
        schoolBoard1.lookup("#schoolPinkProf1").setVisible(bool);
    }
    public void setBlueProfessor1(boolean bool){
        schoolBoard1.lookup("#schoolBlueProf1").setVisible(bool);
    }

    public void setProfessor1(int numColor, boolean bool){
        if(numColor == 0)
            setGreenProfessor1(bool);
        if(numColor == 1)
            setRedProfessor1(bool);
        if(numColor == 2)
            setYellowProfessor1(bool);
        if(numColor == 3)
            setPinkProfessor1(bool);
        if(numColor == 4)
            setBlueProfessor1(bool);
    }
    //setta visibili le torri per la scena iniziale
    public void setTower1(){
        for(int i = 0; i<gui.getLightGame().getPlayers().get(1).getTowerSpace().getNumTower(); i++)
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("whiteTowerSchool" + i))
                    school.setVisible(true);
            }
    }

    public void towerVisibility1(boolean bool, int numTower){
        for(Node school : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("whiteTowerSchool" + numTower))
                school.setVisible(bool);
        }
    }

    public void setCoin1() {
        for (int i = 0; i < gui.getLightGame().getPlayers().get(1).getNumCoin(); i++)
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("coin" + i))
                    school.setVisible(true);
            }
    }

    public void coinVisibility1(boolean bool, int numCoin){
        for(Node school : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("coin" + numCoin))
                school.setVisible(bool);
        }
    }

    //una volta cliccata la pedina sull'entrata per farla spostare
    //o sull'isola o sulla dining, la pedina sull entrata
    //diventa invisibile e non selezionabile
    ///tutte le funzioni qua sotto fino alla 462 fanno sta cosa

    public void green10Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen10").setVisible(false);
        schoolBoard1.lookup("#entranceGreen10").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green11Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen11").setVisible(false);
        schoolBoard1.lookup("#entranceGreen11").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green12Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen12").setVisible(false);
        schoolBoard1.lookup("#entranceGreen12").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green13Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen13").setVisible(false);
        schoolBoard1.lookup("#entranceGreen13").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green14Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen14").setVisible(false);
        schoolBoard1.lookup("#entranceGreen14").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green15Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen15").setVisible(false);
        schoolBoard1.lookup("#entranceGreen15").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green16Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen16").setVisible(false);
        schoolBoard1.lookup("#entranceGreen16").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green17Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen17").setVisible(false);
        schoolBoard1.lookup("#entranceGreen17").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green18Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen18").setVisible(false);
        schoolBoard1.lookup("#entranceGreen18").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void red10Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed10").setVisible(false);
        schoolBoard1.lookup("#entranceRed10").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red11Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed11").setVisible(false);
        schoolBoard1.lookup("#entranceRed11").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red12Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed12").setVisible(false);
        schoolBoard1.lookup("#entranceRed12").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red13Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed13").setVisible(false);
        schoolBoard1.lookup("#entranceRed13").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red14Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed14").setVisible(false);
        schoolBoard1.lookup("#entranceRed14").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red15Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed15").setVisible(false);
        schoolBoard1.lookup("#entranceRed15").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red16Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed16").setVisible(false);
        schoolBoard1.lookup("#entranceRed16").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red17Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed17").setVisible(false);
        schoolBoard1.lookup("#entranceRed17").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red18Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed18").setVisible(false);
        schoolBoard1.lookup("#entranceRed18").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void yellow10Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow10").setVisible(false);
        schoolBoard1.lookup("#entranceYellow10").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow11Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow11").setVisible(false);
        schoolBoard1.lookup("#entranceYellow11").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow12Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow12").setVisible(false);
        schoolBoard1.lookup("#entranceYellow12").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow13Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow13").setVisible(false);
        schoolBoard1.lookup("#entranceYellow13").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow14Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow14").setVisible(false);
        schoolBoard1.lookup("#entranceYellow14").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow15Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow15").setVisible(false);
        schoolBoard1.lookup("#entranceYellow15").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow16Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow16").setVisible(false);
        schoolBoard1.lookup("#entranceYellow16").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow17Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow17").setVisible(false);
        schoolBoard1.lookup("#entranceYellow17").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow18Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow18").setVisible(false);
        schoolBoard1.lookup("#entranceYellow18").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void pink10Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink10").setVisible(false);
        schoolBoard1.lookup("#entrancePink10").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink11Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink11").setVisible(false);
        schoolBoard1.lookup("#entrancePink11").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink12Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink12").setVisible(false);
        schoolBoard1.lookup("#entrancePink12").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink13Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink13").setVisible(false);
        schoolBoard1.lookup("#entrancePink13").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink14Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink14").setVisible(false);
        schoolBoard1.lookup("#entrancePink14").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink15Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink15").setVisible(false);
        schoolBoard1.lookup("#entrancePink15").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink16Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink16").setVisible(false);
        schoolBoard1.lookup("#entrancePink16").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }
    public void pink17Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink17").setVisible(false);
        schoolBoard1.lookup("#entrancePink17").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink18Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink18").setVisible(false);
        schoolBoard1.lookup("#entrancePink18").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void blue10Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue10").setVisible(false);
        schoolBoard1.lookup("#entranceBlue10").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue11Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue11").setVisible(false);
        schoolBoard1.lookup("#entranceBlue11").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue12Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue12").setVisible(false);
        schoolBoard1.lookup("#entranceBlue12").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue13Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue13").setVisible(false);
        schoolBoard1.lookup("#entranceBlue13").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue14Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue14").setVisible(false);
        schoolBoard1.lookup("#entranceBlue14").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue15Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue15").setVisible(false);
        schoolBoard1.lookup("#entranceBlue15").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue16Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue16").setVisible(false);
        schoolBoard1.lookup("#entranceBlue16").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue17Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue17").setVisible(false);
        schoolBoard1.lookup("#entranceBlue17").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue18Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue18").setVisible(false);
        schoolBoard1.lookup("#entranceBlue18").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }


    public void selectSchoolGreen10(MouseEvent mouseEvent) {
        schoolBoard1.lookup("##schoolBoard1Green0").setVisible(false);
        schoolBoard1.lookup("##schoolBoard1Green0").setDisable(true);
    }

    public void selectSchoolGreen11(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Green1").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Green1").setDisable(true);
    }
    public void selectSchoolGreen12(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Green2").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Green2").setDisable(true);
    }
    public void selectSchoolGreen13(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Green3").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Green3").setDisable(true);
    }
    public void selectSchoolGreen14(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Green4").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Green4").setDisable(true);
    }
    public void selectSchoolGreen15(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Green5").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Green5").setDisable(true);
    }
    public void selectSchoolGreen16(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Green6").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Green6").setDisable(true);
    }
    public void selectSchoolGreen17(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Green7").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Green7").setDisable(true);
    }
    public void selectSchoolGreen18(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Green8").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Green8").setDisable(true);
    }
    public void selectSchoolGreen19(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Green9").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Green9").setDisable(true);
    }

    public void selectSchoolRed10(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Red0").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Red0").setDisable(true);
    }
    public void selectSchoolRed11(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Red1").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Red1").setDisable(true);
    }
    public void selectSchoolRed12(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Red2").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Red2").setDisable(true);
    }
    public void selectSchoolRed13(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Red3").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Red3").setDisable(true);
    }
    public void selectSchoolRed14(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Red4").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Red4").setDisable(true);
    }
    public void selectSchoolRed15(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Red5").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Red5").setDisable(true);
    }
    public void selectSchoolRed16(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Red6").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Red6").setDisable(true);
    }
    public void selectSchoolRed17(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Red7").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Red7").setDisable(true);
    }
    public void selectSchoolRed18(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Red8").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Red8").setDisable(true);
    }
    public void selectSchoolRed19(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Red9").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Red9").setDisable(true);
    }

    public void selectSchoolYellow10(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Yellow0").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Yellow0").setDisable(true);
    }
    public void selectSchoolYellow11(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Yellow1").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Yellow1").setDisable(true);
    }
    public void selectSchoolYellow12(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Yellow2").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Yellow2").setDisable(true);
    }
    public void selectSchoolYellow13(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Yellow3").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Yellow3").setDisable(true);
    }
    public void selectSchoolYellow14(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Yellow4").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Yellow4").setDisable(true);
    }
    public void selectSchoolYellow15(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Yellow5").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Yellow5").setDisable(true);
    }
    public void selectSchoolYellow16(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Yellow6").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Yellow6").setDisable(true);
    }
    public void selectSchoolYellow17(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Yellow7").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Yellow7").setDisable(true);
    }
    public void selectSchoolYellow18(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Yellow8").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Yellow8").setDisable(true);
    }
    public void selectSchoolYellow19(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Yellow9").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Yellow9").setDisable(true);
    }

    public void selectSchoolPink10(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Pink0").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Pink0").setDisable(true);
    }
    public void selectSchoolPink11(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Pink1").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Pink1").setDisable(true);
    }
    public void selectSchoolPink12(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Pink2").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Pink2").setDisable(true);
    }
    public void selectSchoolPink13(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Pink3").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Pink3").setDisable(true);
    }
    public void selectSchoolPink14(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Pink4").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Pink4").setDisable(true);
    }
    public void selectSchoolPink15(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Pink5").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Pink5").setDisable(true);
    }
    public void selectSchoolPink16(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Pink6").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Pink6").setDisable(true);
    }
    public void selectSchoolPink17(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Pink7").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Pink7").setDisable(true);
    }
    public void selectSchoolPink18(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Pink8").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Pink8").setDisable(true);
    }
    public void selectSchoolPink19(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Pink9").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Pink9").setDisable(true);
    }

    public void selectSchoolBlue10(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Blue0").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Blue0").setDisable(true);
    }
    public void selectSchoolBlue11(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Blue1").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Blue1").setDisable(true);
    }
    public void selectSchoolBlue12(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Blue2").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Blue2").setDisable(true);
    }
    public void selectSchoolBlue13(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Blue3").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Blue3").setDisable(true);
    }
    public void selectSchoolBlue14(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Blue4").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Blue4").setDisable(true);
    }
    public void selectSchoolBlue15(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Blue5").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Blue5").setDisable(true);
    }
    public void selectSchoolBlue16(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Blue6").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Blue6").setDisable(true);
    }
    public void selectSchoolBlue17(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Blue7").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Blue7").setDisable(true);
    }
    public void selectSchoolBlue18(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Blue8").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Blue8").setDisable(true);
    }
    public void selectSchoolBlue19(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#schoolBoard1Blue9").setVisible(false);
        schoolBoard1.lookup("#schoolBoard1Blue9").setDisable(true);
    }

    public void selection(){
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
        for(int i=0; i<gui.getLightGame().getIslands().size(); i++)
            gui.getGameTable().getGameTablePane().lookup("#island"+ i).setDisable(false);
            if(gui.getNumPawnsCount()==0)
                for(Node school : schoolBoard1.getChildren())
                    school.setDisable(true);
        }else if(gui.getButtonClicked().equals(ButtonAction.DININGROOM)){
            if(gui.getNumPawnsCount()==0){
                for(Node school : schoolBoard1.getChildren()){
                    school.setDisable(true);
                }
                gui.getSocketNetworkHandler().sendMessage(new MovePawnToDiningMessage(gui.getNumPawns(), gui.getColorPawns()));
                gui.getColorPawns().clear();
                gui.getSchoolBoard1Controller().setDiningRoom1();
                gui.getGameTable().getShowSchool1().setCenter(gui.getSchoolBoard1Controller().getSchoolBoard1());
                gui.getGameTable().getShowSchool1().setVisible(true);
                gui.setPedineDaSpostare(gui.getPedineDaSpostare()- gui.getNumPawns());
            }
        }
    }
}