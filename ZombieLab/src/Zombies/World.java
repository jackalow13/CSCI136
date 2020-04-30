package Zombies;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.lang.Math;


// World Class holds World Array and several methods
public class World {
    protected int population;
    // World Array is an array of people (persons?)
    Person[][] worldArr;


    // Array for Analytics - Whats the best way to handle sizing?
    //int[][] infectionData = new int[25][];
    ArrayList<String> listInfectionData = new ArrayList<String>();

    // Threshold for Immunity: Immune Strength is 0-100. Currently if a person is >90 they are immune
    public int immuneThreshold;

    // World Class constructor
    World(int population, int immuneThreshold){
        this.population = population;
        this.worldArr = new Person[(int)(Math.sqrt(population))][(int)(Math.sqrt(population))];
        this.immuneThreshold = immuneThreshold;
    };

    // Fills Array with People with random attributes
    public void fillWorldArr(){
        for(int i = 0; i < worldArr.length; i++){
            for (int j = 0; j < worldArr[i].length; j++){
                worldArr[i][j] = new Person();
                //System.out.print(worldarr[i][j].getClass()+ "   ");
            }
        }
    }

    // Method used to avoid using Try-Catch Loop
    public static boolean checkInBounds(Person[][] w, int checkRow, int checkCol){
        // checks negative X & Y
        if (checkRow >= 0 && checkCol >= 0){
            // checks Positive X & Y
            if (checkRow < w.length && checkCol < w[checkRow].length)
            return true;
        }
        return false;
    }

    // Method to print world
    public static void printWorld(Person[][] w){
        for(int i=0; i < w.length; i++){
            for (int j=0; j < w.length; j++){
                if(w[i][j].getClass().getName().equals("Zombies.Person")) {
                    System.out.print("H  ");
                }
                else{System.out.print("Z  ");}
            }
            System.out.println();
        }
    }

    // Takes Status and makes entries Summary/Data list
    // I ended up hard-coding the commas to end up with CSV
    public static void AddStatusToList(int[] status, ArrayList<String> summary, long timeStamp){
        for (int i = 0; i<status.length; i++){
            //String temp = (Integer.toString(status[i])+",");
            summary.add((Integer.toString(status[i])+","));
        }
        summary.add((Long.toString(timeStamp)));
    }

    // Method to get stats of the infection
    //    Returns an array with this info
    public static int [] WorldStatus(Person[][] w, int iteration){
        int numHealthy = 0;
        int numInfected = 0;
        for (int i = 0; i < w.length; i++){
            for(int j = 0; j < w[i].length; j++){
                if (w[i][j].getClass().getName().equals("Zombies.Person")){
                    numHealthy+=1;
                }
                else if (w[i][j].getClass().getName().equals("Zombies.Zombie")){
                    numInfected +=1;
                }
            }
        }
        return new int[]{iteration, numHealthy, numInfected};
    }


    // Method to turn People into Zombies
    //  ***I didn't know how best to do this. For now it creates a new Zombie sub class with Person super class
    //     with person super class attributes as the params
    public static void Sick(Person[][]w, int row, int col, int imuThresh) throws InterruptedException {
        if (w[row][col].immuneStrength < imuThresh) {
            Zombie newZombie = new Zombie(w[row][col].age, w[row][col].gender, w[row][col].immuneStrength);
            w[row][col] = newZombie;
        }
    }

    // Infection Method adapted from code on Moodle
    // Instead of using try catch loops, it calls the checkInbounds method
    public static void infect(Person[][] w, int sRow, int sCol, int immuneThreshold, ArrayList<String> data,
                              int population) throws InterruptedException {

        int row = 0, col = 0;

        // used "0" iteration for pre-infection
        int numIterations = 0;

        // Time is started before infected
        long startTime = System.nanoTime();

        // Pre-infection stats are taken
        int[] wStatus = WorldStatus(w, numIterations);

        // print and record preinfections stats - time is recorded as 0
        System.out.println("Iteration: " + wStatus[0] + " Healthy: " + wStatus[1] + " Infected: " + wStatus[2]);
        AddStatusToList(wStatus, data, (0L));

        // iteration back to 1 for infection
        numIterations = 1;

        // I was unsure about this while loop. Maybe use a rate of change?
        while(numIterations < population) {
            for( row = sRow-numIterations; row<=sRow+numIterations; row ++) {
                for (col = sCol-numIterations; col<=sCol+numIterations; col++) {
                    // Call to make sure its not out of bounds
                    if (checkInBounds(w, row, col)){
                        Sick(w, row, col, immuneThreshold);
                        //Zombie newZombie = new Zombie(w[row][col].age, w[row][col].gender, w[row][col].immuneStrength);
                        //w[row][col] = newZombie;
                    }
                }
            }

            // creates new Status array
            wStatus = WorldStatus(w, numIterations);

            printWorld(w);
            // Prints Status
            System.out.println("Iteration: " + wStatus[0] + " Healthy: " + wStatus[1] + " Infected: " + wStatus[2]);
            System.out.println();

            // End time and lap time
            long end = System.nanoTime();
            long timeElapsed = end - startTime;

            // call to add status to summary
            AddStatusToList(wStatus, data, timeElapsed);

            numIterations++;
        }

    }
}
