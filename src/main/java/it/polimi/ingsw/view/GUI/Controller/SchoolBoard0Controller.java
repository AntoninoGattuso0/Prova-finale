package it.polimi.ingsw.view.GUI.Controller;
import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.network.Message.ClientToServer.MovePawnToDiningMessage;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


//DEVO RIGUARDARE I PROFESSORI QUINDI MAGARI NON ANDRANNO, DEVO USARE METODO DI SCHOOL1
public class SchoolBoard0Controller {
    Gui gui;

    public void setGui(Gui gui){this.gui=gui;}

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

    //setta le pedine dell'entrata visibili all'inizio del gioco
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

    //le 5 funzioni qui sotto mettono visibile/ non visibili/clickabili...  le pedine che passiamo con numColore
    public void greenEntrance0(boolean boolVisibility, boolean boolClickable, int numGreen){
        schoolBoard0.lookup("#entranceGreen0"+ numGreen).setVisible(boolVisibility);
        schoolBoard0.lookup("#entranceGreen0"+ numGreen).setDisable(boolClickable);
    }

    public void redEntrance0(boolean boolVisibility, boolean boolClickable, int numRed){
        schoolBoard0.lookup("#entranceRed0"+ numRed).setVisible(boolVisibility);
        schoolBoard0.lookup("#entranceRed0"+ numRed).setDisable(boolClickable);
    }
    public void yellowEntrance0(boolean boolVisibility, boolean boolClickable, int numYellow){
        schoolBoard0.lookup("#entranceYellow0"+ numYellow).setVisible(boolVisibility);
        schoolBoard0.lookup("#entranceYellow0"+ numYellow).setDisable(boolClickable);
    }
    public void pinkEntrance0(boolean boolVisibility, boolean boolClickable, int numPink){
        schoolBoard0.lookup("#entrancePink0"+ numPink).setVisible(boolVisibility);
        schoolBoard0.lookup("#entrancePink0"+ numPink).setDisable(boolClickable);
    }
    public void blueEntrance0(boolean boolVisibility, boolean boolClickable, int numBlue){
        schoolBoard0.lookup("#entranceBlue0"+ numBlue).setVisible(boolVisibility);
        schoolBoard0.lookup("#entranceBlue0"+ numBlue).setDisable(boolClickable);
    }


