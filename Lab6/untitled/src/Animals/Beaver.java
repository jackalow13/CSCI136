package Animals;

import java.util.Scanner;

public class Beaver extends Animals{
    String type;
    String lodgelocation;
    int familySize;
    Scanner scan = new Scanner(System.in);

    Beaver(String beaver_name, int beaver_age, char beaver_gender, String beaver_type, String beaver_lodge,
           int beaver_familysize){
        this.name=beaver_name;
        this.age=beaver_age;
        this.gender=beaver_gender;
        this.type=beaver_type;
        this.lodgelocation=beaver_lodge;
        this.familySize=beaver_familysize;
    }
    public String getType(){
        return this.type;
    }
    public void setType(String newType){
        type = newType;
    }
    public String getLodgelocation(){
        return this.lodgelocation;
    }
    public void setLodgelocation(String newLocation){
        this.lodgelocation = newLocation;
    }
    public int getFamilySize(){
        return this.familySize;
    }
    public void setFamilySize(int newSize){
        this.familySize = newSize;
    }
    public void awesomeness(){
        System.out.println("How awesome are beaver?" );
        System.out.println("Enter a number 1-5. 1 = Not Awesome, 5 = SOOOOO AWESOME");
        int opinion = scan.nextInt();
        if (opinion !=5)
            System.out.println("Wrong Answer. Beavers are SOOOOO AWESOME");
    }
}
