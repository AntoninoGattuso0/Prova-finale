package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SchoolBoard3Controller {
    Gui gui;
    LightGame lightGame;//da qualche parte ha bisogno di ricevere lightGame

    public void setGui(Gui gui){this.gui=gui;}

    public void setLightGame(LightGame lightGame){this.lightGame=lightGame;}

    @FXML Pane schoolBoard3;

    public void setSchoolBoard3(){
        setAllInvisible();
        setEntrance3();
        setDiningRoom3();
        setTower3();
        setCoin3();
    }

    public void setAllInvisible(){
        for(Node all : schoolBoard3.getChildren()) {
            all.setVisible(false);
            all.setDisable(true);
        }
    }

    public void setEntrance3Clickable(){
        setEntrance3();
        int green = lightGame.getPlayers().get(3).getEntrance().getGreenPawn();
        for(int i=3; i<green; i++){
            schoolBoard3.lookup("entranceGreen3" + i).setDisable(false);
        }
        int red = lightGame.getPlayers().get(3).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            schoolBoard3.lookup("entranceRed3" + i).setDisable(false);
        }
        int yellow = lightGame.getPlayers().get(3).getEntrance().getRedPawn() + red;
        for(int i=red; i<yellow; i++){
            schoolBoard3.lookup("entranceYellow3" + i).setDisable(false);
        }
        int pink = lightGame.getPlayers().get(3).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            schoolBoard3.lookup("entrancePink3" + i).setDisable(false);
        }
        int blue = lightGame.getPlayers().get(3).getEntrance().getPinkPawn() + pink;
        for(int i=pink; i<blue; i++){
            schoolBoard3.lookup("entranceBlue3" + i).setDisable(false);
        }
    }

    public void setEntrance3(){
        int green = lightGame.getPlayers().get(3).getEntrance().getGreenPawn();
        for(int i=3; i<green; i++){
            schoolBoard3.lookup("entranceGreen3" + i).setVisible(true);
        }
        int red = lightGame.getPlayers().get(3).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            schoolBoard3.lookup("entranceRed3" + i).setVisible(true);
        }
        int yellow = lightGame.getPlayers().get(3).getEntrance().getRedPawn() + red;
        for(int i=red; i<yellow; i++){
            schoolBoard3.lookup("entranceYellow3" + i).setVisible(true);
        }
        int pink = lightGame.getPlayers().get(3).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            schoolBoard3.lookup("entrancePink3" + i).setVisible(true);
        }
        int blue = lightGame.getPlayers().get(3).getEntrance().getPinkPawn() + pink;
        for(int i=pink; i<blue; i++){
            schoolBoard3.lookup("entranceBlue3" + i).setVisible(true);
        }
    }

    public void setDiningRoom3(){
        int green = lightGame.getPlayers().get(3).getDiningRoom().getNumGreen();
        for(int i=3; i<green; i++){
            schoolBoard3.lookup("schoolGreen3" + i).setVisible(true);
        }
        int red = lightGame.getPlayers().get(3).getDiningRoom().getNumRed();
        for(int i=3; i<red; i++){
            schoolBoard3.lookup("schoolRed3" + i).setVisible(true);
        }
        int yellow = lightGame.getPlayers().get(3).getDiningRoom().getNumYellow();
        for(int i=3; i<yellow; i++){
            schoolBoard3.lookup("schoolYellow3" + i).setVisible(true);
        }
        int pink = lightGame.getPlayers().get(3).getDiningRoom().getNumPink();
        for(int i=3; i<pink; i++){
            schoolBoard3.lookup("schoolPink3" + i).setVisible(true);
        }
        int blue = lightGame.getPlayers().get(3).getDiningRoom().getNumBlue();
        for(int i=3; i<blue; i++){
            schoolBoard3.lookup("schoolBlue3" + i).setVisible(true);
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

    public void setTower3(){
        for(int i = 3; i<lightGame.getPlayers().get(3).getTowerSpace().getNumTower(); i++)
            schoolBoard3.lookup("blackTowerSchool" + i).setVisible(true);
    }

    public void setCoin3() {
        for (int i = 3; i < lightGame.getPlayers().get(3).getNumCoin(); i++)
            schoolBoard3.lookup("coin" + i).setVisible(true);
    }

    public ColorPawn green30Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceGreen3").setVisible(false);
        schoolBoard3.lookup("entranceGreen3").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green31Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceGreen31").setVisible(false);
        schoolBoard3.lookup("entranceGreen31").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green32Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceGreen32").setVisible(false);
        schoolBoard3.lookup("entranceGreen32").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green33Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceGreen33").setVisible(false);
        schoolBoard3.lookup("entranceGreen33").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green34Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceGreen34").setVisible(false);
        schoolBoard3.lookup("entranceGreen34").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green35Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceGreen35").setVisible(false);
        schoolBoard3.lookup("entranceGreen35").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green36Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceGreen36").setVisible(false);
        schoolBoard3.lookup("entranceGreen36").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green37Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceGreen37").setVisible(false);
        schoolBoard3.lookup("entranceGreen37").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green38Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceGreen38").setVisible(false);
        schoolBoard3.lookup("entranceGreen38").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn red30Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceRed3").setVisible(false);
        schoolBoard3.lookup("entranceRed3").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red31Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceRed31").setVisible(false);
        schoolBoard3.lookup("entranceRed31").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red32Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceRed32").setVisible(false);
        schoolBoard3.lookup("entranceRed32").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red33Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceRed33").setVisible(false);
        schoolBoard3.lookup("entranceRed33").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red34Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceRed34").setVisible(false);
        schoolBoard3.lookup("entranceRed34").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red35Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceRed35").setVisible(false);
        schoolBoard3.lookup("entranceRed35").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red36Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceRed36").setVisible(false);
        schoolBoard3.lookup("entranceRed36").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red37Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceRed37").setVisible(false);
        schoolBoard3.lookup("entranceRed37").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red38Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceRed38").setVisible(false);
        schoolBoard3.lookup("entranceRed38").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn yellow30Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceYellow3").setVisible(false);
        schoolBoard3.lookup("entranceYellow3").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow31Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceYellow31").setVisible(false);
        schoolBoard3.lookup("entranceYellow31").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow32Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceYellow32").setVisible(false);
        schoolBoard3.lookup("entranceYellow32").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow33Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceYellow33").setVisible(false);
        schoolBoard3.lookup("entranceYellow33").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow34Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceYellow34").setVisible(false);
        schoolBoard3.lookup("entranceYellow34").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow35Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceYellow35").setVisible(false);
        schoolBoard3.lookup("entranceYellow35").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow36Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceYellow36").setVisible(false);
        schoolBoard3.lookup("entranceYellow36").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow37Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceYellow35").setVisible(false);
        schoolBoard3.lookup("entranceYellow35").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow38Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceYellow35").setVisible(false);
        schoolBoard3.lookup("entranceYellow35").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn pink30Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entrancePink3").setVisible(false);
        schoolBoard3.lookup("entrancePink3").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink31Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entrancePink31").setVisible(false);
        schoolBoard3.lookup("entrancePink31").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink32Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entrancePink32").setVisible(false);
        schoolBoard3.lookup("entrancePink32").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink33Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entrancePink33").setVisible(false);
        schoolBoard3.lookup("entrancePink33").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink34Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entrancePink34").setVisible(false);
        schoolBoard3.lookup("entrancePink34").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink35Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entrancePink35").setVisible(false);
        schoolBoard3.lookup("entrancePink35").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink36Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entrancePink36").setVisible(false);
        schoolBoard3.lookup("entrancePink36").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink37Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entrancePink37").setVisible(false);
        schoolBoard3.lookup("entrancePink37").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink38Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entrancePink38").setVisible(false);
        schoolBoard3.lookup("entrancePink38").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn blue30Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceBlue3").setVisible(false);
        schoolBoard3.lookup("entranceBlue3").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue31Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceBlue31").setVisible(false);
        schoolBoard3.lookup("entranceBlue31").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue32Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceBlue32").setVisible(false);
        schoolBoard3.lookup("entranceBlue32").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue33Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceBlue33").setVisible(false);
        schoolBoard3.lookup("entranceBlue33").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue34Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceBlue34").setVisible(false);
        schoolBoard3.lookup("entranceBlue34").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue35Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceBlue35").setVisible(false);
        schoolBoard3.lookup("entranceBlue35").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue36Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceBlue36").setVisible(false);
        schoolBoard3.lookup("entranceBlue36").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue37Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceBlue37").setVisible(false);
        schoolBoard3.lookup("entranceBlue37").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue38Select(MouseEvent mouseEvent) {
        schoolBoard3.lookup("entranceBlue38").setVisible(false);
        schoolBoard3.lookup("entranceBlue38").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn selectSchoolGreen30(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Green0").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Green0").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen31(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Green1").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Green1").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen32(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Green2").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Green2").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen33(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Green3").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Green3").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen34(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Green4").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Green4").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen35(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Green5").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Green5").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen36(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Green6").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Green6").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen37(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Green7").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Green7").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen38(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Green8").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Green8").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen39(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Green9").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Green9").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn selectSchoolRed30(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Red0").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Red0").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed31(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Red1").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Red1").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed32(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Red2").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Red2").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed33(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Red3").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Red3").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed34(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Red4").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Red4").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed35(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Red5").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Red5").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed36(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Red6").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Red6").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed37(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Red7").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Red7").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed38(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Red8").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Red8").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed39(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Red9").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Red9").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn selectSchoolYellow30(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Yellow0").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Yellow0").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow31(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Yellow1").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Yellow1").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow32(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Yellow2").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Yellow2").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow33(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Yellow3").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Yellow3").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow34(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Yellow4").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Yellow4").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow35(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Yellow5").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Yellow5").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow36(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Yellow6").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Yellow6").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow37(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Yellow7").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Yellow7").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow38(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Yellow8").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Yellow8").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow39(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Yellow9").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Yellow9").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn selectSchoolPink30(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Pink0").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Pink0").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink31(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Pink1").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Pink1").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink32(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Pink2").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Pink2").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink33(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Pink3").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Pink3").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink34(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Pink4").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Pink4").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink35(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Pink5").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Pink5").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink36(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Pink6").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Pink6").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink37(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Pink7").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Pink7").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink38(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Pink8").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Pink8").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink39(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Pink9").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Pink9").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn selectSchoolBlue30(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Blue0").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Blue0").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue31(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Blue1").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Blue1").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue32(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Blue2").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Blue2").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue33(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Blue3").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Blue3").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue34(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Blue4").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Blue4").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue35(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Blue5").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Blue5").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue36(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Blue6").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Blue6").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue37(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Blue7").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Blue7").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue38(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Blue8").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Blue8").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue39(MouseEvent mouseEvent) {
        schoolBoard3.lookup("schoolBoard3Blue9").setVisible(false);
        schoolBoard3.lookup("schoolBoard3Blue9").setDisable(true);
        return ColorPawn.BLUE;
    }
}
