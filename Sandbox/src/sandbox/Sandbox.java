/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author keval
 */
public class Sandbox {
    
    static Random rand;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        rand = new Random();
        ArrayList<Integer> diceResults = rollDice(20, 10000);
        for (int i = 0; i < diceResults.size(); i++) {
            System.out.printf("Die %d result: %d\n", i + 1, (int) diceResults.get(i));
        }
        
    }
    
    /**
     * Rolls dice according to the number of faces and dice specified
     * @param faces The number of faces on the dice
     * @param dice The number of dice to roll
     * @return An array with the results of rolling the dice
     */
    public static ArrayList<Integer> rollDice(int faces, int dice) {
        ArrayList<Integer> diceResults = new ArrayList<>();
        for (int i = 0; i < dice; i++) {
            diceResults.add(rand.nextInt(faces) + 1);
        }
        
        return diceResults;
    }
    
}
