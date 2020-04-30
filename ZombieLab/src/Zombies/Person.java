package Zombies;
import java.util.Random;

// Person Super-class
public class Person {
    protected int age;
    protected char gender;
    protected int immuneStrength;

    // Constructor with method calls to fill attributes with random info
    public Person(){
        this.age = getage();
        this.gender = getGender();
        this.immuneStrength = getImmuneStrength();
    };
    // Random Object
    Random rand = new Random();

    // Random age - returns 1-85
    public int getage(){
        return (rand.nextInt(84)+1);
    }

    // Random Gender: returns F by default unless rand numb is 0
    public char getGender(){
        int tempNum = rand.nextInt(1);
        char tempGen = 'F';
        if (tempNum == 0){
            tempGen = 'M';
        };
        return tempGen;
    }

    // Random Immune Strength 1-100
    public int getImmuneStrength(){
        int strength = 0;
        return rand.nextInt(100);
    }
}
