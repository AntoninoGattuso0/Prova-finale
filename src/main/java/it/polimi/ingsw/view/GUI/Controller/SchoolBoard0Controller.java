package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.network.Message.ClientToServer.ChooseCharacterCardMessage;
import it.polimi.ingsw.network.Message.ClientToServer.MovePawnToDiningMessage;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SchoolBoard0Controller {
    Gui gui;

    public void setGui(Gui gui){this.gui=gui;}

    @FXML Pane schoolBoard0;

    public Pane getSchoolBoard0(){return schoolBoard0;}

    public void setSchoolBoard0(){
        setAllInvisible();
        setEntrance0();
        setDiningRoom0();
        int n;
        n=gui.getLightGame().getProfTable().getRedProf();
        if(n==0){
            setRedProfessor0(true);
        }
        n=gui.getLightGame().getProfTable().getPinkProf();
        if(n==0){
            setPinkProfessor0(true);
        }
        n=gui.getLightGame().getProfTable().getGreenProf();
        if(n==0){
            setGreenProfessor0(true);
        }
        n=gui.getLightGame().getProfTable().getBlueProf();
        if(n==0){setBlueProfessor0(true);
        }
        n=gui.getLightGame().getProfTable().getYellowProf();
        if(n==0){
            setYellowProfessor0(true);
        }
        setTower0();
        setCoin0();
    }

    /**sets all the images on the school board invisible except the schoolBoard's images
     */
    public void setAllInvisible(){
        for(Node all : schoolBoard0.getChildren()) {
            all.setVisible(false);
            all.setDisable(true);
            if(all.getId().equals("backSchool0"))
                all.setVisible(true);
        }
    }

    /**sets all the images disabled for the click
     */
    public void setAllDisabled(){
        for(Node all : schoolBoard0.getChildren()) {
            all.setDisable(true);
            if(all.getId().equals("backSchool0"))
                all.setVisible(true);
        }
    }

    /**sets the pawns on the entrance clickable at the begging of the game
     */
    public void setEntrance0Clickable(){
        setEntrance0();
        int green = gui.getLightGame().getPlayers().get(0).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++)
            schoolBoard0.lookup("#entranceGreen0"+ i).setDisable(false);
        int red = gui.getLightGame().getPlayers().get(0).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++)
            schoolBoard0.lookup("#entranceRed0"+ i).setDisable(false);
        int yellow = gui.getLightGame().getPlayers().get(0).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++)
            schoolBoard0.lookup("#entranceYellow0" + i).setDisable(false);
        int pink = gui.getLightGame().getPlayers().get(0).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++)
            schoolBoard0.lookup("#entrancePink0"+ i).setDisable(false);
        int blue = gui.getLightGame().getPlayers().get(0).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++)
            schoolBoard0.lookup("#entranceBlue0"+ i).setDisable(false);

    }

    /**sets the pawns on the entrance not clickable
     */
    public void setEntrance0NOTClickable(){
        int green = gui.getLightGame().getPlayers().get(0).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++)
            schoolBoard0.lookup("#entranceGreen0"+ i).setDisable(true);
        int red = gui.getLightGame().getPlayers().get(0).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++)
            schoolBoard0.lookup("#entranceRed0"+ i).setDisable(true);
        int yellow = gui.getLightGame().getPlayers().get(0).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++)
            schoolBoard0.lookup("#entranceYellow0" + i).setDisable(true);
        int pink = gui.getLightGame().getPlayers().get(0).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++)
            schoolBoard0.lookup("#entrancePink0"+ i).setDisable(true);
        int blue = gui.getLightGame().getPlayers().get(0).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++)
            schoolBoard0.lookup("#entranceBlue0"+ i).setDisable(true);

    }

    /**sets the pawns visible on the entrance
     */
    public void setEntrance0(){
        int green = gui.getLightGame().getPlayers().get(0).getEntrance().getGreenPawn();
        for(int i=0; i<green; i++)
            schoolBoard0.lookup("#entranceGreen0"+ i).setVisible(true);

        int red = gui.getLightGame().getPlayers().get(0).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++)
            schoolBoard0.lookup("#entranceRed0"+ i).setVisible(true);

        int yellow = gui.getLightGame().getPlayers().get(0).getEntrance().getYellowPawn() + red;
        for(int i=red; i<yellow; i++)
            schoolBoard0.lookup("#entranceYellow0"+ i).setVisible(true);

        int pink = gui.getLightGame().getPlayers().get(0).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++)
            schoolBoard0.lookup("#entrancePink0"+ i).setVisible(true);

        int blue = gui.getLightGame().getPlayers().get(0).getEntrance().getBluePawn() + pink;
        for(int i=pink; i<blue; i++)
            schoolBoard0.lookup("#entranceBlue0"+ i).setVisible(true);
    }

    /**sets visible the pawns of the dining room
     */
    public void setDiningRoom0(){
        int green = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumGreen();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolBoard0Green" + i))
                    school.setVisible(true);
            }
        }
        int red = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumRed();
        for(int i=0; i<red; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolBoard0Red" + i))
                    school.setVisible(true);
            }
        }
        int yellow = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumYellow();
        for(int i=0; i<yellow; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolBoard0Yellow" + i))
                    school.setVisible(true);
            }
        }
        int pink = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumPink();
        for(int i=0; i<pink; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolBoard0Pink" + i))
                    school.setVisible(true);
            }
        }
        int blue = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumBlue();
        for(int i=0; i<blue; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolBoard0Blue" + i))
                    school.setVisible(true);
            }
        }
    }

    /**sets visible the Professor on the schoolPlayer that owns it
     * @param bool true if visible, false if not
     */

    public void setGreenProfessor0(boolean bool){
        schoolBoard0.lookup("#schoolGreenProf0").setVisible(bool);
    }
    public void setRedProfessor0(boolean bool){
        schoolBoard0.lookup("#schoolRedProf0").setVisible(bool);
    }
    public void setYellowProfessor0(boolean bool){
        schoolBoard0.lookup("#schoolYellowProf0").setVisible(bool);
    }
    public void setPinkProfessor0(boolean bool){
        schoolBoard0.lookup("#schoolPinkProf0").setVisible(bool);
    }
    public void setBlueProfessor0(boolean bool){
        schoolBoard0.lookup("#schoolBlueProf0").setVisible(bool);
    }

    /**sets the professor visible
     * @param numColor the number corresponds to the color of the professor
     *                 0 = green, 1 = red, 2 = yellow, 3 = pink, 4 = blue
     * @param bool true if visible, false if not
     */
    public void setProfessor0(int numColor, boolean bool){
        if(numColor == 0)
            setGreenProfessor0(bool);
        if(numColor == 1)
            setRedProfessor0(bool);
        if(numColor == 2)
            setYellowProfessor0(bool);
        if(numColor == 3)
            setPinkProfessor0(bool);
        if(numColor == 4)
            setBlueProfessor0(bool);
    }

    /**sets visible the towers on the schoolBoards
     */
    public void setTower0(){
        for(int i = 0; i<gui.getLightGame().getPlayers().get(0).getTowerSpace().getNumTower(); i++)
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("whiteTowerSchool" + i))
                    school.setVisible(true);
            }
    }

    /**sets the coins visible
     */
    public void setCoin0() {
        for (int i = 0; i < gui.getLightGame().getPlayers().get(0).getNumCoin(); i++)
            for(Node schoolBoard0 : schoolBoard0.getChildren()) {
                if (schoolBoard0.getId().equals("coin" + i))
                    schoolBoard0.setVisible(true);
            }
    }

    /**when the first green pawn of the entrance is clicked becomes invisible and not clickable
     * the function calls the method selection at the line 560
     */
    public void green00Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceGreen00").setVisible(false);
        schoolBoard0.lookup("#entranceGreen00").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green01Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceGreen01").setVisible(false);
        schoolBoard0.lookup("#entranceGreen01").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green02Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceGreen02").setVisible(false);
        schoolBoard0.lookup("#entranceGreen02").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green03Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceGreen03").setVisible(false);
        schoolBoard0.lookup("#entranceGreen03").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green04Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceGreen04").setVisible(false);
        schoolBoard0.lookup("#entranceGreen04").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green05Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceGreen05").setVisible(false);
        schoolBoard0.lookup("#entranceGreen05").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green06Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceGreen06").setVisible(false);
        schoolBoard0.lookup("#entranceGreen06").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green07Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceGreen07").setVisible(false);
        schoolBoard0.lookup("#entranceGreen07").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green08Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceGreen08").setVisible(false);
        schoolBoard0.lookup("#entranceGreen08").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void red00Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceRed00").setVisible(false);
        schoolBoard0.lookup("#entranceRed00").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red01Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceRed01").setVisible(false);
        schoolBoard0.lookup("#entranceRed01").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red02Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceRed02").setVisible(false);
        schoolBoard0.lookup("#entranceRed02").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red03Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceRed03").setVisible(false);
        schoolBoard0.lookup("#entranceRed03").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red04Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceRed04").setVisible(false);
        schoolBoard0.lookup("#entranceRed04").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red05Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceRed05").setVisible(false);
        schoolBoard0.lookup("#entranceRed05").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red06Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceRed06").setVisible(false);
        schoolBoard0.lookup("#entranceRed06").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red07Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceRed07").setVisible(false);
        schoolBoard0.lookup("#entranceRed07").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red08Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceRed08").setVisible(false);
        schoolBoard0.lookup("#entranceRed08").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void yellow00Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceYellow00").setVisible(false);
        schoolBoard0.lookup("#entranceYellow00").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow01Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceYellow01").setVisible(false);
        schoolBoard0.lookup("#entranceYellow01").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow02Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceYellow02").setVisible(false);
        schoolBoard0.lookup("#entranceYellow02").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow03Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceYellow03").setVisible(false);
        schoolBoard0.lookup("#entranceYellow03").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow04Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceYellow04").setVisible(false);
        schoolBoard0.lookup("#entranceYellow04").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow05Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceYellow05").setVisible(false);
        schoolBoard0.lookup("#entranceYellow05").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow06Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceYellow06").setVisible(false);
        schoolBoard0.lookup("#entranceYellow06").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow07Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceYellow07").setVisible(false);
        schoolBoard0.lookup("#entranceYellow07").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow08Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceYellow08").setVisible(false);
        schoolBoard0.lookup("#entranceYellow08").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void pink00Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entrancePink00").setVisible(false);
        schoolBoard0.lookup("#entrancePink00").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink01Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entrancePink01").setVisible(false);
        schoolBoard0.lookup("#entrancePink01").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink02Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entrancePink02").setVisible(false);
        schoolBoard0.lookup("#entrancePink02").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink03Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entrancePink03").setVisible(false);
        schoolBoard0.lookup("#entrancePink03").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink04Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entrancePink04").setVisible(false);
        schoolBoard0.lookup("#entrancePink04").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink05Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entrancePink05").setVisible(false);
        schoolBoard0.lookup("#entrancePink05").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink06Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entrancePink06").setVisible(false);
        schoolBoard0.lookup("#entrancePink06").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink07Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entrancePink07").setVisible(false);
        schoolBoard0.lookup("#entrancePink07").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink08Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entrancePink08").setVisible(false);
        schoolBoard0.lookup("#entrancePink08").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void blue00Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceBlue00").setVisible(false);
        schoolBoard0.lookup("#entranceBlue00").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue01Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceBlue01").setVisible(false);
        schoolBoard0.lookup("#entranceBlue01").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue02Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceBlue02").setVisible(false);
        schoolBoard0.lookup("#entranceBlue02").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue03Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceBlue03").setVisible(false);
        schoolBoard0.lookup("#entranceBlue03").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue04Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceBlue04").setVisible(false);
        schoolBoard0.lookup("#entranceBlue04").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue05Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceBlue05").setVisible(false);
        schoolBoard0.lookup("#entranceBlue05").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue06Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceBlue06").setVisible(false);
        schoolBoard0.lookup("#entranceBlue06").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue07Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceBlue07").setVisible(false);
        schoolBoard0.lookup("#entranceBlue07").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue08Select(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#entranceBlue08").setVisible(false);
        schoolBoard0.lookup("#entranceBlue08").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    /**if a pawn of the entrance is selected after the click of button "MoveToDining" of the actions
     * sends a message with the num of pawns selected and an arrayList of colors selected.
     * if a pawn of the entrance is selected after the click of button "MoveToIsland"
     * sets the island clickable in order to be able to move the pawns selected to the island
     */
    public void selection(){
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            for(int i=0; i<gui.getLightGame().getIslands().size(); i++)
                gui.getGameTable().getGameTablePane().lookup("#island"+ i).setDisable(false);
            if(gui.getNumPawnsCount()==0)
                for(Node school : schoolBoard0.getChildren())
                    school.setDisable(true);
            if(gui.getPedineDaSpostare()==0)
                gui.setPedineDaSpostare(gui.getNumPawnMove());
        }else if(gui.getButtonClicked().equals(ButtonAction.DININGROOM)){
            if(gui.getNumPawnsCount()==0){
                for(Node school : schoolBoard0.getChildren()){
                    school.setDisable(true);
                }
                gui.getSocketNetworkHandler().sendMessage(new MovePawnToDiningMessage(gui.getNumPawns(), gui.getColorPawns()));
                gui.getColorPawns().clear();
                gui.getSchoolBoard0Controller().setDiningRoom0();
                gui.getGameTable().getShowSchool0().setCenter(gui.getSchoolBoard0Controller().getSchoolBoard0());
                gui.getGameTable().getShowSchool0().setVisible(true);
                gui.setPedineDaSpostare(gui.getPedineDaSpostare()- gui.getNumPawns());
            }
            if(gui.getPedineDaSpostare()==0)
                gui.setPedineDaSpostare(gui.getNumPawnMove());
        }else if(gui.getButtonClicked().equals(ButtonAction.GIUSEPPE)){
            int i;
            for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=6; i++);
            if(gui.getNumPawnsCount() == 0){
                gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
                gui.getColorPawns().clear();
                gui.setVar(true);
            }
        }else if(gui.getButtonClicked().equals(ButtonAction.MARIA)){
            if(gui.getNumPawnsCount() == gui.getNumPawns()/2){
                gui.getGameTable().whatToDo.setText("Select Pawn from Dining");
                setEntrance0NOTClickable();
                int green = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumGreen();
                for(int i = 0; i < green; i++)
                    schoolBoard0.lookup("#schoolBoard0Green" + i).setDisable(false);
                int red = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumRed();
                for(int i = 0; i < red; i++)
                    schoolBoard0.lookup("#schoolBoard0Red" + i).setDisable(false);
                int yellow = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumYellow();
                for(int i = 0; i < yellow; i++)
                    schoolBoard0.lookup("#schoolBoard0Yellow" + i).setDisable(false);
                int pink = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumPink();
                for(int i = 0; i < pink; i++)
                    schoolBoard0.lookup("#schoolBoard0Pink" + i).setDisable(false);
                int blue = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumBlue();
                for(int i = 0; i < blue; i++)
                    schoolBoard0.lookup("#schoolBoard0Blue" + i).setDisable(false);
            }
        }
    }

    /**This function is used only if a green pawn of the DiningRoom is clickable: the last pawn become invisible and is activated the effect of the CC n°9
     */
    public void selectSchoolGreen0(MouseEvent mouseEvent) {
        int i;
        for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=9; i++);
        gui.getColorPawns().add(ColorPawn.GREEN);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        int green = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumGreen();
        if(schoolBoard0.lookup("#schoolBoard0Green" + (green - 1)).isVisible()) {
            schoolBoard0.lookup("#schoolBoard0Green" + (green - 1)).setVisible(false);
            schoolBoard0.lookup("#schoolBoard0Green" + (green - 1)).setDisable(true);
        }else if(schoolBoard0.lookup("#schoolBoard0Green" + (green - 2)).isVisible()){
            schoolBoard0.lookup("#schoolBoard0Green" + (green - 2)).setVisible(false);
            schoolBoard0.lookup("#schoolBoard0Green" + (green - 2)).setDisable(true);
        }else{
            schoolBoard0.lookup("#schoolBoard0Green" + (green - 3)).setVisible(false);
            schoolBoard0.lookup("#schoolBoard0Green" + (green - 3)).setDisable(true);
        }
        if(gui.getNumPawnsCount() == 0){
            setAllDisabled();
            gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
            gui.getColorPawns().clear();
            gui.setVar(true);
        }
    }

    /**This function is used only if a red pawn of the DiningRoom is clickable: the last pawn become invisible and is activated the effect of the CC n°9
     */
    public void selectSchoolRed0(MouseEvent mouseEvent) {
        int i;
        for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=9; i++);
        gui.getColorPawns().add(ColorPawn.RED);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        int red = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumRed();
        if(schoolBoard0.lookup("#schoolBoard0Red" + (red - 1)).isVisible()) {
            schoolBoard0.lookup("#schoolBoard0Red" + (red - 1)).setVisible(false);
            schoolBoard0.lookup("#schoolBoard0Red" + (red - 1)).setDisable(true);
        }else if(schoolBoard0.lookup("#schoolBoard0Red" + (red - 2)).isVisible()){
            schoolBoard0.lookup("#schoolBoard0Red" + (red - 2)).setVisible(false);
            schoolBoard0.lookup("#schoolBoard0Red" + (red - 2)).setDisable(true);
        }else{
            schoolBoard0.lookup("#schoolBoard0Red" + (red - 3)).setVisible(false);
            schoolBoard0.lookup("#schoolBoard0Red" + (red - 3)).setDisable(true);
        }
        if(gui.getNumPawnsCount() == 0){
            setAllDisabled();
            gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
            gui.getColorPawns().clear();
            gui.setVar(true);
        }
    }

    /**This function is used only if a yellow pawn of the DiningRoom is clickable: the last pawn become invisible and is activated the effect of the CC n°9
     */

    public void selectSchoolYellow0(MouseEvent mouseEvent) {
        int i;
        for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=9; i++);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        int yellow = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumYellow();
        if(schoolBoard0.lookup("#schoolBoard0Yellow" + (yellow - 1)).isVisible()) {
            schoolBoard0.lookup("#schoolBoard0Yellow" + (yellow - 1)).setVisible(false);
            schoolBoard0.lookup("#schoolBoard0Yellow" + (yellow - 1)).setDisable(true);
        }else if(schoolBoard0.lookup("#schoolBoard0Yellow" + (yellow - 2)).isVisible()){
            schoolBoard0.lookup("#schoolBoard0Yellow" + (yellow - 2)).setVisible(false);
            schoolBoard0.lookup("#schoolBoard0Yellow" + (yellow - 2)).setDisable(true);
        }else{
            schoolBoard0.lookup("#schoolBoard0Yellow" + (yellow - 3)).setVisible(false);
            schoolBoard0.lookup("#schoolBoard0Yellow" + (yellow - 3)).setDisable(true);
        }
        if(gui.getNumPawnsCount() == 0){
            setAllDisabled();
            gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
            gui.getColorPawns().clear();
            gui.setVar(true);
        }
    }

    /**This function is used only if a pink pawn of the DiningRoom is clickable: the last pawn become invisible and is activated the effect of the CC n°9
     */

    public void selectSchoolPink0(MouseEvent mouseEvent) {
        int i;
        for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=9; i++);
        gui.getColorPawns().add(ColorPawn.PINK);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        int pink = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumPink();
        if(schoolBoard0.lookup("#schoolBoard0Pink" + (pink - 1)).isVisible()) {
            schoolBoard0.lookup("#schoolBoard0Pink" + (pink - 1)).setVisible(false);
            schoolBoard0.lookup("#schoolBoard0Pink" + (pink - 1)).setDisable(true);
        }else if(schoolBoard0.lookup("#schoolBoard0Pink" + (pink - 2)).isVisible()){
            schoolBoard0.lookup("#schoolBoard0Pink" + (pink - 2)).setVisible(false);
            schoolBoard0.lookup("#schoolBoard0Pink" + (pink - 2)).setDisable(true);
        }else{
            schoolBoard0.lookup("#schoolBoard0Pink" + (pink - 3)).setVisible(false);
            schoolBoard0.lookup("#schoolBoard0Pink" + (pink - 3)).setDisable(true);
        }
        if(gui.getNumPawnsCount() == 0){
            setAllDisabled();
            gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
            gui.getColorPawns().clear();
            gui.setVar(true);
        }
    }

    /**This function is used only if a blue pawn of the DiningRoom is clickable: the last pawn become invisible and is activated the effect of the CC n°9
     */
    public void selectSchoolBlue0(MouseEvent mouseEvent) {
        int i;
        for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=9; i++);
        gui.getColorPawns().add(ColorPawn.BLUE);
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        int blue = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumBlue();
        if(schoolBoard0.lookup("#schoolBoard0Blue" + (blue - 1)).isVisible()) {
            schoolBoard0.lookup("#schoolBoard0Blue" + (blue - 1)).setVisible(false);
            schoolBoard0.lookup("#schoolBoard0Blue" + (blue - 1)).setDisable(true);
        }else if(schoolBoard0.lookup("#schoolBoard0Blue" + (blue - 2)).isVisible()){
            schoolBoard0.lookup("#schoolBoard0Blue" + (blue - 2)).setVisible(false);
            schoolBoard0.lookup("#schoolBoard0Blue" + (blue - 2)).setDisable(true);
        }else{
            schoolBoard0.lookup("#schoolBoard0Blue" + (blue - 3)).setVisible(false);
            schoolBoard0.lookup("#schoolBoard0Blue" + (blue - 3)).setDisable(true);
        }
        if(gui.getNumPawnsCount() == 0){
            setAllDisabled();
            gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
            gui.getColorPawns().clear();
            gui.setVar(true);
        }
    }
}