/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week7T6;
import java.util.Random;

/**
 *
 * @author Acer
 */
public class T6Q1f {
    
//Define a static void method that generates 10 random numbers within 0 to 100
//to the method’s parameter. The random numbers can be accessed by the main
//method
    
    public static void main(String[] args) {
        
        int[] randomNumbers = new int[10];  // Array to hold the random numbers
        
        // Call the method to generate random numbers and store them in the array
        generateRandomNumbers(randomNumbers);
        
        // Display the random numbers from the array
        System.out.println("Generated random numbers:");
        for (int num : randomNumbers) {
            System.out.println(num);
        }
    }

    // Static void method that generates 10 random numbers and stores them in the parameter array
    public static void generateRandomNumbers(int[] numbers) {
        Random rand = new Random();
        
        // Generate 10 random numbers between 0 and 100 (inclusive)
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(101);  // Generates a number between 0 and 100
        }
    }
    
}
