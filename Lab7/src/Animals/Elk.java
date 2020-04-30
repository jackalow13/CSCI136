package Animals;

public class Elk extends Animals{

    // Attributes
    private String type;
    private double antlerSize;
    private int rankInPack;

    // constructor - Is this correct?
    public Elk(String elk_name, int elk_age, char elk_gender, double elk_antlerSize, int elk_rankInPack){
        this.species="Elk";
        this.name=elk_name;
        this.age=elk_age;
        this.gender=elk_gender;
        this.type = "North American Elk";
        this.antlerSize = elk_antlerSize;
        this.rankInPack = elk_rankInPack;

    }
    // getters and setters
    public String getType(){
        return this.type;
    }
    public void setType(String newType){
        type = newType;
    }
    public double getAntlerSize(){
        return this.antlerSize;
    }
    public void setAntlerSize(double newSize){
        antlerSize = newSize;
    }
    public int getRankInPack(){
        return this.rankInPack;
    }
    public void setRankInPack(int newPlace){
        rankInPack = newPlace;
    }

    // additional method to get hunting regulations
    public void huntingRegulations(){
        System.out.println("Archer season: Sept 5 - Oct 18");
        System.out.println("General: Oct 24 - Nov 29");
    }
}
