/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week3L2;
import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author Acer
 */
public class L2Q3 {
    
    //Write a program that generates three random numbers. The range of the random number is 10 to 50. 
    //Display the three numbers, sum of the numbers and the average in two decimal places.
    
    public static void main(String[] args) {
        
        Random rand = new Random();
        int n = 3;
        int[] randArray = new int[n];
        
        for (int i = 0; i < n; i++){
            int min = 10;
            int max = 50;
            randArray[i] = rand.nextInt(max - min + 1) + min;}
        
        System.out.println(Arrays.toString(randArray));
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += randArray[i];
        }
        //int sum = randArray[0] + randArray[1] + randArray[2]; (alternative, but this is possible cs small num of elements in array)
        
        System.out.printf("The sum is: "+ sum);
            
        
        }
    }
    

