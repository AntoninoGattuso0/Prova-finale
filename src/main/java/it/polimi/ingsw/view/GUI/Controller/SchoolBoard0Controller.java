package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SchoolBoard0Controller {
    Gui gui;
    LightGame lightGame;

    public void setGui(Gui gui){this.gui=gui;}

    public void setLightGame(LightGame lightGame){this.lightGame=lightGame;}

    @FXML Pane schoolBoard0;

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
        for(int i=0; i<green; i++){
            schoolBoard0.lookup("entranceGreen0" + i).setVisible(true);
        }
        int red = lightGame.getPlayers().get(0).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            schoolBoard0.lookup("entranceRed0" + i).setVisible(true);
        }
        int yellow = lightGame.getPlayers().get(0).getEntrance().getRedPawn() + red;
        for(int i=red; i<yellow; i++){
            schoolBoard0.lookup("entranceYellow0" + i).setVisible(true);
        }
        int pink = lightGame.getPlayers().get(0).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            schoolBoard0.lookup("entrancePink0" + i).setVisible(true);
        }
        int blue = lightGame.getPlayers().get(0).getEntrance().getPinkPawn() + pink;
        for(int i=pink; i<blue; i++){
            schoolBoard0.lookup("entranceBlue0" + i).setVisible(true);
        }
    }

    public void setDiningRoom0(){
        int green = lightGame.getPlayers().get(0).getDiningRoom().getNumGreen();
        for(int i=0; i<green; i++){
            schoolBoard0.lookup("schoolGreen0" + i).setVisible(true);
        }
        int red = lightGame.getPlayers().get(0).getDiningRoom().getNumRed();
        for(int i=0; i<red; i++){
            schoolBoard0.lookup("schoolRed0" + i).setVisible(true);
        }
        int yellow = lightGame.getPlayers().get(0).getDiningRoom().getNumYellow();
        for(int i=0; i<yellow; i++){
            schoolBoard0.lookup("schoolYellow0" + i).setVisible(true);
        }
        int pink = lightGame.getPlayers().get(0).getDiningRoom().getNumPink();
        for(int i=0; i<pink; i++){
            schoolBoard0.lookup("schoolPink0" + i).setVisible(true);
        }
        int blue = lightGame.getPlayers().get(0).getDiningRoom().getNumBlue();
        for(int i=0; i<blue; i++){
            schoolBoard0.lookup("schoolBlue0" + i).setVisible(true);
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
            schoolBoard0.lookup("blackTowerSchool" + i).setVisible(true);
    }

    public void setCoin0() {
        for (int i = 0; i < lightGame.getPlayers().get(0).getNumCoin(); i++)
            schoolBoard0.lookup("coin" + i).setVisible(true);
    }


    public ColorPawn green00Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen00").setVisible(false);
        schoolBoard0.lookup("entranceGreen00").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green01Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen01").setVisible(false);
        schoolBoard0.lookup("entranceGreen01").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green02Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen02").setVisible(false);
        schoolBoard0.lookup("entranceGreen02").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green03Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen03").setVisible(false);
        schoolBoard0.lookup("entranceGreen03").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green04Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen04").setVisible(false);
        schoolBoard0.lookup("entranceGreen04").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green05Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen05").setVisible(false);
        schoolBoard0.lookup("entranceGreen05").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green06Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen06").setVisible(false);
        schoolBoard0.lookup("entranceGreen06").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green07Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen07").setVisible(false);
        schoolBoard0.lookup("entranceGreen07").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green08Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceGreen08").setVisible(false);
        schoolBoard0.lookup("entranceGreen08").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn red00Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed00").setVisible(false);
        schoolBoard0.lookup("entranceRed00").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red01Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed01").setVisible(false);
        schoolBoard0.lookup("entranceRed01").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red02Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed02").setVisible(false);
        schoolBoard0.lookup("entranceRed02").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red03Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed03").setVisible(false);
        schoolBoard0.lookup("entranceRed03").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red04Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed04").setVisible(false);
        schoolBoard0.lookup("entranceRed04").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red05Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed05").setVisible(false);
        schoolBoard0.lookup("entranceRed05").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red06Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed06").setVisible(false);
        schoolBoard0.lookup("entranceRed06").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red07Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed07").setVisible(false);
        schoolBoard0.lookup("entranceRed07").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red08Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceRed08").setVisible(false);
        schoolBoard0.lookup("entranceRed08").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn yellow00Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow00").setVisible(false);
        schoolBoard0.lookup("entranceYellow00").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow01Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow01").setVisible(false);
        schoolBoard0.lookup("entranceYellow01").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow02Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow02").setVisible(false);
        schoolBoard0.lookup("entranceYellow02").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow03Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow03").setVisible(false);
        schoolBoard0.lookup("entranceYellow03").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow04Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow04").setVisible(false);
        schoolBoard0.lookup("entranceYellow04").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow05Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow05").setVisible(false);
        schoolBoard0.lookup("entranceYellow05").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow06Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow06").setVisible(false);
        schoolBoard0.lookup("entranceYellow06").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow07Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow05").setVisible(false);
        schoolBoard0.lookup("entranceYellow05").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow08Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceYellow05").setVisible(false);
        schoolBoard0.lookup("entranceYellow05").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn pink00Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink00").setVisible(false);
        schoolBoard0.lookup("entrancePink00").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink01Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink01").setVisible(false);
        schoolBoard0.lookup("entrancePink01").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink02Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink02").setVisible(false);
        schoolBoard0.lookup("entrancePink02").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink03Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink03").setVisible(false);
        schoolBoard0.lookup("entrancePink03").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink04Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink04").setVisible(false);
        schoolBoard0.lookup("entrancePink04").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink05Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink05").setVisible(false);
        schoolBoard0.lookup("entrancePink05").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink06Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink06").setVisible(false);
        schoolBoard0.lookup("entrancePink06").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink07Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink07").setVisible(false);
        schoolBoard0.lookup("entrancePink07").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink08Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entrancePink08").setVisible(false);
        schoolBoard0.lookup("entrancePink08").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn blue00Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue00").setVisible(false);
        schoolBoard0.lookup("entranceBlue00").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue01Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue01").setVisible(false);
        schoolBoard0.lookup("entranceBlue01").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue02Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue02").setVisible(false);
        schoolBoard0.lookup("entranceBlue02").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue03Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue03").setVisible(false);
        schoolBoard0.lookup("entranceBlue03").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue04Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue04").setVisible(false);
        schoolBoard0.lookup("entranceBlue04").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue05Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue05").setVisible(false);
        schoolBoard0.lookup("entranceBlue05").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue06Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue06").setVisible(false);
        schoolBoard0.lookup("entranceBlue06").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue07Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue07").setVisible(false);
        schoolBoard0.lookup("entranceBlue07").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue08Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("entranceBlue08").setVisible(false);
        schoolBoard0.lookup("entranceBlue08").setDisable(true);
        return ColorPawn.BLUE;
    }
}
