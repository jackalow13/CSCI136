import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class lab4_2dArr {
    public static void main(String[] args) {

        int[][] aArr = instantiateArray();
        int[][] bArr = instantiateArray();

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
        System.out.println();
        System.out.println("Original contents of array bArr are:");
        outputArray(bArr);
        System.out.println();

        System.out.println("Performing Deep Copy.....");
        System.out.println();
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
        System.out.println();
        System.out.println("The SUM of array aArr is: " + sumIntArray(bArr));
        System.out.println("The MEAN of aArr is: " + meanIntArray(bArr));
        System.out.println("The MIN of aArr is: " + minValue(bArr));
        System.out.println("The MAX of aArr is: " + maxValue(bArr));
        System.out.println("The RANGE of aArr is: " + (maxValue(bArr)-minValue(bArr)));
        System.out.println();
        System.out.println("The sorted contents of bArr are:");
        outputRange(bArr);
    }

    static void deepCopy(int[][] copyFrom, int[][] copyTo)  {
        // loop to deep copy *should I have used fill method?
        for(int i = 0; i < copyFrom.length; i++){
            for (int j = 0; j <copyFrom[i].length; j++)
            copyTo[i][j] = copyFrom[i][j];
        }
    }

    static int[][] instantiateArray()  {
        //code to create and return a new array
        //the return statement below is added so the class will compile.  Replace with your own code.

        // Initiate and return array *why change this from int[10]?
        return new int [10][10];
    }

    static void initializeArray(int[][] Temp, Random rand) {
        //code to initialize each element of array to the value x
        //why is this void?  Can it be modified to return an array?
        // ANSWER: This is void because we are changing the value of the reference
        // ANSWER: Yes we can modify it. Change the method and call, then point it to A[]

        for (int i = 0; i < Temp.length; i++) {
            for (int j = 0; j < Temp[i].length; j++){
            Temp[i][j] = rand.nextInt(10);
        }
    }
    }

    static void outputArray(int[][] Temp)  {
        //code to output each element of the array
        for (int i=0; i<Temp.length; i++) {
            for(int j=0;j<Temp[i].length;j++) {
                System.out.print(Temp[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int sumIntArray(int[][]a)  {
        //adds all elements of a together and returns an integer
        //the return statement below is added so the class will compile.  Replace with your own code.

        // declare value and use it as a running total in the for loop
        int value = 0;
        for(int i = 0; i < a.length; i++){
            for(int j=0;j<a[i].length;j++)
            value += a[i][j];
        }
        return value;
    }

    static double meanIntArray(int[][] a) {
        //calculates the mean of the values stored in the array and returns a double
        //the return statement below is added so the class will compile.  Replace with your own code.

        // declare value and use it as a running total in the for loop

        // multiply value by 1.0 to make the output a double, return the value divided by length of a[]
        int count = 0;
        for (int i = 0; i<a.length; i++)
            for (int j = 0; j <a[i].length; j++)
                count += 1;
        return (sumIntArray(a) * 1.0 /count );
    }

    static int minValue(int[][] a) {
        //returns the smallest value stored in the array
        //the return statement below is added so the class will compile.  Replace with your own code.

        // declare value with first index. Then test each index to value to get the min
        int value = a[0][0];
        for(int i = 0; i < a.length; i++){
            for(int j=0;j<a[i].length;j++){
                if (a[i][j] < value)
                    value=a[i][j];
            }
        }
        return value;
    }
    static int maxValue(int[][] a)  {
        //returns the largest value stored in the array
        //the return statement below is added so the class will compile.  Replace with your own code.

        // declare value with first index. Then test each index to value to get the max
        int value = a[0][0];
        for(int i = 0; i < a.length; i++){
            for(int j=0;j<a[i].length;j++) {
                if (a[i][j] > value)
                    value = a[i][j];
            }
        }
        return value;
    }

    static void outputRange(int[][] a)  {
        //outputs the range of values in the array (smallest to largest)

        // using sort, then printing contents in for loop
        for(int i = 0; i < a.length; i++){
            for(int j=0;j<a[i].length;j++) {
                for (int k = 0; k < a[i].length - j - 1; k++) {
                    if (a[i][k] > a[i][k + 1]) {

                        // swapping of elements
                        int t = a[i][k];
                        a[i][k] = a[i][k + 1];
                        a[i][k + 1] = t;
                    }
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }
}
