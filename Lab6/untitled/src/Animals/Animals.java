package Animals;

public class Animals {
    protected String name;
    protected int age;
    protected char gender;

    Animals(){};

    public String getName(){
        return name;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public int getAge(){
        return age;
    }

    public void setAge(int newAge){
        this.age = newAge;
    }
    public char getGender(){
        return gender;
    }
    public void setGender(char newGender){
        this.gender = newGender;
    }
}
