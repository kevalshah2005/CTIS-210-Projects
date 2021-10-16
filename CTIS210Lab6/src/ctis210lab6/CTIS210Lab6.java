/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctis210lab6;

import java.util.Random;
import java.lang.Math;

/**
 *
 * @author keval
 */
public class CTIS210Lab6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random rand = new Random();
        
        // Instantiates applicant and grades
        Applicant applicant = new Applicant();
        applicant.id = rand.nextInt(900) + 100;
        System.out.printf("Applicant: %d%n", applicant.id);
        applicant.overallCollegeGPA = 40 * rand.nextDouble() + 60d;
        System.out.printf("Overall GPA: %.2f%n", applicant.overallCollegeGPA);
        
        applicant.introToCompProg = 40 * rand.nextDouble() + 60d;
        applicant.advCompProg = 40 * rand.nextDouble() + 60d;
        applicant.networking = 40 * rand.nextDouble() + 60d;
        applicant.algorithms = 40 * rand.nextDouble() + 60d;
        System.out.printf("Intro to Comp Prog: %.2f%nAdvanced Comp Prog: %.2f%nNetworking: %.2f%nAlgorithms: %.2f%n", 
                applicant.introToCompProg, applicant.advCompProg, applicant.networking, applicant.algorithms);
        
        // Of course the time that I decide to use printf is also the time where we learn about it :/
        
        System.out.printf("Max of Intro to Computer Programming and Advanced Computer Programming: %.2f%n", 
                Math.max(applicant.introToCompProg, applicant.advCompProg));
        
        applicant.setAverageComputingScore();
        System.out.printf("Average Computing Score: %.2f%n", applicant.averageComputingScore);
        
        System.out.printf("Max of Overall College GPA and Average Computing Score: %.2f%n", 
                Math.max(applicant.overallCollegeGPA, applicant.averageComputingScore));
        
        System.out.printf("Standard Deviation: %.2f%n", applicant.calculateStandardDeviation());
    }
    
}
