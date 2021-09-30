/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctis210lab2;

/**
 *
 * @author keval
 */
public class CTIS210Lab2 {
    
    static int introCompProg = 100;
    static int advancedCompProg = 95;
    static int operatingSystems = 75;
    static int networking = 80;
    static int databaseSystems = 89;
    static int algorithms = 91;
    static double overallGPA = 83.3;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
        // Prints Applicant 0's grade information
        System.out.println("Applicant 0");
        System.out.println("Intro to Comp Prog\t" + introCompProg);
        System.out.println("Advanced Comp Prog\t" + advancedCompProg);
        System.out.println("Operating Systems\t" + operatingSystems);
        System.out.println("Networking\t" + networking);
        System.out.println("Database Systems\t" + databaseSystems);
        System.out.println("Algorithms\t" + algorithms);
        System.out.println("Overall GPA\t" + overallGPA);
        
        algorithms = 100;
        
        System.out.println("Algorithms\t" + algorithms);
        
        int introCompProg = 87;
    }
    
}
