/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctis210lab6;

import java.util.ArrayList;

/**
 *
 * @author keval
 */
public class Applicant {
    // I didn't feel like making getter and setter methods so I just made the variables public since it doesn't really matter for this application
    public int id;
    public double introToCompProg;
    public double advCompProg;
    public double networking;
    public double algorithms;
    public double overallCollegeGPA;
    
    public double[] grades = {introToCompProg, advCompProg, networking, algorithms};
    
    public double averageComputingScore;
    
    public Applicant() {
        
    }
    
    public Applicant(int id, int introToCompProg, int advCompProg, int networking, int algorithms, double overallCollegeGPA) {
        this.id = id;
        this.introToCompProg = introToCompProg;
        this.advCompProg = advCompProg;
        this.networking = networking;
        this.algorithms = algorithms;
        this.overallCollegeGPA = overallCollegeGPA;
    }
    
    public void setAverageComputingScore() {
        averageComputingScore = (introToCompProg + advCompProg + networking + algorithms) / 4;
    }
    
    public double calculateStandardDeviation() {
        double variance = 0;
        for (int i = 0; i < grades.length; i++) { // 4 grades
            variance += (Math.pow(Math.abs(grades[i] - averageComputingScore), 2d) / grades.length);
        }
        return Math.sqrt(variance);
    }
}
