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
public class L2Q6 {
    
    //Write a program that calculates the energy needed to heat water.
    //Q = M * (final temperature – initial temperature) * 4184
    //M = Weight of water in kg
    //Q = Energy in joules
    //The temperature are in degree Celsius
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount of water in gram");
        double gM = sc.nextDouble();
        System.out.println("Enter the initial temperature in Fahrenheit");
        double I = sc.nextDouble();
        System.out.println("Enter the final temperature in Fahrenheit");
        double F = sc.nextDouble();
        double M = gM/1000;
        double DI = (I - 32) / 1.8;
        double DF = (F - 32) / 1.8;
        
        double Q = M * (DF - DI) * 4184;
        System.out.println("The energy needed is " + Q);
    }
    
}
