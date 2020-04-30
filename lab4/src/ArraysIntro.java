
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.util.Random;
/*
    Jack Meyer
    CSCI 136 Spring 2020
    Lab 4: Arrays
    Feb 2, 2020
 */

public class ArraysIntro {
    public static void main(String[] args) {

    int[] aArr = new int[10];
    int[] bArr = instantiateArray();

    // Creating instance of a random class for test
    Random rand = new Random();

    //default method call
    //initializeArray(aArr, 3);
    //initializeArray(bArr, 10);

    // method call with random
    initializeArray(aArr, rand);
    initializeArray(bArr, rand);

    System.out.println("Original contents of array aArr are:");
    outputArray(aArr);
    System.out.println("Original contents of array bArr are:");
    outputArray(bArr);
    System.out.println();

    System.out.println("Performing Deep Copy.....");
    //use the TimeUnit class to pause the program
    //This call has to be made inside a try/catch
    try {
        TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
        //do nothing
    }

    deepCopy(aArr, bArr);
// Confused ******** bArr becomes aArr?
    System.out.println("The contents of array aArr are:");
    outputArray(bArr);

    //write statements to test each of the remaining methods

        // Call each method ***added range***?
        System.out.println("The SUM of array aArr is: " + sumIntArray(bArr));
        System.out.println("The MEAN of aArr is: " + meanIntArray(bArr));
        System.out.println("The MIN of aArr is: " + minValue(bArr));
        System.out.println("The MAX of aArr is: " + maxValue(bArr));
        System.out.println("The RANGE of aArr is: " + (maxValue(bArr)-minValue(bArr)));
        System.out.println();
        System.out.println("The sorted contents of bArr are:");
        outputRange(bArr);
}

    static void deepCopy(int[] copyFrom, int[] copyTo)  {
        // loop to deep copy *should I have used fill method?
        for(int i = 0; i < copyFrom.length; i++){
            copyTo[i] = copyFrom[i];
        }
    }

    static int[] instantiateArray()  {
        //code to create and return a new array
        //the return statement below is added so the class will compile.  Replace with your own code.

        // Initiate and return array *why change this from int[10]?
        int [] A = new int [10];
        return A;
    }

    static void initializeArray(int[] Temp, Random rand) {
        //code to initialize each element of array to the value x
        //why is this void?  Can it be modified to return an array?
        // ANSWER: This is void because we are changing the value of the reference
        // ANSWER: Yes we can modify it. Change the method and call, then point it to A[]

        for (int i = 0; i < Temp.length; i++) {
            Temp[i] = rand.nextInt(100);
        }
    }

    static void outputArray(int[] Temp)  {
        //code to output each element of the array
        for (int i=0; i<Temp.length; i++) {
            System.out.println(Temp[i]);
        }
    }

    static int sumIntArray(int[]a)  {
        //adds all elements of a together and returns an integer
        //the return statement below is added so the class will compile.  Replace with your own code.

        // declare value and use it as a running total in the for loop
        int value = 0;
        for(int i = 0; i < a.length; i++){
            value += a[i];
        }
        return value;
    }

    static double meanIntArray(int[] a) {
        //calculates the mean of the values stored in the array and returns a double
        //the return statement below is added so the class will compile.  Replace with your own code.

        // declare value and use it as a running total in the for loop

        // multiply value by 1.0 to make the output a double, return the value divided by length of a[]
        return (sumIntArray(a) * 1.0 /a.length);
    }

    static int minValue(int[] a) {
        //returns the smallest value stored in the array
        //the return statement below is added so the class will compile.  Replace with your own code.

        // declare value with first index. Then test each index to value to get the min
        int value = a[0];
        for(int i = 0; i < a.length; i++){
            if (a[i] < value)
                    value=a[i];
        }
        return value;
    }
    static int maxValue(int[] a)  {
        //returns the largest value stored in the array
        //the return statement below is added so the class will compile.  Replace with your own code.

        // declare value with first index. Then test each index to value to get the max
        int value = a[0];
        for(int i = 0; i < a.length; i++){
            if (a[i] > value)
                value=a[i];
        }
        return value;
    }

    static void outputRange(int[] a)  {
        //outputs the range of values in the array (smallest to largest)

        // using sort, then printing contents in for loop
        Arrays.sort(a);
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}

