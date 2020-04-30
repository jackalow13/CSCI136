package Zombies;

public class Zombie extends Person{
    private int infecttime;

    public Zombie(int a, char g, int s){
        this.age=a;
        this.gender= g;
        this.immuneStrength = s;
        this.infecttime = 0;
    }

}
