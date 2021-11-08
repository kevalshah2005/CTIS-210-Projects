/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanexpressionlab;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rmw
 */
public class BooleanExpressionLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame booleanApp = new JFrame("Boolean Expressions");
        JPanel everything = new JPanel();
        everything.setLayout(new BoxLayout(everything, BoxLayout.PAGE_AXIS));
        RelationalExpressionPanel relations = new RelationalExpressionPanel();
        QuestionPanel questions = new QuestionPanel();
        everything.add(relations);
        everything.add(questions);
        booleanApp.add(everything);
        everything.setSize(new Dimension(400, 800));
        booleanApp.pack();
        booleanApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        booleanApp.setVisible(true);
    }
    
}
