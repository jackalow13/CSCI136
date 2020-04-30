package Animals;

public class Bear extends Animals{

    // attributes - did not work when I made them private
    protected String type;
    protected Boolean historyOfDanger;
    protected int sleuthSize;

    // constructor - is this correct?
    public Bear(String bear_name, int bear_age, char bear_gender, String bear_type, Boolean bear_historyOfDanger,
         int bear_famsize){
        this.species = "Bear";
        this.name = bear_name;
        this.age=bear_age;
        this.gender=bear_gender;
        this.type=bear_type;
        this.historyOfDanger=bear_historyOfDanger;
        this.sleuthSize=bear_famsize;
    }

    // getters and setters
    public String getType() {
        return this.type;
    }

    public void setType(String newType) {
        type = newType;
    }

    public Boolean getHistoryOfDanger() {
        return this.historyOfDanger;
    }

    public void setHistoryOfDanger(Boolean newDanger) {
        historyOfDanger = newDanger;
    }

    public int getSleuthSize() {
        return this.sleuthSize;
    }

    public void setSleuthSize(int newSize) {
        sleuthSize = newSize;
    }

    // additional method
    public void bearProtocol() {
        System.out.println("1. Speak firmly to the bear");
        System.out.println("2. Back away slowly");
        System.out.println("3. Keep eye on bear");
    }
}
