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
public class T1Q2 {
    
    public static void main(String[] args) {
        
        //Determine whether a random number is greater than 50.
        
        int num;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a number");
        num = sc.nextInt();
        
        if (num>50) { System.out.println("The number is greater than 50");}
        
        else if (num == 50) {System.out.println("The number is equals to 50");}
        
        else {System.out.println("The number is lesser than 50");}
        
    }
    
}
