package ctis210exam1fall21errors;

import java.util.Scanner;

public class Enigma {

    public static void main(String[] args) {
        // The program should read in one integer value and
        // two floating-point values from the user.
        //
        // The integer value should be stored in the variable
        // score weight, and the floating-point values 
        // in the variables firstValue and secondValue.
        //
        // The program should print out the three values entered.
        //
        // Then, the program should calculate the quantity
        // 100.0 - weight * (firstValue + secondValue)
        // and store it in the deductedScore.
        //
        // The program should then print out the value of deductedScore.

        Scanner scan = new Scanner(System.in); // I had to import the Scanner class

        double firstValue;
        double secondValue; // Added semicolon
           
        System.out.print("Enter the weight: ");
        int weight = scan.nextInt(); // Added data type of int
        System.out.print("Enter the first number: ");
        firstValue = scan.nextInt(); // capitalised v in firstValue
        System.out.print("Enter the second number: ");
        secondValue = scan.nextDouble();

        System.out.println("The weight is " + weight);
        System.out.println("The two values are " + firstValue + " and " + secondValue); // put pluses instead of commas to fix notation

        double deductedScore = 100.0 - weight * (firstValue + secondValue); // added parentheses

        System.out.println("The value of the result is " + deductedScore);

    }
}
