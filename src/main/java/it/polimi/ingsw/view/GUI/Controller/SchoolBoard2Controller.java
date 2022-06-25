package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.network.Message.ClientToServer.MovePawnToDiningMessage;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SchoolBoard2Controller {
    Gui gui;

    public void setGui(Gui gui){
        this.gui=gui;
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
        int green = gui.getLightGame().getPlayers().get(2).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard2.getChildren()){
                if(school.getId().equals("entranceGreen2" + i))
                    school.setDisable(false);
            }
        }

        int red = gui.getLightGame().getPlayers().get(2).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("entranceRed2" + i))
                    school.setDisable(false);
            }
        }
        int yellow = gui.getLightGame().getPlayers().get(2).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("entranceYellow2" + i))
                    school.setDisable(false);
            }
        }
        int pink = gui.getLightGame().getPlayers().get(2).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("entrancePink2" + i))
                    school.setDisable(false);
            }
        }
        int blue = gui.getLightGame().getPlayers().get(2).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("entranceBlue2" + i))
                    school.setDisable(false);
            }
        }
    }


    public void setEntrance2(){
        int green = gui.getLightGame().getPlayers().get(2).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard2.getChildren()){
                if(school.getId().equals("entranceGreen2" + i))
                    school.setVisible(true);
            }
        }

        int red = gui.getLightGame().getPlayers().get(2).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("entranceRed2" + i))
                    school.setVisible(true);
            }
        }
        int yellow = gui.getLightGame().getPlayers().get(2).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("entranceYellow2" + i))
                    school.setVisible(true);
            }
        }
        int pink = gui.getLightGame().getPlayers().get(2).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("entrancePink2" + i))
                    school.setVisible(true);
            }
        }
        int blue = gui.getLightGame().getPlayers().get(2).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("entranceBlue2" + i))
                    school.setVisible(true);
            }
        }
    }

    //le 5 funzioni qui sotto mettono visibile/ non visibili le pedine che passiamo con numColore
    public void greenEntrance2(boolean boolVisibility, boolean boolClickable, int numGreen){
        schoolBoard2.lookup("#entranceGreen2"+ numGreen).setVisible(boolVisibility);
        schoolBoard2.lookup("#entranceGreen2"+ numGreen).setDisable(boolClickable);
    }

    public void redEntrance2(boolean boolVisibility, boolean boolClickable, int numRed){
        schoolBoard2.lookup("#entranceRed2"+ numRed).setVisible(boolVisibility);
        schoolBoard2.lookup("#entranceRed2"+ numRed).setDisable(boolClickable);
    }
    public void yellowEntrance2(boolean boolVisibility, boolean boolClickable, int numYellow){
        schoolBoard2.lookup("#entranceYellow2"+ numYellow).setVisible(boolVisibility);
        schoolBoard2.lookup("#entranceYellow2"+ numYellow).setDisable(boolClickable);
    }
    public void pinkEntrance2(boolean boolVisibility, boolean boolClickable, int numPink){
        schoolBoard2.lookup("#entrancePink2"+ numPink).setVisible(boolVisibility);
        schoolBoard2.lookup("#entrancePink2"+ numPink).setDisable(boolClickable);
    }
    public void blueEntrance2(boolean boolVisibility, boolean boolClickable, int numBlue){
        schoolBoard2.lookup("#entranceBlue2"+ numBlue).setVisible(boolVisibility);
        schoolBoard2.lookup("#entranceBlue2"+ numBlue).setDisable(boolClickable);
    }

    public void setDiningRoom2(){
        int green = gui.getLightGame().getPlayers().get(2).getDiningRoom().getNumGreen();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("schoolBoard2Green" + i))
                    school.setVisible(true);
            }
        }
        int red = gui.getLightGame().getPlayers().get(2).getDiningRoom().getNumRed();
        for(int i=0; i<red; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("schoolBoard2Red" + i))
                    school.setVisible(true);
            }
        }
        int yellow = gui.getLightGame().getPlayers().get(2).getDiningRoom().getNumYellow();
        for(int i=0; i<yellow; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("schoolBoard2Yellow" + i))
                    school.setVisible(true);
            }
        }
        int pink = gui.getLightGame().getPlayers().get(2).getDiningRoom().getNumPink();
        for(int i=0; i<pink; i++){
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("schoolBoard2Pink" + i))
                    school.setVisible(true);
            }
        }
        int blue = gui.getLightGame().getPlayers().get(2).getDiningRoom().getNumBlue();
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
        if(gui.getLightGame().getProfTable().getGreenProf() == 2)
            schoolBoard2.lookup("schoolGreenProf2").setVisible(true);
        if(gui.getLightGame().getProfTable().getRedProf() == 2)
            schoolBoard2.lookup("schoolRedProf2").setVisible(true);
        if(gui.getLightGame().getProfTable().getYellowProf() == 2)
            schoolBoard2.lookup("schoolYellowProf2").setVisible(true);
        if(gui.getLightGame().getProfTable().getPinkProf() == 2)
            schoolBoard2.lookup("schoolPinkProf2").setVisible(true);
        if(gui.getLightGame().getProfTable().getBlueProf() == 2)
            schoolBoard2.lookup("schoolBlueProf2").setVisible(true);
    }

    public void setTower2(){
        for(int i = 0; i<gui.getLightGame().getPlayers().get(2).getTowerSpace().getNumTower(); i++)
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
        for (int i = 0; i < gui.getLightGame().getPlayers().get(2).getNumCoin(); i++)
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
        schoolBoard2.lookup("#entranceGreen20").setVisible(false);
        schoolBoard2.lookup("#entranceGreen20").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green21Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceGreen21").setVisible(false);
        schoolBoard2.lookup("#entranceGreen21").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green22Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceGreen22").setVisible(false);
        schoolBoard2.lookup("#entranceGreen22").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green23Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceGreen23").setVisible(false);
        schoolBoard2.lookup("#entranceGreen23").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green24Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceGreen24").setVisible(false);
        schoolBoard2.lookup("#entranceGreen24").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green25Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceGreen25").setVisible(false);
        schoolBoard2.lookup("#entranceGreen25").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green26Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceGreen26").setVisible(false);
        schoolBoard2.lookup("#entranceGreen26").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green27Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceGreen27").setVisible(false);
        schoolBoard2.lookup("#entranceGreen27").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green28Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceGreen28").setVisible(false);
        schoolBoard2.lookup("#entranceGreen28").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void red20Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceRed20").setVisible(false);
        schoolBoard2.lookup("#entranceRed20").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red21Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceRed21").setVisible(false);
        schoolBoard2.lookup("#entranceRed21").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red22Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceRed22").setVisible(false);
        schoolBoard2.lookup("#entranceRed22").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red23Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceRed23").setVisible(false);
        schoolBoard2.lookup("#entranceRed23").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red24Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceRed24").setVisible(false);
        schoolBoard2.lookup("#entranceRed24").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red25Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceRed25").setVisible(false);
        schoolBoard2.lookup("#entranceRed25").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red26Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceRed26").setVisible(false);
        schoolBoard2.lookup("#entranceRed26").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red27Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceRed27").setVisible(false);
        schoolBoard2.lookup("#entranceRed27").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red28Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceRed28").setVisible(false);
        schoolBoard2.lookup("#entranceRed28").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void yellow20Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceYellow20").setVisible(false);
        schoolBoard2.lookup("#entranceYellow20").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow21Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceYellow21").setVisible(false);
        schoolBoard2.lookup("#entranceYellow21").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow22Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceYellow22").setVisible(false);
        schoolBoard2.lookup("#entranceYellow22").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow23Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceYellow23").setVisible(false);
        schoolBoard2.lookup("#entranceYellow23").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        selection();
    }

    public void yellow24Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceYellow24").setVisible(false);
        schoolBoard2.lookup("#entranceYellow24").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow25Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceYellow25").setVisible(false);
        schoolBoard2.lookup("#entranceYellow25").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow26Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceYellow26").setVisible(false);
        schoolBoard2.lookup("#entranceYellow26").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow27Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceYellow27").setVisible(false);
        schoolBoard2.lookup("#entranceYellow27").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow28Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceYellow28").setVisible(false);
        schoolBoard2.lookup("#entranceYellow28").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void pink20Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entrancePink20").setVisible(false);
        schoolBoard2.lookup("#entrancePink20").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        selection();
    }

    public void pink21Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entrancePink21").setVisible(false);
        schoolBoard2.lookup("#entrancePink21").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink22Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entrancePink22").setVisible(false);
        schoolBoard2.lookup("#entrancePink22").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink23Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entrancePink23").setVisible(false);
        schoolBoard2.lookup("#entrancePink23").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink24Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entrancePink24").setVisible(false);
        schoolBoard2.lookup("#entrancePink24").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        selection();
    }

    public void pink25Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entrancePink25").setVisible(false);
        schoolBoard2.lookup("#entrancePink25").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink26Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entrancePink26").setVisible(false);
        schoolBoard2.lookup("#entrancePink26").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink27Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entrancePink27").setVisible(false);
        schoolBoard2.lookup("#entrancePink27").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink28Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entrancePink28").setVisible(false);
        schoolBoard2.lookup("#entrancePink28").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        selection();
    }

    public void blue20Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceBlue20").setVisible(false);
        schoolBoard2.lookup("#entranceBlue20").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue21Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceBlue21").setVisible(false);
        schoolBoard2.lookup("#entranceBlue21").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        selection();
    }

    public void blue22Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceBlue22").setVisible(false);
        schoolBoard2.lookup("#entranceBlue22").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue23Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceBlue23").setVisible(false);
        schoolBoard2.lookup("#entranceBlue23").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue24Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceBlue24").setVisible(false);
        schoolBoard2.lookup("#entranceBlue24").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        selection();
    }

    public void blue25Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceBlue25").setVisible(false);
        schoolBoard2.lookup("#entranceBlue25").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue26Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceBlue26").setVisible(false);
        schoolBoard2.lookup("#entranceBlue26").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue27Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceBlue27").setVisible(false);
        schoolBoard2.lookup("#entranceBlue27").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue28Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#entranceBlue28").setVisible(false);
        schoolBoard2.lookup("#entranceBlue28").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }


    public void selectSchoolGreen20(MouseEvent mouseEvent) {
        schoolBoard2.lookup("##schoolBoard2Green0").setVisible(false);
        schoolBoard2.lookup("##schoolBoard2Green0").setDisable(true);
    }

    public void selectSchoolGreen21(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Green1").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Green1").setDisable(true);
    }
    public void selectSchoolGreen22(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Green2").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Green2").setDisable(true);
    }
    public void selectSchoolGreen23(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Green3").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Green3").setDisable(true);
    }
    public void selectSchoolGreen24(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Green4").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Green4").setDisable(true);
    }
    public void selectSchoolGreen25(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Green5").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Green5").setDisable(true);
    }
    public void selectSchoolGreen26(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Green6").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Green6").setDisable(true);
    }
    public void selectSchoolGreen27(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Green7").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Green7").setDisable(true);
    }
    public void selectSchoolGreen28(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Green8").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Green8").setDisable(true);
    }
    public void selectSchoolGreen29(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Green9").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Green9").setDisable(true);
    }

    public void selectSchoolRed20(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Red0").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Red0").setDisable(true);
    }
    public void selectSchoolRed21(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Red1").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Red1").setDisable(true);
    }
    public void selectSchoolRed22(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Red2").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Red2").setDisable(true);
    }
    public void selectSchoolRed23(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Red3").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Red3").setDisable(true);
    }
    public void selectSchoolRed24(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Red4").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Red4").setDisable(true);
    }
    public void selectSchoolRed25(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Red5").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Red5").setDisable(true);
    }
    public void selectSchoolRed26(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Red6").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Red6").setDisable(true);
    }
    public void selectSchoolRed27(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Red7").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Red7").setDisable(true);
    }
    public void selectSchoolRed28(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Red8").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Red8").setDisable(true);
    }
    public void selectSchoolRed29(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Red9").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Red9").setDisable(true);
    }

    public void selectSchoolYellow20(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Yellow0").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Yellow0").setDisable(true);
    }
    public void selectSchoolYellow21(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Yellow1").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Yellow1").setDisable(true);
    }
    public void selectSchoolYellow22(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Yellow2").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Yellow2").setDisable(true);
    }
    public void selectSchoolYellow23(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Yellow3").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Yellow3").setDisable(true);
    }
    public void selectSchoolYellow24(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Yellow4").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Yellow4").setDisable(true);
    }
    public void selectSchoolYellow25(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Yellow5").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Yellow5").setDisable(true);
    }
    public void selectSchoolYellow26(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Yellow6").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Yellow6").setDisable(true);
    }
    public void selectSchoolYellow27(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Yellow7").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Yellow7").setDisable(true);
    }
    public void selectSchoolYellow28(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Yellow8").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Yellow8").setDisable(true);
    }
    public void selectSchoolYellow29(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Yellow9").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Yellow9").setDisable(true);
    }

    public void selectSchoolPink20(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Pink0").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Pink0").setDisable(true);
    }
    public void selectSchoolPink21(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Pink1").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Pink1").setDisable(true);
    }
    public void selectSchoolPink22(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Pink2").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Pink2").setDisable(true);
    }
    public void selectSchoolPink23(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Pink3").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Pink3").setDisable(true);
    }
    public void selectSchoolPink24(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Pink4").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Pink4").setDisable(true);
    }
    public void selectSchoolPink25(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Pink5").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Pink5").setDisable(true);
    }
    public void selectSchoolPink26(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Pink6").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Pink6").setDisable(true);
    }
    public void selectSchoolPink27(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Pink7").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Pink7").setDisable(true);
    }
    public void selectSchoolPink28(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Pink8").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Pink8").setDisable(true);
    }
    public void selectSchoolPink29(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Pink9").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Pink9").setDisable(true);
    }

    public void selectSchoolBlue20(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Blue0").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Blue0").setDisable(true);
    }
    public void selectSchoolBlue21(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Blue1").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Blue1").setDisable(true);
    }
    public void selectSchoolBlue22(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Blue2").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Blue2").setDisable(true);
    }
    public void selectSchoolBlue23(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Blue3").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Blue3").setDisable(true);
    }
    public void selectSchoolBlue24(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Blue4").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Blue4").setDisable(true);
    }
    public void selectSchoolBlue25(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Blue5").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Blue5").setDisable(true);
    }
    public void selectSchoolBlue26(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Blue6").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Blue6").setDisable(true);
    }
    public void selectSchoolBlue27(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Blue7").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Blue7").setDisable(true);
    }
    public void selectSchoolBlue28(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Blue8").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Blue8").setDisable(true);
    }
    public void selectSchoolBlue29(MouseEvent mouseEvent) {
        schoolBoard2.lookup("#schoolBoard2Blue9").setVisible(false);
        schoolBoard2.lookup("#schoolBoard2Blue9").setDisable(true);
    }

    public void selection(){
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            for(int i=0; i<gui.getLightGame().getIslands().size(); i++)
                gui.getGameTable().getGameTablePane().lookup("#island"+ i).setDisable(false);
            if(gui.getNumPawnsCount()==0)
                for(Node school : schoolBoard2.getChildren())
                    school.setDisable(true);
        }else if(gui.getButtonClicked().equals(ButtonAction.DININGROOM)){
            if(gui.getNumPawnsCount()==0){
                for(Node school : schoolBoard2.getChildren()){
                    school.setDisable(true);
                }
                gui.getSocketNetworkHandler().sendMessage(new MovePawnToDiningMessage(gui.getNumPawns(), gui.getColorPawns()));
                gui.getColorPawns().clear();
                gui.getSchoolBoard2Controller().setDiningRoom2();
                gui.getGameTable().getShowSchool2().setCenter(gui.getSchoolBoard2Controller().getSchoolBoard2());
                gui.getGameTable().getShowSchool2().setVisible(true);
                gui.setPedineDaSpostare(gui.getPedineDaSpostare()- gui.getNumPawns());
            }
        }
    }
}