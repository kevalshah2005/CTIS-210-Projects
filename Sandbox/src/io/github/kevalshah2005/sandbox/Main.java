    package io.github.kevalshah2005.sandbox;

    import java.awt.Canvas;  
    import java.awt.Color;  
    import java.awt.Font;  
    import java.awt.Graphics;  
    import java.awt.Graphics2D;  
    import java.awt.geom.Ellipse2D;  
    import java.awt.geom.Line2D;  
    import java.awt.geom.Rectangle2D;  
    import javax.swing.JFrame;

    public class Main extends Canvas {

        public static void main(String[] args) {  
            // TODO code application logic here  
            JFrame frame = new JFrame("CTIS 210 Exam 1 Graphics Question");  
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            Main graphicsDisplay = new Main();  
            graphicsDisplay.setSize(350, 350);  
            frame.add(graphicsDisplay);  
            frame.pack();  
            frame.setVisible(true);

        }

        @Override  
        public void paint(Graphics g) {  
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.green);  
            g2.draw(new Ellipse2D.Double(75, 75, 150, 150));  
            g2.setColor(Color.blue);  
            g2.fill(new Ellipse2D.Double(100, 125, 25, 25));  
            g2.fill(new Ellipse2D.Double(175, 125, 25, 25));  
            g2.setColor(Color.red);  
            g2.draw(new Line2D.Double(125, 187, 175, 187));  
            g2.setColor(Color.red);  
            g2.fill(new Rectangle2D.Double(50, 10, 80, 50));  
            Font font = new Font("Arial", Font.BOLD, 24);  
            g2.setFont(font);  
            g2.setColor(Color.white);  
            g2.drawString("Hello!", 55, 45);  
        }

    }