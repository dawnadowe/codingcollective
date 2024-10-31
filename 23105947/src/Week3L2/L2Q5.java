/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week3L2;
import java.util.Random;

/**
 *
 * @author Acer
 */
public class L2Q5 {
    
    // Write a program that generates one random number. The range of the random number is 0 to 10000. 
    //Display the number and the sum of all the digits in the number
    
    public static void main(String[] args) {
        
        int sum = 0;
        Random rand = new Random();
        int num = rand.nextInt(10000);
        System.out.println(num);
        
        while (num > 0){
            int digit = 0;
            digit = num % 10;
            sum = sum + digit;
            num = num/10; 
        }
        
        System.out.println("The sum of all digits in the number is: "+ sum);
        
    }
    
}
