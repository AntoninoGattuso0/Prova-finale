package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.network.Message.ClientToServer.ChooseCharacterCardMessage;
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
        int n;
        n=gui.getLightGame().getProfTable().getRedProf();
        if(n==2){
            setRedProfessor2(true);
        }
        n=gui.getLightGame().getProfTable().getPinkProf();
        if(n==2){
            setPinkProfessor2(true);
        }
        n=gui.getLightGame().getProfTable().getGreenProf();
        if(n==2){
            setGreenProfessor2(true);
        }
        n=gui.getLightGame().getProfTable().getBlueProf();
        if(n==2){setBlueProfessor2(true);
        }
        n=gui.getLightGame().getProfTable().getYellowProf();
        if(n==2){
            setYellowProfessor2(true);
        }
        setCoin2();
    }
    /**sets all the images on the school board invisible except the schoolBoard's images
     */
    public void setAllInvisible(){
        for(Node all : schoolBoard2.getChildren()) {
            all.setVisible(false);
            all.setDisable(true);
            if(all.getId().equals("backSchool2"))
                all.setVisible(true);
        }
    }

    /**sets the pawns on the entrance clickable at the begging of the game
     */
    public void setEntrance2Clickable(){
        setEntrance2();
        int green = gui.getLightGame().getPlayers().get(2).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++)
            schoolBoard2.lookup("#entranceGreen2"+ i).setDisable(false);
        int red = gui.getLightGame().getPlayers().get(2).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++)
            schoolBoard2.lookup("#entranceRed2"+ i).setDisable(false);
        int yellow = gui.getLightGame().getPlayers().get(2).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++)
            schoolBoard2.lookup("#entranceYellow2" + i).setDisable(false);
        int pink = gui.getLightGame().getPlayers().get(2).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++)
            schoolBoard2.lookup("#entrancePink2"+ i).setDisable(false);
        int blue = gui.getLightGame().getPlayers().get(2).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++)
            schoolBoard2.lookup("#entranceBlue2"+ i).setDisable(false);

    }
    public void setEntrance2(){
        int green = gui.getLightGame().getPlayers().get(2).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++)
            schoolBoard2.lookup("#entranceGreen2"+ i).setVisible(true);

        int red = gui.getLightGame().getPlayers().get(2).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++)
            schoolBoard2.lookup("#entranceRed2"+ i).setVisible(true);

        int yellow = gui.getLightGame().getPlayers().get(2).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++)
            schoolBoard2.lookup("#entranceYellow2"+ i).setVisible(true);

        int pink = gui.getLightGame().getPlayers().get(2).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++)
            schoolBoard2.lookup("#entrancePink2"+ i).setVisible(true);

        int blue = gui.getLightGame().getPlayers().get(2).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++)
            schoolBoard2.lookup("#entranceBlue2"+ i).setVisible(true);
    }

    /**sets visible the pawns of the dining room
     */
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

    /**sets visible the Professor on the schoolPlayer that owns it
     * @param bool true if visible, false if not
     */
    public void setGreenProfessor2(boolean bool){
        schoolBoard2.lookup("#schoolGreenProf2").setVisible(bool);
    }
    public void setRedProfessor2(boolean bool){
        schoolBoard2.lookup("#schoolRedProf2").setVisible(bool);
    }
    public void setYellowProfessor2(boolean bool){
        schoolBoard2.lookup("#schoolYellowProf2").setVisible(bool);
    }

    public void setPinkProfessor2(boolean bool){
        schoolBoard2.lookup("#schoolPinkProf2").setVisible(bool);
    }
    public void setBlueProfessor2(boolean bool){
        schoolBoard2.lookup("#schoolBlueProf2").setVisible(bool);
    }
    /**sets the professor visible
     * @param numColor the number corresponds to the color of the professor
     *                 0 = green, 1 = red, 2 = yellow, 3 = pink, 4 = blue
     * @param bool true if visible, false if not
     */
    public void setProfessor2(int numColor, boolean bool){
        if(numColor == 0)
            setGreenProfessor2(bool);
        if(numColor == 1)
            setRedProfessor2(bool);
        if(numColor == 2)
            setYellowProfessor2(bool);
        if(numColor == 3)
            setPinkProfessor2(bool);
        if(numColor == 4)
            setBlueProfessor2(bool);
    }

    /**sets visible the towers on the schoolBoards
     */
    public void setTower2(){
        for(int i = 0; i<gui.getLightGame().getPlayers().get(2).getTowerSpace().getNumTower(); i++)
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("greyTowerSchool" + i))
                    school.setVisible(true);
            }
    }

    /**sets the coins visible
     */
    public void setCoin2() {
        for (int i = 0; i < gui.getLightGame().getPlayers().get(2).getNumCoin(); i++)
            for(Node school : schoolBoard2.getChildren()) {
                if (school.getId().equals("coin" + i))
                    school.setVisible(true);
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

    public void selection(){
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            for(int i=0; i<gui.getLightGame().getIslands().size(); i++)
                gui.getGameTable().getGameTablePane().lookup("#island"+ i).setDisable(false);
            if(gui.getNumPawnsCount()==0)
                for(Node school : schoolBoard2.getChildren())
                    school.setDisable(true);
            if(gui.getPedineDaSpostare()==0)
                gui.setPedineDaSpostare(gui.getNumPawnMove());
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
            if(gui.getPedineDaSpostare()==0)
                gui.setPedineDaSpostare(gui.getNumPawnMove());
        }else if(gui.getButtonClicked().equals(ButtonAction.GIUSEPPE)){
            int i;
            for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=6; i++);
            if(gui.getNumPawnsCount() == 0) {
                gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns() / 2, gui.getIslandSelected(), gui.getColorPawns(), true));
                gui.getColorPawns().clear();
            }
        }else if(gui.getButtonClicked().equals(ButtonAction.MARIA)){
            System.out.println("ho cliccato una pedina nel entrata");
            if(gui.getNumPawnsCount() == gui.getNumPawns()/2){
                gui.getGameTable().whatToDo.setText("Select Pawn from Dining");
                setEntrance2NOTClickable();
                int green = gui.getLightGame().getPlayers().get(2).getDiningRoom().getNumGreen();
                for(int i = 0; i < green; i++)
                    schoolBoard2.lookup("#schoolBoard2Green" + i).setDisable(false);
                int red = gui.getLightGame().getPlayers().get(2).getDiningRoom().getNumRed();
                for(int i = 0; i < red; i++)
                    schoolBoard2.lookup("#schoolBoard2Red" + i).setDisable(false);
                int yellow = gui.getLightGame().getPlayers().get(2).getDiningRoom().getNumYellow();
                for(int i = 0; i < yellow; i++)
                    schoolBoard2.lookup("#schoolBoard2Yellow" + i).setDisable(false);
                int pink = gui.getLightGame().getPlayers().get(2).getDiningRoom().getNumPink();
                for(int i = 0; i < pink; i++)
                    schoolBoard2.lookup("#schoolBoard2Pink" + i).setDisable(false);
                int blue = gui.getLightGame().getPlayers().get(2).getDiningRoom().getNumBlue();
                for(int i = 0; i < blue; i++)
                    schoolBoard2.lookup("#schoolBoard2Blue" + i).setDisable(false);
            }
        }
    }

    /**sets the pawns on the entrance not clickable
     */
    private void setEntrance2NOTClickable() {
        int green = gui.getLightGame().getPlayers().get(2).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++)
            schoolBoard2.lookup("#entranceGreen2"+ i).setDisable(true);
        int red = gui.getLightGame().getPlayers().get(2).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++)
            schoolBoard2.lookup("#entranceRed2"+ i).setDisable(true);
        int yellow = gui.getLightGame().getPlayers().get(2).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++)
            schoolBoard2.lookup("#entranceYellow2" + i).setDisable(true);
        int pink = gui.getLightGame().getPlayers().get(2).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++)
            schoolBoard2.lookup("#entrancePink2"+ i).setDisable(true);
        int blue = gui.getLightGame().getPlayers().get(2).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++)
            schoolBoard2.lookup("#entranceBlue2"+ i).setDisable(true);

    }
    /**sets the pawns visible on the entrance
     */
    public void selectSchoolGreen2(MouseEvent mouseEvent) {
        int i;
        for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=9; i++);
        gui.getColorPawns().add(ColorPawn.GREEN);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        int green = gui.getLightGame().getPlayers().get(2).getDiningRoom().getNumGreen();
        if(schoolBoard2.lookup("#schoolBoard2Green" + (green - 1)).isVisible()) {
            schoolBoard2.lookup("#schoolBoard2Green" + (green - 1)).setVisible(false);
            schoolBoard2.lookup("#schoolBoard2Green" + (green - 1)).setDisable(true);
        }else if(schoolBoard2.lookup("#schoolBoard2Green" + (green - 2)).isVisible()){
            schoolBoard2.lookup("#schoolBoard2Green" + (green - 2)).setVisible(false);
            schoolBoard2.lookup("#schoolBoard2Green" + (green - 2)).setDisable(true);
        }else{
            schoolBoard2.lookup("#schoolBoard2Green" + (green - 3)).setVisible(false);
            schoolBoard2.lookup("#schoolBoard2Green" + (green - 3)).setDisable(true);
        }
        if(gui.getNumPawnsCount() == 0){
            setAllDisabled();
            gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
            gui.getColorPawns().clear();
        }
    }

    /**sets all the images disabled for the click
     */
    public void setAllDisabled(){
        for(Node all : schoolBoard2.getChildren()) {
            all.setDisable(true);
            if(all.getId().equals("backSchool2"))
                all.setVisible(true);
        }
    }

    public void selectSchoolRed2(MouseEvent mouseEvent) {
        int i;
        for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=9; i++);
        gui.getColorPawns().add(ColorPawn.RED);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        int red = gui.getLightGame().getPlayers().get(2).getDiningRoom().getNumRed();
        if(schoolBoard2.lookup("#schoolBoard2Red" + (red - 1)).isVisible()) {
            schoolBoard2.lookup("#schoolBoard2Red" + (red - 1)).setVisible(false);
            schoolBoard2.lookup("#schoolBoard2Red" + (red - 1)).setDisable(true);
        }else if(schoolBoard2.lookup("#schoolBoard2Red" + (red - 2)).isVisible()){
            schoolBoard2.lookup("#schoolBoard2Red" + (red - 2)).setVisible(false);
            schoolBoard2.lookup("#schoolBoard2Red" + (red - 2)).setDisable(true);
        }else{
            schoolBoard2.lookup("#schoolBoard2Red" + (red - 3)).setVisible(false);
            schoolBoard2.lookup("#schoolBoard2Red" + (red - 3)).setDisable(true);
        }
        if(gui.getNumPawnsCount() == 0){
            setAllDisabled();
            gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
            gui.getColorPawns().clear();
            gui.setVar(true);
        }
    }

    public void selectSchoolYellow2(MouseEvent mouseEvent) {
        int i;
        for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=9; i++);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        int yellow = gui.getLightGame().getPlayers().get(2).getDiningRoom().getNumYellow();
        if(schoolBoard2.lookup("#schoolBoard2Yellow" + (yellow - 1)).isVisible()) {
            schoolBoard2.lookup("#schoolBoard2Yellow" + (yellow - 1)).setVisible(false);
            schoolBoard2.lookup("#schoolBoard2Yellow" + (yellow - 1)).setDisable(true);
        }else if(schoolBoard2.lookup("#schoolBoard2Yellow" + (yellow - 2)).isVisible()){
            schoolBoard2.lookup("#schoolBoard2Yellow" + (yellow - 2)).setVisible(false);
            schoolBoard2.lookup("#schoolBoard2Yellow" + (yellow - 2)).setDisable(true);
        }else{
            schoolBoard2.lookup("#schoolBoard2Yellow" + (yellow - 3)).setVisible(false);
            schoolBoard2.lookup("#schoolBoard2Yellow" + (yellow - 3)).setDisable(true);
        }
        if(gui.getNumPawnsCount() == 0){
            setAllDisabled();
            gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
            gui.getColorPawns().clear();
            gui.setVar(true);
        }
    }

    public void selectSchoolPink2(MouseEvent mouseEvent) {
        int i;
        for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=9; i++);
        gui.getColorPawns().add(ColorPawn.PINK);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        int pink = gui.getLightGame().getPlayers().get(2).getDiningRoom().getNumPink();
        if(schoolBoard2.lookup("#schoolBoard2Pink" + (pink - 1)).isVisible()) {
            schoolBoard2.lookup("#schoolBoard2Pink" + (pink - 1)).setVisible(false);
            schoolBoard2.lookup("#schoolBoard2Pink" + (pink - 1)).setDisable(true);
        }else if(schoolBoard2.lookup("#schoolBoard2Pink" + (pink - 2)).isVisible()){
            schoolBoard2.lookup("#schoolBoard2Pink" + (pink - 2)).setVisible(false);
            schoolBoard2.lookup("#schoolBoard2Pink" + (pink - 2)).setDisable(true);
        }else{
            schoolBoard2.lookup("#schoolBoard2Pink" + (pink - 3)).setVisible(false);
            schoolBoard2.lookup("#schoolBoard2Pink" + (pink - 3)).setDisable(true);
        }
        if(gui.getNumPawnsCount() == 0){
            setAllDisabled();
            gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
            gui.getColorPawns().clear();
            gui.setVar(true);
        }
    }

    public void selectSchoolBlue2(MouseEvent mouseEvent) {
        int i;
        for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=9; i++);
        gui.getColorPawns().add(ColorPawn.BLUE);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        int blue = gui.getLightGame().getPlayers().get(2).getDiningRoom().getNumBlue();
        if(schoolBoard2.lookup("#schoolBoard2Blue" + (blue - 1)).isVisible()) {
            schoolBoard2.lookup("#schoolBoard2Blue" + (blue - 1)).setVisible(false);
            schoolBoard2.lookup("#schoolBoard2Blue" + (blue - 1)).setDisable(true);
        }else if(schoolBoard2.lookup("#schoolBoard2Blue" + (blue - 2)).isVisible()){
            schoolBoard2.lookup("#schoolBoard2Blue" + (blue - 2)).setVisible(false);
            schoolBoard2.lookup("#schoolBoard2Blue" + (blue - 2)).setDisable(true);
        }else{
            schoolBoard2.lookup("#schoolBoard2Blue" + (blue - 3)).setVisible(false);
            schoolBoard2.lookup("#schoolBoard2Blue" + (blue - 3)).setDisable(true);
        }
        if(gui.getNumPawnsCount() == 0){
            setAllDisabled();
            gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
            gui.getColorPawns().clear();
            gui.setVar(true);
        }
    }
}