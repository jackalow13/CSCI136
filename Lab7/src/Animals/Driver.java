package Animals;
/*
Jack Meyer
CSCI 136 - Lab 6 & 7
3/3/2020
 */

public class Driver {
    public static void main(String[] args){
        // delcare new "zoo" class
        WildLifePreserve wlp = new WildLifePreserve();

        // fill animal array with animals - whats the best way to do this?
        wlp.fillAnimalsArr(wlp.wildlife);

        // Preserve report
        wlp.wildLifeReport(wlp.wildlife);

        // Bear Report
        wlp.bearReport(wlp.wildlife);

    }
}
