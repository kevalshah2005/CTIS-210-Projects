/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package applicantevaluation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author keval
 */
public class ApplicantEvaluation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PositionApplicant testApplicant = new PositionApplicant("Test Test", "Janitor Intern", 10, 4, 7, 24, 12, 6, 3, 2);
        System.out.println(testApplicant.getAdvCompProg());
        System.out.println(testApplicant.getAlgorithms());
        System.out.println(testApplicant.getApplicantName());
        
        ArrayList<PositionApplicant> applicants = new ArrayList<>();
        applicants.add(testApplicant);
        System.out.println("The size of the list is " + applicants.size());
        // applicants.add("Will this work?");
        PositionApplicant testItem = applicants.get(0);
        System.out.println(testItem.getAdvCompProg());
        System.out.println(testItem.getAlgorithms());
        System.out.println(testItem.getApplicantName());
        
        applicants.remove(0);
        System.out.println("The size of the list is " + applicants.size());
        
        try   {
            Scanner fileScan = new Scanner(new File("allTheApps.txt"));
            
            Random randGenerator = new Random();
            while (fileScan.hasNext()) {
                int introToCompProg = fileScan.nextInt();  
                int advCompProg = fileScan.nextInt();  
                int networking = fileScan.nextInt();  
                int databaseSystems = fileScan.nextInt();  
                int algorithms = fileScan.nextInt();  
                int operatingSystems = fileScan.nextInt();  
                double overallGPA = fileScan.nextDouble();  
                int applicantNum = randGenerator.nextInt(1000000);  
                String name = "Applicant";  
                String position = "Programmer";  
                PositionApplicant theApplicant = new PositionApplicant(name, 
                    position, applicantNum, introToCompProg, 
                    advCompProg, networking, databaseSystems,  
                    algorithms, operatingSystems, overallGPA);  
                applicants.add(theApplicant);  
            }
            
            System.out.println("The size of the list is " + applicants.size());

            fileScan.close();  
        }       
        catch (FileNotFoundException e) {
            System.out.println(e);  
            System.exit(0);  
        }
        
        // No optional assignments so I decided to do a little something extra :)
        
        int countApproved1 = 0;  
        countApproved1 = applicants.stream().filter(app -> (app.analyzeApplicant1())).map(_item -> 1).reduce(countApproved1, Integer::sum);
        System.out.println("The number of approved applicants using method 1: " + countApproved1);
        System.out.println("The percent of approved applicants using method 1: " + 100 * ((double) countApproved1 / applicants.size()));
        
        int countApproved2 = 0;  
        countApproved2 = applicants.stream().filter(app -> (app.analyzeApplicant2())).map(_item -> 1).reduce(countApproved2, Integer::sum);
        System.out.println("The number of approved applicants using method 2: " + countApproved2);
        System.out.println("The percent of approved applicants using method 2: " + 100 * ((double) countApproved2 / applicants.size()));
        
        int countApproved3 = 0;  
        countApproved3 = applicants.stream().filter(app -> (app.analyzeApplicant3())).map(_item -> 1).reduce(countApproved3, Integer::sum);
        System.out.println("The number of approved applicants using method 3: " + countApproved3);
        System.out.println("The percent of approved applicants using method 3: " + 100 * ((double) countApproved3 / applicants.size()));
        
        int countApproved4 = 0;  
        countApproved4 = applicants.stream().filter(app -> (app.analyzeApplicant4())).map(_item -> 1).reduce(countApproved4, Integer::sum);
        System.out.println("The number of approved applicants using method 4: " + countApproved4);
        System.out.println("The percent of approved applicants using method 4: " + 100 * ((double) countApproved4 / applicants.size()));
        
        int countApproved5 = 0;  
        countApproved5 = applicants.stream().filter(app -> (app.analyzeApplicant5())).map(_item -> 1).reduce(countApproved5, Integer::sum);
        System.out.println("The number of approved applicants using method 5: " + countApproved5);
        System.out.println("The percent of approved applicants using method 5: " + 100 * ((double) countApproved5 / applicants.size()));
        
        int countApproved6 = 0;  
        countApproved6 = applicants.stream().filter(app -> (app.analyzeApplicant6())).map(_item -> 1).reduce(countApproved6, Integer::sum);
        System.out.println("The number of approved applicants using method 6: " + countApproved6);
        System.out.println("The percent of approved applicants using method 6: " + 100 * ((double) countApproved6 / applicants.size()));
    }
}