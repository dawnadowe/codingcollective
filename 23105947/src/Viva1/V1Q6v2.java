/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viva1;
import java.util.Scanner;
/**
 *
 * @author Acer
 */
public class V1Q6v2 {
    
    public static void main(String[] args) {
        
        boolean NegativeNum = false; 
        
        // Initialize variables
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int largest = Integer.MIN_VALUE; // Initialize to minimum possible value
        int secondLargest = Integer.MIN_VALUE;
        int count = 0;
        int count2 = 0;

        System.out.println("Enter numbers (enter 0 to stop): ");
        
        // Loop to get inputs and process them
        while (true) {
            int num = sc.nextInt();
            
            // Check if input is 0, and break the loop if it's 0
            if (num == 0) break;

            // Add to sum
            sum += num;

            // Check for negative numbers
            if (num < 0) {
                NegativeNum = true;
            }

            // Update largest and second largest values and their counts
            if (num > largest) {
                secondLargest = largest;
                largest = num;
                count2 = count;
                count = 1;
            } else if (num == largest) {
                count++;
            } else if (num > secondLargest) {
                secondLargest = num;
                count2 = 1;
            } else if (num == secondLargest) {
                count2++;
            }
        }

        // Output results
        System.out.println("The largest number is " + largest);
        System.out.println("The occurrence count of the largest number is " + count);
        
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("There is no second largest number");
        } else {
            System.out.println("The second largest number is " + secondLargest);
            System.out.println("The occurrence count of the second largest number is " + count2);
        }
        
        System.out.println("The total sum of all numbers is " + sum);
        
        if (NegativeNum) {
            System.out.println("Negative numbers were entered.");
        } else {
            System.out.println("No negative numbers were entered.");
        }
    }
}

    

