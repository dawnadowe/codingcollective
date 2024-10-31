/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week3L2;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class L2Q2 {
    
    //Write a program to calculate the monthly payment for car loan. 
    //The following are the inputs of the program. Output the monthly payment in two decimal places.
    //P The price of the car
    //D Down payment
    //R Interest Rate in %
    //Y Loan duration in year
    //M Monthly Payment
    //M = (P – D) * (1 + R*Y/100) / (Y *12)
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the price of the car");
        double P = sc.nextDouble();
        System.out.println("Enter the down payment");
        double D = sc.nextDouble();
        System.out.println("Enter interest rate in %");
        double R = sc.nextDouble();
        System.out.println("Enter loan duration in year");
        double Y = sc.nextDouble();
        
        double M = (P - D) * (1 + R*Y/100) / (Y *12);
        
        System.out.printf("The monthly payment is: RM %.2f", M);
    }
    
}
