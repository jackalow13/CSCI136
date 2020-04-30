import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class twoDfun {
   /* Jack Meyer
      CSCI 136
      Lab 5 - Fun with 2d Arrays
      Feb 16 2020
      */

    public static void main(String[] args) {

        // Declare Scanner
        Scanner scan = new Scanner(System.in);

        // Declare instance of date class and format it
        LocalDateTime myDate = LocalDateTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MMM dd yyyy");
        String myToday = myDate.format(pattern);

        // prints heading
        System.out.println("~~ To-Do list ~~");
        System.out.println("Date: " + myToday);
        System.out.println();

        // String variables to see add to array for
        String undone = " O ";
        String done = " X ";

        // Get Number of strings
        int userNum = takeInt(scan);

        // Declare 2d Array
        char[][] letters = new char [userNum][];

        // Loop to get Strings and put them in the array
        for (int i = 0; i < userNum; i++) {
            System.out.print((i+1)+". Please enter a task: ");

            // get string
            String userStr = scan.nextLine();

            // initiate column
            letters[i] = new char[userStr.length()+undone.length()];

            // fill characters into array
            fillArray(letters, i, userStr, undone);
        }
        System.out.println();

        // Call to print array
        printLetters(letters, myToday);

        // Loop to run until all tasks are done
        while (!checkifdone(letters, undone, done, userNum)){
            System.out.println();
            System.out.print("What task have you gotten done? Enter number: ");

            // Ask user what task they have completed
            int userTaskDone = scan.nextInt();

            // call to change and print to-do list with task completed
            taskcompleted(letters, userTaskDone, done, myToday);
        }
    }

    // ~~~~~~~~~~~~~~~~~~~~~~ Begin Methods ~~~~~~~~~~~~~~~~~~~~~~

    // Method to get number of strings
   static int takeInt(Scanner input){
       System.out.print("How many tasks do you have today? (Enter a number) ");
       int x = input.nextInt();
       input.nextLine();
       return x;
   }

   // Method to fill array with characters
   static void fillArray(char[][] arr, int index, String userString, String undone){

        // declare variable to accommodate length of user string/task and done/undone string
        int totalLength = userString.length() + undone.length();

        // loop to insert undone String and User string/task
       for (int j=0; j < totalLength; j++){
           if (j == 0) {

               // inserts " " into char array
               arr[index][j] = undone.charAt(0);
           }
           else if (j==1) {

               // inserts "O" into char array
               arr[index][j] = undone.charAt(1);
           }
           else if (j==2) {

               // inserts " " into char array
               arr[index][j] = undone.charAt(2);
           }
           else {

                    // inserts user string/task name
                   arr[index][j] = userString.charAt((j-3));
               }
       }
   }
    // Method to print letters
    static void printLetters(char[][] letters, String myToday){
        System.out.println("~~ To-Do list ~~");
        System.out.println("Date: " + myToday);
        for(int i = 0; i<letters.length; i++) {
            System.out.print((i+1)+".");
            for (int j = 0; j < letters[i].length; j++)
                System.out.print(letters[i][j]);
            System.out.println();
        }
    }
    // Method to check when all tasks are completed
    static boolean checkifdone(char[][] letters, String undone, String done, int numtasks){

        // Declare variable to check tasks done against total num of tasks
        int numtasksdone = 0;

        // Loop to go through Array to see if tasks are complete (X) or incomplete (O)
        for (int i = 0; i < letters.length; i++){
            if (letters[i][1]==done.charAt(1)){
                numtasksdone +=1;
            }
        }
        // Condition if tasks complete equals total tasks
        if (numtasks == numtasksdone) {
            System.out.println();
            System.out.println("Congrats! Your done! Now go relax!!!!!");
            return true;
        }
        else {
            return false;
        }

    }
    // Method to modify array once a task is completed
    static void taskcompleted(char[][] letters, int usertaskdone, String done, String mytoday){

        // declare temp variable to offset user input with array index
        int temparraddress = (usertaskdone - 1);

        // change array from O to X
        letters[temparraddress][1] = done.charAt(1);

        // call to print updated array
        printLetters(letters, mytoday);
    }
}
