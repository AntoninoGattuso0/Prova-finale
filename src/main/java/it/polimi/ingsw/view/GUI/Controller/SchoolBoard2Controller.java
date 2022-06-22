package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SchoolBoard2Controller {
    Gui gui;
    LightGame lightGame;//da qualche parte ha bisogno di ricevere lightGame

    public void setGui(Gui gui){
        this.gui=gui;
        this.lightGame = gui.getLightGame();
    }

    @FXML Pane schoolBoard2;

    public Pane getSchoolBoard2(){return schoolBoard2;}

    public void setSchoolBoard2(){
        setAllInvisible();
        setEntrance2();
        setDiningRoom2();
        setTower2();
        setCoin2();
    }

    public void setAllInvisible(){
        for(Node all : schoolBoard2.getChildren()) {
            all.setVisible(false);
            all.setDisable(true);
            if(all.getId().equals("backSchool2"))
                all.setVisible(true);
        }
    }


    public void setEntrance2Clickable(){
        setEntrance2();
        int green = lightGame.getPlayers().get(2).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard2.getChildren()){
                if(school.getId().equals("entranceGreen2" + i))
                    school.setDisable(false);
            }
        }

        int red = lightGame.getPlayers().get(2).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("entranceRed2" + i))
                    school.setDisable(false);
            }
        }
        int yellow = lightGame.getPlayers().get(2).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("entranceYellow2" + i))
                    school.setDisable(false);
            }
        }
        int pink = lightGame.getPlayers().get(2).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("entrancePink2" + i))
                    school.setDisable(false);
            }
        }
        int blue = lightGame.getPlayers().get(2).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("entranceBlue2" + i))
                    school.setDisable(false);
            }
        }
    }


    public void setEntrance2(){
        int green = lightGame.getPlayers().get(2).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard2.getChildren()){
                if(school.getId().equals("entranceGreen2" + i))
                    school.setVisible(true);
            }
        }

        int red = lightGame.getPlayers().get(2).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("entranceRed2" + i))
                    school.setVisible(true);
            }
        }
        int yellow = lightGame.getPlayers().get(2).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("entranceYellow2" + i))
                    school.setVisible(true);
            }
        }
        int pink = lightGame.getPlayers().get(2).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("entrancePink2" + i))
                    school.setVisible(true);
            }
        }
        int blue = lightGame.getPlayers().get(2).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("entranceBlue2" + i))
                    school.setVisible(true);
            }
        }
    }

    //le 5 funzioni qui sotto mettono visibile/ non visibili le pedine che passiamo con numColore
    public void greenEntrance2(boolean boolVisibility, boolean boolClickable, int numGreen){
        for(Node school : schoolBoard2.getChildren()){
            if(school.getId().equals("entranceGreen2" + numGreen)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }

    public void redEntrance2(boolean boolVisibility, boolean boolClickable, int numRed){
        for(Node school : schoolBoard2.getChildren()){
            if(school.getId().equals("entranceRed2" + numRed)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void yellowEntrance2(boolean boolVisibility, boolean boolClickable, int numYellow){
        for(Node school : schoolBoard2.getChildren()){
            if(school.getId().equals("entranceYellow2" + numYellow)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void pinkVEntrance2(boolean boolVisibility, boolean boolClickable, int numPink){
        for(Node school : schoolBoard2.getChildren()){
            if(school.getId().equals("entrancePink2" + numPink)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void blueEntrance2(boolean boolVisibility, boolean boolClickable, int numBlue){
        for(Node school : schoolBoard2.getChildren()){
            if(school.getId().equals("entranceBlue2" + numBlue)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }

    public void setDiningRoom2(){
        int green = lightGame.getPlayers().get(2).getDiningRoom().getNumGreen();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("schoolBoard2Green" + i))
                    school.setVisible(true);
            }
        }
        int red = lightGame.getPlayers().get(2).getDiningRoom().getNumRed();
        for(int i=0; i<red; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("schoolBoard2Red" + i))
                    school.setVisible(true);
            }
        }
        int yellow = lightGame.getPlayers().get(2).getDiningRoom().getNumYellow();
        for(int i=0; i<yellow; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("schoolBoard2Yellow" + i))
                    school.setVisible(true);
            }
        }
        int pink = lightGame.getPlayers().get(2).getDiningRoom().getNumPink();
        for(int i=0; i<pink; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("schoolBoard2Pink" + i))
                    school.setVisible(true);
            }
        }
        int blue = lightGame.getPlayers().get(2).getDiningRoom().getNumBlue();
        for(int i=0; i<blue; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("schoolBoard2Blue" + i))
                    school.setVisible(true);
            }
        }
    }
    //le 5 funzioni qui sotto mettono visibile/ non visibili le pedine delle dining che passiamo con num
    public void greenDining2(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard2.getChildren()) {
            if (school.getId().equals("schoolBoard2Green" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void redDining2(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard2.getChildren()) {
            if (school.getId().equals("schoolBoard2Red" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void yellowDining2(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard2.getChildren()) {
            if (school.getId().equals("schoolBoard2Yellow" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void pinkDining2(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard2.getChildren()) {
            if (school.getId().equals("schoolBoard2Pink" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void blueVDining2(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard2.getChildren()) {
            if (school.getId().equals("schoolBoard2Blue" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }

    public void setProfessor2(){
        if(lightGame.getProfTable().getGreenProf() == 2)
            schoolBoard2.lookup("schoolGreenProf2").setVisible(true);
        if(lightGame.getProfTable().getRedProf() == 2)
            schoolBoard2.lookup("schoolRedProf2").setVisible(true);
        if(lightGame.getProfTable().getYellowProf() == 2)
            schoolBoard2.lookup("schoolYellowProf2").setVisible(true);
        if(lightGame.getProfTable().getPinkProf() == 2)
            schoolBoard2.lookup("schoolPinkProf2").setVisible(true);
        if(lightGame.getProfTable().getBlueProf() == 2)
            schoolBoard2.lookup("schoolBlueProf2").setVisible(true);
    }

    public void setTower2(){
        for(int i = 0; i<lightGame.getPlayers().get(2).getTowerSpace().getNumTower(); i++)
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("greyTowerSchool" + i))
                    school.setVisible(true);
            }
    }

    public void towerVisibility2(boolean bool, int numTower){
        for(Node school : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("greyTowerSchool" + numTower))
                school.setVisible(bool);
        }
    }

    public void setCoin2() {
        for (int i = 0; i < lightGame.getPlayers().get(2).getNumCoin(); i++)
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("coin" + i))
                    school.setVisible(true);
            }
    }

    public void coinVisibility2(boolean bool, int numCoin){
        for(Node school : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("coin" + numCoin))
                school.setVisible(bool);
        }
    }


    public void green20Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceGreen20"))
                schoolBoard2.setVisible(true);
            schoolBoard2.setDisable(true);
        }
    }

    public void green21Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceGreen21")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void green22Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceGreen22")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void green23Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceGreen23")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void green24Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceGreen24")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void green25Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceGreen25")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void green26Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceGreen26")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void green27Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceGreen27")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void green28Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceGreen28")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void red20Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceRed20")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void red21Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceRed21")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void red22Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceRed22")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void red23Select(MouseEvent mouseEvent) {

        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceRed23")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void red24Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceRed24")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void red25Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceRed25")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void red26Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceRed26")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void red27Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceRed27")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void red28Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceRed28")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void yellow20Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceYellow20")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void yellow21Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceYellow21")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void yellow22Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceYellow22")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void yellow23Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceYellow23")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void yellow24Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceYellow24")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void yellow25Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceYellow25")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void yellow26Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceYellow26")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void yellow27Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceYellow27")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void yellow28Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceYellow28")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void pink20Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entrancePink20")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void pink21Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entrancePink21")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void pink22Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entrancePink22")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void pink23Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entrancePink23")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void pink24Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entrancePink24")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void pink25Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entrancePink25")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void pink26Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entrancePink26")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void pink27Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entrancePink27")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void pink28Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entrancePink28")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void blue20Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceBlue20")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void blue21Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceBlue21")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void blue22Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceBlue22")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void blue23Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceBlue23")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void blue24Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceBlue24")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void blue25Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceBlue25")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void blue26Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceBlue26")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void blue27Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceBlue27")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void blue28Select(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("entranceBlue28")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    //alcune carte permettono di togliere delle pedine dalla dining
    //una volta selezionata la pedina sulla dining
    //diventa invisibile e non selezionabile
    //da qui in giu uguale
    public void selectSchoolGreen20(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Green0")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void selectSchoolGreen21(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Green1")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen22(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Green2")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen23(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Green3")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen24(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Green4")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen25(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Green5")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen26(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Green6")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen27(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Green7")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen28(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Green8")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen29(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Green9")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void selectSchoolRed20(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Red0")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolRed21(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Red1")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolRed22(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Red2")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolRed23(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Red3")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolRed24(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Red4")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolRed25(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Red5")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolRed26(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Red6")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolRed27(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Red7")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolRed28(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Red8")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolRed29(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Red9")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void selectSchoolYellow20(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Yellow0")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow21(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Yellow1")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow22(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Yellow2")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow23(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Yellow3")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow24(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Yellow4")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow25(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Yellow5")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow26(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Yellow6")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow27(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Yellow7")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow28(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Yellow8")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow29(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Yellow9")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void selectSchoolPink20(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Pink0")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolPink21(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Pink1")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolPink22(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Pink2")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolPink23(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Pink3")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolPink24(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Pink4")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolPink25(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Pink5")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolPink26(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Pink6")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolPink27(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Pink7")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolPink28(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Pink8")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolPink29(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Pink9")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }

    public void selectSchoolBlue20(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Blue0")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue21(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Blue1")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue22(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Blue2")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue23(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Blue3")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue24(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Blue4")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue25(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Blue5")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue26(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Blue6")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue27(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Blue7")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue28(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Blue8")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue29(MouseEvent mouseEvent) {
        for(Node schoolBoard2 : schoolBoard2.getChildren()) {
            if (schoolBoard2.getId().equals("schoolBoard2Blue9")){
                schoolBoard2.setVisible(false);
                schoolBoard2.setDisable(true);
            }
        }
    }
}