package it.polimi.ingsw.view.GUI.Controller;
import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.network.Message.ClientToServer.MovePawnToDiningMessage;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SchoolBoard3Controller {
    Gui gui;

    public void setGui(Gui gui){
        this.gui=gui;
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
        int green = gui.getLightGame().getPlayers().get(3).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard3.getChildren()){
                if(school.getId().equals("entranceGreen3" + i))
                    school.setDisable(false);
            }
        }

        int red = gui.getLightGame().getPlayers().get(3).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("entranceRed3" + i))
                    school.setDisable(false);
            }
        }
        int yellow = gui.getLightGame().getPlayers().get(3).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("entranceYellow3" + i))
                    school.setDisable(false);
            }
        }
        int pink = gui.getLightGame().getPlayers().get(3).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("entrancePink3" + i))
                    school.setDisable(false);
            }
        }
        int blue = gui.getLightGame().getPlayers().get(3).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("entranceBlue3" + i))
                    school.setDisable(false);
            }
        }
    }


    public void setEntrance3(){
        int green = gui.getLightGame().getPlayers().get(3).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard3.getChildren()){
                if(school.getId().equals("entranceGreen3" + i))
                    school.setVisible(true);
            }
        }

        int red = gui.getLightGame().getPlayers().get(3).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("entranceRed3" + i))
                    school.setVisible(true);
            }
        }
        int yellow = gui.getLightGame().getPlayers().get(3).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("entranceYellow3" + i))
                    school.setVisible(true);
            }
        }
        int pink = gui.getLightGame().getPlayers().get(3).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("entrancePink3" + i))
                    school.setVisible(true);
            }
        }
        int blue = gui.getLightGame().getPlayers().get(3).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("entranceBlue3" + i))
                    school.setVisible(true);
            }
        }
    }

    //le 5 funzioni qui sotto mettono visibile/ non visibili le pedine che passiamo con numColore
    public void greenEntrance3(boolean boolVisibility, boolean boolClickable, int numGreen){
        schoolBoard3.lookup("#entranceGreen3"+ numGreen).setVisible(boolVisibility);
        schoolBoard3.lookup("#entranceGreen3"+ numGreen).setDisable(boolClickable);
    }

    public void redEntrance3(boolean boolVisibility, boolean boolClickable, int numRed){
        schoolBoard3.lookup("#entranceRed3"+ numRed).setVisible(boolVisibility);
        schoolBoard3.lookup("#entranceRed3"+ numRed).setDisable(boolClickable);
    }
    public void yellowEntrance3(boolean boolVisibility, boolean boolClickable, int numYellow){
        schoolBoard3.lookup("#entranceYellow3"+ numYellow).setVisible(boolVisibility);
        schoolBoard3.lookup("#entranceYellow3"+ numYellow).setDisable(boolClickable);
    }
    public void pinkEntrance3(boolean boolVisibility, boolean boolClickable, int numPink){
        schoolBoard3.lookup("#entrancePink3"+ numPink).setVisible(boolVisibility);
        schoolBoard3.lookup("#entrancePink3"+ numPink).setDisable(boolClickable);
    }
    public void blueEntrance3(boolean boolVisibility, boolean boolClickable, int numBlue){
        schoolBoard3.lookup("#entranceBlue3"+ numBlue).setVisible(boolVisibility);
        schoolBoard3.lookup("#entranceBlue3"+ numBlue).setDisable(boolClickable);
    }

    public void setDiningRoom3(){
        int green = gui.getLightGame().getPlayers().get(3).getDiningRoom().getNumGreen();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("schoolBoard3Green" + i))
                    school.setVisible(true);
            }
        }
        int red = gui.getLightGame().getPlayers().get(3).getDiningRoom().getNumRed();
        for(int i=0; i<red; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("schoolBoard3Red" + i))
                    school.setVisible(true);
            }
        }
        int yellow = gui.getLightGame().getPlayers().get(3).getDiningRoom().getNumYellow();
        for(int i=0; i<yellow; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("schoolBoard3Yellow" + i))
                    school.setVisible(true);
            }
        }
        int pink = gui.getLightGame().getPlayers().get(3).getDiningRoom().getNumPink();
        for(int i=0; i<pink; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("schoolBoard3Pink" + i))
                    school.setVisible(true);
            }
        }
        int blue = gui.getLightGame().getPlayers().get(3).getDiningRoom().getNumBlue();
        for(int i=0; i<blue; i++){
            for(Node school : schoolBoard3.getChildren()) {
                if (school.getId().equals("schoolBoard3Blue" + i))
                    school.setVisible(true);
            }
        }
    }

    //le 5 funzioni qui sotto mettono visibile/ non visibili le pedine delle dining che passiamo con num
    public void greenDining3(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard3.getChildren()) {
            if (school.getId().equals("schoolBoard3Green" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void redDining3(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard3.getChildren()) {
            if (school.getId().equals("schoolBoard3Red" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void yellowDining3(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard3.getChildren()) {
            if (school.getId().equals("schoolBoard3Yellow" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void pinkDining3(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard3.getChildren()) {
            if (school.getId().equals("schoolBoard3Pink" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void blueDining3(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard3.getChildren()) {
            if (school.getId().equals("schoolBoard3Blue" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }

    public void setGreenProfessor3(boolean bool){
        schoolBoard3.lookup("#schoolGreenProf3").setVisible(bool);
    }
    public void setRedProfessor3(boolean bool){
        schoolBoard3.lookup("#schoolRedProf3").setVisible(bool);
    }
    public void setYellowProfessor3(boolean bool){
        schoolBoard3.lookup("#schoolYellowProf3").setVisible(bool);
    }

    public void setPinkProfessor3(boolean bool){
        schoolBoard3.lookup("#schoolPinkProf3").setVisible(bool);
    }
    public void setBlueProfessor3(boolean bool){
        schoolBoard3.lookup("#schoolBlueProf3").setVisible(bool);
    }


    public void setCoin3() {
        for (int i = 0; i < gui.getLightGame().getPlayers().get(3).getNumCoin(); i++)
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
        schoolBoard3.lookup("#entranceGreen30").setVisible(false);
        schoolBoard3.lookup("#entranceGreen30").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green31Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceGreen31").setVisible(false);
        schoolBoard3.lookup("#entranceGreen31").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green32Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceGreen32").setVisible(false);
        schoolBoard3.lookup("#entranceGreen32").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green33Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceGreen33").setVisible(false);
        schoolBoard3.lookup("#entranceGreen33").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green34Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceGreen34").setVisible(false);
        schoolBoard3.lookup("#entranceGreen34").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green35Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceGreen35").setVisible(false);
        schoolBoard3.lookup("#entranceGreen35").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green36Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceGreen36").setVisible(false);
        schoolBoard3.lookup("#entranceGreen36").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green37Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceGreen37").setVisible(false);
        schoolBoard3.lookup("#entranceGreen37").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green38Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceGreen38").setVisible(false);
        schoolBoard3.lookup("#entranceGreen38").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void red30Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceRed30").setVisible(false);
        schoolBoard3.lookup("#entranceRed30").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red31Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceRed31").setVisible(false);
        schoolBoard3.lookup("#entranceRed31").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red32Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceRed32").setVisible(false);
        schoolBoard3.lookup("#entranceRed32").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red33Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceRed33").setVisible(false);
        schoolBoard3.lookup("#entranceRed33").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red34Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceRed34").setVisible(false);
        schoolBoard3.lookup("#entranceRed34").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red35Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceRed35").setVisible(false);
        schoolBoard3.lookup("#entranceRed35").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red36Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceRed36").setVisible(false);
        schoolBoard3.lookup("#entranceRed36").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red37Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceRed37").setVisible(false);
        schoolBoard3.lookup("#entranceRed37").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red38Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceRed38").setVisible(false);
        schoolBoard3.lookup("#entranceRed38").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void yellow30Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceYellow30").setVisible(false);
        schoolBoard3.lookup("#entranceYellow30").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow31Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceYellow31").setVisible(false);
        schoolBoard3.lookup("#entranceYellow31").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow32Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceYellow32").setVisible(false);
        schoolBoard3.lookup("#entranceYellow32").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow33Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceYellow33").setVisible(false);
        schoolBoard3.lookup("#entranceYellow33").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow34Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceYellow34").setVisible(false);
        schoolBoard3.lookup("#entranceYellow34").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow35Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceYellow35").setVisible(false);
        schoolBoard3.lookup("#entranceYellow35").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow36Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceYellow36").setVisible(false);
        schoolBoard3.lookup("#entranceYellow36").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow37Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceYellow37").setVisible(false);
        schoolBoard3.lookup("#entranceYellow37").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow38Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceYellow38").setVisible(false);
        schoolBoard3.lookup("#entranceYellow38").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void pink30Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entrancePink30").setVisible(false);
        schoolBoard3.lookup("#entrancePink30").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink31Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entrancePink31").setVisible(false);
        schoolBoard3.lookup("#entrancePink31").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink32Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entrancePink32").setVisible(false);
        schoolBoard3.lookup("#entrancePink32").setDisable(true); gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink33Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entrancePink33").setVisible(false);
        schoolBoard3.lookup("#entrancePink33").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink34Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entrancePink34").setVisible(false);
        schoolBoard3.lookup("#entrancePink34").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink35Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entrancePink35").setVisible(false);
        schoolBoard3.lookup("#entrancePink35").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink36Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entrancePink36").setVisible(false);
        schoolBoard3.lookup("#entrancePink36").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink37Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entrancePink37").setVisible(false);
        schoolBoard3.lookup("#entrancePink37").setDisable(true); gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink38Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entrancePink38").setVisible(false);
        schoolBoard3.lookup("#entrancePink38").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void blue30Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceBlue30").setVisible(false);
        schoolBoard3.lookup("#entranceBlue30").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue31Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceBlue31").setVisible(false);
        schoolBoard3.lookup("#entranceBlue31").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue32Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceBlue32").setVisible(false);
        schoolBoard3.lookup("#entranceBlue32").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        selection();
    }

    public void blue33Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceBlue33").setVisible(false);
        schoolBoard3.lookup("#entranceBlue33").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue34Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceBlue34").setVisible(false);
        schoolBoard3.lookup("#entranceBlue34").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue35Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceBlue35").setVisible(false);
        schoolBoard3.lookup("#entranceBlue35").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue36Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceBlue36").setVisible(false);
        schoolBoard3.lookup("#entranceBlue36").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue37Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceBlue37").setVisible(false);
        schoolBoard3.lookup("#entranceBlue37").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue38Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#entranceBlue38").setVisible(false);
        schoolBoard3.lookup("#entranceBlue38").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }


    public void selectSchoolGreen30(MouseEvent mouseEvent) {
        schoolBoard3.lookup("##schoolBoard3Green0").setVisible(false);
        schoolBoard3.lookup("##schoolBoard3Green0").setDisable(true);
    }

    public void selectSchoolGreen31(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Green1").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Green1").setDisable(true);
    }
    public void selectSchoolGreen32(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Green2").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Green2").setDisable(true);
    }
    public void selectSchoolGreen33(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Green3").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Green3").setDisable(true);
    }
    public void selectSchoolGreen34(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Green4").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Green4").setDisable(true);
    }
    public void selectSchoolGreen35(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Green5").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Green5").setDisable(true);
    }
    public void selectSchoolGreen36(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Green6").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Green6").setDisable(true);
    }
    public void selectSchoolGreen37(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Green7").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Green7").setDisable(true);
    }
    public void selectSchoolGreen38(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Green8").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Green8").setDisable(true);
    }
    public void selectSchoolGreen39(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Green9").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Green9").setDisable(true);
    }

    public void selectSchoolRed30(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Red0").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Red0").setDisable(true);
    }
    public void selectSchoolRed31(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Red1").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Red1").setDisable(true);
    }
    public void selectSchoolRed32(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Red2").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Red2").setDisable(true);
    }
    public void selectSchoolRed33(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Red3").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Red3").setDisable(true);
    }
    public void selectSchoolRed34(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Red4").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Red4").setDisable(true);
    }
    public void selectSchoolRed35(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Red5").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Red5").setDisable(true);
    }
    public void selectSchoolRed36(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Red6").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Red6").setDisable(true);
    }
    public void selectSchoolRed37(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Red7").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Red7").setDisable(true);
    }
    public void selectSchoolRed38(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Red8").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Red8").setDisable(true);
    }
    public void selectSchoolRed39(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Red9").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Red9").setDisable(true);
    }

    public void selectSchoolYellow30(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Yellow0").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Yellow0").setDisable(true);
    }
    public void selectSchoolYellow31(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Yellow1").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Yellow1").setDisable(true);
    }
    public void selectSchoolYellow32(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Yellow2").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Yellow2").setDisable(true);
    }
    public void selectSchoolYellow33(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Yellow3").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Yellow3").setDisable(true);
    }
    public void selectSchoolYellow34(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Yellow4").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Yellow4").setDisable(true);
    }
    public void selectSchoolYellow35(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Yellow5").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Yellow5").setDisable(true);
    }
    public void selectSchoolYellow36(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Yellow6").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Yellow6").setDisable(true);
    }
    public void selectSchoolYellow37(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Yellow7").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Yellow7").setDisable(true);
    }
    public void selectSchoolYellow38(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Yellow8").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Yellow8").setDisable(true);
    }
    public void selectSchoolYellow39(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Yellow9").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Yellow9").setDisable(true);
    }

    public void selectSchoolPink30(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Pink0").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Pink0").setDisable(true);
    }
    public void selectSchoolPink31(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Pink1").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Pink1").setDisable(true);
    }
    public void selectSchoolPink32(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Pink2").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Pink2").setDisable(true);
    }
    public void selectSchoolPink33(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Pink3").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Pink3").setDisable(true);
    }
    public void selectSchoolPink34(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Pink4").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Pink4").setDisable(true);
    }
    public void selectSchoolPink35(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Pink5").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Pink5").setDisable(true);
    }
    public void selectSchoolPink36(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Pink6").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Pink6").setDisable(true);
    }
    public void selectSchoolPink37(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Pink7").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Pink7").setDisable(true);
    }
    public void selectSchoolPink38(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Pink8").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Pink8").setDisable(true);
    }
    public void selectSchoolPink39(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Pink9").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Pink9").setDisable(true);
    }

    public void selectSchoolBlue30(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Blue0").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Blue0").setDisable(true);
    }
    public void selectSchoolBlue31(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Blue1").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Blue1").setDisable(true);
    }
    public void selectSchoolBlue32(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Blue2").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Blue2").setDisable(true);
    }
    public void selectSchoolBlue33(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Blue3").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Blue3").setDisable(true);
    }
    public void selectSchoolBlue34(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Blue4").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Blue4").setDisable(true);
    }
    public void selectSchoolBlue35(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Blue5").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Blue5").setDisable(true);
    }
    public void selectSchoolBlue36(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Blue6").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Blue6").setDisable(true);
    }
    public void selectSchoolBlue37(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Blue7").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Blue7").setDisable(true);
    }
    public void selectSchoolBlue38(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Blue8").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Blue8").setDisable(true);
    }
    public void selectSchoolBlue39(MouseEvent mouseEvent) {
        schoolBoard3.lookup("#schoolBoard3Blue9").setVisible(false);
        schoolBoard3.lookup("#schoolBoard3Blue9").setDisable(true);
    }

    public void selection(){
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            for(int i=0; i<gui.getLightGame().getIslands().size(); i++)
                gui.getGameTable().getGameTablePane().lookup("#island"+ i).setDisable(false);
            if(gui.getNumPawnsCount()==0)
                for(Node school : schoolBoard3.getChildren())
                    school.setDisable(true);
        }else if(gui.getButtonClicked().equals(ButtonAction.DININGROOM)){
            if(gui.getNumPawnsCount()==0){
                for(Node school : schoolBoard3.getChildren()){
                    school.setDisable(true);
                }
                gui.getSocketNetworkHandler().sendMessage(new MovePawnToDiningMessage(gui.getNumPawns(), gui.getColorPawns()));
                gui.getColorPawns().clear();
                gui.getSchoolBoard3Controller().setDiningRoom3();
                gui.getGameTable().getShowSchool3().setCenter(gui.getSchoolBoard3Controller().getSchoolBoard3());
                gui.getGameTable().getShowSchool3().setVisible(true);
                gui.setPedineDaSpostare(gui.getPedineDaSpostare()- gui.getNumPawns());
            }
        }
    }
}