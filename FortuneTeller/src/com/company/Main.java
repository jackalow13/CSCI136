package com.company;
import java.util.Scanner;
/*
Jack Meyer
CSCI 136 Spring 2020
Lab #1 Fortune Teller Jan 17 2020
*/

public class Main {

    public static void main(String[] args){
        // Declare input
    Scanner in = new Scanner(System.in);

    // Take First User Input
    System.out.println("Please enter a number between 1 and 8");
    int UserNum_1 = in.nextInt();

    // Comparision of First User Input
    if (UserNum_1 % 2 == 0) {
        System.out.println("Please choose a number: 4, 3, 7, 8");
    }
    else {
        System.out.println("Please choose a number: 1, 2, 5, 6 ");
    }
    // Take Second User Input
        int UserNum_2 = in.nextInt();

      // Comparison of Second User Input
    if (UserNum_2 == 2 || UserNum_2 == 3 || UserNum_2 == 6 || UserNum_2 == 7){
        System.out.println("Please choose a number: 1, 2, 5, 6");
    }
    else {
        System.out.println("Please choose a number: 4, 7, 8, 3");
    }
    // Take Third User Input
    int UserNum_3 = in.nextInt();

    // Comparison of Third User Input & Output of Fortunes
    if (UserNum_3 == 1){
        System.out.println("Your fortune is:");
        System.out.println("You are due to sleep in!");
    }
    else if (UserNum_3 == 2) {
        System.out.println("Your fortune is:");
        System.out.print("You will have a relaxing weekend!");
    }
    else if (UserNum_3 == 3){
        System.out.println("Your fortune is:");
        System.out.println("You NEED to go to POWER-HOUR!");
    }
    else if (UserNum_3 == 4){
        System.out.println("Your fortune is:");
        System.out.println("Stay away from stocks.");
    }
    else if (UserNum_3 == 5){
        System.out.println("Your fortune is:");
        System.out.println("You are over due to take a relaxing walk");
    }
    else if (UserNum_3 == 6){
        System.out.println("Your fortune is:");
        System.out.println("You deserve some high-quality coffee!");
    }
    else if (UserNum_3 == 7){
        System.out.println("Your fortune is:");
        System.out.println("You will get a job offer this week!");
    }
    else if (UserNum_3 == 8){
        System.out.println("Your fortune is:");
        System.out.println("Put down the screens! Read a good book!");
    }
    System.out.println("");
    System.out.println("Thanks for playing!");
    }
}

