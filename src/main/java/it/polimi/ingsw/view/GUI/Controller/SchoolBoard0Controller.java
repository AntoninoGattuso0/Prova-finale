package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SchoolBoard0Controller {
    Gui gui;
    LightGame lightGame;

    public void setGui(Gui gui){this.gui=gui;
    this.lightGame = gui.getLightGame();}

    @FXML Pane schoolBoard0;

    public Pane getSchoolBoard0(){return schoolBoard0;}

    public void setSchoolBoard0(){
        setAllInvisible();
        setEntrance0();
        setDiningRoom0();
        setTower0();
        setCoin0();
    }

    //mette tutto invibile tranne lo sfondo
    public void setAllInvisible(){
        for(Node all : schoolBoard0.getChildren()) {
            all.setVisible(false);
            all.setDisable(true);
            if(all.getId().equals("backSchool0"))
                all.setVisible(true);
        }
    }

    //rende le pedine non cliccabili all'inizio
    public void setEntrance0Clickable(){
        setEntrance0();
        int green = lightGame.getPlayers().get(0).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard0.getChildren()){
                if(school.getId().equals("entranceGreen0" + i))
                    school.setDisable(false);
            }
        }

        int red = lightGame.getPlayers().get(0).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("entranceRed0" + i))
                    school.setDisable(false);
            }
        }
        int yellow = lightGame.getPlayers().get(0).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("entranceYellow0" + i))
                    school.setDisable(false);
            }
        }
        int pink = lightGame.getPlayers().get(0).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("entrancePink0" + i))
                    school.setDisable(false);
            }
        }
        int blue = lightGame.getPlayers().get(0).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("entranceBlue0" + i))
                    school.setDisable(false);
            }
        }
    }

    //setta le pedine dell'entrata visibili all'inizio del gioco
    public void setEntrance0(){
        int green = lightGame.getPlayers().get(0).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard0.getChildren()){
                if(school.getId().equals("entranceGreen0" + i))
                    school.setVisible(true);
            }
        }

        int red = lightGame.getPlayers().get(0).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("entranceRed0" + i))
                    school.setVisible(true);
            }
        }
        int yellow = lightGame.getPlayers().get(0).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("entranceYellow0" + i))
                    school.setVisible(true);
            }
        }
        int pink = lightGame.getPlayers().get(0).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("entrancePink0" + i))
                    school.setVisible(true);
            }
        }
        int blue = lightGame.getPlayers().get(0).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("entranceBlue0" + i))
                    school.setVisible(true);
            }
        }
    }

    //le 5 funzioni qui sotto mettono visibile/ non visibili/clickabili...  le pedine che passiamo con numColore
    public void greenEntrance0(boolean boolVisibility, boolean boolClickable, int numGreen){
        for(Node school : schoolBoard0.getChildren()){
            if(school.getId().equals("entranceGreen0" + numGreen)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }

    public void redEntrance0(boolean boolVisibility, boolean boolClickable, int numRed){
        for(Node school : schoolBoard0.getChildren()){
            if(school.getId().equals("entranceRed0" + numRed)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void yellowEntrance0(boolean boolVisibility, boolean boolClickable, int numYellow){
        for(Node school : schoolBoard0.getChildren()){
            if(school.getId().equals("entranceYellow0" + numYellow)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void pinkEntrance0(boolean boolVisibility, boolean boolClickable, int numPink){
        for(Node school : schoolBoard0.getChildren()){
            if(school.getId().equals("entrancePink0" + numPink)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void blueEntrance0(boolean boolVisibility, boolean boolClickable, int numBlue){
        for(Node school : schoolBoard0.getChildren()){
            if(school.getId().equals("entranceBlue0" + numBlue)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }


    public void setDiningRoom0(){
        int green = lightGame.getPlayers().get(0).getDiningRoom().getNumGreen();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolBoard0Green" + i))
                    school.setVisible(true);
            }
        }
        int red = lightGame.getPlayers().get(0).getDiningRoom().getNumRed();
        for(int i=0; i<red; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolBoard0Red" + i))
                    school.setVisible(true);
            }
        }
        int yellow = lightGame.getPlayers().get(0).getDiningRoom().getNumYellow();
        for(int i=0; i<yellow; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolBoard0Yellow" + i))
                    school.setVisible(true);
            }
        }
        int pink = lightGame.getPlayers().get(0).getDiningRoom().getNumPink();
        for(int i=0; i<pink; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolBoard0Pink" + i))
                    school.setVisible(true);
            }
        }
        int blue = lightGame.getPlayers().get(0).getDiningRoom().getNumBlue();
        for(int i=0; i<blue; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolBoard0Blue" + i))
                    school.setVisible(true);
            }
        }
    }

    //le 5 funzioni qui sotto mettono visibile/ non visibili le pedine delle dining che passiamo con num

    public void greenDining0(boolean boolVisibility, boolean boolClickable, int num){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolBoard0Green" + num)){
                    school.setVisible(boolVisibility);
                    school.setDisable(boolClickable);
                }
            }
    }
    public void redDining0(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard0.getChildren()) {
            if (school.getId().equals("schoolBoard0Red" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void yellowDining0(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard0.getChildren()) {
            if (school.getId().equals("schoolBoard0Yellow" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void pinkDining0(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard0.getChildren()) {
            if (school.getId().equals("schoolBoard0Pink" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void blueDining0(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard0.getChildren()) {
            if (school.getId().equals("schoolBoard0Blue" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }

//questo devo rivederlo
    public void setProfessor0(){
        if(lightGame.getProfTable().getGreenProf() == 0){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolGreenProf0"))
                    school.setVisible(true);
            }
        }
        if(lightGame.getProfTable().getRedProf() == 0){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolRedProf0"))
                    school.setVisible(true);
            }
        }

        if(lightGame.getProfTable().getYellowProf() == 0){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolYellowProf0"))
                    school.setVisible(true);
            }
        }

        if(lightGame.getProfTable().getPinkProf() == 0){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolPinkProf0"))
                    school.setVisible(true);
            }
        }

        if(lightGame.getProfTable().getBlueProf() == 0){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolBlueProf0"))
                    school.setVisible(true);
            }
        }
    }



    public void setTower0(){
        for(int i = 0; i<lightGame.getPlayers().get(0).getTowerSpace().getNumTower(); i++)
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("blackTowerSchool" + i))
                    school.setVisible(true);
            }
    }

    //ho aggiunto questa funzione che è particamente identica a quella sopea
    //al  massimo se non servono entrambe cancelliamo questa sotto
    // e a quella sopra passiamo come paramtri bool e numTower
    //stessa cosa anche per le coin
    public void towerVisibility0(boolean bool, int numTower){
        for(Node school : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("blackTowerSchool" + numTower))
                school.setVisible(bool);
        }
    }

    //setta all'inizio solo la prima coin visibile
    public void setCoin0() {
        for (int i = 0; i < lightGame.getPlayers().get(0).getNumCoin(); i++)
            for(Node schoolBoard0 : schoolBoard0.getChildren()) {
                if (schoolBoard0.getId().equals("coin" + i))
                    schoolBoard0.setVisible(true);
            }
    }


    public void coinVisibility0(boolean bool, int numCoin){
        for(Node school : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("coin" + numCoin))
                school.setVisible(bool);
        }
    }



    public void green00Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceGreen00"))
                schoolBoard0.setVisible(true);
                schoolBoard0.setDisable(true);
        }
    }

    public void green01Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceGreen01")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void green02Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceGreen02")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void green03Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceGreen03")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void green04Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceGreen04")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void green05Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceGreen05")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void green06Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceGreen06")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void green07Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceGreen07")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void green08Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceGreen08")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void red00Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceRed00")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void red01Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceRed01")){
            schoolBoard0.setVisible(false);
            schoolBoard0.setDisable(true);
            }
        }
    }

    public void red02Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceRed02")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void red03Select(MouseEvent mouseEvent) {

        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceRed03")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void red04Select(MouseEvent mouseEvent) {
         for(Node schoolBoard0 : schoolBoard0.getChildren()) {
             if (schoolBoard0.getId().equals("entranceRed04")){
                 schoolBoard0.setVisible(false);
                 schoolBoard0.setDisable(true);
             }
        }
    }

    public void red05Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceRed05")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void red06Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceRed06")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void red07Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceRed07")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void red08Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceRed08")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void yellow00Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceYellow00")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void yellow01Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceYellow01")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void yellow02Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceYellow02")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void yellow03Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceYellow03")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void yellow04Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceYellow04")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void yellow05Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceYellow05")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void yellow06Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceYellow06")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void yellow07Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceYellow07")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void yellow08Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceYellow08")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void pink00Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entrancePink00")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void pink01Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entrancePink01")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void pink02Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entrancePink02")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void pink03Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entrancePink03")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void pink04Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entrancePink04")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void pink05Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entrancePink05")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void pink06Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entrancePink06")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void pink07Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entrancePink07")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void pink08Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entrancePink08")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void blue00Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceBlue00")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void blue01Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceBlue01")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void blue02Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceBlue02")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void blue03Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceBlue03")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void blue04Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceBlue04")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void blue05Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceBlue05")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void blue06Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceBlue06")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void blue07Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceBlue07")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void blue08Select(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("entranceBlue08")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void selectSchoolGreen00(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Green0")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void selectSchoolGreen01(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Green1")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen02(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Green2")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen03(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Green3")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen04(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Green4")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen05(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Green5")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen06(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Green6")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen07(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Green7")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen08(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Green8")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolGreen09(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Green9")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void selectSchoolRed00(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Red0")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolRed01(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Red1")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolRed02(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Red2")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolRed03(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Red3")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolRed04(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Red4")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolRed05(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Red5")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolRed06(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Red6")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolRed07(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Red7")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolRed08(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Red8")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolRed09(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Red9")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void selectSchoolYellow00(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Yellow0")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow01(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Yellow1")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow02(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Yellow2")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow03(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Yellow3")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow04(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Yellow4")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow05(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Yellow5")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow06(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Yellow6")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow07(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Yellow7")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow08(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Yellow8")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolYellow09(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Yellow9")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void selectSchoolPink00(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Pink0")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolPink01(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Pink1")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolPink02(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Pink2")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolPink03(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Pink3")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolPink04(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Pink4")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolPink05(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Pink5")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolPink06(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Pink6")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolPink07(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Pink7")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolPink08(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Pink8")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolPink09(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Pink9")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

    public void selectSchoolBlue00(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Blue0")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue01(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Blue1")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue02(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Blue2")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue03(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Blue3")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue04(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Blue4")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue05(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Blue5")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue06(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Blue6")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue07(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Blue7")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue08(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Blue8")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }
    public void selectSchoolBlue09(MouseEvent mouseEvent) {
        for(Node schoolBoard0 : schoolBoard0.getChildren()) {
            if (schoolBoard0.getId().equals("schoolBoard0Blue9")){
                schoolBoard0.setVisible(false);
                schoolBoard0.setDisable(true);
            }
        }
    }

}