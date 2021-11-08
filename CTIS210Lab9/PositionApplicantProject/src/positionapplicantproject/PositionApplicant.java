package positionapplicantproject;

import java.util.ArrayList;

/**
 *
 * @author keval
 */
public class PositionApplicant {
    private String applicantName;
    private String positionName;
    private int applicantNumber;
    private double introCompProg;
    private double advCompProg;
    private double operatingSystems;
    private double networking;
    private double databaseSystems;
    private double algorithms;
    private double gpa;
    private ArrayList<Double> grades = new ArrayList<>();
    
    public PositionApplicant(String applicantName) {
        this.applicantName = applicantName;
    }

    public PositionApplicant(String applicantName, String positionName, int applicantNumber, double introCompProg, double advCompProg, double operatingSystems, double networking, double databaseSystems, double algorithms, double gpa) {
        this.applicantName = applicantName;
        this.positionName = positionName;
        this.applicantNumber = applicantNumber;
        this.introCompProg = introCompProg;
        this.advCompProg = advCompProg;
        this.operatingSystems = operatingSystems;
        this.networking = networking;
        this.databaseSystems = databaseSystems;
        this.algorithms = algorithms;
        this.gpa = gpa;
    }
    
    public double calculateAverageScore() {
        double averageScore;
        averageScore = (introCompProg + advCompProg + operatingSystems + networking + databaseSystems + algorithms + gpa) / 7;
        return averageScore;
    }
    
    public double calculateStandardDeviation() {
        setGrades();
        
        double variance = 0;
        double average = calculateAverageScore();
        for (int i = 0; i < grades.size(); i++) { // 4 grades
            variance += (Math.pow(grades.get(i) - average, 2d) / grades.size());
        }
        return Math.sqrt(variance);
    }
    
    public void setGrades() {
        grades.add(introCompProg);
        grades.add(advCompProg);
        grades.add(operatingSystems);
        grades.add(networking);
        grades.add(databaseSystems);
        grades.add(algorithms);
        grades.add(gpa);
    }
    
    public String stringsUpper() {
        return (applicantName.toUpperCase() + ", " + positionName.toUpperCase());
    }
    
    public String reverseName() {
        String[] names = applicantName.split(" ");
        String returnString = names[names.length - 1] + ", ";
        for (int i = 0; i < names.length - 1; i++) {
            returnString += (names[i] + " ");
        }
        return returnString;
    }
    
    public boolean analyzeApplicant1() {
        boolean accept;
        accept = introCompProg > 80; // Analyze Applicant 1; consider applicant if introCompProg is greater than 80
        return accept;
    }
    
    public boolean analyzeApplicant2() {
        boolean accept;
        accept = introCompProg > 85 && advCompProg > 85;        
        return accept;
    }
    
    public boolean analyzeApplicant3() {
        boolean accept;
        accept = (gpa > 90) || (calculateAverageScore() > 85); // Analyze Applicant 3; consider applicant if gpa is greater than 90 or average score is greater than 85
        return accept;
    }
    
    public boolean analyzeApplicant4() {
        boolean accept;
        // Only consider someone if they have an average of 84 in introCompProg, advCompProg, databaseSystems, and algorithms
        accept = ((introCompProg + advCompProg + databaseSystems + algorithms) / 4) > 84;
        return accept;
    }
    
    public boolean analyzeApplicant5() {
        boolean accept;
        /*
            Only consider someone if they have an average of 84 in introCompProg,
            advCompProg, databaseSystems, and algorithms and greater than or 
            equal to a 90 in algorithms
        */
        accept = ((algorithms >= 90) && ((introCompProg + advCompProg + databaseSystems + algorithms) / 4) > 84); 
        /*
            Algorithms is a very important course for machine learning 
            (the main skill for the position we're hiring), 
            so it makes sense to value that very highly.
        */
        return accept;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public int getApplicantNumber() {
        return applicantNumber;
    }

    public void setApplicantNumber(int applicantNumber) {
        this.applicantNumber = applicantNumber;
    }

    public double getIntroCompProg() {
        return introCompProg;
    }

    public void setIntroCompProg(double introCompProg) {
        this.introCompProg = introCompProg;
    }

    public double getAdvCompProg() {
        return advCompProg;
    }

    public void setAdvCompProg(double advCompProg) {
        this.advCompProg = advCompProg;
    }

    public double getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(double operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public double getNetworking() {
        return networking;
    }

    public void setNetworking(double networking) {
        this.networking = networking;
    }

    public double getDatabaseSystems() {
        return databaseSystems;
    }

    public void setDatabaseSystems(double databaseSystems) {
        this.databaseSystems = databaseSystems;
    }

    public double getAlgorithms() {
        return algorithms;
    }

    public void setAlgorithms(double algorithms) {
        this.algorithms = algorithms;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "PositionApplicant{" + "applicantName=" + applicantName + ", positionName=" + positionName + ", applicantNumber=" + applicantNumber + ", introCompProg=" + introCompProg + ", advCompProg=" + advCompProg + ", operatingSystems=" + operatingSystems + ", networking=" + networking + ", databaseSystems=" + databaseSystems + ", algorithms=" + algorithms + ", gpa=" + gpa + ", grades=" + grades + '}';
    }
}