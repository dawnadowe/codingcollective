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
public class T1Q3 {
    
    public static void main(String[] args) {
       
        //Print the pass/fail grade based on the mark entered by user. 
        //The passing mark is at least 40.
        
        int mark;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter your mark");
        mark = sc.nextInt();
        
        if (mark > 39) {System.out.println("You passed");}
        
        else {System.out.println("You failed");}
        
    }
    
}
