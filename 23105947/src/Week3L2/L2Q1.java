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
public class L2Q1 {
    
    //Write a program that convert the temperature in degree Fahrenheit to degree Celsius.
    //The program will display the degree Celsius in two decimal places.
    //Celsius = (Fahrenheit – 32) / 1.8
    
    public static void main(String[] args) {
        
    System.out.println("Enter the temperature in degree Fahrenheit");
        Scanner sc = new Scanner(System.in);
        double fahren;
        fahren = sc.nextDouble();
        
        double celcius = (fahren - 32) / 1.8;
        
        System.out.printf("Temperature in degree Celsius: %.2f" , celcius);
    
}
}
