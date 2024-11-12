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
public class V1Q1 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        int digitalRoot = 0;
        int remaining = num;
        int number;
        
        while (remaining > 0){
            number = num % 10;
            remaining = num / 10;
            digitalRoot += number;
            num = remaining;
            
            if (remaining < 9 && digitalRoot > 9){
                remaining = digitalRoot;
                num = digitalRoot;
                digitalRoot = 0;
                
            }

        }
        
        System.out.println("The sum of digits until single digit is: " + digitalRoot);
    }
    
}
