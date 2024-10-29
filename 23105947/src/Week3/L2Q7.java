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
public class L2Q7 {
    
    public static void main(String[] args) {
        
        //7.	Write a java program that converts inches to meters. (Given 1 inch equals to 2.54 centimeters). 
        //      Print the output in two decimal places.
        
        double inches, meters;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter value in inch");
        inches = sc.nextDouble();
        
        meters = (inches*2.54)/100;
        System.out.printf("%.2f inches = %.2f meters", inches, meters);

    }
}
