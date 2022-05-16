package it.polimi.ingsw.view.Cli;

import it.polimi.ingsw.model.Nicola;

public enum ColorCli {

    //color end string, color reset
    RESET("\033[0m"),
    CLEAR("\033[H\033[2J"),

    //Classici Colori

    GREEN("\033[0;32m"),
    RED("\033[0;31m"),
    YELLOW("\033[0;33m"),
    PINK("\033[0;35m"),
    BLUE("\033[0;34m"),
    BLACK("\033[0;30m"),
    BOLDCYAN("\033[1;36m"); //Per tabelle

    private final String code;

    ColorCli(String code){
        this.code = code;
    }

    @Override
    public String toString(){
        return code;
    }
}
