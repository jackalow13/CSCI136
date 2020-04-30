import java.util.Scanner;

public class worksheet {


    public static void main(String[] args){
            // Declare input
        int sum=0, num=0;
        Scanner scanner = new Scanner(System.in);

        while (num != -999) {
            System.out.println("Enter num");
            num = scanner.nextInt();
            if (num != -999) {
                sum+=num;
                System.out.println("--sum: " + sum + "  num: "+num);
            }
        }
        System.out.println("the sum is "+ sum);
}}
