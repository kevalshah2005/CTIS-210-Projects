/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.util.Scanner;

/**
 *
 * @author keval
 */
public class Sandbox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dog dog = new Dog("Fido", 10, "Red");
        dog.bark();
        System.out.println(dog.getAge());
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two numbers to multiply: ");
        System.out.println(scan.nextInt() * scan.nextInt());
    }
    
}
