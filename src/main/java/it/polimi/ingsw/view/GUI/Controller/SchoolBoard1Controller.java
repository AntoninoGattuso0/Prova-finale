package it.polimi.ingsw.view.GUI.Controller;
import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.network.Message.ClientToServer.ChooseCharacterCardMessage;
import it.polimi.ingsw.network.Message.ClientToServer.MovePawnToDiningMessage;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class SchoolBoard1Controller {
    Gui gui;

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    @FXML
    Pane schoolBoard1;

    public Pane getSchoolBoard1() {
        return schoolBoard1;
    }

    public void setSchoolBoard1() {
        setAllInvisible();
        setEntrance1();
        setDiningRoom1();
        setTower1();
        int n;
        n = gui.getLightGame().getProfTable().getRedProf();
        if (n == 1) {
            setRedProfessor1(true);
        }
        n = gui.getLightGame().getProfTable().getPinkProf();
        if (n == 1) {
            setPinkProfessor1(true);
        }
        n = gui.getLightGame().getProfTable().getGreenProf();
        if (n == 1) {
            setGreenProfessor1(true);
        }
        n = gui.getLightGame().getProfTable().getBlueProf();
        if (n == 1) {
            setBlueProfessor1(true);
        }
        n = gui.getLightGame().getProfTable().getYellowProf();
        if (n == 1) {
            setYellowProfessor1(true);
        }
        setCoin1();
    }

    /**sets all the images on the school board invisible except the schoolBoard's images
     */
    public void setAllInvisible() {
        for (Node all : schoolBoard1.getChildren()) {
            all.setVisible(false);
            all.setDisable(true);
            if (all.getId().equals("backSchool1"))
                all.setVisible(true);
        }
    }

    /**sets the pawns on the entrance clickable at the begging of the game
     */
    public void setEntrance1Clickable() {
        setEntrance1();
        int green = gui.getLightGame().getPlayers().get(1).getEntrance().getGreenPawn();
        for (int i = 0; i < green; i++) {
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceGreen1" + i))
                    school.setDisable(false);
            }
        }

        int red = gui.getLightGame().getPlayers().get(1).getEntrance().getRedPawn() + green;
        for (int i = green; i < red; i++) {
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceRed1" + i))
                    school.setDisable(false);
            }
        }
        int yellow = gui.getLightGame().getPlayers().get(1).getEntrance().getYellowPawn() + red;
        for (int i = red; i < yellow; i++) {
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceYellow1" + i))
                    school.setDisable(false);
            }
        }
        int pink = gui.getLightGame().getPlayers().get(1).getEntrance().getPinkPawn() + yellow;
        for (int i = yellow; i < pink; i++) {
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entrancePink1" + i))
                    school.setDisable(false);
            }
        }
        int blue = gui.getLightGame().getPlayers().get(1).getEntrance().getBluePawn() + pink;
        for (int i = pink; i < blue; i++) {
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceBlue1" + i))
                    school.setDisable(false);
            }
        }
    }

    /**sets the pawns on the entrance not clickable
     */
    public void setEntrance1NOTClickable(){
        int green = gui.getLightGame().getPlayers().get(1).getEntrance().getGreenPawn();
        for (int i = 0; i < green; i++) {
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceGreen1" + i))
                    school.setDisable(true);
            }
        }

        int red = gui.getLightGame().getPlayers().get(1).getEntrance().getRedPawn() + green;
        for (int i = green; i < red; i++) {
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceRed1" + i))
                    school.setDisable(true);
            }
        }
        int yellow = gui.getLightGame().getPlayers().get(1).getEntrance().getYellowPawn() + red;
        for (int i = red; i < yellow; i++) {
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceYellow1" + i))
                    school.setDisable(true);
            }
        }
        int pink = gui.getLightGame().getPlayers().get(1).getEntrance().getPinkPawn() + yellow;
        for (int i = yellow; i < pink; i++) {
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entrancePink1" + i))
                    school.setDisable(true);
            }
        }
        int blue = gui.getLightGame().getPlayers().get(1).getEntrance().getBluePawn() + pink;
        for (int i = pink; i < blue; i++) {
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("entranceBlue1" + i))
                    school.setDisable(true);
            }
        }
    }

    /**sets the pawns visible on the entrance
     */
    public void setEntrance1() {
        int green = gui.getLightGame().getPlayers().get(1).getEntrance().getGreenPawn();
        for (int i = 0; i < green; i++)
            schoolBoard1.lookup("#entranceGreen1" + i).setVisible(true);

        int red = gui.getLightGame().getPlayers().get(1).getEntrance().getRedPawn() + green;
        for (int i = green; i < red; i++)
            schoolBoard1.lookup("#entranceRed1" + i).setVisible(true);

        int yellow = gui.getLightGame().getPlayers().get(1).getEntrance().getYellowPawn() + red;
        for (int i = red; i < yellow; i++)
            schoolBoard1.lookup("#entranceYellow1" + i).setVisible(true);

        int pink = gui.getLightGame().getPlayers().get(1).getEntrance().getPinkPawn() + yellow;
        for (int i = yellow; i < pink; i++)
            schoolBoard1.lookup("#entrancePink1" + i).setVisible(true);

        int blue = gui.getLightGame().getPlayers().get(1).getEntrance().getBluePawn() + pink;
        for (int i = pink; i < blue; i++)
            schoolBoard1.lookup("#entranceBlue1" + i).setVisible(true);
    }

    /**sets visible the pawns of the dining room
     */
    public void setDiningRoom1() {
        int green = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumGreen();
        for (int i = 0; i < green; i++) {
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolBoard1Green" + i))
                    school.setVisible(true);
            }
        }
        int red = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumRed();
        for (int i = 0; i < red; i++) {
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolBoard1Red" + i))
                    school.setVisible(true);
            }
        }
        int yellow = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumYellow();
        for (int i = 0; i < yellow; i++) {
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolBoard1Yellow" + i))
                    school.setVisible(true);
            }
        }
        int pink = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumPink();
        for (int i = 0; i < pink; i++) {
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolBoard1Pink" + i))
                    school.setVisible(true);
            }
        }
        int blue = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumBlue();
        for (int i = 0; i < blue; i++) {
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("schoolBoard1Blue" + i))
                    school.setVisible(true);
            }
        }
    }

    /**sets visible the Professor on the schoolPlayer that owns it
     * @param bool true if visible, false if not
     */
    public void setGreenProfessor1(boolean bool) {
        schoolBoard1.lookup("#schoolGreenProf1").setVisible(bool);
    }

    public void setRedProfessor1(boolean bool) {
        schoolBoard1.lookup("#schoolRedProf1").setVisible(bool);
    }

    public void setYellowProfessor1(boolean bool) {
        schoolBoard1.lookup("#schoolYellowProf1").setVisible(bool);
    }

    public void setPinkProfessor1(boolean bool) {
        schoolBoard1.lookup("#schoolPinkProf1").setVisible(bool);
    }

    public void setBlueProfessor1(boolean bool) {
        schoolBoard1.lookup("#schoolBlueProf1").setVisible(bool);
    }
    /**sets the professor visible
     * @param numColor the number corresponds to the color of the professor
     *                 0 = green, 1 = red, 2 = yellow, 3 = pink, 4 = blue
     * @param bool true if visible, false if not
     */
    public void setProfessor1(int numColor, boolean bool) {
        if (numColor == 0)
            setGreenProfessor1(bool);
        if (numColor == 1)
            setRedProfessor1(bool);
        if (numColor == 2)
            setYellowProfessor1(bool);
        if (numColor == 3)
            setPinkProfessor1(bool);
        if (numColor == 4)
            setBlueProfessor1(bool);
    }

    /**sets visible the towers on the schoolBoards
     */
    public void setTower1() {
        for (int i = 0; i < gui.getLightGame().getPlayers().get(1).getTowerSpace().getNumTower(); i++)
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("blackTowerSchool" + i))
                    school.setVisible(true);
            }
    }

    /**sets the coins visible
     */
    public void setCoin1() {
        for (int i = 0; i < gui.getLightGame().getPlayers().get(1).getNumCoin(); i++)
            for (Node school : schoolBoard1.getChildren()) {
                if (school.getId().equals("coin" + i))
                    school.setVisible(true);
            }
    }

    public void coinVisibility1(boolean bool, int numCoin) {
        for (Node school : schoolBoard1.getChildren()) {
            if (schoolBoard1.getId().equals("coin" + numCoin))
                school.setVisible(bool);
        }
    }

    public void green10Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen10").setVisible(false);
        schoolBoard1.lookup("#entranceGreen10").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green11Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen11").setVisible(false);
        schoolBoard1.lookup("#entranceGreen11").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green12Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen12").setVisible(false);
        schoolBoard1.lookup("#entranceGreen12").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green13Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen13").setVisible(false);
        schoolBoard1.lookup("#entranceGreen13").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green14Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen14").setVisible(false);
        schoolBoard1.lookup("#entranceGreen14").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green15Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen15").setVisible(false);
        schoolBoard1.lookup("#entranceGreen15").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green16Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen16").setVisible(false);
        schoolBoard1.lookup("#entranceGreen16").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green17Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen17").setVisible(false);
        schoolBoard1.lookup("#entranceGreen17").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void green18Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceGreen18").setVisible(false);
        schoolBoard1.lookup("#entranceGreen18").setDisable(true);
        gui.getColorPawns().add(ColorPawn.GREEN);
        selection();
    }

    public void red10Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed10").setVisible(false);
        schoolBoard1.lookup("#entranceRed10").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red11Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed11").setVisible(false);
        schoolBoard1.lookup("#entranceRed11").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red12Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed12").setVisible(false);
        schoolBoard1.lookup("#entranceRed12").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red13Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed13").setVisible(false);
        schoolBoard1.lookup("#entranceRed13").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red14Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed14").setVisible(false);
        schoolBoard1.lookup("#entranceRed14").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red15Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed15").setVisible(false);
        schoolBoard1.lookup("#entranceRed15").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red16Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed16").setVisible(false);
        schoolBoard1.lookup("#entranceRed16").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red17Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed17").setVisible(false);
        schoolBoard1.lookup("#entranceRed17").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void red18Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceRed18").setVisible(false);
        schoolBoard1.lookup("#entranceRed18").setDisable(true);
        gui.getColorPawns().add(ColorPawn.RED);
        selection();
    }

    public void yellow10Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow10").setVisible(false);
        schoolBoard1.lookup("#entranceYellow10").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow11Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow11").setVisible(false);
        schoolBoard1.lookup("#entranceYellow11").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow12Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow12").setVisible(false);
        schoolBoard1.lookup("#entranceYellow12").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow13Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow13").setVisible(false);
        schoolBoard1.lookup("#entranceYellow13").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow14Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow14").setVisible(false);
        schoolBoard1.lookup("#entranceYellow14").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow15Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow15").setVisible(false);
        schoolBoard1.lookup("#entranceYellow15").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow16Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow16").setVisible(false);
        schoolBoard1.lookup("#entranceYellow16").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow17Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow17").setVisible(false);
        schoolBoard1.lookup("#entranceYellow17").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void yellow18Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceYellow18").setVisible(false);
        schoolBoard1.lookup("#entranceYellow18").setDisable(true);
        gui.getColorPawns().add(ColorPawn.YELLOW);
        selection();
    }

    public void pink10Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink10").setVisible(false);
        schoolBoard1.lookup("#entrancePink10").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink11Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink11").setVisible(false);
        schoolBoard1.lookup("#entrancePink11").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink12Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink12").setVisible(false);
        schoolBoard1.lookup("#entrancePink12").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink13Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink13").setVisible(false);
        schoolBoard1.lookup("#entrancePink13").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink14Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink14").setVisible(false);
        schoolBoard1.lookup("#entrancePink14").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink15Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink15").setVisible(false);
        schoolBoard1.lookup("#entrancePink15").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink16Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink16").setVisible(false);
        schoolBoard1.lookup("#entrancePink16").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink17Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink17").setVisible(false);
        schoolBoard1.lookup("#entrancePink17").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void pink18Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entrancePink18").setVisible(false);
        schoolBoard1.lookup("#entrancePink18").setDisable(true);
        gui.getColorPawns().add(ColorPawn.PINK);
        selection();
    }

    public void blue10Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue10").setVisible(false);
        schoolBoard1.lookup("#entranceBlue10").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue11Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue11").setVisible(false);
        schoolBoard1.lookup("#entranceBlue11").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue12Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue12").setVisible(false);
        schoolBoard1.lookup("#entranceBlue12").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue13Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue13").setVisible(false);
        schoolBoard1.lookup("#entranceBlue13").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue14Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue14").setVisible(false);
        schoolBoard1.lookup("#entranceBlue14").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue15Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue15").setVisible(false);
        schoolBoard1.lookup("#entranceBlue15").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue16Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue16").setVisible(false);
        schoolBoard1.lookup("#entranceBlue16").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue17Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue17").setVisible(false);
        schoolBoard1.lookup("#entranceBlue17").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void blue18Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("#entranceBlue18").setVisible(false);
        schoolBoard1.lookup("#entranceBlue18").setDisable(true);
        gui.getColorPawns().add(ColorPawn.BLUE);
        selection();
    }

    public void selection() {
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        if (gui.getButtonClicked().equals(ButtonAction.ISLAND)) {
            for (int i = 0; i < gui.getLightGame().getIslands().size(); i++)
                gui.getGameTable().getGameTablePane().lookup("#island" + i).setDisable(false);
            if (gui.getNumPawnsCount() == 0)
                for (Node school : schoolBoard1.getChildren())
                    school.setDisable(true);
            if (gui.getPedineDaSpostare() == 0) {
                gui.setPedineDaSpostare(gui.getNumPawnMove());
            }
        } else if (gui.getButtonClicked().equals(ButtonAction.DININGROOM)) {
            if (gui.getNumPawnsCount() == 0) {
                for (Node school : schoolBoard1.getChildren()) {
                    school.setDisable(true);
                }
                gui.getSocketNetworkHandler().sendMessage(new MovePawnToDiningMessage(gui.getNumPawns(), gui.getColorPawns()));
                gui.getColorPawns().clear();
                gui.getSchoolBoard1Controller().setDiningRoom1();
                gui.getGameTable().getShowSchool1().setCenter(gui.getSchoolBoard1Controller().getSchoolBoard1());
                gui.getGameTable().getShowSchool1().setVisible(true);
                gui.setPedineDaSpostare(gui.getPedineDaSpostare() - gui.getNumPawns());
            }
            if (gui.getPedineDaSpostare() == 0)
                gui.setPedineDaSpostare(gui.getNumPawnMove());
        } else if (gui.getButtonClicked().equals(ButtonAction.GIUSEPPE)) {
            int i;
            for (i = 0; i < 3 && gui.getLightGame().getCharacterCards().get(i).getNumCard() != 6; i++) ;
            if (gui.getNumPawnsCount() == 0) {
                gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns() / 2, gui.getIslandSelected(), gui.getColorPawns(), true));
                gui.getColorPawns().clear();
                gui.setVar(true);
            }
        } else if (gui.getButtonClicked().equals(ButtonAction.MARIA)) {
            System.out.println("ho cliccato una pedina nel entrata");
            if (gui.getNumPawnsCount() == gui.getNumPawns() / 2) {
                gui.getGameTable().whatToDo.setText("Select Pawn from Dining");
                setEntrance1NOTClickable();
                int green = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumGreen();
                for (int i = 0; i < green; i++)
                    schoolBoard1.lookup("#schoolBoard1Green" + i).setDisable(false);
                int red = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumRed();
                for (int i = 0; i < red; i++)
                    schoolBoard1.lookup("#schoolBoard1Red" + i).setDisable(false);
                int yellow = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumYellow();
                for (int i = 0; i < yellow; i++)
                    schoolBoard1.lookup("#schoolBoard1Yellow" + i).setDisable(false);
                int pink = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumPink();
                for (int i = 0; i < pink; i++)
                    schoolBoard1.lookup("#schoolBoard1Pink" + i).setDisable(false);
                int blue = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumBlue();
                for (int i = 0; i < blue; i++)
                    schoolBoard1.lookup("#schoolBoard1Blue" + i).setDisable(false);
            }
        }
    }
            public void selectSchoolGreen1(MouseEvent mouseEvent) {
                int i;
                for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=9; i++);
                gui.getColorPawns().add(ColorPawn.GREEN);
                gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
                int green = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumGreen();
                if(schoolBoard1.lookup("#schoolBoard1Green" + (green - 1)).isVisible()) {
                    schoolBoard1.lookup("#schoolBoard1Green" + (green - 1)).setVisible(false);
                    schoolBoard1.lookup("#schoolBoard1Green" + (green - 1)).setDisable(true);
                }else if(schoolBoard1.lookup("#schoolBoard1Green" + (green - 2)).isVisible()){
                    schoolBoard1.lookup("#schoolBoard1Green" + (green - 2)).setVisible(false);
                    schoolBoard1.lookup("#schoolBoard1Green" + (green - 2)).setDisable(true);
                }else{
                    schoolBoard1.lookup("#schoolBoard1Green" + (green - 3)).setVisible(false);
                    schoolBoard1.lookup("#schoolBoard1Green" + (green - 3)).setDisable(true);
                }
                if(gui.getNumPawnsCount() == 0){
                    setAllDisabled();
                    gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
                    gui.getColorPawns().clear();
                    gui.setVar(true);
                }
            }

            public void selectSchoolRed1(MouseEvent mouseEvent) {
                int i;
                for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=9; i++);
                gui.getColorPawns().add(ColorPawn.RED);
                gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
                int red = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumRed();
                if(schoolBoard1.lookup("#schoolBoard1Red" + (red - 1)).isVisible()) {
                    schoolBoard1.lookup("#schoolBoard1Red" + (red - 1)).setVisible(false);
                    schoolBoard1.lookup("#schoolBoard1Red" + (red - 1)).setDisable(true);
                }else if(schoolBoard1.lookup("#schoolBoard1Red" + (red - 2)).isVisible()){
                    schoolBoard1.lookup("#schoolBoard1Red" + (red - 2)).setVisible(false);
                    schoolBoard1.lookup("#schoolBoard1Red" + (red - 2)).setDisable(true);
                }else{
                    schoolBoard1.lookup("#schoolBoard1Red" + (red - 3)).setVisible(false);
                    schoolBoard1.lookup("#schoolBoard1Red" + (red - 3)).setDisable(true);
                }
                if(gui.getNumPawnsCount() == 0){
                    setAllDisabled();
                    gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
                    gui.getColorPawns().clear();
                    gui.setVar(true);
                }
            }

            public void selectSchoolYellow1(MouseEvent mouseEvent) {
                int i;
                for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=9; i++);
                gui.getColorPawns().add(ColorPawn.YELLOW);
                gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
                int yellow = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumYellow();
                if(schoolBoard1.lookup("#schoolBoard1Yellow" + (yellow - 1)).isVisible()) {
                    schoolBoard1.lookup("#schoolBoard1Yellow" + (yellow - 1)).setVisible(false);
                    schoolBoard1.lookup("#schoolBoard1Yellow" + (yellow - 1)).setDisable(true);
                }else if(schoolBoard1.lookup("#schoolBoard1Yellow" + (yellow - 2)).isVisible()){
                    schoolBoard1.lookup("#schoolBoard1Yellow" + (yellow - 2)).setVisible(false);
                    schoolBoard1.lookup("#schoolBoard1Yellow" + (yellow - 2)).setDisable(true);
                }else{
                    schoolBoard1.lookup("#schoolBoard1Yellow" + (yellow - 3)).setVisible(false);
                    schoolBoard1.lookup("#schoolBoard1Yellow" + (yellow - 3)).setDisable(true);
                }
                if(gui.getNumPawnsCount() == 0){
                    setAllDisabled();
                    gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
                    gui.getColorPawns().clear();
                    gui.setVar(true);
                }
            }

            public void selectSchoolPink1(MouseEvent mouseEvent) {
                int i;
                for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=9; i++);
                gui.getColorPawns().add(ColorPawn.PINK);
                gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
                int pink = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumPink();
                if(schoolBoard1.lookup("#schoolBoard1Pink" + (pink - 1)).isVisible()) {
                    schoolBoard1.lookup("#schoolBoard1Pink" + (pink - 1)).setVisible(false);
                    schoolBoard1.lookup("#schoolBoard1Pink" + (pink - 1)).setDisable(true);
                }else if(schoolBoard1.lookup("#schoolBoard1Pink" + (pink - 2)).isVisible()){
                    schoolBoard1.lookup("#schoolBoard1Pink" + (pink - 2)).setVisible(false);
                    schoolBoard1.lookup("#schoolBoard1Pink" + (pink - 2)).setDisable(true);
                }else{
                    schoolBoard1.lookup("#schoolBoard1Pink" + (pink - 3)).setVisible(false);
                    schoolBoard1.lookup("#schoolBoard1Pink" + (pink - 3)).setDisable(true);
                }
                if(gui.getNumPawnsCount() == 0){
                    setAllDisabled();
                    gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
                    gui.getColorPawns().clear();
                    gui.setVar(true);
                }
            }

            public void selectSchoolBlue1(MouseEvent mouseEvent) {
                int i;
                for(i=0; i<3 && gui.getLightGame().getCharacterCards().get(i).getNumCard()!=9; i++);
                gui.getColorPawns().add(ColorPawn.BLUE);
                gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
                int blue = gui.getLightGame().getPlayers().get(1).getDiningRoom().getNumBlue();
                if(schoolBoard1.lookup("#schoolBoard1Blue" + (blue - 1)).isVisible()) {
                    schoolBoard1.lookup("#schoolBoard1Blue" + (blue - 1)).setVisible(false);
                    schoolBoard1.lookup("#schoolBoard1Blue" + (blue - 1)).setDisable(true);
                }else if(schoolBoard1.lookup("#schoolBoard1Blue" + (blue - 2)).isVisible()){
                    schoolBoard1.lookup("#schoolBoard1Blue" + (blue - 2)).setVisible(false);
                    schoolBoard1.lookup("#schoolBoard1Blue" + (blue - 2)).setDisable(true);
                }else{
                    schoolBoard1.lookup("#schoolBoard1Blue" + (blue - 3)).setVisible(false);
                    schoolBoard1.lookup("#schoolBoard1Blue" + (blue - 3)).setDisable(true);
                }
                if(gui.getNumPawnsCount() == 0){
                    setAllDisabled();
                    gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(i, gui.getNumPawns(), gui.getIslandSelected(), gui.getColorPawns(), true));
                    gui.getColorPawns().clear();
                    gui.setVar(true);
                }
            }

    /**sets all the images disabled for the click
     */
    public void setAllDisabled(){
        for(Node all : schoolBoard1.getChildren()) {
            all.setDisable(true);
            if(all.getId().equals("backSchool1"))
                all.setVisible(true);
        }
    }
}