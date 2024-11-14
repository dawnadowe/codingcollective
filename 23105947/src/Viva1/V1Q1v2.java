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
public class V1Q1v2 {
    
    public static void main(String[] args) { 

        Scanner scanner = new Scanner(System.in); 

        InputLoop: //Label in case the number entered is less than or equal to 0, so it can continue here 

        //Prompt the user to enter a number to find its digital root 

        while (true){ 

        System.out.print("Enter a number: "); 

        int num = scanner.nextInt(); 

         

        // Ensure the input is a positive integer as the question asked 

        if (num <= 0) { 

            System.out.println("Please enter a positive integer."); 

            continue InputLoop; 

        } 

             // Calculate the digital root by summing its digits until a single digit is obtained 

        while (num >= 10) { //Repeats as long as the number is not a single positive digit (1-9) 

            int sum = 0; 

            // Sum each digits of the current number using a for loop 

            for (int temp = num; temp > 0; temp /= 10) { 

                sum += temp % 10;  // Extract the last digit and add to sum 

            } 

            // Update the number to the sum of its digits 

            num = sum; 

        } 

        // Output the result 

        System.out.println("Sum of digits until single digit: " + num); 

        break; 

} }}
    

