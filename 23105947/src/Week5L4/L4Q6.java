/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5L4;
import java.util.Random;

/**
 *
 * @author Acer
 */
public class L4Q6 {
    
//Write a program that generates a non-negative random integer. Display the number of
//digits in the integer
    
    public static void main(String[] args) {
        
        Random rand = new Random();
        int num = rand.nextInt(0,1000);
        int count = 0;
        int value =num;
        System.out.print("Integer: " + num);
        do {
            value /= 10;
            count++;
            }
        while (value>0);
        
        System.out.println("\nThe number of digits in " + num + " is " + count);
        
    }
    
}
