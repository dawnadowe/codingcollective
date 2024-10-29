/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week3;
import java.util.Scanner;
/**
 *
 * @author Acer
 */
public class L2Q5 {
    
    public static void main(String[] args) {
        
        //1.	Correct the error for the following statements.
        
        //a.    final double AMOUNT = "32.5"; 
        //      AMOUNT += 10; 
        //      System.out.println("The amount is " + AMOUNT);
        double amount = 32.5;
        amount += 10;
        System.out.println("The amount is " +amount);
        
        //b.    string chapter = 'Summary'; 
        //      System.out.println(chapter);
        String chapter = "Summary";
        System.out.println(chapter);
        
        //c.    int num; 
        //      ++num++; 
        //      num1 = num;
        int num=1, num1;
        num++;
        num1 = num;
        
        //d.    int num2 = 3000; 
        //      System.out.printf("%4.2f\n", num);
        double num2 = 3000;
        System.out.printf("%4.2f", num2);
       
        //e.    String contact; 
        //      Scanner keyboard = new Scanner(System.out); 
        //      contact = keyboard.nextLine();
        String contact;
        Scanner keyboard = new Scanner(System.in);
        contact = keyboard.nextLine();
    }
    
}
