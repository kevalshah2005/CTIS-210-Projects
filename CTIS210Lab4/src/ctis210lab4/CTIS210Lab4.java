/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctis210lab4;

import java.util.ArrayList;;

/**
 *
 * @author keval
 */
public class CTIS210Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String applicantName = new String("Charles Babbage");
        applicantName = "Ada Lovelace";
        System.out.println("The applicant name is " + applicantName);
        
        System.out.println("The length of the string applicantName is " + applicantName.length() + ".");
        System.out.println("The character at index 5 is " + applicantName.charAt(5) + ".");
        
        String applicantUpper = applicantName.toUpperCase();
        print(applicantUpper);
        
        String bestApplicant = applicantName.concat(" is the best applicant.");
        print(bestApplicant);
        
        String applicantReplace = applicantName.replace('a', 'x');
        print(applicantReplace);
        
        String applicantFirstName = applicantName.substring(0, 3);
        print(applicantFirstName);
        
        applicantName = "Keval Shah";
        
        // This is the substring method of doing it
        String firstName = applicantName.substring(0, 5);
        String lastName = applicantName.substring(6);
        
        print(firstName);
        print(lastName);
        
        // This is the more efficient method of doing it
        applicantName = "Augusta Ada King Countess of Lovelace";
        String[] applicantNames = applicantName.split(" ");
        for (String name : applicantNames) {
            print(name);
        }
        
        // Pulling it all together (and possibly the worst code I've ever written but I'm tired)
        applicantName = "Augusta ADa KiNg couNtess of loVeLACE";
        String[] nameParts = applicantName.split(" ");
        String[] newNameParts = new String[nameParts.length];
        for (int i = 0; i < nameParts.length; i++) {
            ArrayList<String> letters = new ArrayList<>();
            String firstLetter = String.valueOf(nameParts[i].charAt(0));
            String newFirstLetter = firstLetter.toUpperCase();
            
            letters.add(newFirstLetter);
            letters.add(nameParts[i].substring(1).replace(nameParts[i].substring(1), nameParts[i].substring(1).toLowerCase()));
            
            for (String part : letters) {
                newNameParts[i] += part;
            }
        }
        
        String newApplicantName = "";

        for (String part : newNameParts) {
            newApplicantName += part;
        }
        
        newApplicantName = newApplicantName.replaceAll("null", " ").substring(1);
        
        print(newApplicantName);
    }
    
    public static void print(String a) {
        System.out.println(a);
    }
    
}
