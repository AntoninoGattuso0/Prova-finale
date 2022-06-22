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
    public void setAllInvisible(){
        for(Node all : schoolBoard0.getChildren()) {
            all.setVisible(false);
            all.setDisable(true);
            if(all.getId().equals("backSchool0"))
                all.setVisible(true);
        }
    }

    public void setEntrance0Clickable(){
        setEntrance0();
        int green = lightGame.getPlayers().get(0).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++){
            schoolBoard0.lookup("entranceGreen0" + i).setDisable(false);
        }
        int red = lightGame.getPlayers().get(0).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            schoolBoard0.lookup("entranceRed0" + i).setDisable(false);
        }
        int yellow = lightGame.getPlayers().get(0).getEntrance().getRedPawn() + red;
        for(int i=red; i<yellow; i++){
            schoolBoard0.lookup("entranceYellow0" + i).setDisable(false);
        }
        int pink = lightGame.getPlayers().get(0).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            schoolBoard0.lookup("entrancePink0" + i).setDisable(false);
        }
        int blue = lightGame.getPlayers().get(0).getEntrance().getPinkPawn() + pink;
        for(int i=pink; i<blue; i++){
            schoolBoard0.lookup("entranceBlue0" + i).setDisable(false);
        }
    }



    public void setEntrance0(){
        int green = lightGame.getPlayers().get(0).getEntrance().getGreenPawn();
        System.out.println(green);
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

    public void setProfessor0(){
        if(lightGame.getProfTable().getGreenProf() == 0)
            schoolBoard0.lookup("schoolGreenProf0").setVisible(true);
        if(lightGame.getProfTable().getRedProf() == 0)
            schoolBoard0.lookup("schoolRedProf0").setVisible(true);
        if(lightGame.getProfTable().getYellowProf() == 0)
            schoolBoard0.lookup("schoolYellowProf0").setVisible(true);
        if(lightGame.getProfTable().getPinkProf() == 0)
            schoolBoard0.lookup("schoolPinkProf0").setVisible(true);
        if(lightGame.getProfTable().getBlueProf() == 0)
            schoolBoard0.lookup("schoolBlueProf0").setVisible(true);
    }



    public void setTower0(){
        for(int i = 0; i<lightGame.getPlayers().get(0).getTowerSpace().getNumTower(); i++)
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("blackTowerSchool" + i))
                    school.setVisible(true);
            }
    }




    public void setCoin0() {
        for (int i = 0; i < lightGame.getPlayers().get(0).getNumCoin(); i++)
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("coin" + i))
                    school.setVisible(true);
            }
    }


    public void green00Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen00").setVisible(false);
        schoolBoard0.lookup("entranceGreen00").setDisable(true);
    }

    public void green01Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen01").setVisible(false);
        schoolBoard0.lookup("entranceGreen01").setDisable(true);
    }

    public void green02Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen02").setVisible(false);
        schoolBoard0.lookup("entranceGreen02").setDisable(true);
    }

    public void green03Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen03").setVisible(false);
        schoolBoard0.lookup("entranceGreen03").setDisable(true);
    }

    public void green04Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen04").setVisible(false);
        schoolBoard0.lookup("entranceGreen04").setDisable(true);
    }

    public void green05Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen05").setVisible(false);
        schoolBoard0.lookup("entranceGreen05").setDisable(true);
    }

    public void green06Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen06").setVisible(false);
        schoolBoard0.lookup("entranceGreen06").setDisable(true);
    }

    public void green07Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen07").setVisible(false);
        schoolBoard0.lookup("entranceGreen07").setDisable(true);
    }

    public void green08Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen08").setVisible(false);
        schoolBoard0.lookup("entranceGreen08").setDisable(true);
    }

    public void red00Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed00").setVisible(false);
        schoolBoard0.lookup("entranceRed00").setDisable(true);
    }

    public void red01Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed01").setVisible(false);
        schoolBoard0.lookup("entranceRed01").setDisable(true);
    }

    public void red02Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed02").setVisible(false);
        schoolBoard0.lookup("entranceRed02").setDisable(true);
    }

    public void red03Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed03").setVisible(false);
        schoolBoard0.lookup("entranceRed03").setDisable(true);
    }

    public void red04Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed04").setVisible(false);
        schoolBoard0.lookup("entranceRed04").setDisable(true);
    }

    public void red05Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed05").setVisible(false);
        schoolBoard0.lookup("entranceRed05").setDisable(true);
    }

    public void red06Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed06").setVisible(false);
        schoolBoard0.lookup("entranceRed06").setDisable(true);
    }

    public void red07Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed07").setVisible(false);
        schoolBoard0.lookup("entranceRed07").setDisable(true);
    }

    public void red08Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed08").setVisible(false);
        schoolBoard0.lookup("entranceRed08").setDisable(true);
    }

    public void yellow00Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow00").setVisible(false);
        schoolBoard0.lookup("entranceYellow00").setDisable(true);
    }

    public void yellow01Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow01").setVisible(false);
        schoolBoard0.lookup("entranceYellow01").setDisable(true);
    }

    public void yellow02Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow02").setVisible(false);
        schoolBoard0.lookup("entranceYellow02").setDisable(true);
    }

    public void yellow03Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow03").setVisible(false);
        schoolBoard0.lookup("entranceYellow03").setDisable(true);
    }

    public void yellow04Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow04").setVisible(false);
        schoolBoard0.lookup("entranceYellow04").setDisable(true);
    }

    public void yellow05Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow05").setVisible(false);
        schoolBoard0.lookup("entranceYellow05").setDisable(true);
    }

    public void yellow06Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow06").setVisible(false);
        schoolBoard0.lookup("entranceYellow06").setDisable(true);
    }

    public void yellow07Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow05").setVisible(false);
        schoolBoard0.lookup("entranceYellow05").setDisable(true);
    }

    public void yellow08Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow05").setVisible(false);
        schoolBoard0.lookup("entranceYellow05").setDisable(true);
    }

    public void pink00Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink00").setVisible(false);
        schoolBoard0.lookup("entrancePink00").setDisable(true);
    }

    public void pink01Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink01").setVisible(false);
        schoolBoard0.lookup("entrancePink01").setDisable(true);
    }

    public void pink02Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink02").setVisible(false);
        schoolBoard0.lookup("entrancePink02").setDisable(true);
    }

    public void pink03Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink03").setVisible(false);
        schoolBoard0.lookup("entrancePink03").setDisable(true);
    }

    public void pink04Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink04").setVisible(false);
        schoolBoard0.lookup("entrancePink04").setDisable(true);
    }

    public void pink05Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink05").setVisible(false);
        schoolBoard0.lookup("entrancePink05").setDisable(true);
    }

    public void pink06Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink06").setVisible(false);
        schoolBoard0.lookup("entrancePink06").setDisable(true);
    }

    public void pink07Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink07").setVisible(false);
        schoolBoard0.lookup("entrancePink07").setDisable(true);
    }

    public void pink08Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink08").setVisible(false);
        schoolBoard0.lookup("entrancePink08").setDisable(true);
    }

    public void blue00Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue00").setVisible(false);
        schoolBoard0.lookup("entranceBlue00").setDisable(true);
    }

    public void blue01Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue01").setVisible(false);
        schoolBoard0.lookup("entranceBlue01").setDisable(true);
    }

    public void blue02Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue02").setVisible(false);
        schoolBoard0.lookup("entranceBlue02").setDisable(true);
    }

    public void blue03Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue03").setVisible(false);
        schoolBoard0.lookup("entranceBlue03").setDisable(true);
    }

    public void blue04Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue04").setVisible(false);
        schoolBoard0.lookup("entranceBlue04").setDisable(true);
    }

    public void blue05Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue05").setVisible(false);
        schoolBoard0.lookup("entranceBlue05").setDisable(true);
    }

    public void blue06Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue06").setVisible(false);
        schoolBoard0.lookup("entranceBlue06").setDisable(true);
    }

    public void blue07Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue07").setVisible(false);
        schoolBoard0.lookup("entranceBlue07").setDisable(true);
    }

    public void blue08Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue08").setVisible(false);
        schoolBoard0.lookup("entranceBlue08").setDisable(true);
    }

    public void selectSchoolGreen00(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Green0").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Green0").setDisable(true);
    }
    public void selectSchoolGreen01(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Green1").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Green1").setDisable(true);
    }
    public void selectSchoolGreen02(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Green2").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Green2").setDisable(true);
    }
    public void selectSchoolGreen03(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Green3").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Green3").setDisable(true);
    }
    public void selectSchoolGreen04(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Green4").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Green4").setDisable(true);
    }
    public void selectSchoolGreen05(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Green5").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Green5").setDisable(true);
    }
    public void selectSchoolGreen06(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Green6").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Green6").setDisable(true);
    }
    public void selectSchoolGreen07(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Green7").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Green7").setDisable(true);
    }
    public void selectSchoolGreen08(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Green8").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Green8").setDisable(true);
    }
    public void selectSchoolGreen09(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Green9").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Green9").setDisable(true);
    }

    public void selectSchoolRed00(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Red0").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Red0").setDisable(true);
    }
    public void selectSchoolRed01(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Red1").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Red1").setDisable(true);
    }
    public void selectSchoolRed02(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Red2").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Red2").setDisable(true);
    }
    public void selectSchoolRed03(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Red3").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Red3").setDisable(true);
    }
    public void selectSchoolRed04(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Red4").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Red4").setDisable(true);
    }
    public void selectSchoolRed05(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Red5").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Red5").setDisable(true);
    }
    public void selectSchoolRed06(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Red6").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Red6").setDisable(true);
    }
    public void selectSchoolRed07(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Red7").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Red7").setDisable(true);
    }
    public void selectSchoolRed08(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Red8").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Red8").setDisable(true);
    }
    public void selectSchoolRed09(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Red9").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Red9").setDisable(true);
    }

    public void selectSchoolYellow00(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Yellow0").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Yellow0").setDisable(true);
    }
    public void selectSchoolYellow01(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Yellow1").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Yellow1").setDisable(true);
    }
    public void selectSchoolYellow02(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Yellow2").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Yellow2").setDisable(true);
    }
    public void selectSchoolYellow03(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Yellow3").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Yellow3").setDisable(true);
    }
    public void selectSchoolYellow04(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Yellow4").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Yellow4").setDisable(true);
    }
    public void selectSchoolYellow05(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Yellow5").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Yellow5").setDisable(true);
    }
    public void selectSchoolYellow06(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Yellow6").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Yellow6").setDisable(true);
    }
    public void selectSchoolYellow07(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Yellow7").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Yellow7").setDisable(true);
    }
    public void selectSchoolYellow08(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Yellow8").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Yellow8").setDisable(true);
    }
    public void selectSchoolYellow09(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Yellow9").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Yellow9").setDisable(true);
    }

    public void selectSchoolPink00(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Pink0").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Pink0").setDisable(true);
    }
    public void selectSchoolPink01(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Pink1").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Pink1").setDisable(true);
    }
    public void selectSchoolPink02(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Pink2").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Pink2").setDisable(true);
    }
    public void selectSchoolPink03(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Pink3").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Pink3").setDisable(true);
    }
    public void selectSchoolPink04(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Pink4").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Pink4").setDisable(true);
    }
    public void selectSchoolPink05(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Pink5").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Pink5").setDisable(true);
    }
    public void selectSchoolPink06(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Pink6").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Pink6").setDisable(true);
    }
    public void selectSchoolPink07(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Pink7").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Pink7").setDisable(true);
    }
    public void selectSchoolPink08(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Pink8").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Pink8").setDisable(true);
    }
    public void selectSchoolPink09(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Pink9").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Pink9").setDisable(true);
    }

    public void selectSchoolBlue00(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Blue0").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Blue0").setDisable(true);
    }
    public void selectSchoolBlue01(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Blue1").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Blue1").setDisable(true);
    }
    public void selectSchoolBlue02(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Blue2").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Blue2").setDisable(true);
    }
    public void selectSchoolBlue03(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Blue3").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Blue3").setDisable(true);
    }
    public void selectSchoolBlue04(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Blue4").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Blue4").setDisable(true);
    }
    public void selectSchoolBlue05(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Blue5").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Blue5").setDisable(true);
    }
    public void selectSchoolBlue06(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Blue6").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Blue6").setDisable(true);
    }
    public void selectSchoolBlue07(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Blue7").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Blue7").setDisable(true);
    }
    public void selectSchoolBlue08(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Blue8").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Blue8").setDisable(true);
    }
    public void selectSchoolBlue09(MouseEvent mouseEvent) {
        schoolBoard0.lookup("schoolBoard0Blue9").setVisible(false);
        schoolBoard0.lookup("schoolBoard0Blue9").setDisable(true);
    }

}
