package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.model.ColorPawn;
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
        for(int i=2; i<green; i++){
            schoolBoard2.lookup("entranceGreen2" + i).setDisable(false);
        }
        int red = lightGame.getPlayers().get(2).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            schoolBoard2.lookup("entranceRed2" + i).setDisable(false);
        }
        int yellow = lightGame.getPlayers().get(2).getEntrance().getRedPawn() + red;
        for(int i=red; i<yellow; i++){
            schoolBoard2.lookup("entranceYellow2" + i).setDisable(false);
        }
        int pink = lightGame.getPlayers().get(2).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            schoolBoard2.lookup("entrancePink2" + i).setDisable(false);
        }
        int blue = lightGame.getPlayers().get(2).getEntrance().getPinkPawn() + pink;
        for(int i=pink; i<blue; i++){
            schoolBoard2.lookup("entranceBlue2" + i).setDisable(false);
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

    public void setCoin2() {
        for (int i = 0; i < lightGame.getPlayers().get(2).getNumCoin(); i++)
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("coin" + i))
                    school.setVisible(true);
            }
    }


    public ColorPawn green20Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen2").setVisible(false);
        schoolBoard2.lookup("entranceGreen2").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green21Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen21").setVisible(false);
        schoolBoard2.lookup("entranceGreen21").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green22Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen22").setVisible(false);
        schoolBoard2.lookup("entranceGreen22").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green23Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen23").setVisible(false);
        schoolBoard2.lookup("entranceGreen23").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green24Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen24").setVisible(false);
        schoolBoard2.lookup("entranceGreen24").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green25Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen25").setVisible(false);
        schoolBoard2.lookup("entranceGreen25").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green26Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen26").setVisible(false);
        schoolBoard2.lookup("entranceGreen26").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green27Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen27").setVisible(false);
        schoolBoard2.lookup("entranceGreen27").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green28Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen28").setVisible(false);
        schoolBoard2.lookup("entranceGreen28").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn red20Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed2").setVisible(false);
        schoolBoard2.lookup("entranceRed2").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red21Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed21").setVisible(false);
        schoolBoard2.lookup("entranceRed21").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red22Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed22").setVisible(false);
        schoolBoard2.lookup("entranceRed22").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red23Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed23").setVisible(false);
        schoolBoard2.lookup("entranceRed23").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red24Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed24").setVisible(false);
        schoolBoard2.lookup("entranceRed24").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red25Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed25").setVisible(false);
        schoolBoard2.lookup("entranceRed25").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red26Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed26").setVisible(false);
        schoolBoard2.lookup("entranceRed26").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red27Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed27").setVisible(false);
        schoolBoard2.lookup("entranceRed27").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red28Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed28").setVisible(false);
        schoolBoard2.lookup("entranceRed28").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn yellow20Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow2").setVisible(false);
        schoolBoard2.lookup("entranceYellow2").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow21Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow21").setVisible(false);
        schoolBoard2.lookup("entranceYellow21").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow22Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow22").setVisible(false);
        schoolBoard2.lookup("entranceYellow22").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow23Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow23").setVisible(false);
        schoolBoard2.lookup("entranceYellow23").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow24Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow24").setVisible(false);
        schoolBoard2.lookup("entranceYellow24").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow25Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow25").setVisible(false);
        schoolBoard2.lookup("entranceYellow25").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow26Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow26").setVisible(false);
        schoolBoard2.lookup("entranceYellow26").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow27Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow25").setVisible(false);
        schoolBoard2.lookup("entranceYellow25").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow28Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow25").setVisible(false);
        schoolBoard2.lookup("entranceYellow25").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn pink20Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink2").setVisible(false);
        schoolBoard2.lookup("entrancePink2").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink21Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink21").setVisible(false);
        schoolBoard2.lookup("entrancePink21").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink22Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink22").setVisible(false);
        schoolBoard2.lookup("entrancePink22").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink23Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink23").setVisible(false);
        schoolBoard2.lookup("entrancePink23").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink24Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink24").setVisible(false);
        schoolBoard2.lookup("entrancePink24").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink25Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink25").setVisible(false);
        schoolBoard2.lookup("entrancePink25").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink26Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink26").setVisible(false);
        schoolBoard2.lookup("entrancePink26").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink27Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink27").setVisible(false);
        schoolBoard2.lookup("entrancePink27").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink28Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink28").setVisible(false);
        schoolBoard2.lookup("entrancePink28").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn blue20Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue2").setVisible(false);
        schoolBoard2.lookup("entranceBlue2").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue21Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue21").setVisible(false);
        schoolBoard2.lookup("entranceBlue21").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue22Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue22").setVisible(false);
        schoolBoard2.lookup("entranceBlue22").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue23Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue23").setVisible(false);
        schoolBoard2.lookup("entranceBlue23").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue24Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue24").setVisible(false);
        schoolBoard2.lookup("entranceBlue24").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue25Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue25").setVisible(false);
        schoolBoard2.lookup("entranceBlue25").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue26Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue26").setVisible(false);
        schoolBoard2.lookup("entranceBlue26").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue27Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue27").setVisible(false);
        schoolBoard2.lookup("entranceBlue27").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue28Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue28").setVisible(false);
        schoolBoard2.lookup("entranceBlue28").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn selectSchoolGreen20(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Green0").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Green0").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen21(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Green1").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Green1").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen22(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Green2").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Green2").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen23(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Green3").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Green3").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen24(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Green4").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Green4").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen25(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Green5").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Green5").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen26(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Green6").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Green6").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen27(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Green7").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Green7").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen28(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Green8").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Green8").setDisable(true);
        return ColorPawn.GREEN;
    }
    public ColorPawn selectSchoolGreen29(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Green9").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Green9").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn selectSchoolRed20(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Red0").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Red0").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed21(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Red1").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Red1").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed22(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Red2").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Red2").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed23(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Red3").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Red3").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed24(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Red4").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Red4").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed25(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Red5").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Red5").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed26(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Red6").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Red6").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed27(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Red7").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Red7").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed28(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Red8").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Red8").setDisable(true);
        return ColorPawn.RED;
    }
    public ColorPawn selectSchoolRed29(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Red9").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Red9").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn selectSchoolYellow20(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Yellow0").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Yellow0").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow21(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Yellow1").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Yellow1").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow22(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Yellow2").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Yellow2").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow23(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Yellow3").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Yellow3").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow24(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Yellow4").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Yellow4").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow25(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Yellow5").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Yellow5").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow26(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Yellow6").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Yellow6").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow27(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Yellow7").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Yellow7").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow28(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Yellow8").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Yellow8").setDisable(true);
        return ColorPawn.YELLOW;
    }
    public ColorPawn selectSchoolYellow29(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Yellow9").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Yellow9").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn selectSchoolPink20(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Pink0").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Pink0").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink21(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Pink1").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Pink1").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink22(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Pink2").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Pink2").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink23(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Pink3").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Pink3").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink24(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Pink4").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Pink4").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink25(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Pink5").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Pink5").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink26(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Pink6").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Pink6").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink27(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Pink7").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Pink7").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink28(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Pink8").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Pink8").setDisable(true);
        return ColorPawn.PINK;
    }
    public ColorPawn selectSchoolPink29(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Pink9").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Pink9").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn selectSchoolBlue20(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Blue0").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Blue0").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue21(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Blue1").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Blue1").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue22(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Blue2").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Blue2").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue23(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Blue3").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Blue3").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue24(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Blue4").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Blue4").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue25(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Blue5").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Blue5").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue26(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Blue6").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Blue6").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue27(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Blue7").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Blue7").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue28(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Blue8").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Blue8").setDisable(true);
        return ColorPawn.BLUE;
    }
    public ColorPawn selectSchoolBlue29(MouseEvent mouseEvent) {
        schoolBoard2.lookup("schoolBoard2Blue9").setVisible(false);
        schoolBoard2.lookup("schoolBoard2Blue9").setDisable(true);
        return ColorPawn.BLUE;
    }

}