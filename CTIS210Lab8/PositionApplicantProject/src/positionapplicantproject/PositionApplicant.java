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
        setGrades();
    }
    
    public double calculateAverageScore() {
        double averageScore = 0;
        for (double grade : grades) {
            averageScore += grade;
        }
        averageScore /= grades.size();
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