    public void setDiningRoom0(){
        int green = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumGreen();
        for(int i=0; i<green; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("#schoolBoard0Green" + i))
                    school.setVisible(true);
            }
        }
        int red = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumRed();
        for(int i=0; i<red; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("#schoolBoard0Red" + i))
                    school.setVisible(true);
            }
        }
        int yellow = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumYellow();
        for(int i=0; i<yellow; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("#schoolBoard0Yellow" + i))
                    school.setVisible(true);
            }
        }
        int pink = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumPink();
        for(int i=0; i<pink; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("#schoolBoard0Pink" + i))
                    school.setVisible(true);
            }
        }
        int blue = gui.getLightGame().getPlayers().get(0).getDiningRoom().getNumBlue();
        for(int i=0; i<blue; i++){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("#schoolBoard0Blue" + i))
                    school.setVisible(true);
            }
        }
    }

    //le 5 funzioni qui sotto mettono visibile/ non visibili le pedine delle dining che passiamo con num

    public void greenDining0(boolean boolVisibility, boolean boolClickable, int num){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("#schoolBoard0Green" + num)){
                    school.setVisible(boolVisibility);
                    school.setDisable(boolClickable);
                }
            }
    }
    public void redDining0(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard0.getChildren()) {
            if (school.getId().equals("#schoolBoard0Red" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void yellowDining0(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard0.getChildren()) {
            if (school.getId().equals("#schoolBoard0Yellow" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void pinkDining0(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard0.getChildren()) {
            if (school.getId().equals("#schoolBoard0Pink" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }
    public void blueDining0(boolean boolVisibility, boolean boolClickable, int num){
        for(Node school : schoolBoard0.getChildren()) {
            if (school.getId().equals("#schoolBoard0Blue" + num)){
                school.setVisible(boolVisibility);
                school.setDisable(boolClickable);
            }
        }
    }

//questo devo rivederlo
    public void setProfessor0(){
        if(gui.getLightGame().getProfTable().getGreenProf() == 0){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolGreenProf0"))
                    school.setVisible(true);
            }
        }
        if(gui.getLightGame().getProfTable().getRedProf() == 0){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolRedProf0"))
                    school.setVisible(true);
            }
        }

        if(gui.getLightGame().getProfTable().getYellowProf() == 0){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolYellowProf0"))
                    school.setVisible(true);
            }
        }

        if(gui.getLightGame().getProfTable().getPinkProf() == 0){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolPinkProf0"))
                    school.setVisible(true);
            }
        }

        if(gui.getLightGame().getProfTable().getBlueProf() == 0){
            for(Node school : schoolBoard0.getChildren()) {
                if (school.getId().equals("schoolBlueProf0"))
                    school.setVisible(true);
            }
        }
    }



    public void setTower0(){
        for(int i = 0; i<gui.getLightGame().getPlayers().get(0).getTowerSpace().getNumTower(); i++)
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
        for (int i = 0; i < gui.getLightGame().getPlayers().get(0).getNumCoin(); i++)
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


    //per tuttte le funzioni dell'entrata una volta cliccata la pedina diventa non selezionabile ed invisbile
    //si aggiunge una pedina all array in base al colore della pedina
    //se ha schiacciato il bottone delle isole allora si rendono selezionabili le isole
    //se invece ha schiacciato il bottone della dining allora manda il messaggio quando
    //sono state scelte tutte le pedine che voleva spostare
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


    public void selectSchoolGreen00(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Green0").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Green0").setDisable(true);
    }

    public void selectSchoolGreen01(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Green1").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Green1").setDisable(true);
    }
    public void selectSchoolGreen02(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Green2").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Green2").setDisable(true);
    }
    public void selectSchoolGreen03(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Green3").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Green3").setDisable(true);
    }
    public void selectSchoolGreen04(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Green4").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Green4").setDisable(true);
    }
    public void selectSchoolGreen05(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Green5").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Green5").setDisable(true);
    }
    public void selectSchoolGreen06(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Green6").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Green6").setDisable(true);
    }
    public void selectSchoolGreen07(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Green7").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Green7").setDisable(true);
    }
    public void selectSchoolGreen08(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Green8").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Green8").setDisable(true);
    }
    public void selectSchoolGreen09(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Green9").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Green9").setDisable(true);
    }

    public void selectSchoolRed00(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Red0").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Red0").setDisable(true);
    }
    public void selectSchoolRed01(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Red1").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Red1").setDisable(true);
    }
    public void selectSchoolRed02(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Red2").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Red2").setDisable(true);
    }
    public void selectSchoolRed03(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Red3").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Red3").setDisable(true);
    }
    public void selectSchoolRed04(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Red4").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Red4").setDisable(true);
    }
    public void selectSchoolRed05(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Red5").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Red5").setDisable(true);
    }
    public void selectSchoolRed06(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Red6").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Red6").setDisable(true);
    }
    public void selectSchoolRed07(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Red7").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Red7").setDisable(true);
    }
    public void selectSchoolRed08(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Red8").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Red8").setDisable(true);
    }
    public void selectSchoolRed09(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Red9").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Red9").setDisable(true);
    }

    public void selectSchoolYellow00(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Yellow0").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Yellow0").setDisable(true);
    }
    public void selectSchoolYellow01(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Yellow1").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Yellow1").setDisable(true);
    }
    public void selectSchoolYellow02(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Yellow2").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Yellow2").setDisable(true);
    }
    public void selectSchoolYellow03(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Yellow3").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Yellow3").setDisable(true);
    }
    public void selectSchoolYellow04(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Yellow4").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Yellow4").setDisable(true);
    }
    public void selectSchoolYellow05(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Yellow5").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Yellow5").setDisable(true);
    }
    public void selectSchoolYellow06(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Yellow6").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Yellow6").setDisable(true);
    }
    public void selectSchoolYellow07(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Yellow7").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Yellow7").setDisable(true);
    }
    public void selectSchoolYellow08(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Yellow8").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Yellow8").setDisable(true);
    }
    public void selectSchoolYellow09(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Yellow9").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Yellow9").setDisable(true);
    }

    public void selectSchoolPink00(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Pink0").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Pink0").setDisable(true);
    }
    public void selectSchoolPink01(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Pink1").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Pink1").setDisable(true);
    }
    public void selectSchoolPink02(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Pink2").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Pink2").setDisable(true);
    }
    public void selectSchoolPink03(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Pink3").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Pink3").setDisable(true);
    }
    public void selectSchoolPink04(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Pink4").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Pink4").setDisable(true);
    }
    public void selectSchoolPink05(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Pink5").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Pink5").setDisable(true);
    }
    public void selectSchoolPink06(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Pink6").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Pink6").setDisable(true);
    }
    public void selectSchoolPink07(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Pink7").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Pink7").setDisable(true);
    }
    public void selectSchoolPink08(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Pink8").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Pink8").setDisable(true);
    }
    public void selectSchoolPink09(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Pink9").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Pink9").setDisable(true);
    }

    public void selectSchoolBlue00(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Blue0").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Blue0").setDisable(true);
    }
    public void selectSchoolBlue01(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Blue1").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Blue1").setDisable(true);
    }
    public void selectSchoolBlue02(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Blue2").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Blue2").setDisable(true);
    }
    public void selectSchoolBlue03(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Blue3").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Blue3").setDisable(true);
    }
    public void selectSchoolBlue04(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Blue4").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Blue4").setDisable(true);
    }
    public void selectSchoolBlue05(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Blue5").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Blue5").setDisable(true);
    }
    public void selectSchoolBlue06(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Blue6").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Blue6").setDisable(true);
    }
    public void selectSchoolBlue07(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Blue7").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Blue7").setDisable(true);
    }
    public void selectSchoolBlue08(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Blue8").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Blue8").setDisable(true);
    }
    public void selectSchoolBlue09(MouseEvent mouseEvent) {
        schoolBoard0.lookup("#schoolBoard0Blue9").setVisible(false);
        schoolBoard0.lookup("#schoolBoard0Blue9").setDisable(true);
    }

    public void selection(){
        gui.setNumPawnsCount(gui.getNumPawnsCount() - 1);
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            for(int i=0; i<gui.getLightGame().getIslands().size(); i++)
                gui.getGameTable().getGameTablePane().lookup("#island"+ i).setDisable(false);
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
        }
    }
}
