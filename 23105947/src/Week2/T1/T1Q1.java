/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2;
import java.util.Scanner;
/**
 *
 * @author Acer
 */
public class T1Q1 {
    
    public static void main(String[] args) {
        
        //1. Request two numbers from the user and print the multiplication of the numbers.
        int num1, num2, prod;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a number");
        num1 = sc.nextInt();
        
        System.out.println("Enter another number");
        num2 = sc.nextInt();
        
        prod = num1 * num2;
        System.out.print("The product is: " + prod);
    }
    
}
