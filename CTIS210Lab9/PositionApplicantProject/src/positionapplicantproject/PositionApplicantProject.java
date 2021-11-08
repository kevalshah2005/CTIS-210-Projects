/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package positionapplicantproject;

import java.util.*;

/**
 *
 * @author keval
 */
public class PositionApplicantProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rnd = new Random();
        // TODO code application logic here
        PositionApplicant theApplicant = new PositionApplicant("Ada Lovelace", "Lead Programmer", rnd.nextInt(18357) + 1, rnd.nextDouble() * 100, rnd.nextDouble() * 100, rnd.nextDouble() * 100, rnd.nextDouble() * 100, rnd.nextDouble() * 100, rnd.nextDouble() * 100, rnd.nextDouble() * 100);
        System.out.println("The applicantName name is " + theApplicant.getApplicantName());
        
        theApplicant.setApplicantName("Esteban Julio Ricardo Montoya Del Rosa Ramirez");  
        System.out.println("The changed applicant name is " + theApplicant.getApplicantName());
        
        theApplicant.setApplicantNumber(rnd.nextInt(18357) + 1);
        theApplicant.setIntroCompProg(rnd.nextDouble() * 100);
        theApplicant.setAdvCompProg(rnd.nextDouble() * 100);
        theApplicant.setOperatingSystems(rnd.nextDouble() * 100);
        theApplicant.setNetworking(rnd.nextDouble() * 100);
        theApplicant.setDatabaseSystems(rnd.nextDouble() * 100);
        theApplicant.setAlgorithms(rnd.nextDouble() * 100);
        theApplicant.setGpa(rnd.nextDouble() * 100);
        
        System.out.printf("Applicant name: %s%n", theApplicant.getApplicantName());
        System.out.printf("Applicant Number: %d%n", theApplicant.getApplicantNumber());
        System.out.printf("Intro Comp Prog: %f%n", theApplicant.getIntroCompProg());
        System.out.printf("Adv Comp Prog: %f%n", theApplicant.getAdvCompProg());
        System.out.printf("Operating Systems: %f%n", theApplicant.getOperatingSystems());
        System.out.printf("Networking: %f%n", theApplicant.getNetworking());
        System.out.printf("Database Systems: %f%n", theApplicant.getDatabaseSystems());
        System.out.printf("Algorithms: %f%n", theApplicant.getAlgorithms());
        System.out.printf("Overall GPA: %f%n", theApplicant.getGpa());
        
        PositionApplicant theOtherApplicant = new PositionApplicant("John Doe", "Programming Intern", rnd.nextInt(18357)+1, 80, 70, 60, 59, 37, 21, 53);
        System.out.printf("Other Applciant Overall GPA: %f%n", theOtherApplicant.getGpa());
        
        System.out.printf("Average Score: %f%n", theApplicant.calculateAverageScore());
        
        System.out.println(theApplicant);
        
        System.out.println("Before: " + theApplicant.getGpa());
        theApplicant.setGpa(100);
        System.out.println("After: " + theApplicant.getGpa());
        
        System.out.println("Standard Deviation: " + theApplicant.calculateStandardDeviation());
        
        System.out.println("Uppercase Strings: " + theApplicant.stringsUpper());
        
        System.out.println("Reversed Name: " + theApplicant.reverseName());
        
        System.out.println("Analyzed Applicant: " + theApplicant.analyzeApplicant3());
        
        /*
        if (theApplicant.analyzeApplicant1()) {
            System.out.println(theApplicant.getApplicantName() + ": Consider further");  
        }
        else {  
            System.out.println(theApplicant.getApplicantName() + ": Do not consider");  
        }
        
        if (theApplicant.analyzeApplicant2()) {
            System.out.println(theApplicant.getApplicantName() + ": Consider further");  
        }
        else {  
            System.out.println(theApplicant.getApplicantName() + ": Do not consider");  
        }
        
        if (theApplicant.analyzeApplicant3()) {
            System.out.println(theApplicant.getApplicantName() + ": Consider further");  
        }
        else {  
            System.out.println(theApplicant.getApplicantName() + ": Do not consider");  
        }
        
        if (theApplicant.analyzeApplicant2() && theApplicant.analyzeApplicant3()) {
            System.out.println(theApplicant.getApplicantName() + ": Consider further");  
        }
        else {  
            System.out.println(theApplicant.getApplicantName() + ": Do not consider");  
        }

        */
        
        theApplicant.setAlgorithms(100);
        
        if (theApplicant.analyzeApplicant4()) {
            System.out.println(theApplicant.getApplicantName() + ": Consider further");  
        }
        else {  
            System.out.println(theApplicant.getApplicantName() + ": Do not consider");  
        }
        
        if (theApplicant.analyzeApplicant5()) {
            System.out.println(theApplicant.getApplicantName() + ": Consider further");  
        }
        else {  
            System.out.println(theApplicant.getApplicantName() + ": Do not consider");  
        }
    }
}
