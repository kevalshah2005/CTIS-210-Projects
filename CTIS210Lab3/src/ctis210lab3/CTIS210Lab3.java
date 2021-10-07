package ctis210lab3;

/**
 * Extremely modified version of lab 3
 *
 * @author Keval Shah
 * @veraion 1.0
 *
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.lang.Math;

public class CTIS210Lab3 extends Canvas {

    private static JFrame frame;
    
    private static final String[] courseNames = {"Introduction to Comp Prog", "Advanced Comp Prog", "Operating Systems", 
        "Networking", "Database Systems", "Algorithms", "Overall GPA"};
    private static Double[] grades = new Double[courseNames.length];
    private static Color[] gradeColors = new Color[grades.length];
    private static String applicantName;
    private static final double yScale = 0.5;
    private static final int textOffsetY = 20;
    static Canvas scoreDisplay;

    /**
     *
     * Construct a window that will hold our dashboard and display it
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the applicant name: ");
        applicantName = scan.nextLine();
        
        for (int i = 0; i < courseNames.length; i++) {
            System.out.println("Enter grade for " + courseNames[i] + ":");
            grades[i] = scan.nextDouble();
        }
        
        for (int i = 0; i < gradeColors.length; i++) {
            gradeColors[i] = calculateColor(grades[i]);
        }
        
        frame = new JFrame("Score Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
        scoreDisplay = new CTIS210Lab3();
        scoreDisplay.setSize(screenResolution.width, screenResolution.height);
        frame.add(scoreDisplay);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Displays squares for dashboard based on provided values of scores
     *
     * @param g graphics context to display drawing
     */
    public void paint(Graphics g) { 
        Graphics2D g2 = (Graphics2D) g;
        
        double sizeX = scoreDisplay.getWidth() / courseNames.length;
        
        drawRectangles(g2, Color.BLACK, 25, 25, sizeX, yScale);
        g2.drawString("Applicant Name: " + applicantName, scoreDisplay.getWidth() / 2, (int) ((scoreDisplay.getHeight() * yScale) + textOffsetY));
        
        /*
        //g2.setColor(new Color((int) redIntro, 0, 0));
        g2.fill(new Rectangle2D.Double(25, 25, 100, 100));

        //g2.setColor(new Color((int) redAdv, 0, 0));
        g2.fill(new Rectangle2D.Double(125, 25, 100, 100));

        g2.setFont(new Font("Helvetica", Font.PLAIN, 24));

        g2.setColor(Color.BLACK);
        g2.drawString("Intro", 50, 70);
        g2.drawString("Adv", 150, 70);
        */
    }
    
    /**
     * Gets the correct shade from the grade
     * @param grade The grade to calculate the colour from
     * @return Color object calculated from the grade
     */
    
    private static Color calculateColor(double grade) {
        double redColor = clamp(25 * Math.pow(1.022, grade) + 50 - 25, 0, 255);
        Color returnColor = new Color((int) redColor, 0, 0);
        return returnColor;
    }
    
    /**
     * Draws the rectangles and text
     * @param g2 Graphics2D object
     * @param textColor Color of the text
     * @param startX X-coordinate of where to put first rectangle; others will be placed accordingly
     * @param startY Y-coordinate of where to put first rectangle 
     * @param sizeX Width of the rectangles
     * @param yScale How far the rectangles should extend down
     */
    
    private void drawRectangles(Graphics2D g2, Color textColor, double startX, double startY, 
            double sizeX, double yScale) {
        yScale = scoreDisplay.getHeight() * yScale;
        
        double rectX;
        double rectY = startY;
        double textX;
        double textY = startY;
        
        for (int i = 0; i < gradeColors.length; i++) {
            rectX = (sizeX * i + startX);
            g2.setColor(gradeColors[i]);
            g2.fill(new Rectangle2D.Double(rectX, rectY, sizeX, (yScale * (grades[i] / 100))));
        }
        
        g2.setColor(textColor);
        for (int i = 0; i < courseNames.length; i++) {
            textX = (startX + (sizeX / 2)) + (i * sizeX);
            g2.drawString(courseNames[i], (int) textX, (int) (textY + (yScale * (grades[i] / 100) / 2)));
        }
        
    }
    
    /**
     * If number is bigger than max, make it max; if number is smaller than min, make it min
     * @param value Value to clamp
     * @param min Minimum value of value
     * @param max Maximum value of value
     * @return clamped number
     */
    
    public static double clamp(double value, int min, int max) {
        if (value < min) value = min;
        if (value > max) value = max;
        return value;
    }

}
