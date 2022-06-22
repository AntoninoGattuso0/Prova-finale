package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class SchoolBoard1Controller {
    Gui gui;
    LightGame lightGame;//da qualche parte ha bisogno di ricevere lightGame

    public void setGui(Gui gui){
        this.gui=gui;
        this.lightGame=gui.getLightGame();
    }

    @FXML Pane schoolBoard1;

    public Pane getSchoolBoard1(){return schoolBoard1;}

    public void setSchoolBoard1(){
        setAllInvisible();
        setEntrance1();
        setDiningRoom1();
        setTower1();
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
        int green = lightGame.getPlayers().get(1).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard1.getChildren()){
                if(school.getId().equals("entranceGreen1" + i))
                    school.setDisable(false);
            }
        }

        int red = lightGame.getPlayers().get(1).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceRed1" + i))
                    school.setDisable(false);
            }
        }
        int yellow = lightGame.getPlayers().get(1).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceYellow1" + i))
                    school.setDisable(false);
            }
        }
        int pink = lightGame.getPlayers().get(1).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entrancePink1" + i))
                    school.setDisable(false);
            }
        }
        int blue = lightGame.getPlayers().get(1).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceBlue1" + i))
                    school.setDisable(false);
            }
        }
    }


    public void setEntrance1(){
        int green = lightGame.getPlayers().get(1).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard1.getChildren()){
                if(school.getId().equals("entranceGreen1" + i))
                    school.setVisible(true);
            }
        }

        int red = lightGame.getPlayers().get(1).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceRed1" + i))
                    school.setVisible(true);
            }
        }
        int yellow = lightGame.getPlayers().get(1).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceYellow1" + i))
                    school.setVisible(true);
            }
        }
        int pink = lightGame.getPlayers().get(1).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entrancePink1" + i))
                    school.setVisible(true);
            }
        }
        int blue = lightGame.getPlayers().get(1).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceBlue1" + i))
                    school.setVisible(true);
            }
        }
    }

    //le 5 funzioni qui sotto mettono visibile/ non visibili clickabili.. le pedine che passiamo con numColore
    public void greenEntrance1(boolean boolVisibility, boolean boolClickable, int numGreen){
        for(Node school : schoolBoard1.getChildren()){
            if(school.getId().equals("entranceGreen1" + numGreen)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }

    public void redEntrance1(boolean boolVisibility, boolean boolClickable, int numRed){
            for(Node school : schoolBoard1.getChildren()){
                if(school.getId().equals("entranceRed1" + numRed)){
                    school.setVisible(boolVisibility);
                    school.setDisable(boolClickable);
            }
        }
    }
    public void yellowEntrance1(boolean boolVisibility, boolean boolClickable, int numYellow){
            for(Node school : schoolBoard1.getChildren()){
                if(school.getId().equals("entranceYellow1" + numYellow)){
                    school.setVisible(boolVisibility);
                    school.setDisable(boolClickable);
            }
        }
    }
    public void pinkEntrance1(boolean boolVisibility, boolean boolClickable, int numPink){
            for(Node school : schoolBoard1.getChildren()){
                if(school.getId().equals("entrancePink1" + numPink)){
                    school.setVisible(boolVisibility);
                    school.setDisable(boolClickable);
            }
        }
    }
    public void blueEntrance1(boolean boolVisibility, boolean boolClickable, int numBlue){
            for(Node school : schoolBoard1.getChildren()){
                if(school.getId().equals("entranceBlue1" + numBlue)){
                    school.setVisible(boolVisibility);
                    school.setDisable(boolClickable);
            }
        }
    }

    public void setDiningRoom1(){
        int green = lightGame.getPlayers().get(1).getDiningRoom().getNumGreen();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolBoard1Green" + i))
                    school.setVisible(true);
            }
        }
        int red = lightGame.getPlayers().get(1).getDiningRoom().getNumRed();
        for(int i=0; i<red; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolBoar1Red" + i))
                    school.setVisible(true);
            }
        }
        int yellow = lightGame.getPlayers().get(1).getDiningRoom().getNumYellow();
        for(int i=0; i<yellow; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolBoard1Yellow" + i))
                    school.setVisible(true);
            }
        }
        int pink = lightGame.getPlayers().get(1).getDiningRoom().getNumPink();
        for(int i=0; i<pink; i++){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolBoard1Pink" + i))
                    school.setVisible(true);
            }
        }
        int blue = lightGame.getPlayers().get(1).getDiningRoom().getNumBlue();
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


    //QUESTO lo usero per i prof delle altre school
    public void setGreenProfessor1(boolean bool){
        if(lightGame.getProfTable().getGreenProf() == 1){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolGreenProf1"))
                    school.setVisible(bool);
            }
        }
    }
    public void setRedProfessor1(boolean bool){
        if(lightGame.getProfTable().getRedProf() == 1){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolRedProf1"))
                    school.setVisible(bool);
            }
        }
    }
    public void setYellowProfessor1(boolean bool){
        if(lightGame.getProfTable().getYellowProf() == 1){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolYellowProf1"))
                    school.setVisible(bool);
            }
        }
    }

    public void setPinkProfessor1(boolean bool){
        if(lightGame.getProfTable().getPinkProf() == 1){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolPinkProf1"))
                    school.setVisible(bool);
            }
        }
    }
    public void setBlueProfessor1(boolean bool){
        if(lightGame.getProfTable().getBlueProf() == 1){
            for(Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolBlueProf1"))
                    school.setVisible(bool);
            }
        }
    }

    //setta visibili le torri per la scena iniziale
    public void setTower1(){
        for(int i = 0; i<lightGame.getPlayers().get(1).getTowerSpace().getNumTower(); i++)
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
        for (int i = 0; i < lightGame.getPlayers().get(1).getNumCoin(); i++)
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
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceGreen10"))
                schoolBoard1.setVisible(true);
            schoolBoard1.setDisable(true);
        }
    }

    public void green11Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceGreen11")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void green12Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceGreen12")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void green13Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceGreen13")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void green14Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceGreen14")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void green15Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceGreen15")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void green16Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceGreen16")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void green17Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceGreen17")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void green18Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceGreen18")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void red10Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceRed10")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void red11Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceRed11")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void red12Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceRed12")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void red13Select(MouseEvent mouseEvent) {

        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceRed13")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void red14Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceRed14")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void red15Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceRed15")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void red16Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceRed16")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void red17Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceRed17")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void red18Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceRed18")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void yellow10Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceYellow10")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void yellow11Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceYellow11")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void yellow12Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceYellow12")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void yellow13Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceYellow13")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void yellow14Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceYellow14")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void yellow15Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceYellow15")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void yellow16Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceYellow16")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void yellow17Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceYellow17")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void yellow18Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceYellow18")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void pink10Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entrancePink10")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void pink11Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entrancePink11")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void pink12Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entrancePink12")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void pink13Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entrancePink13")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void pink14Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entrancePink14")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void pink15Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entrancePink15")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void pink16Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entrancePink16")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void pink17Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entrancePink17")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void pink18Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entrancePink18")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void blue10Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceBlue10")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void blue11Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceBlue11")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void blue12Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceBlue12")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void blue13Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceBlue13")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void blue14Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceBlue14")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void blue15Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceBlue15")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void blue16Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceBlue16")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void blue17Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceBlue17")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void blue18Select(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("entranceBlue18")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    //alcune carte permettono di togliere delle pedine dalla dining
    //una volta selezionata la pedina sulla dining
    //diventa invisibile e non selezionabile
    //da qui in giu uguale
    public void selectSchoolGreen10(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Green0")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void selectSchoolGreen11(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Green1")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen12(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Green2")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen13(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Green3")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen14(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Green4")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen15(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Green5")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen16(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Green6")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen17(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Green7")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen18(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Green8")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen19(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Green9")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void selectSchoolRed10(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Red0")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolRed11(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Red1")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolRed12(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Red2")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolRed13(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Red3")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolRed14(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Red4")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolRed15(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Red5")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolRed16(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Red6")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolRed17(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Red7")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolRed18(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Red8")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolRed19(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Red9")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void selectSchoolYellow10(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Yellow0")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow11(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Yellow1")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow12(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Yellow2")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow13(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Yellow3")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow14(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Yellow4")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow15(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Yellow5")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow16(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Yellow6")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow17(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Yellow7")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow18(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Yellow8")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow19(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Yellow9")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void selectSchoolPink10(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Pink0")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolPink11(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Pink1")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolPink12(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Pink2")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolPink13(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Pink3")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolPink14(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Pink4")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolPink15(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Pink5")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolPink16(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Pink6")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolPink17(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Pink7")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolPink18(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Pink8")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolPink19(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Pink9")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

    public void selectSchoolBlue10(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Blue0")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue11(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Blue1")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue12(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Blue2")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue13(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Blue3")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue14(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Blue4")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue15(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Blue5")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue16(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Blue6")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue17(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Blue7")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue18(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Blue8")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue19(MouseEvent mouseEvent) {
        for(Node schoolBoard1 : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("schoolBoard1Blue9")){
                schoolBoard1.setVisible(false);
                schoolBoard1.setDisable(true);
            }
        }
    }

}