/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.lang.Thread;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
        /*
        rand = new Random();
        ArrayList<Integer> diceResults = rollDice(20, 10000);
        for (int i = 0; i < diceResults.size(); i++) {
            System.out.printf("Die %d result: %d\n", i + 1, (int) diceResults.get(i));
        }
        */
        
        Instant time1 = Instant.now();
        try {
            Thread.sleep(13628);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        Instant time2 = Instant.now();
        
        long deltaTime = Duration.between(time1, time2).toMillis();
        
        long millis = deltaTime % 1000;
        deltaTime /= 1000;
        long sec = deltaTime % 60;
        deltaTime /= 60;
        long min = deltaTime % 60;
        deltaTime /= 60;
        long hours = deltaTime % 24;
        deltaTime /= 24;
        System.out.printf("%d hours, %d minutes, %d seconds, %d milliseconds", hours, min, sec, millis);
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
