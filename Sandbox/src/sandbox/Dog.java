/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

/**
 *
 * @author keval
 */
public class Dog {
    double size;
    String breed;
    String color;
    int age;
    int numLegs;
    String Gender;
    String name;
    
    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
    
    public void bark() {
        System.out.println("Woof");
    }
    
    public int getAge() {
        return this.age;
    }
}
