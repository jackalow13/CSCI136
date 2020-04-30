import java.util.Scanner;
import java.util.Random;
/*
    Jack Meyer
    CSCI136 Spring 2020
    Lab 2: Dice Throws
    Jan 29 2020
*/

public class lab2 {
    public static void main (String[] args){

        // declare number of rolls and average variables:
        int NumRolls;
        double avg = 0;

        // creating an instance of the random class and input class:
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        // Prompt user for # of rolls then take input:
        System.out.print("How many times would you like to roll the dice?  ");
        NumRolls = scanner.nextInt();

        // loop through # of rolls:
        for (int i = 0; i < NumRolls; i++ ) {

            // declare die variables and use random class to get range: 0-5
            int d1 = rand.nextInt(6);
            int d2 = rand.nextInt(6);

            // adding 1 to die, to make the range: 1-6
            d1 += 1;
            d2 += 1;

            // add die results to average variable:
            avg += (d1 + d2);

            // condition, print if die variable match:
            if(d1 == d2) {
                System.out.printf("%d  %d  <-- You rolled a pair!%n", d1, d2);
            }
            // printing if die variable don't match:
            else {
                System.out.printf("%d  %d%n", d1, d2);
            }
        }
        // new line, computing average and printing it:
        System.out.println(" ");
        System.out.println("your average roll: " + (avg / (NumRolls*2)));
    }
}