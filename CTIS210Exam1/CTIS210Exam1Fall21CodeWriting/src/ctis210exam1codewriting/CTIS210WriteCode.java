package ctis210exam1codewriting;

import java.util.Random;
import java.util.Scanner;

public class CTIS210WriteCode {

    // Complete the task in each comment. You may need to add lines of code
    // in other places besides where the comment is. The overall goal of this program
    // is to have the user enter a string, obtain a substring with a random number of characters 
    // from the beginning of the string, and print out that substring. 
    //
    // For example, if the user enters the string "Dry Cleaning", then
    // a sample output from the program would be:
    //
    // The first 6 characters of Dry Cleaning are Dry Cl.
    // 
    
    public static void main(String[] args) {
        // Declare and instantiate a Scanner object with the identifier scan 
        // that will accept input from the keyboard
        Scanner scan = new Scanner(System.in);

        // Declare and instantiate a Random object with the identifier rand
        Random rand = new Random();
        
        // Declare a String variable with the identifier originalString, 
        // but do not instantiate it
        String originalString;
        
        // Declare an int variable numChar and initialize it with the value 0
        int numChar = 0;
        
        
        // Prompt the user for a string literal and use the Scanner object to read
        // what they enter into the originalString variable
        System.out.println("Please enter your phrase: ");
        originalString = scan.nextLine();
        
        // Use the length of the string to generate a random integer between 1
        // and (length of string). Store that value in numChar 
        try {
            numChar = rand.nextInt(originalString.length() - 1) + 1;
        } catch (Exception e) {
            throw new RuntimeException("Invalid input!");
        }
        
        
        // Send a message to originalString to get the substring with the first
        // numChar characters. Assign the result to a String variable named
        // finalString 
        String finalString = originalString.substring(0, numChar);
        
        
        // Print out the result using the format from the original comment
        System.out.printf("The first %d characters of %s are %s.%n", numChar, originalString, finalString);
        
        
    }

}
