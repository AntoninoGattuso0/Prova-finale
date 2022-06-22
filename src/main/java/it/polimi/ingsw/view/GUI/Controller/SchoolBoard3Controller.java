package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SchoolBoard3Controller {
    Gui gui;
    LightGame lightGame;//da qualche parte ha bisogno di ricevere lightGame

    public void setGui(Gui gui){
        this.gui=gui;
        this.lightGame = gui.getLightGame();
    }

    @FXML Pane schoolBoard3;

    public Pane getSchoolBoard3(){return schoolBoard3;}

    public void setSchoolBoard3(){
        setAllInvisible();
        setEntrance3();
        setDiningRoom3();
        setCoin3();
    }

    public void setAllInvisible(){
        for(Node all : schoolBoard3.getChildren()) {
            all.setVisible(false);
            all.setDisable(true);
            if(all.getId().equals("backSchool3"))
                all.setVisible(true);
        }
    }


    public void setEntrance3Clickable(){
        setEntrance3();
        int green = lightGame.getPlayers().get(3).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard3.getChildren()){
                if(school.getId().equals("entranceGreen3" + i))
                    school.setDisable(false);
            }
        }

        int red = lightGame.getPlayers().get(3).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("entranceRed3" + i))
                    school.setDisable(false);
            }
        }
        int yellow = lightGame.getPlayers().get(3).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("entranceYellow3" + i))
                    school.setDisable(false);
            }
        }
        int pink = lightGame.getPlayers().get(3).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("entrancePink3" + i))
                    school.setDisable(false);
            }
        }
        int blue = lightGame.getPlayers().get(3).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("entranceBlue3" + i))
                    school.setDisable(false);
            }
        }
    }

    public void setGreenEntrance3Clickable(boolean bool, int num){
        for(Node school : schoolBoard3.getChildren()){
            if(school.getId().equals("entranceGreen3" + num))
                school.setDisable(bool);
        }
    }
    public void setRedEntrance3Clickable(boolean bool, int num){
        for(Node school : schoolBoard3.getChildren()){
            if(school.getId().equals("entranceRed3" + num))
                school.setDisable(bool);
        }
    }
    public void setYellowEntrance3Clickable(boolean bool, int num){
        for(Node school : schoolBoard3.getChildren()){
            if(school.getId().equals("entranceYellow3" + num))
                school.setDisable(bool);
        }
    }
    public void setPinkEntrance3Clickable(boolean bool, int num){
        for(Node school : schoolBoard3.getChildren()){
            if(school.getId().equals("entrancePink3" + num))
                school.setDisable(bool);
        }
    } public void setBlueEntrance3Clickable(boolean bool, int num){
        for(Node school : schoolBoard3.getChildren()){
            if(school.getId().equals("entranceBlue3" + num))
                school.setDisable(bool);
        }
    }

    public void setEntrance3(){
        int green = lightGame.getPlayers().get(3).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard3.getChildren()){
                if(school.getId().equals("entranceGreen3" + i))
                    school.setVisible(true);
            }
        }

        int red = lightGame.getPlayers().get(3).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("entranceRed3" + i))
                    school.setVisible(true);
            }
        }
        int yellow = lightGame.getPlayers().get(3).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("entranceYellow3" + i))
                    school.setVisible(true);
            }
        }
        int pink = lightGame.getPlayers().get(3).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("entrancePink3" + i))
                    school.setVisible(true);
            }
        }
        int blue = lightGame.getPlayers().get(3).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("entranceBlue3" + i))
                    school.setVisible(true);
            }
        }
    }

    //le 5 funzioni qui sotto mettono visibile/ non visibili le pedine che passiamo con numColore
    public void greenVisibilityEntrance3(boolean bool, int numGreen){
        for(Node school : schoolBoard3.getChildren()){
            if(school.getId().equals("entranceGreen3" + numGreen))
                school.setVisible(bool);
        }
    }

    public void redVisibilityEntrance3(boolean bool, int numRed){
        for(Node school : schoolBoard3.getChildren()){
            if(school.getId().equals("entranceRed3" + numRed))
                school.setVisible(bool);
        }
    }
    public void yellowVisibilityEntrance3(boolean bool, int numYellow){
        for(Node school : schoolBoard3.getChildren()){
            if(school.getId().equals("entranceYellow3" + numYellow))
                school.setVisible(bool);
        }
    }
    public void pinkVisibilityEntrance3(boolean bool, int numPink){
        for(Node school : schoolBoard3.getChildren()){
            if(school.getId().equals("entrancePink3" + numPink))
                school.setVisible(bool);
        }
    }
    public void blueVisibilityEntrance3(boolean bool, int numBlue){
        for(Node school : schoolBoard3.getChildren()){
            if(school.getId().equals("entranceBlue3" + numBlue))
                school.setVisible(bool);
        }
    }

    public void setDiningRoom3(){
        int green = lightGame.getPlayers().get(3).getDiningRoom().getNumGreen();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("schoolBoard3Green" + i))
                    school.setVisible(true);
            }
        }
        int red = lightGame.getPlayers().get(3).getDiningRoom().getNumRed();
        for(int i=0; i<red; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("schoolBoard3Red" + i))
                    school.setVisible(true);
            }
        }
        int yellow = lightGame.getPlayers().get(3).getDiningRoom().getNumYellow();
        for(int i=0; i<yellow; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("schoolBoard3Yellow" + i))
                    school.setVisible(true);
            }
        }
        int pink = lightGame.getPlayers().get(3).getDiningRoom().getNumPink();
        for(int i=0; i<pink; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("schoolBoard3Pink" + i))
                    school.setVisible(true);
            }
        }
        int blue = lightGame.getPlayers().get(3).getDiningRoom().getNumBlue();
        for(int i=0; i<blue; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("schoolBoard3Blue" + i))
                    school.setVisible(true);
            }
        }
    }

    //le 5 funzioni qui sotto mettono visibile/ non visibili le pedine delle dining che passiamo con num
    public void greenVisibilityDining3(boolean bool, int num){
        for(Node school : schoolBoard3.getChildren()) {
            if (school.getId().equals("schoolBoard3Green" + num))
                school.setVisible(bool);
        }
    }
    public void redVisibilityDining3(boolean bool, int num){
        for(Node school : schoolBoard3.getChildren()) {
            if (school.getId().equals("schoolBoard3Red" + num))
                school.setVisible(bool);
        }
    }
    public void yellowVisibilityDining3(boolean bool, int num){
        for(Node school : schoolBoard3.getChildren()) {
            if (school.getId().equals("schoolBoard3Yellow" + num))
                school.setVisible(bool);
        }
    }
    public void pinkVisibilityDining3(boolean bool, int num){
        for(Node school : schoolBoard3.getChildren()) {
            if (school.getId().equals("schoolBoard3Pink" + num))
                school.setVisible(bool);
        }
    }
    public void blueVisibilityDining3(boolean bool, int num){
        for(Node school : schoolBoard3.getChildren()) {
            if (school.getId().equals("schoolBoard3Blue" + num))
                school.setVisible(bool);
        }
    }

    public void setProfessor3(){
        if(lightGame.getProfTable().getGreenProf() == 3)
            schoolBoard3.lookup("schoolGreenProf3").setVisible(true);
        if(lightGame.getProfTable().getRedProf() == 3)
            schoolBoard3.lookup("schoolRedProf3").setVisible(true);
        if(lightGame.getProfTable().getYellowProf() == 3)
            schoolBoard3.lookup("schoolYellowProf3").setVisible(true);
        if(lightGame.getProfTable().getPinkProf() == 3)
            schoolBoard3.lookup("schoolPinkProf3").setVisible(true);
        if(lightGame.getProfTable().getBlueProf() == 3)
            schoolBoard3.lookup("schoolBlueProf3").setVisible(true);
    }


    public void setCoin3() {
        for (int i = 0; i < lightGame.getPlayers().get(3).getNumCoin(); i++)
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("coin" + i))
                    school.setVisible(true);
            }
    }

    public void coinVisibility3(boolean bool, int numCoin){
        for(Node school : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("coin" + numCoin))
                school.setVisible(bool);
        }
    }

    public void green30Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceGreen30"))
                schoolBoard3.setVisible(true);
            schoolBoard3.setDisable(true);
        }
    }

    public void green31Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceGreen31")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void green32Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceGreen32")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void green33Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceGreen33")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void green34Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceGreen34")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void green35Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceGreen35")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void green36Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceGreen36")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void green37Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceGreen37")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void green38Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceGreen38")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void red30Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceRed30")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void red31Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceRed31")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void red32Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceRed32")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void red33Select(MouseEvent mouseEvent) {

        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceRed33")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void red34Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceRed34")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void red35Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceRed35")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void red36Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceRed36")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void red37Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceRed37")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void red38Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceRed38")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void yellow30Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceYellow30")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void yellow31Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceYellow31")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void yellow32Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceYellow32")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void yellow33Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceYellow33")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void yellow34Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceYellow34")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void yellow35Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceYellow35")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void yellow36Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceYellow36")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void yellow37Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceYellow37")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void yellow38Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceYellow38")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void pink30Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entrancePink30")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void pink31Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entrancePink31")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void pink32Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entrancePink32")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void pink33Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entrancePink33")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void pink34Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entrancePink34")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void pink35Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entrancePink35")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void pink36Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entrancePink36")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void pink37Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entrancePink37")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void pink38Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entrancePink38")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void blue30Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceBlue30")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void blue31Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceBlue31")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void blue32Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceBlue32")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void blue33Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceBlue33")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void blue34Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceBlue34")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void blue35Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceBlue35")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void blue36Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceBlue36")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void blue37Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceBlue37")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void blue38Select(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("entranceBlue38")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    //alcune carte permettono di togliere delle pedine dalla dining
    //una volta selezionata la pedina sulla dining
    //diventa invisibile e non selezionabile
    //da qui in giu uguale
    public void selectSchoolGreen30(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Green0")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void selectSchoolGreen31(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Green1")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen32(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Green2")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen33(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Green3")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen34(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Green4")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen35(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Green5")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen36(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Green6")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen37(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Green7")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen38(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Green8")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen39(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Green9")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void selectSchoolRed30(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Red0")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolRed31(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Red1")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolRed32(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Red2")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolRed33(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Red3")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolRed34(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Red4")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolRed35(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Red5")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolRed36(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Red6")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolRed37(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Red7")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolRed38(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Red8")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolRed39(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Red9")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void selectSchoolYellow30(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Yellow0")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow31(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Yellow1")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow32(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Yellow2")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow33(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Yellow3")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow34(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Yellow4")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow35(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Yellow5")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow36(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Yellow6")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow37(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Yellow7")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow38(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Yellow8")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow39(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Yellow9")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void selectSchoolPink30(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Pink0")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolPink31(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Pink1")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolPink32(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Pink2")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolPink33(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Pink3")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolPink34(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Pink4")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolPink35(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Pink5")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolPink36(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Pink6")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolPink37(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Pink7")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolPink38(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Pink8")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolPink39(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Pink9")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }

    public void selectSchoolBlue30(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Blue0")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue31(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Blue1")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue32(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Blue2")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue33(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Blue3")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue34(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Blue4")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue35(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Blue5")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue36(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Blue6")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue37(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Blue7")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue38(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Blue8")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue39(MouseEvent mouseEvent) {
        for(Node schoolBoard3 : schoolBoard3.getChildren()) {
            if (schoolBoard3.getId().equals("schoolBoard3Blue9")){
                schoolBoard3.setVisible(false);
                schoolBoard3.setDisable(true);
            }
        }
    }
}