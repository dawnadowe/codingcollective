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
public class L2Q6 {
    
    public static void main(String[] args) {
        
        //6.	Write a java program that print the circumference of a circle. 
        //      The input of the program is diameter. Display the result in three decimal places. (Note π = Math.PI)
        
        double diameter, circ;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter diameter");
        diameter = sc.nextDouble();
        
        circ = diameter * Math.PI;
        System.out.printf("The circumference of the circle is: %.3f\n", circ);
    }
   
}
