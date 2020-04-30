package Zombies;
/*
Jack Meyer
CSCI 136
Zombie Lab
4/14/20
 */

import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        // Variables for CMD Line Arguments
        int population = 0;
        int threshold = 0;

        // default filename
        String fileName = "ZombieData.csv";

        // args:
        // 0. Population, 1. Immunity Threshold. 2. file Name

        //System.out.println("~~ Zombie Simulator ~~");
        //System.out.println("Please enter the population size (even integer): ");
        //System.out.println("Please enter the immunity threshold (int 1-99): ");

        // CMD Line args in try-catch if user inputs incorrectly
        // 0. Population, 1. Immunity Threshold
        try {
            population = Integer.parseInt(args[0]);
            threshold = Integer.parseInt(args[1]);
            fileName = args[2];
        }
        catch (NumberFormatException nfe){
            System.out.println("Please enter a valid input");
        }

        // Create new instance/construct World with cmd args as params.
        World myWorld = new World(population, threshold);

        // Populate World Array with People
        myWorld.fillWorldArr();

        // Prints World Array before infection
        System.out.println("World:");
        World.printWorld(myWorld.worldArr);
        System.out.println();

        // Infection Method with Patient 0 index, and cmd args
        World.infect(myWorld.worldArr, 0, 0, myWorld.immuneThreshold, myWorld.listInfectionData,
                myWorld.population);
        System.out.println();
        SaveData.SaveZombieData(fileName, myWorld.listInfectionData);
        System.out.println();
    }
}